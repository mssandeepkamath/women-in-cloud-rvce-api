package com.workspace.management.restfulapi_workspace_management.Entity;

public class Student {
    String stu_first_name;
    String stu_mid_name;
    String stu_last_name;
    String Batch;
    String USN;//check if something varchar datatype as in sql is avalaible
    String Department;
    String ph_number;
    String email_id;

    public String getStu_first_name() {
        return stu_first_name;
    }

    public void setStu_first_name(String stu_first_name) {
        this.stu_first_name = stu_first_name;
    }

    public String getStu_mid_name() {
        return stu_mid_name;
    }

    public void setStu_mid_name(String stu_mid_name) {
        this.stu_mid_name = stu_mid_name;
    }

    public String getStu_last_name() {
        return stu_last_name;
    }

    public void setStu_last_name(String stu_last_name) {
        this.stu_last_name = stu_last_name;
    }

    public String getBatch() {
        return Batch;
    }

    public void setBatch(String batch) {
        Batch = batch;
    }

    public String getUSN() {
        return USN;
    }

    public void setUSN(String USN) {
        this.USN = USN;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getEmailid() {
        return email_id;
    }

    public void setEmailid(String email_id) {
        this.email_id = email_id;
    }

    public String getPh_number() {
        return ph_number;
    }

    public void setPh_number(String ph_number) {
        this.ph_number = ph_number;
    }
}
