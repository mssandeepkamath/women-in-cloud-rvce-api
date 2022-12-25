package com.workspace.management.restfulapi_workspace_management.Entity;

import java.util.Date;

public class Workshop {
    int workshop_id;
    Date start_date=new Date();
    Date end_date=new Date();
    String Staff_incharge;
    String location;

    public int getWorkshop_id() {
        return workshop_id;
    }

    public void setWorkshop_id(int workshop_id) {
        this.workshop_id = workshop_id;
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
        return Staff_incharge;
    }

    public void setStaff_incharge(String staff_incharge) {
        Staff_incharge = staff_incharge;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
