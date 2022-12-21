package com.workspace.management.restfulapi_workspace_management.Controller;

import com.workspace.management.restfulapi_workspace_management.Entity.Projects;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProjectController {


    @GetMapping(path = "/testProjectEndPoint",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> testProjectEndPoint() {
        return new ResponseEntity<>("API Responding",HttpStatus.CREATED);
    }


    @GetMapping(path = "/projects",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Projects>> getProjects() {
        List<Projects> projects = new ArrayList<>();

        return new ResponseEntity<>(projects, HttpStatus.ACCEPTED);
    }

}
