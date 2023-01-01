package com.workspace.management.restfulapi_workspace_management.Dao;

import com.workspace.management.restfulapi_workspace_management.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface EventDao extends JpaRepository<Event,Integer> {
    @Query(value = "SELECT * FROM event where end_date < :currentDate",nativeQuery = true)
    public List<Event> getArchivedEvent(@Param("currentDate") Date currentDate);

    @Query(value = "SELECT * FROM event where end_date >= :currentDate",nativeQuery = true)
    public List<Event> getActiveEvent(@Param("currentDate") Date currentDate);
// Add queries here using @Query annotations and corresponding functions
}

