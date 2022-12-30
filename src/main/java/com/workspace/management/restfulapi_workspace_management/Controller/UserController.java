package com.workspace.management.restfulapi_workspace_management.Controller;
import com.workspace.management.restfulapi_workspace_management.Entity.*;
import com.workspace.management.restfulapi_workspace_management.Service.EventService;
import com.workspace.management.restfulapi_workspace_management.Service.InternshipService;
import com.workspace.management.restfulapi_workspace_management.Service.ProjectService;
import com.workspace.management.restfulapi_workspace_management.Service.StudentChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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

    @GetMapping(path = "/projects",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Project>> getProjects() {
        return this.projectService.getProjects();
    }
    @GetMapping(path = "/internships",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Internship>> getInternships() {
        return this.internshipService.getInternships();
    }

    @GetMapping(path = "/events",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> getEvents() {
        return this.eventService.getEvents();
    }

    @GetMapping(path = "/student-chapter",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentChapter>> getStudentChapter() {
        return new ResponseEntity<>(this.studentChapterService.getStudentChapter(), HttpStatus.OK);
    }

}
