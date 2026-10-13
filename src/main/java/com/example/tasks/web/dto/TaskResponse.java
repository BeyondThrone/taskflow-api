package com.example.tasks.web.dto;

import com.example.tasks.domain.Priority;
import com.example.tasks.domain.Status;
import com.example.tasks.domain.Task;

import java.time.Instant;
import java.time.LocalDate;

public record TaskResponse(
        Long id,
        String title,
        String description,
        Status status,
        Priority priority,
        LocalDate dueDate,
        Instant createdAt,
        Instant updatedAt
) {
    public static TaskResponse from(Task t) {
        return new TaskResponse(
                t.getId(),
                t.getTitle(),
                t.getDescription(),
                t.getStatus(),
                t.getPriority(),
                t.getDueDate(),
                t.getCreatedAt(),
                t.getUpdatedAt()
        );
    }
}