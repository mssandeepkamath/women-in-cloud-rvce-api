package com.workspace.management.restfulapi_workspace_management.Service;


import com.workspace.management.restfulapi_workspace_management.Dao.ProjectDao;
import com.workspace.management.restfulapi_workspace_management.Dao.StudentDao;
import com.workspace.management.restfulapi_workspace_management.Entity.Project;
import com.workspace.management.restfulapi_workspace_management.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    public ResponseEntity<List<Project>> getProjects() {
        try {
            return new ResponseEntity<>(projectDao.findAll(),HttpStatus.OK) ;
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.OK) ;
        }
    }

    @Override
    public List<Student> getProjectAppliedStudent(int project_id) {
        Project project=projectDao.findById(project_id).orElse(null);
        if(project!=null)
        {
            return new ArrayList<>(project.getStudents());
        }
        return null;
    }

    @Override
    public HttpStatus addProject(Project project){

        try
        {
            projectDao.save(project);
            return HttpStatus.OK;
        }
        catch(Exception e)
        {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
    @Override
    public HttpStatus applyProject(String USN, int project_id) {
       Project project=projectDao.findById(project_id).orElse(null);
       Student student=studentDao.findById(USN).orElse(null);
       if(project!=null && student!=null)
       {
           Set<Project> projectSet=student.getProjects();
           projectSet.add(project);
           student.setProjects(projectSet);
           studentDao.save(student);
           return HttpStatus.OK;
       }
       else
           return HttpStatus.INTERNAL_SERVER_ERROR;
    }



}
