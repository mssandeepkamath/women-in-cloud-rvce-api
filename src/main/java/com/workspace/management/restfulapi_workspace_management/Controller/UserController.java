package com.workspace.management.restfulapi_workspace_management.Controller;
import com.workspace.management.restfulapi_workspace_management.Entity.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    @GetMapping(path = "/projects",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Project>> getProjects() {
        List<Project> projects = new ArrayList<>();

        return new ResponseEntity<>(projects, HttpStatus.ACCEPTED);
    }
    @GetMapping(path = "/internships",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Internship>> getInternships() {
        List<Internship> internships = new ArrayList<>();

        return new ResponseEntity<>(internships, HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/seminars",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Seminar>> getSeminars() {
        List<Seminar> seminars = new ArrayList<>();

        return new ResponseEntity<>(seminars, HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/workshops",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Workshop>> getWorkshops() {
        List<Workshop> workshops = new ArrayList<>();

        return new ResponseEntity<>(workshops, HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/student-chapter",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentChapter>> getStudentChapter() {
        List<StudentChapter> studentsChapters = new ArrayList<>();

        return new ResponseEntity<>(studentsChapters, HttpStatus.ACCEPTED);
    }


}
