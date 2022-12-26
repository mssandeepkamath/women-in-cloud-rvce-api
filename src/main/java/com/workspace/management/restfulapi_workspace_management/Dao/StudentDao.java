package com.workspace.management.restfulapi_workspace_management.Dao;

import com.workspace.management.restfulapi_workspace_management.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,String> {
     // Add queries here using @Query annotations and corresponding functions
}
