package com.workspace.management.restfulapi_workspace_management.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;


@Entity
public class Event {

    private int event_id;
    private Date start_date=new Date();
    private Date end_date=new Date();
    private String staff_incharge;
    private String location;
    private String type;

    public Event() {
        super();
    }
    public Event(int event_id, Date start_date, Date end_date, String staff_incharge, String location, String type) {
        super();
        this.event_id = event_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.staff_incharge = staff_incharge;
        this.location = location;
        this.type = type;
    }

@Id
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
