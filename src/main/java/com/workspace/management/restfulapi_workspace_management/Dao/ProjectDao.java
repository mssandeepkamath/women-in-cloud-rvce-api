package com.workspace.management.restfulapi_workspace_management.Dao;

import com.workspace.management.restfulapi_workspace_management.Entity.Project;
import com.workspace.management.restfulapi_workspace_management.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProjectDao extends JpaRepository<Project,Integer> {
// Add queries here using @Query annotations and corresponding functions

}
