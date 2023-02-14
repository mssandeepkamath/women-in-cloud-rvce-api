package com.workspace.management.restfulapi_workspace_management.Dao;

import com.workspace.management.restfulapi_workspace_management.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentDao extends JpaRepository<Student,String> {
     // Add queries here using @Query annotations and corresponding functions

    @Query(value = "SELECT * FROM student s WHERE s.USN = :USN",nativeQuery = true)
    public  Student getStudentByUSN(@Param("USN") String USN);

    @Query(value = "SELECT USN FROM student s WHERE s.email_id = :email_id",nativeQuery = true)
    public String getUSN(@Param("email_id") String email_id);


}
