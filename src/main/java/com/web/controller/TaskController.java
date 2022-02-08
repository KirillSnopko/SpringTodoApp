package com.web.controller;

import com.web.entity.Comment;
import com.web.entity.Task;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.web.utils.ConstantClass.*;

@Controller
@RequestMapping({URL_ADMIN_TASK_, URL_TASK_})
public class TaskController extends AbstactController {
    private static final Logger LOGGER = Logger.getLogger(TaskController.class.getName());

    @GetMapping(URL_ADMIN_TASK_DELETE)
    public String deleteTaskById(@RequestParam(TASK_ID) int taskId, @RequestParam(PROJECT_ID) int projectId) {
        tasksSevice.deleteTaskById(taskId);
        LOGGER.log(Level.INFO, getUser().getLogin() + LOGGER_DELETE_TASK + taskId);
        return REDIRECT_PROJECT_GET_ + projectId;
    }

    @PostMapping(URL_TASK_ADD)
    public String addTask(@ModelAttribute(TASK) Task task) {
        int projectId = task.getIdProject();
        tasksSevice.addTask(task);
        LOGGER.log(Level.INFO, getUser().getLogin() + LOGGER_CREATE_TASK);
        return REDIRECT_PROJECT_GET_ + projectId;
    }

    @GetMapping(URL_TASK_GET_)
    public ModelAndView displayTasks(@RequestParam(TASK_ID) int taskId) {
        Task task = tasksSevice.getTask(taskId);
        String login = getUser().getLogin();
        List<Comment> comments = commentRepository.getByIdTask(taskId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(TASKS);
        modelAndView.addObject(TASK, task);
        modelAndView.addObject(COMMENTS, comments);
        modelAndView.addObject(LOGIN, login);
        return modelAndView;
    }

    @PostMapping(URL_TASK_ADD_COMMENT)
    public String addComment(@ModelAttribute(COMMENT) Comment comment, @Param(ID_TASK) int idTask) {
        commentRepository.addSave(comment);
        LOGGER.log(Level.INFO, getUser().getLogin() + LOGGER_ADD_COMMENT + idTask);
        return REDIRECT_TASK_GET_ + idTask;
    }

    @PostMapping(URL_TASK_CHANGE_STATUS)
    public String updateTaskStatus(@Param(ID_TASK) int idTask, @Param(STATUS) String status) {
        tasksSevice.changeStatus(status, idTask);
        LOGGER.log(Level.INFO, getUser().getLogin() + LOGGER_CHANGE_STATUS_TASK + idTask + LOGGER_NEW_STATUS + status);
        return REDIRECT_TASK_GET_ + idTask;
    }
}
