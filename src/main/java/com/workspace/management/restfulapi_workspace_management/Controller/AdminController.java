package com.workspace.management.restfulapi_workspace_management.Controller;

import com.workspace.management.restfulapi_workspace_management.Dao.FundDao;
import com.workspace.management.restfulapi_workspace_management.Entity.*;
import com.workspace.management.restfulapi_workspace_management.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


@RestController
public class AdminController {

    @Autowired
   private  ProjectService projectService;
    @Autowired
    private InternshipService internshipService;
    @Autowired
    private EventService eventService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private FundService fundService;



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
    @PostMapping(path = "/hire-project",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> hireProject(@RequestBody Map<String,String> json) {
        return new ResponseEntity<>(projectService.hireProject(json.get("USN"), Integer.parseInt(json.get("project_id"))));
    }
    @PostMapping(path = "/hire-internship",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> hireInternship(@RequestBody Map<String,String> json) {
        return new ResponseEntity<>(internshipService.hireInternship(json.get("USN"), Integer.parseInt(json.get("internship_id"))));
    }

    @PostMapping(path = "/upload-project-document/{project_id}")
    public ResponseEntity<List<Object>> uploadProjectDocumentToDB(@RequestParam("file") MultipartFile[] files,@PathVariable String project_id) {
        return projectService.uploadProjectDocument(files,Integer.parseInt(project_id));
    }
    @PostMapping(path = "/upload-project-document/{internship_id}")
    public ResponseEntity<List<Object>> uploadInternshipDocumentToDB(@RequestParam("file") MultipartFile[] files,@PathVariable String internship_id) {
        return internshipService.uploadInternshipDocument(files,Integer.parseInt(internship_id));
    }
    @PostMapping(path = "/upload-project-document/{event_id}")
    public ResponseEntity<List<Object>> uploadEventDocumentToDB(@RequestParam("file") MultipartFile[] files,@PathVariable String event_id) {
        return eventService.uploadEventDocument(files,Integer.parseInt(event_id));
    }

    @PostMapping(path = "/student",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> uploadEventDocumentToDB(@RequestBody Map<String,String> json) {
        return studentService.studentDetails(json.get("USN"));
    }

    @GetMapping(path = "/funds",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Fund>> getFunds()
    {
        return  this.fundService.getFunds();
    }

    @PostMapping(path = "/add-fund", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> addFund(@RequestBody Fund fund) {
        return new ResponseEntity<>(this.fundService.addFund(fund));
    }



}
