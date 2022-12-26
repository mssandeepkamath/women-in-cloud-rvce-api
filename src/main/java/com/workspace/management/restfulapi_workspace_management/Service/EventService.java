package com.workspace.management.restfulapi_workspace_management.Service;

import com.workspace.management.restfulapi_workspace_management.Entity.Event;
import com.workspace.management.restfulapi_workspace_management.Entity.Student;

import java.util.List;

public interface EventService {

    List<Event> getEvents();

    List<Student> getEventAppliedStudent(int event_id);

    void addEvent(Event event);

}
