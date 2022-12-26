package com.workspace.management.restfulapi_workspace_management.Entity;

import java.util.Date;

public class Internship {
    private int internship_id;
    private String company_name;


    private String role_description;
    private String requirements;
    private String manager;
    private Date start_date = new Date();
    private Date end_date = new Date();

    //   String Duration;//derived it is
    String mode;//online or offline
    String location; //applied only if offline
    String type;//wts this?

    public Internship() {
        super();
    }

    public Internship(int internship_id, String company_name, String role_description, String requirements, String manager, Date start_date, Date end_date, String mode, String location, String type) {
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
