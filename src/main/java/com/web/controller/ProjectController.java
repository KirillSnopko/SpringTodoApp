package com.web.controller;

import com.web.entity.Project;
import com.web.entity.Task;
import com.web.entity.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.web.utils.ConstantClass.*;

@Controller
@RequestMapping({URL_PROJECT_,URL_USER,URL_ADMIN_PROJECT_})
public class ProjectController extends AbstactController {
    private static final Logger LOGGER = Logger.getLogger(ProjectController.class.getName());

    @GetMapping(URL_USER)
    public ModelAndView displayHomePage(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        User user = getUser();
        List<Integer> projectsId = projectService.getListIdByIdUser(user.getId(), user.getRole());
        modelAndView.addObject(USER, user);
        modelAndView.addObject(PROJECTS_ID, projectsId);
        modelAndView.setViewName(USER);
        return modelAndView;
    }

    @GetMapping(URL_ADMIN_PROJECT_DELETE)
    public String deleteProjectById(@RequestParam(PROJECT_ID) int id) {
        projectService.deleteProjectById(id);
        LOGGER.log(Level.INFO, getUser().getLogin() + LOGGER_DELETE_PROJECT + id);
        return REDIRECT_USER;
    }

    @PostMapping(URL_ADMIN_PROJECT_ADD)
    public String addProject() {
        projectService.addProject(getUser().getId());
        LOGGER.log(Level.INFO, getUser().getLogin() + LOGGER_NEW_PROJECT);
        return REDIRECT_USER;
    }

    @PostMapping(URL_ADMIN_PROJECT_CHANGE_STATUS)
    public String changeProjectStatus(@Param(ID_PROJECT) int idProject, @Param(STATUS) String status) {
        projectService.updateStatus(idProject, status);
        LOGGER.log(Level.INFO, getUser().getLogin() + LOGGER_CHANGE_STATUS_PROJECT + idProject + LOGGER_NEW_STATUS + status);
        return REDIRECT_PROJECT_GET_ + idProject;
    }

    @GetMapping(URL_PROJECT_GET)
    public ModelAndView getProjectAndTasksById(@RequestParam(PROJECT_ID) int id, ModelAndView modelAndView) {
        modelAndView.setViewName(PROJECTS);
        Project project = projectService.getProjectById(id);
        List<Task> tasks = tasksSevice.getByProjectId(id);
        Map<Integer, String> usersInProject = userService.getUsersInProjectByProjectId(id);
        Map<Integer, String> usersOutProject = userService.getUsersOutProjectId(id);
        User user = getUser();
        modelAndView.addObject(USER, user);
        modelAndView.addObject(PROJECT, project);
        modelAndView.addObject(TASKS, tasks);
        modelAndView.addObject(USERS_IN_PROJECT, usersInProject);
        modelAndView.addObject(USERS_OUT_PROJECT, usersOutProject);
        return modelAndView;
    }

    @PostMapping(URL_PROJECT_USER)
    public String addUserInProject(@Param(ID_PROJECT) int idProject, @Param(ID_USER) int idUser) {
        projectService.addUser(idUser, idProject);
        LOGGER.log(Level.INFO, getUser().getLogin() + LOGGER_ADD_USER + idUser + LOGGER_IN_PROJECT + idProject);
        return REDIRECT_PROJECT_GET_ + idProject;
    }
}
