package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();  //создаем таблицу
        userService.saveUser("Yan", "Malashyn", (byte) 27);  //добавляем 4 Usera
        userService.saveUser("Ivan", "Ivanov", (byte) 65);
        userService.saveUser("Sergei", "Petrov", (byte) 15);
        userService.saveUser("Jenya", "Gorin", (byte) 35);
        List<User> userList  = userService.getAllUsers();  // получаем таблицу
        System.out.println(userList);
        userService.cleanUsersTable();  // чистим таблицу
        userService.dropUsersTable();  // удаляем таблицу








    }
}
