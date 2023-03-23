package com.workspace.management.restfulapi_workspace_management.Service;

import com.workspace.management.restfulapi_workspace_management.Dao.DocumentDao;
import com.workspace.management.restfulapi_workspace_management.Dao.StudentDao;
import com.workspace.management.restfulapi_workspace_management.Entity.Document;
import com.workspace.management.restfulapi_workspace_management.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private DocumentDao documentDao;

    @Override
    public HttpStatus studentRegister(Student student) {
        try
        {
            studentDao.save(student);
            return HttpStatus.OK;
        }
      catch (Exception e)
        {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }

    public ResponseEntity uploadToLocalFileSystem(MultipartFile file, String USN) {
        Document doc = new Document();
        Student student=studentDao.findById(USN).orElse(null);
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        if(student!=null)
        {
            doc.setDocument_name(new Timestamp(System.currentTimeMillis()) +fileName);

            try {
                doc.setFile(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            Set<Document> documentSet=student.getDocuments();
            documentSet.add(doc);
            student.setDocuments(documentSet);
            doc.setStudent(student);

        }

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/download/")
                .path(doc.getDocument_name())
                .toUriString();
        doc.setFile_url(fileDownloadUri);
        documentDao.save(doc);
        return ResponseEntity.ok(fileDownloadUri);

    }
    @Override
    public ResponseEntity<List<Object>> uploadStudentDocument(MultipartFile[] files, String USN) {
        List<Object> fileDownloadUrls = new ArrayList<>();
        Arrays.asList(files)
                .stream()
                .forEach(file -> fileDownloadUrls.add(uploadToLocalFileSystem(file,USN).getBody()));
        return new ResponseEntity<>(fileDownloadUrls, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Student> studentDetails(String USN) {
        try
        {
            return new ResponseEntity<>(studentDao.getStudentByUSN(USN),HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<Student> getRegisteredStudent() {
        return studentDao.findAll();
    }

    @Override
    public String getUsnByEmail(String email) {
      try{
          return studentDao.getUSN(email);
      }
      catch(Exception e)
      {
          System.out.println(e.getMessage());
      }
        return null;
    }

}
