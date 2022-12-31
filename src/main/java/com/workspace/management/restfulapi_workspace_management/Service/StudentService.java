package com.workspace.management.restfulapi_workspace_management.Service;

import com.workspace.management.restfulapi_workspace_management.Entity.Student;
import org.springframework.http.HttpStatus;

public interface StudentService {
    HttpStatus studentRegister(Student student);
}
