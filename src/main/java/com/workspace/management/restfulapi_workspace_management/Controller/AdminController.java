package com.workspace.management.restfulapi_workspace_management.Controller;

import com.workspace.management.restfulapi_workspace_management.Entity.*;
import com.workspace.management.restfulapi_workspace_management.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    ProjectService projectService;
    @Autowired
    InternshipService internshipService;
    @Autowired
    EventService eventService;


    @GetMapping(path = "/project-applied-students/{project_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getProjectAppliedStudent(@PathVariable String project_id) {
        return new ResponseEntity<>(this.projectService.getProjectAppliedStudent(Integer.parseInt(project_id)), HttpStatus.OK);
    }

    @GetMapping(path = "/internship-applied-students/{internship_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getInternshipAppliedStudent(@PathVariable String internship_id) {
        return new ResponseEntity<>(this.internshipService.getInternshipAppliedStudent(Integer.parseInt(internship_id)), HttpStatus.OK);
    }

    @GetMapping(path = "/event-applied-students/{event_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getEventAppliedStudent(@PathVariable String event_id) {
        return new ResponseEntity<>(this.eventService.getEventAppliedStudent(Integer.parseInt(event_id)), HttpStatus.OK);
    }

    @PostMapping(path = "/add-project", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> addProject(@RequestBody Project project) {
            return new ResponseEntity<>(this.projectService.addProject(project));
    }

    @PostMapping(path = "/add-internship", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> addInternship(@RequestBody Internship internship) {
            return new ResponseEntity<>( this.internshipService.addInternship(internship));
    }

    @PostMapping(path = "/add-event", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> addEvent(@RequestBody Event event) {
            return new ResponseEntity<>(this.eventService.addEvent(event));
    }


}
