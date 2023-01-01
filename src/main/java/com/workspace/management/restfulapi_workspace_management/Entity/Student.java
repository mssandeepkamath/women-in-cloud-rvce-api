package com.workspace.management.restfulapi_workspace_management.Entity;


import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    @Column(name = "student_first_name", nullable = false)
    private String student_first_name;

    @Column(name = "student_mid_name", nullable = true)
    private String student_mid_name;

    @Column(name = "student_last_name", nullable = true)
    private String student_last_name;

    @Column(name = "batch", nullable = false)
    private String batch;


    @Id
    @Column(name = "USN", nullable = false)
    private String USN;//check if something varchar datatype as in sql is avalaible

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "phone_number", nullable = false)
    private String phone_number;

    @Column(name = "email_id", nullable = false)
    private String email_id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "project_applied",
            joinColumns = {@JoinColumn(name = "USN")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private Set<Project> applied_projects;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "internship_applied",
            joinColumns = {@JoinColumn(name = "USN")},
            inverseJoinColumns = {@JoinColumn(name = "internship_id")})
    private Set<Internship> applied_internships;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "event_applied",
            joinColumns = {@JoinColumn(name = "USN")},
            inverseJoinColumns = {@JoinColumn(name = "event_id")})
    private Set<Event> applied_events;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//     @JoinColumn(name = "internship_id",nullable = false)
//     private Internship ongoing_internship;
//
//    public Internship getOngoing_internship() {
//        return ongoing_internship;
//    }
//
//    public void setOngoing_internship(Internship ongoing_internship) {
//        this.ongoing_internship = ongoing_internship;
//    }
    public Student() {
        super();
    }

    public Student(String stu_first_name, String stu_mid_name, String stu_last_name, String batch, String USN, String department, String ph_number, String email_id) {
        super();
        this.student_first_name = stu_first_name;
        this.student_mid_name = stu_mid_name;
        this.student_last_name = stu_last_name;
        this.batch = batch;
        this.USN = USN;
        this.department = department;
        this.phone_number = ph_number;
        this.email_id = email_id;
    }

    public Set<Project> getApplied_projects() {
        return applied_projects;
    }

    public void setApplied_projects(Set<Project> applied_projects) {
        this.applied_projects = applied_projects;
    }

    public Set<Internship> getApplied_internships() {
        return applied_internships;
    }

    public void setApplied_internships(Set<Internship> applied_internships) {
        this.applied_internships = applied_internships;
    }

    public Set<Event> getApplied_events() {
        return applied_events;
    }

    public void setApplied_events(Set<Event> applied_events) {
        this.applied_events = applied_events;
    }

    public String getStudent_first_name() {
        return student_first_name;
    }

    public void setStudent_first_name(String student_first_name) {
        this.student_first_name = student_first_name;
    }

    public String getStudent_mid_name() {
        return student_mid_name;
    }

    public void setStudent_mid_name(String student_mid_name) {
        this.student_mid_name = student_mid_name;
    }

    public String getStudent_last_name() {
        return student_last_name;
    }

    public void setStudent_last_name(String student_last_name) {
        this.student_last_name = student_last_name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getUSN() {
        return USN;
    }

    public void setUSN(String USN) {
        this.USN = USN;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_first_name='" + student_first_name + '\'' +
                ", student_mid_name='" + student_mid_name + '\'' +
                ", student_last_name='" + student_last_name + '\'' +
                ", batch='" + batch + '\'' +
                ", USN='" + USN + '\'' +
                ", department='" + department + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email_id='" + email_id + '\'' +
                '}';
    }
}
