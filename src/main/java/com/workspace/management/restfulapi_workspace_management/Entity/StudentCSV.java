package com.workspace.management.restfulapi_workspace_management.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class StudentCSV {
    private String student_first_name;
    private String resume;
    private String student_last_name;
    private String batch;
    private String USN;
    private String department;
    private String phone_number;
    private String email_id;
    private String applied_project_company_name;
    private String applied_internship_company_name;
    private String on_going_project_company_name;
    private String on_going_internship_company_name;

    public StudentCSV(String student_first_name, String student_mid_name, String student_last_name, String batch, String USN, String department, String phone_number, String email_id) {
        this.student_first_name = student_first_name;
        this.resume = student_mid_name;
        this.student_last_name = student_last_name;
        this.batch = batch;
        this.USN = USN;
        this.department = department;
        this.phone_number = phone_number;
        this.email_id = email_id;
    }
}
