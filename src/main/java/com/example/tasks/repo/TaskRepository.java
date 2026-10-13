package com.example.tasks.repo;

import com.example.tasks.domain.Status;
import com.example.tasks.domain.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> findByStatus(Status status, Pageable pageable);

    List<Task> findByDueDateBeforeAndStatusNot(LocalDate date, Status status);

    @Query("select t from Task t where lower(t.title) like lower(concat('%', :q, '%'))")
    Page<Task> searchByTitle(@Param("q") String q, Pageable pageable);
}