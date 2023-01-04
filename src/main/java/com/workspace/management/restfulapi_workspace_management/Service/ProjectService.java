package com.workspace.management.restfulapi_workspace_management.Service;


import com.workspace.management.restfulapi_workspace_management.Entity.Event;
import com.workspace.management.restfulapi_workspace_management.Entity.Project;
import com.workspace.management.restfulapi_workspace_management.Entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProjectService {

    ResponseEntity<List<Project>> getProjects();

    List<Student> getProjectAppliedStudent(int project_id);

    HttpStatus addProject(Project project);

    HttpStatus applyProject(String USN,int project_id);


    HttpStatus hireProject(String USN,int project_id);

    ResponseEntity<List<Project>> getArchivedProjects();

    ResponseEntity<List<Object>> uploadProjectDocument(MultipartFile[] files,int project_id);

}
