package com.workspace.management.restfulapi_workspace_management.Service;


import com.workspace.management.restfulapi_workspace_management.Dao.DocumentDao;
import com.workspace.management.restfulapi_workspace_management.Dao.StudentDao;
import com.workspace.management.restfulapi_workspace_management.Entity.Document;
import com.workspace.management.restfulapi_workspace_management.Entity.Internship;
import com.workspace.management.restfulapi_workspace_management.Entity.Student;
import com.workspace.management.restfulapi_workspace_management.Entity.StudentChapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
