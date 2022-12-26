package com.workspace.management.restfulapi_workspace_management.Service;

import com.workspace.management.restfulapi_workspace_management.Entity.Internship;
import com.workspace.management.restfulapi_workspace_management.Entity.Student;

import java.util.List;

public interface InternshipService {

    List<Internship> getInternships();

    List<Student> getInternshipAppliedStudent(int internship_id);

    void addInternship(Internship internship);

}
