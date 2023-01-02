package com.workspace.management.restfulapi_workspace_management.Util;

import com.workspace.management.restfulapi_workspace_management.Entity.Internship;
import com.workspace.management.restfulapi_workspace_management.Entity.Project;
import com.workspace.management.restfulapi_workspace_management.Entity.Student;
import com.workspace.management.restfulapi_workspace_management.Service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

 public class MailSenderThread implements Runnable {


    private EmailSenderService emailSenderService;
    private Student student;
    private Project project = null;
    private Internship internship = null;

    public MailSenderThread(EmailSenderService emailSenderService, Student student, Project project) {
        this.emailSenderService=emailSenderService;
        this.student = student;
        this.project = project;
    }

    public MailSenderThread(EmailSenderService emailSenderService,Student student, Internship internship) {
        this.emailSenderService=emailSenderService;
        this.student = student;
        this.internship = internship;
    }

    @Override
    public void run() {

        String body;

        body = (internship == null) ? "Hi,\nRegarding your application for " + project.getCompany_name() + "," +
                "we have reviewed your resume and found you as a right candidate for the project." +
                "\nThis is your access token for workspace{access_token}\nThanks and regards,\nCOE admin,\nWIC,\nR V College of Engineering, Bengaluru" :
                "Hi,\nRegarding your application for " + internship.getCompany_name() + ", " +
                        "we have reviewed your resume and found you as a right candidate for the internship." +
                        "\nThis is your access token for workspace{access_token}\nThanks and regards,\nCOE admin,\nWIC,\nR V College of Engineering, Bengaluru";

        try {
            emailSenderService.sendSimpleEmail(student.getEmail_id(), body, "You are HIRED!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}