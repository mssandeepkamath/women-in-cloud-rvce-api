package com.workspace.management.restfulapi_workspace_management.Controller;

import com.workspace.management.restfulapi_workspace_management.Entity.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminController {

    @GetMapping(path="/project-applied-students",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getProjectAppliedStudent()
    {
        List<Student>students=new ArrayList<Student>();

        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

    @GetMapping(path="/internship-applied-students",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getInternshipAppliedStudent()
    {
        List<Student>students=new ArrayList<Student>();

        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

    @PostMapping(path="/add-project",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> addProject(@RequestBody Project project)
    {
        //return based on acceptance
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path="/add-internship",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> addInternship(@RequestBody Internship internship)
    {
        //return based on acceptance
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path="/add-seminar",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> addSeminar(@RequestBody Seminar seminar)
    {
        //return based on acceptance
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path="/add-workshop",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> addWorkshop(@RequestBody Workshop workshop)
    {
        //return based on acceptance
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
