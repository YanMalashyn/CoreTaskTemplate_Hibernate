package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection connection = Util.getConnection();
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS `usershema`.`USER` (\n" +
                    "   `id` BIGINT(20) NOT NULL AUTO_INCREMENT,\n" +
                    "   `name` VARCHAR(45) NOT NULL,\n" +
                    "   `lastname` VARCHAR(45) NOT NULL,\n" +
                    "   `age` TINYINT(3) NULL,\n" +
                    "   PRIMARY KEY (`id`))\n" +
                    "   ENGINE = InnoDB\n" +
                    "   DEFAULT CHARACTER SET = ascii;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS `usershema`.`user`;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(String.format("INSERT INTO user(name, lastname, age)" +
                    "VALUES ('%s', '%s', '%d');", name, lastName, age));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(String.format("DELETE FROM USER WHERE id = '%d'", id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USER");
            while (resultSet.next()){
                User user = new User(resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getByte("age"));
                user.setId((long) resultSet.getInt("id"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("TRUNCATE USER");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
