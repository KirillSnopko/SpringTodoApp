package com.web.utils;

public class ConstantClass {

    /*
    Mapper & Repo
     */
    public final static String ID = "id";
    public final static String ID_TASK = "idTask";
    public final static String ID_PROJECT = "idProject";
    public final static String ID_USER = "idUser";
    public final static String TASK = "task";
    public final static String LOGIN = "login";
    public final static String COMMENT = "comment";
    public final static String DATE = "date";
    public final static String DATE_START = "dateStart";
    public final static String DATE_FINISH = "dateFinish";
    public final static String STATUS = "status";
    public final static String FIRST_NAME = "firstName";
    public final static String SECOND_NAME = "secondName";
    public final static String USERNAME = "username";
    public final static String PASSWORD = "password";
    public final static String EMAIL = "email";
    public final static String AUTHORITY = "authority";
    public final static String NOOP = "{noop}";
    public final static String ROLE_USER = "ROLE_USER";
    public final static String ROLE_ADMIN = "ROLE_ADMIN";

    /*
    URL
     */
    public final static String URL_USER = "/user";
    public final static String URL_ADMIN_TASK_ = "/admin/task/**";
    public final static String URL_TASK_ = "/task/**";
    public final static String URL_ADMIN_TASK_DELETE = "/admin/task/delete/*";
    public final static String URL_TASK_ADD = "/task/add";
    public final static String URL_TASK_GET_ = "/task/get/*";
    public final static String URL_TASK_ADD_COMMENT = "/task/add/comment";
    public final static String URL_TASK_CHANGE_STATUS = "/task/change/status";
    public final static String URL_PROJECT_ = "/project/*";
    public final static String URL_ADMIN_PROJECT_ = "/admin/project/*";
    public final static String URL_ADMIN_PROJECT_DELETE = "/admin/project/delete/*";
    public final static String URL_ADMIN_PROJECT_ADD = "/admin/project/add/";
    public final static String URL_ADMIN_PROJECT_CHANGE_STATUS = "/admin/project/change/status/";
    public final static String URL_PROJECT_GET = "/project/get/*";
    public final static String URL_PROJECT_USER = "/project/add_user/";
    public final static String URL_WELCOM = "/";
    public final static String URL_LOGIN = "/login";
    public final static String URL_SIGN_UP = "/sign_up";
    public final static String URL_SIGNUP =  "/signup";


    public final static String REDIRECT_PROJECT_GET_ = "redirect:/project/get/?projectId=";
    public final static String REDIRECT_TASK_GET_ = "redirect:/task/get/?taskId=";
    public final static String REDIRECT_USER = "redirect:/user";
    public final static String REDIRECT_LOGIN =  "redirect:/login";

    /*
    @RequestParam
     */
    public final static String TASK_ID = "taskId";
    public final static String PROJECT_ID = "projectId";
    public final static String PROJECTS_ID = "projectsId";


    /*
    LOGGER
     */
    public final static String LOGGER_DELETE_TASK = " deleted task id=";
    public final static String LOGGER_CREATE_TASK = " created new task.";
    public final static String LOGGER_ADD_COMMENT = " added new comment for task id=";
    public final static String LOGGER_CHANGE_STATUS_TASK = " changed task status. id=";
    public final static String LOGGER_NEW_STATUS = " new status -> ";
    public final static String LOGGER_DELETE_PROJECT = " deleted project id=";
    public final static String LOGGER_NEW_PROJECT = " created new project.";
    public final static String LOGGER_CHANGE_STATUS_PROJECT = " changed project status. id=";
    public final static String LOGGER_ADD_USER =  " added user id=";
    public final static String LOGGER_IN_PROJECT = " in project id=";
    public final static String LOGGER_LOG_UP = " is logged up";
    public final static String LOGGER_LOG_IN = " is logged in";

    /*
    Controller
     */
    public final static String TASKS = "tasks";
    public final static String COMMENTS = "comments";
    public final static String USER = "user";
    public final static String PROJECTS = "projects";
    public final static String PROJECT = "project";
    public final static String USERS_IN_PROJECT = "usersInProject";
    public final static String USERS_OUT_PROJECT = "usersOutProject";
    public final static String WELCOM = "welcom";
    public final static String REGISTRATION =  "registration";
    public final static String NULL = "";
    public final static String SESSION = "session";
    public final static String NOTHING = "nothing";

}
