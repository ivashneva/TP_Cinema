package cinema.dao.impl;

import cinema.dao.Dao;
import cinema.hiber.SessionUtil;
import cinema.model.User;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends SessionUtil implements Dao<User> {

    @Override
    public User add(User user) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(user);
        closeTransactionSesstion();
        return user;
    }

    @Override
    public List<User> findAll() throws SQLException {
        openTransactionSession();
        Session session = getSession();
        List<User> users = session.createQuery("FROM User").list();
        closeTransactionSesstion();
        return users;
    }

    @Override
    public User findById(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        User user = session.get(User.class, id);
        closeTransactionSesstion();
        return user;
    }

    @Override
    public User update(User data) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.saveOrUpdate(data);
        closeTransactionSesstion();
        return data;
    }

    @Override
    public void deleteById(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        User user = session.get(User.class, id);
        session.remove(user);
        closeTransactionSesstion();
    }
}
