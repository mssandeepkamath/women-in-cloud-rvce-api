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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
        Student student=studentDao.findById(USN).get();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(student!=null)
        {
            doc.setDocument_name(fileName);

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
        documentDao.save(doc);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/download/")
                .path(fileName)
                .toUriString();
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

}
