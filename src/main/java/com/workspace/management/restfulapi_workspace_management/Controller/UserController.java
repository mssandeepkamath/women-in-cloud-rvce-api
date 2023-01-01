package com.workspace.management.restfulapi_workspace_management.Controller;

import com.workspace.management.restfulapi_workspace_management.Entity.*;
import com.workspace.management.restfulapi_workspace_management.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private InternshipService internshipService;
    @Autowired
    private EventService eventService;
    @Autowired
    private StudentChapterService studentChapterService;

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/projects", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Project>> getProjects() {
        return this.projectService.getProjects();
    }

    @GetMapping(path = "/internships", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Internship>> getInternships() {
        return this.internshipService.getInternships();
    }

    @GetMapping(path = "/events", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> getEvents() {
        return this.eventService.getEvents();
    }

    @GetMapping(path = "/projects-archived", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Project>> getArchivedProjects() {
        return this.projectService.getArchivedProjects();
    }
    @GetMapping(path = "/internships-archived", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Internship>> getArchivedInternships() {
        return this.internshipService.getArchivedInternships();
    }

    @GetMapping(path = "/events-archived", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> getArchivedEvents() {
        return this.eventService.getAchivedEvents();
    }

    @PostMapping(path = "/apply-project", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> applyProject(@RequestBody Map<String,String> json) {
        return new ResponseEntity<>(projectService.applyProject(json.get("USN"), Integer.parseInt(json.get("project_id"))));
    }

    @PostMapping(path = "/apply-internship", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> applyInternship(@RequestBody Map<String,String> json) {
        return new ResponseEntity<>(internshipService.applyInternship(json.get("USN"), Integer.parseInt(json.get("internship_id"))));
    }

    @PostMapping(path = "/apply-event", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> applyEvent(@RequestBody Map<String,String> json) {
        return new ResponseEntity<>(eventService.applyEvent(json.get("USN"), Integer.parseInt(json.get("event_id"))));
    }

    @GetMapping(path = "/student-chapter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentChapter>> getStudentChapter() {
        return new ResponseEntity<>(this.studentChapterService.getStudentChapter(), HttpStatus.OK);
    }
    @PostMapping(path = "/register-student", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> applyEvent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.studentRegister(student));
    }

}
