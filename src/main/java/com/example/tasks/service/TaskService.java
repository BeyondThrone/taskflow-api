package com.example.tasks.service;

import com.example.tasks.domain.Status;
import com.example.tasks.domain.Task;
import com.example.tasks.repo.TaskRepository;
import com.example.tasks.web.NotFoundException;
import com.example.tasks.web.dto.TaskRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public Page<Task> list(Status status, String q, Pageable pageable) {
        if (q != null && !q.isBlank()) {
            return repo.searchByTitle(q, pageable);
        }
        if (status != null) {
            return repo.findByStatus(status, pageable);
        }
        return repo.findAll(pageable);
    }

    public Task get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Task " + id + " not found"));
    }

    @Transactional
    public Task create(TaskRequest req) {
        Task t = new Task();
        apply(t, req);
        return repo.save(t);
    }

    @Transactional
    public Task update(Long id, TaskRequest req) {
        Task t = get(id);
        apply(t, req);
        return repo.save(t);
    }

    @Transactional
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Task " + id + " not found");
        }
        repo.deleteById(id);
    }

    private void apply(Task t, TaskRequest req) {
        t.setTitle(req.title());
        t.setDescription(req.description());
        if (req.status() != null) t.setStatus(req.status());
        if (req.priority() != null) t.setPriority(req.priority());
        t.setDueDate(req.dueDate());
    }
}