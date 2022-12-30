package com.workspace.management.restfulapi_workspace_management.Service;


import com.workspace.management.restfulapi_workspace_management.Dao.InternshipDao;

import com.workspace.management.restfulapi_workspace_management.Dao.StudentDao;
import com.workspace.management.restfulapi_workspace_management.Entity.Internship;
import com.workspace.management.restfulapi_workspace_management.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InternshipServiceImpl implements InternshipService {


    @Autowired
    private  InternshipDao internshipDao;

    @Autowired
    private StudentDao studentDao;

    @Override
    public ResponseEntity<List<Internship>> getInternships() {
        try {
            return new ResponseEntity<>(internshipDao.findAll(),HttpStatus.OK) ;
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.OK) ;
        }
    }

    @Override
    public List<Student> getInternshipAppliedStudent(int internship_id) {
        return null;
    }

    @Override
    public HttpStatus addInternship(Internship internship) {
        try {
            internshipDao.save(internship);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

}
