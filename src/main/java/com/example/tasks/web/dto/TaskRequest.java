package com.example.tasks.web.dto;

import com.example.tasks.domain.Priority;
import com.example.tasks.domain.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record TaskRequest(
        @NotBlank @Size(max = 200) String title,
        @Size(max = 2000) String description,
        Status status,
        Priority priority,
        LocalDate dueDate
) {
}