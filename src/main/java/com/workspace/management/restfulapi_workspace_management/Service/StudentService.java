package com.workspace.management.restfulapi_workspace_management.Service;

import com.workspace.management.restfulapi_workspace_management.Entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {
    HttpStatus studentRegister(Student student);

    ResponseEntity<List<Object>> uploadStudentDocument(MultipartFile[] files, String USN);
}
