package cinema.service;

import cinema.dao.Dao;
import cinema.dao.impl.UserDaoImpl;
import cinema.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private Dao<User> userDao = new UserDaoImpl();

    public List<User> printAllUsers() throws SQLException {
        return userDao.findAll();
    }

    public void saveUser(User user) throws SQLException {
        userDao.add(user);
    }

    public void deleteUser(Long id) throws SQLException {
        userDao.deleteById(id);
    }

    public void updateUser(User newUser) throws SQLException {
        userDao.update(newUser);
    }

    public User getUserById(Long id) throws SQLException {
        return userDao.findById(id);
    }
}