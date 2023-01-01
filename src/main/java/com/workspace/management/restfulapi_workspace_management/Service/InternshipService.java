package com.workspace.management.restfulapi_workspace_management.Service;

import com.workspace.management.restfulapi_workspace_management.Entity.Internship;
import com.workspace.management.restfulapi_workspace_management.Entity.Internship;
import com.workspace.management.restfulapi_workspace_management.Entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface InternshipService {

    ResponseEntity<List<Internship>> getInternships();

    List<Student> getInternshipAppliedStudent(int internship_id);

    HttpStatus addInternship(Internship internship);

    HttpStatus applyInternship(String USN,int internship_id);

    HttpStatus hireInternship(String USN,int project_id);

    ResponseEntity<List<Internship>> getArchivedInternships();
}
