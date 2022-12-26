package com.workspace.management.restfulapi_workspace_management.Service;


import com.workspace.management.restfulapi_workspace_management.Entity.Project;
import com.workspace.management.restfulapi_workspace_management.Entity.Student;

import java.util.List;

public interface ProjectService {

    List<Project> getProjects();

    List<Student> getProjectAppliedStudent(int project_id);

    void addProject(Project project);

}
