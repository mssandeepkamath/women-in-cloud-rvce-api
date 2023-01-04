package com.workspace.management.restfulapi_workspace_management.Entity;


import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "document_name")
    private String document_name;

    @Column(name = "file")
    @Lob
    private byte[] file;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "internship_id")
    private Internship internship;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "USN")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Document() {

    }

    public Document(int id, String document_name, byte[] file, Project project, Internship internship, Event event) {
        this.id = id;
        this.document_name = document_name;
        this.file = file;
        this.project = project;
        this.internship = internship;
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocument_name() {
        return document_name;
    }

    public void setDocument_name(String document_name) {
        this.document_name = document_name;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", document_name='" + document_name + '\'' +
                ", file=" + Arrays.toString(file) +
                ", project=" + project +
                ", internship=" + internship +
                ", event=" + event +
                '}';
    }


}
