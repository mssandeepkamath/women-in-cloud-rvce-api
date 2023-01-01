package com.workspace.management.restfulapi_workspace_management.Dao;

import com.workspace.management.restfulapi_workspace_management.Entity.Project;
import com.workspace.management.restfulapi_workspace_management.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProjectDao extends JpaRepository<Project,Integer> {
// Add queries here using @Query annotations and corresponding functions
    @Query(value = "SELECT * FROM project p where p.opening>0",nativeQuery = true)
    public List<Project> getProjectByOpening();

    @Query(value = "SELECT  * FROM project p where p.opening<1",nativeQuery = true)
    public List<Project> getArchivedProject();
}
