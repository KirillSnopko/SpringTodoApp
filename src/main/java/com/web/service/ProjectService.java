package com.web.service;

import com.web.entity.Project;
import com.web.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectService {
    @Autowired
    public ProjectRepository projectRepository;

    public Map<Integer, Project> getProjectByUserLogin(String login) {
        Map<Integer, Project> projectHashMap = new HashMap<>();
        List<Project> projectList = projectRepository.getByUserName(login);
        for (Project project : projectList) {
            projectHashMap.put(project.getId(), project);
        }
        return projectHashMap;
    }

    public List<Integer> getListIdByIdUser(int id, String role) {
        return projectRepository.getIdProjectsByIdUser(id, role);
    }

    public Project getProjectById(int id) {
        return projectRepository.getProjectById(id);
    }

    public void deleteProjectById(int id) {
        projectRepository.deleteProject(id);
    }

    public void addProject(int adminId) {
        projectRepository.addProject(adminId);
    }

    public void updateStatus(int idProject, String status) {
        projectRepository.updateStatus(idProject, status);
    }

    public void addUser(int idUser, int idProject) {
        projectRepository.addUserInProject(idUser, idProject);
    }
}
