package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("Yan", "Malashyn", (byte) 27);
        userService.saveUser("Ivan", "Ivanov", (byte) 65);
        userService.saveUser("Sergei", "Petrov", (byte) 15);
        userService.saveUser("Jenya", "Gorin", (byte) 35);
        List<User> userList = userService.getAllUsers();
        System.out.println(userList);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
