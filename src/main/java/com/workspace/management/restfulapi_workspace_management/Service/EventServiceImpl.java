package com.workspace.management.restfulapi_workspace_management.Service;


import com.workspace.management.restfulapi_workspace_management.Dao.EventDao;
import com.workspace.management.restfulapi_workspace_management.Dao.StudentDao;
import com.workspace.management.restfulapi_workspace_management.Entity.Event;
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
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao eventDao;
    @Autowired
    private StudentDao studentDao;


    @Override
    public ResponseEntity<List<Event>> getEvents() {
        try {
            return new ResponseEntity<>(eventDao.findAll(),HttpStatus.OK) ;
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.OK) ;
        }
    }

    @Override
    public List<Student> getEventAppliedStudent(int event_id) {
        Event event=eventDao.findById(event_id).orElse(null);
        if(event!=null)
        {
            return new ArrayList<>(event.getApplied_students());
        }
        return null;
    }

    @Override
    public HttpStatus addEvent(Event event) {

        try {
            eventDao.save(event);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }

    @Override
    public HttpStatus applyEvent(String USN,int event_id) {

        Event event = eventDao.findById(event_id).orElse(null);
        Student student = studentDao.findById(USN).orElse(null);

        if (event != null && student != null) {
            Set<Event> eventSet = student.getApplied_events();
            eventSet.add(event);
            student.setApplied_events(eventSet);
            studentDao.save(student);
            return HttpStatus.OK;
        } else
            return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
