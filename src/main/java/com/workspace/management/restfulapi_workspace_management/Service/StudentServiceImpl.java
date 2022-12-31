package com.workspace.management.restfulapi_workspace_management.Service;

import com.workspace.management.restfulapi_workspace_management.Dao.StudentDao;
import com.workspace.management.restfulapi_workspace_management.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public HttpStatus studentRegister(Student student) {
        try
        {
            studentDao.save(student);
            return HttpStatus.OK;
        }
      catch (Exception e)
        {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }
}
