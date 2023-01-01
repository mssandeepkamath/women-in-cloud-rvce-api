package com.workspace.management.restfulapi_workspace_management.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int event_id;


    @Column(nullable = false, name = "start_date")
    private Date start_date = new Date();

    @Column(nullable = false, name = "end_date")
    private Date end_date = new Date();

    @Column(nullable = false, name = "staff_incharge")
    private String staff_incharge;

    @Column(nullable = false, name = "location")
    private String location;

    @Column(nullable = false, name = "type")
    private String type;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "description")
    private String description;

    @Column(nullable = true, name = "poster")
    private String poster;

    public Event(int event_id, Date start_date, Date end_date, String staff_incharge, String location, String type, String name, String description, String poster, Set<Student> applied_students) {
        this.event_id = event_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.staff_incharge = staff_incharge;
        this.location = location;
        this.type = type;
        this.name = name;
        this.description = description;
        this.poster = poster;
        this.applied_students = applied_students;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "applied_events")
    private Set<Student> applied_students;



    public Set<Student> getApplied_students() {
        return applied_students;
    }

    public void setApplied_students(Set<Student> applied_students) {
        this.applied_students = applied_students;
    }

    public Event() {
        super();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
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

    public String getStaff_incharge() {
        return staff_incharge;
    }

    public void setStaff_incharge(String staff_incharge) {
        this.staff_incharge = staff_incharge;
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
        return "Event{" +
                "event_id=" + event_id +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", staff_incharge='" + staff_incharge + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
