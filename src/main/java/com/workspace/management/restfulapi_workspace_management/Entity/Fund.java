package com.workspace.management.restfulapi_workspace_management.Entity;


import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "fund")
public class Fund {

    @Id
    @Column(name = "fund_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fund_id;

    @Column(name = "organization_name")
    private String organization_name;

    @Column(name = "amount")
    private double amount;

    @Column(name = "date")
    private Date date = new Date();


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "funded_projects",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "fund_id")})
    private Set<Project> funded_projects;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "funded_internships",
            joinColumns = {@JoinColumn(name = "internship_id")},
            inverseJoinColumns = {@JoinColumn(name = "fund_id")})
    private Set<Internship> funded_internships;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "funded_events",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "fund_id")})
    private Set<Event> funded_events;

    public Fund() {

    }

    public int getFund_id() {
        return fund_id;
    }

    public void setFund_id(int fund_id) {
        this.fund_id = fund_id;
    }

    public String getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Project> getFunded_projects() {
        return funded_projects;
    }

    public void setFunded_projects(Set<Project> funded_projects) {
        this.funded_projects = funded_projects;
    }

    public Set<Internship> getFunded_internships() {
        return funded_internships;
    }

    public void setFunded_internships(Set<Internship> funded_internships) {
        this.funded_internships = funded_internships;
    }

    public Set<Event> getFunded_events() {
        return funded_events;
    }

    public void setFunded_events(Set<Event> funded_events) {
        this.funded_events = funded_events;
    }

    @Override
    public String toString() {
        return "Fund{" +
                "fund_id=" + fund_id +
                ", organization_name='" + organization_name + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", funded_projects=" + funded_projects +
                ", funded_internships=" + funded_internships +
                ", funded_events=" + funded_events +
                '}';
    }

    public Fund(int fund_id, String organization_name, double amount, Date date) {
        this.fund_id = fund_id;
        this.organization_name = organization_name;
        this.amount = amount;
        this.date = date;
    }
}
