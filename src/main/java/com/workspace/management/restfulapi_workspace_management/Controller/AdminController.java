package com.workspace.management.restfulapi_workspace_management.Controller;

import com.workspace.management.restfulapi_workspace_management.Entity.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminController {

    @GetMapping(path="/project-applied-students/{project_id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getProjectAppliedStudent(@PathVariable String project_id)
    {
        List<Student>students=new ArrayList<Student>();

        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

    @GetMapping(path="/internship-applied-students/{internship_id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getInternshipAppliedStudent(@PathVariable String internship_id)
    {
        List<Student>students=new ArrayList<Student>();

        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

    @GetMapping(path="/event-applied-students/{event_id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getEventAppliedStudent(@PathVariable String event_id)
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

    @PostMapping(path="/add-events",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> addEvent(@RequestBody Event seminar)
    {
        //return based on acceptance
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
