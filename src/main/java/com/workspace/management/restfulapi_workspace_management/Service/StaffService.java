package com.workspace.management.restfulapi_workspace_management.Service;

import com.workspace.management.restfulapi_workspace_management.Entity.Staff;

import java.util.List;

public interface StaffService {

    public Object addStaff(Staff staff);
    public List<Staff> getAllStaff();
}
