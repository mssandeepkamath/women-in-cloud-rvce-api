package com.workspace.management.restfulapi_workspace_management.Service;

import com.workspace.management.restfulapi_workspace_management.Entity.Event;
import com.workspace.management.restfulapi_workspace_management.Entity.Project;
import com.workspace.management.restfulapi_workspace_management.Entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EventService {

    ResponseEntity<List<Event>> getEvents();

    List<Student> getEventAppliedStudent(int event_id);

    HttpStatus addEvent(Event event);

    HttpStatus applyEvent(String USN,int event_id);


    ResponseEntity<List<Event>> getAchivedEvents();

    ResponseEntity<List<Object>> uploadEventDocument(MultipartFile[] files, int event_id);

    public List<Student> allAppliedEventStudent();
}
