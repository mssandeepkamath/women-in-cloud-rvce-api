package com.workspace.management.restfulapi_workspace_management.Service;


import com.workspace.management.restfulapi_workspace_management.Dao.DocumentDao;
import com.workspace.management.restfulapi_workspace_management.Dao.ProjectDao;
import com.workspace.management.restfulapi_workspace_management.Dao.StudentDao;
import com.workspace.management.restfulapi_workspace_management.Entity.Document;
import com.workspace.management.restfulapi_workspace_management.Entity.Project;
import com.workspace.management.restfulapi_workspace_management.Entity.Student;

import com.workspace.management.restfulapi_workspace_management.Util.MailSenderThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private DocumentDao documentDao;


    @Override
    public ResponseEntity<List<Project>> getProjects() {
        try {
            return new ResponseEntity<>(projectDao.getProjectByOpening(),HttpStatus.OK) ;
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
    }
    @Override
    public List<Student> getProjectAppliedStudent(int project_id) {
        Project project=projectDao.findById(project_id).orElse(null);
        if(project!=null)
        {
            return new ArrayList<>(project.getApplied_students());
        }
        return null;
    }
    @Override
    public HttpStatus addProject(Project project){
        try
        {
            projectDao.save(project);
            return HttpStatus.OK;
        }
        catch(Exception e)
        {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
    @Override
    public HttpStatus applyProject(String USN, int project_id) {
       Project project=projectDao.findById(project_id).orElse(null);
       Student student=studentDao.findById(USN).orElse(null);

       if(project!=null && student!=null && student.getOn_going_project()==null)
       {
           Set<Project> projectSet=student.getApplied_projects();
           projectSet.add(project);
           student.setApplied_projects(projectSet);
           studentDao.save(student);
           return HttpStatus.OK;
       }
       else
       {
           return HttpStatus.INTERNAL_SERVER_ERROR;
       }


    }

    @Override
    public HttpStatus hireProject(String USN, int project_id) {
        Student student=studentDao.findById(USN).orElse(null);
        Project project=projectDao.findById(project_id).orElse(null);
        try
        {
            if(student!=null && project!=null)
            {
                Set<Student> working_student= project.getWorking_students();
                working_student.add(student);
                project.setWorking_students(working_student);
                project.setOpening(project.getOpening()-1);
                student.setApplied_projects(null);
                student.setOn_going_project(project);
                projectDao.save(project);
                studentDao.save(student);
                new Thread(new MailSenderThread(emailSenderService,student,project)).start();
                return HttpStatus.OK;
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Override
    public ResponseEntity<List<Project>> getArchivedProjects() {
        try {
            return new ResponseEntity<>(projectDao.getArchivedProject(),HttpStatus.OK) ;
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
    }
    public ResponseEntity uploadToLocalFileSystem(MultipartFile file,int project_id) {
        Document doc = new Document();
        Project project=projectDao.findById(project_id).get();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(project!=null)
        {
            doc.setDocument_name(new Timestamp(System.currentTimeMillis())+fileName);

            try {
                doc.setFile(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            Set<Document> documentSet=project.getDocuments();
            documentSet.add(doc);
            project.setDocuments(documentSet);
            doc.setProject(project);
        }
        documentDao.save(doc);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/download/")
                .path(doc.getDocument_name())
                .toUriString();
        return ResponseEntity.ok(fileDownloadUri);
    }

    @Override
    public ResponseEntity<List<Object>> uploadProjectDocument(MultipartFile[] files,int project_id) {
        List<Object> fileDownloadUrls = new ArrayList<>();
        Arrays.asList(files)
                .stream()
                .forEach(file -> fileDownloadUrls.add(uploadToLocalFileSystem(file,project_id).getBody()));
        return new ResponseEntity<>(fileDownloadUrls,HttpStatus.OK);
    }

    @Override
    public List<Student> allAppliedStudent() {
        return projectDao.allAppliedStudent();
    }


}
