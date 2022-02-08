package com.web.service;

import com.web.entity.User;
import com.web.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByLogin(String login) {
        return userRepository.getByUserName(login);
    }

    public Map<Integer, String> getUsersInProjectByProjectId(int id) {
        List<User> userList = userRepository.getUsersInProjectByProjectId(id);
        ;
        Map<Integer, String> userMap = new HashMap<>();
        for (User user : userList) {
            userMap.put(user.getId(), user.getLogin());
        }
        return userMap;
    }

    public void addSave(User user) {
        userRepository.addSave(user);
    }

    public Map<Integer, String> getUsersOutProjectId(int id) {
        List<User> userList1 = userRepository.getUsersInProjectByProjectId(id);
        List<User> userList2 = userRepository.getAllUsers();
        Map<Integer, String> usersMap = new HashMap<>();
        for (User user : userList1) {
            userList2.remove(user);
        }
        for (User user : userList2) {
            usersMap.put(user.getId(), user.getLogin());
        }
        return usersMap;
    }
}
