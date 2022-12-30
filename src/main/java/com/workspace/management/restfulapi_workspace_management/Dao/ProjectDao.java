package com.workspace.management.restfulapi_workspace_management.Dao;

import com.workspace.management.restfulapi_workspace_management.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectDao extends JpaRepository<Project,Integer> {
// Add queries here using @Query annotations and corresponding functions

}
