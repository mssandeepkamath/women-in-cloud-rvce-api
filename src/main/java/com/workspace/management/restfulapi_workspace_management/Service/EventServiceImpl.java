package com.workspace.management.restfulapi_workspace_management.Service;


import com.workspace.management.restfulapi_workspace_management.Dao.DocumentDao;
import com.workspace.management.restfulapi_workspace_management.Dao.EventDao;
import com.workspace.management.restfulapi_workspace_management.Dao.StudentDao;
import com.workspace.management.restfulapi_workspace_management.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao eventDao;
    @Autowired
    private StudentDao studentDao;

    @Autowired
    private DocumentDao documentDao;

    @Override
    public ResponseEntity<List<Event>> getEvents() {
        try {
            return new ResponseEntity<>(eventDao.getActiveEvent(new Date(System.currentTimeMillis())),HttpStatus.OK) ;
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR) ;
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

    @Override
    public ResponseEntity<List<Event>> getAchivedEvents() {
        try {
            return new ResponseEntity<>(eventDao.getArchivedEvent(new Date(System.currentTimeMillis())),HttpStatus.OK) ;
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR) ;
        }

    }

    public ResponseEntity uploadToLocalFileSystem(MultipartFile file,int event_id) {
        Document doc = new Document();
        Event event=eventDao.findById(event_id).get();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(event!=null) {
            doc.setDocument_name(new Timestamp(System.currentTimeMillis())+fileName);

            try {
                doc.setFile(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

            Set<Document> documentSet=event.getDocuments();
            documentSet.add(doc);
            event.setDocuments(documentSet);
        }
        documentDao.save(doc);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/files/download/")
                .path(doc.getDocument_name())
                .toUriString();
        return ResponseEntity.ok(fileDownloadUri);
    }
    @Override
    public ResponseEntity<List<Object>> uploadEventDocument(MultipartFile[] files, int event_id) {
        List<Object> fileDownloadUrls = new ArrayList<>();
        Arrays.asList(files)
                .stream()
                .forEach(file -> fileDownloadUrls.add(uploadToLocalFileSystem(file,event_id).getBody()));
        return new ResponseEntity<>(fileDownloadUrls,HttpStatus.OK);
    }

    @Override
    public List<Student> allAppliedEventStudent() {
        return eventDao.allAppliedStudent();
    }

}
