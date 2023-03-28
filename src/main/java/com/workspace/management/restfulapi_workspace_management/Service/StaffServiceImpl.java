package com.workspace.management.restfulapi_workspace_management.Service;


import com.workspace.management.restfulapi_workspace_management.Dao.StaffDao;
import com.workspace.management.restfulapi_workspace_management.Entity.Staff;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService{

    @Autowired
    private StaffDao staffDao;

    @Override
    public Object addStaff(Staff staff) {
        JSONObject jsonObject = new JSONObject();
        try
        {
            staffDao.save(staff);
            jsonObject.put("status", HttpStatus.OK);
            return jsonObject.toMap();

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            jsonObject.put("status",HttpStatus.INTERNAL_SERVER_ERROR);
            return jsonObject.toMap();
        }

    }

    @Override
    public List<Staff> getAllStaff() {
        return staffDao.findAll();
    }
}
