package com.workspace.management.restfulapi_workspace_management.Service;


import com.workspace.management.restfulapi_workspace_management.Dao.InternshipDao;

import com.workspace.management.restfulapi_workspace_management.Dao.StudentDao;
import com.workspace.management.restfulapi_workspace_management.Entity.Internship;
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
public class InternshipServiceImpl implements InternshipService {


    @Autowired
    private InternshipDao internshipDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    EmailSenderService emailSenderService;

    @Override
    public ResponseEntity<List<Internship>> getInternships() {
        try {
            return new ResponseEntity<>(internshipDao.getInternshipByOpening(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<Student> getInternshipAppliedStudent(int internship_id) {
        Internship internship = internshipDao.findById(internship_id).orElse(null);
        if (internship != null) {
            return new ArrayList<>(internship.getApplied_students());
        }
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

    @Override
    public HttpStatus applyInternship(String USN, int internship_id) {
        Internship internship = internshipDao.findById(internship_id).orElse(null);
        Student student = studentDao.findById(USN).orElse(null);
        if (internship != null && student != null) {
            Set<Internship> internshipSet = student.getApplied_internships();
            internshipSet.add(internship);
            student.setApplied_internships(internshipSet);
            studentDao.save(student);
            return HttpStatus.OK;
        } else
            return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Override
    public HttpStatus hireInternship(String USN, int internship_id) {
        Student student = studentDao.findById(USN).orElse(null);
        Internship internship = internshipDao.findById(internship_id).orElse(null);
        if (student != null && internship != null) {
            emailSenderService.sendSimpleEmail(student.getEmail_id(), "Hi,\nRegarding your application for " + internship.getCompany_name() + ", we have reviewed your resume and found you as a right candidate for the Internship .\nThis is your access token for workspace{access_token}\nThanks and regards,\nCOE admin,\nWIC,\nR V College of Engineering, Bengaluru", "You are HIRED!");
            return HttpStatus.OK;
        } else
            return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Override
    public ResponseEntity<List<Internship>> getArchivedInternships() {
        try {
            return new ResponseEntity<>(internshipDao.getArchivedInternship(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}