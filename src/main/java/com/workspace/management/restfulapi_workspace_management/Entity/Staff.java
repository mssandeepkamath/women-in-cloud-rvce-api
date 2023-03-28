package com.workspace.management.restfulapi_workspace_management.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.sql.ast.tree.expression.Collation;

import java.util.Set;

@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @Column(name = "SID",nullable = false)
    private  String SID;

    @Column(name = "department")
    private String department;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "date_of_join")
    private String date_of_join;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "guided_projects",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "SID")})
    private Set<Project> guided_projects;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "guided_internships",
            joinColumns = {@JoinColumn(name = "internship_id")},
            inverseJoinColumns = {@JoinColumn(name = "SID")})
    private Set<Internship> guided_internships;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "event_organized",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "SID")})
    private Set<Event> event_organized;

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getDate_of_join() {
        return date_of_join;
    }

    public void setDate_of_join(String date_of_join) {
        this.date_of_join = date_of_join;
    }

    public Set<Project> getGuided_projects() {
        return guided_projects;
    }

    public void setGuided_projects(Set<Project> guided_projects) {
        this.guided_projects = guided_projects;
    }

    public Set<Internship> getGuided_internships() {
        return guided_internships;
    }

    public void setGuided_internships(Set<Internship> guided_internships) {
        this.guided_internships = guided_internships;
    }

    public Set<Event> getEvent_organized() {
        return event_organized;
    }

    public void setEvent_organized(Set<Event> event_organized) {
        this.event_organized = event_organized;
    }

    public Staff() {
    }
}
