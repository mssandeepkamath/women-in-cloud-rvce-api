package com.workspace.management.restfulapi_workspace_management.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "internship")
public class Internship {

    @Id
    @Column(name = "internship_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int internship_id;


    @Column(nullable = false,name="company_name")
    private String company_name;

    @Column(nullable = false, name = "role_description")
    private String role_description;

    @Column(nullable = false,name = "requirements")
    private String requirements;

    @Column(nullable = false, name = "manager")
    private String manager;


    @Column(nullable = false,name="start_date")
    private Date start_date = new Date();

    @Column(name="end_date")
    private Date end_date = new Date();

    //   String Duration;//derived it is

    @Column(nullable = false,name = "mode")
    private String mode;//online or offline

    @Column(nullable = false,name = "location")
    private String location; //applied only if offline

    @Column(name = "type")
    private String type;


    public int getOpening() {
        return opening;
    }

    public void setOpening(int opening) {
        this.opening = opening;
    }
    @Column(name = "opening",nullable = false)
    private int opening;
    @JsonIgnore
    @ManyToMany(mappedBy="applied_internships")
    private Set<Student> applied_students;

    @JsonIgnore
    @ManyToMany(mappedBy="guided_internships")
    private Set<Staff> staff_incharge;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy="on_going_internship",cascade = CascadeType.ALL)
    private Set<Student> working_students;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,mappedBy="internship",cascade = CascadeType.ALL)
    private Set<Document> documents;

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    @JsonIgnore
    @ManyToMany(mappedBy="funded_internships")
    private Set<Fund> funds;

    public Set<Fund> getFunds() {
        return funds;
    }

    public void setFunds(Set<Fund> funds) {
        this.funds = funds;
    }

    public Set<Student> getWorking_students() {
        return working_students;
    }

    public void setWorking_students(Set<Student> working_students) {
        this.working_students = working_students;
    }

    public Internship() {
        super();
    }

    public Set<Student> getApplied_students() {
        return applied_students;
    }

    public void setApplied_students(Set<Student> applied_students) {
        this.applied_students = applied_students;
    }

    public Internship(int internship_id, String company_name, String role_description, String requirements, String manager, Date start_date, Date end_date, String mode, String location, String type,int opening) {
       super();
        this.internship_id = internship_id;
        this.company_name = company_name;
        this.role_description = role_description;
        this.requirements = requirements;
        this.manager = manager;
        this.start_date = start_date;
        this.end_date = end_date;
        this.mode = mode;
        this.location = location;
        this.type = type;
        this.opening=opening;
    }

    public int getInternship_id() {
        return internship_id;
    }

    public void setInternship_id(int internship_id) {
        this.internship_id = internship_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getRole_description() {
        return role_description;
    }

    public void setRole_description(String role_description) {
        this.role_description = role_description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Internship{" +
                "internship_id=" + internship_id +
                ", company_name='" + company_name + '\'' +
                ", role_description='" + role_description + '\'' +
                ", requirements='" + requirements + '\'' +
                ", manager='" + manager + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", mode='" + mode + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
