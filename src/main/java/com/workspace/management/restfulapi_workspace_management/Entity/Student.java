package com.workspace.management.restfulapi_workspace_management.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    private String student_first_name;
    private String student_mid_name;
    private String student_last_name;
    private String batch;
    private String USN;//check if something varchar datatype as in sql is avalaible
    private String department;
    private String phone_number;
    private String email_id;

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

    @Id
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
