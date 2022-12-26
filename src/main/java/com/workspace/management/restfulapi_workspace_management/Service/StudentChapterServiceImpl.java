package com.workspace.management.restfulapi_workspace_management.Service;


import com.workspace.management.restfulapi_workspace_management.Dao.StudentDao;
import com.workspace.management.restfulapi_workspace_management.Entity.StudentChapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentChapterServiceImpl implements StudentChapterService {

    @Autowired
   private StudentDao studentDao;
    @Override
    public List<StudentChapter> getStudentChapter() {
        return null;
    }
}
