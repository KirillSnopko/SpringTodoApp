package com.web.utils;

public class SqlQueries {

    /*
    comment
     */
    public final static String ADD_COMMENT = "insert into comments (idProject,idTask, login, comment, date) values(?,?,?,?, NOW())";
    public final static String GET_COMMENT_BY_ID_TASK = "SELECT * FROM comments where idTask=?";
    public final static String DELETE_COMMENTS = "delete from comments where idTask=?";
    public final static String DELETE_COMMENTS_BY_PROJECT_ID = "delete from comments where idProject = ?";

    /*
    task
     */
    public final static String ADD_TASK = "insert into tasks (idProject, task, idUser, dateStart) values(?,?,?,now())";
    public final static String GET_BY_ID_PROJECT = "SELECT * FROM tasks where idProject=?";
    public final static String GET_TASK_BY_ID_TASK = "SELECT * FROM tasks where id=?";
    public final static String CHANGE_STATUS_TASK = "update tasks set status=? where id=?";
    public final static String CHANGE_STATUS_TASK_AND_FINISH = "update tasks set status=?, dateFinish=now() where id=?";
    public final static String DELETE_TASK = "delete from tasks where id=?";
    public final static String DELETE_TASKS_BY_PROJECT_ID = "delete from tasks where idProject=?";

    /*
    project
     */
    public final static String GET_LIST_PROJECT_BY_USER_ID = "SELECT projects.id FROM projects join user_project on projects.id=user_project.idProject where user_project.userId=?";
    public final static String GET_LIST_PROJECT_BY_ADMIN_ID = "SELECT projects.id FROM projects where adminId=?";
    public final static String ADD_PROJECT = "insert into projects (adminId) values (?)";
    public final static String GET_PROJECT_BY_USERNAME = "SELECT projects.id, projects.admin, projects.status FROM projects join user_project on projects.id=user_project.idProject where user_project.login=?";
    public final static String GET_PROJECT_BY_ID = "SELECT projects.id, users.username, projects.status FROM projects join users on projects.adminId=users.id where projects.id=?";
    public final static String ADD_USER_IN_PROJECT = "insert into user_project (userId, idProject) values (?,?)";
    public final static String CHANGE_PROJECT_STATUS = "update projects set status=? where id=?";
    public final static String DELETE_PROJECT_BY_ID = "delete from projects where id = ?";
    public final static String DELETE_FROM_USER_PROJECT_BY_PROJECT_ID =  "delete from user_project where idProject = ?";

    /*
    user
     */
    public final static String ADD_USER = "insert into users (firstName, secondName, username, password, email, authority) values (?,?,?,?,?,?)";
    public final static String GET_USER_BY_USERNAME = "SELECT users.id, users.firstName, users.secondName, users.username," +
            " users.password, users.email, users.authority from users where username=?";
    public final static String GET_USERS_IN_PROJECT = "SELECT users.id, users.firstName, users.secondName, users.username," +
            " users.password, users.email, users.authority FROM users join user_project on users.id=user_project.userId where user_project.idProject=?";
    public final static String GET_ALL_USERS = "SELECT users.id, users.firstName, users.secondName, users.username, users.password, users.email, users.authority FROM users";
}
