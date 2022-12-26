package com.workspace.management.restfulapi_workspace_management.Service;

import com.workspace.management.restfulapi_workspace_management.Dao.EventDao;
import com.workspace.management.restfulapi_workspace_management.Dao.StudentDao;
import com.workspace.management.restfulapi_workspace_management.Entity.Event;
import com.workspace.management.restfulapi_workspace_management.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao eventDao;
    @Autowired
    private StudentDao studentDao;


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
