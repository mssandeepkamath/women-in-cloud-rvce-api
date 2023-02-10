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

    @Query(value = "select student_first_name,student_last_name,s.USN,email_id,phone_number,department,batch,student_mid_name from project_applied p,student s where s.USN=p.USN",nativeQuery = true)
    public List<Student> allAppliedStudent();
}
