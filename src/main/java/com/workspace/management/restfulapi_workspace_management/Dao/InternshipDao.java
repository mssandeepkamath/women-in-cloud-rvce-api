package com.workspace.management.restfulapi_workspace_management.Dao;

import com.workspace.management.restfulapi_workspace_management.Entity.Internship;
import com.workspace.management.restfulapi_workspace_management.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InternshipDao extends JpaRepository<Internship, Integer> {
    // Add queries here using @Query annotations and corresponding functions
    @Query(value = "SELECT * FROM internship i where i.opening>0", nativeQuery = true)
    public List<Internship> getInternshipByOpening();
    @Query(value = "SELECT * FROM internship i where i.opening<1", nativeQuery = true)
    public List<Internship> getArchivedInternship();
}
