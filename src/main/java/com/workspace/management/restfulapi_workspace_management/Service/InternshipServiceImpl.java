package com.workspace.management.restfulapi_workspace_management.Service;


import com.workspace.management.restfulapi_workspace_management.Dao.DocumentDao;
import com.workspace.management.restfulapi_workspace_management.Dao.InternshipDao;

import com.workspace.management.restfulapi_workspace_management.Dao.StudentDao;
import com.workspace.management.restfulapi_workspace_management.Entity.Document;
import com.workspace.management.restfulapi_workspace_management.Entity.Internship;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


@Service
public class InternshipServiceImpl implements InternshipService {


    @Autowired
    private InternshipDao internshipDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private DocumentDao documentDao;

    @Override
    public ResponseEntity<List<Internship>> getInternships() {
        try {
            return new ResponseEntity<>(internshipDao.getInternshipByOpening(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<Student> getInternshipAppliedStudent(int internship_id) {
        Internship internship = internshipDao.findById(internship_id).orElse(null);
        if (internship != null) {
            return new ArrayList<>(internship.getApplied_students());
        }
        return null;
    }

    @Override
    public HttpStatus addInternship(Internship internship) {
        try {
            internshipDao.save(internship);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    @Override
    public HttpStatus applyInternship(String USN, int internship_id) {
        Internship internship = internshipDao.findById(internship_id).orElse(null);
        Student student = studentDao.findById(USN).orElse(null);
        if (internship != null && student != null && student.getOn_going_internship()==null) {
            Set<Internship> internshipSet = student.getApplied_internships();
            internshipSet.add(internship);
            student.setApplied_internships(internshipSet);
            studentDao.save(student);
            return HttpStatus.OK;
        } else
            return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Override
    public HttpStatus hireInternship(String USN, int internship_id) {
        Student student = studentDao.findById(USN).orElse(null);
        Internship internship = internshipDao.findById(internship_id).orElse(null);
        try {

            if (student != null && internship != null) {
                Set<Student> working_student= internship.getWorking_students();
                working_student.add(student);
                internship.setWorking_students(working_student);
                internship.setOpening(internship.getOpening()-1);
                student.setApplied_internships(null);
                studentDao.save(student);
                internshipDao.save(internship);
                new Thread(new MailSenderThread(emailSenderService,student,internship)).start();
                return HttpStatus.OK;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return HttpStatus.INTERNAL_SERVER_ERROR;

    }

    @Override
    public ResponseEntity<List<Internship>> getArchivedInternships() {
        try {
            return new ResponseEntity<>(internshipDao.getArchivedInternship(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity uploadToLocalFileSystem(MultipartFile file,int internship_id) {
        Document doc = new Document();
        Internship internship=internshipDao.findById(internship_id).get();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(internship!=null) {
            doc.setDocument_name(new Timestamp(System.currentTimeMillis())+fileName);

            try {
                doc.setFile(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Set<Document> documentSet=internship.getDocuments();
            documentSet.add(doc);
            internship.setDocuments(documentSet);
        }
        documentDao.save(doc);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/download/")
                .path(doc.getDocument_name())
                .toUriString();
        return ResponseEntity.ok(fileDownloadUri);
    }
    @Override
    public ResponseEntity<List<Object>> uploadInternshipDocument(MultipartFile[] files, int internship_id) {
        List<Object> fileDownloadUrls = new ArrayList<>();
        Arrays.asList(files)
                .stream()
                .forEach(file -> fileDownloadUrls.add(uploadToLocalFileSystem(file,internship_id).getBody()));
        return new ResponseEntity<>(fileDownloadUrls,HttpStatus.OK);
    }

}