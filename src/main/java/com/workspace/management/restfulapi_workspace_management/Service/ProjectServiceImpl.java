package com.workspace.management.restfulapi_workspace_management.Service;


import com.workspace.management.restfulapi_workspace_management.Dao.ProjectDao;
import com.workspace.management.restfulapi_workspace_management.Dao.StudentDao;
import com.workspace.management.restfulapi_workspace_management.Entity.Project;
import com.workspace.management.restfulapi_workspace_management.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Project> getProjects() {
        return null;
    }

    @Override
    public List<Student> getProjectAppliedStudent(int project_id) {
        return null;
    }

    @Override
    public void addProject(Project project) {
    }

}
