package com.workspace.management.restfulapi_workspace_management.Dao;

import com.workspace.management.restfulapi_workspace_management.Entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;

public interface DocumentDao extends JpaRepository<Document,Integer> {

    @Query(value = "select * from document d where d.document_name=:document_name",nativeQuery = true)
    Document findByDocName(@Param("document_name") String document_name);

}
