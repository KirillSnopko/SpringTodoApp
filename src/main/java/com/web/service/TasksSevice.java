package com.web.service;

import com.web.entity.Task;
import com.web.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksSevice {
    @Autowired
    public TaskRepository taskRepository;

    public List<Task> getByProjectId(int id) {
        return taskRepository.getByIdProject(id);
    }

    public void addTask(Task task) {
        taskRepository.addSave(task.getIdProject(), task.getTask(), task.getIdUser());
    }

    public void deleteTaskById(int idTask) {
        taskRepository.deleteTaskByTaskId(idTask);
    }

    public Task getTask(int id) {
        return taskRepository.getTaskByTaskId(id);
    }

    public void changeStatus(String status, int id){
        taskRepository.changeStatus(status,id);
    }
}
