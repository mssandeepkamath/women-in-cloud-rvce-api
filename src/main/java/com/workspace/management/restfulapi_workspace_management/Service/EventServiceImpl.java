package com.workspace.management.restfulapi_workspace_management.Service;

import com.workspace.management.restfulapi_workspace_management.Entity.Event;
import com.workspace.management.restfulapi_workspace_management.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Override
    public List<Event> getEvents() {
        return null;
    }

    @Override
    public List<Student> getEventAppliedStudent(int event_id) {
        return null;
    }

    @Override
    public void addEvent(Event event) {
    }

}
