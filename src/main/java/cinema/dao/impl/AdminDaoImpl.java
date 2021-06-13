package cinema.dao.impl;

import cinema.dao.Dao;
import cinema.hiber.SessionUtil;
import cinema.model.Admin;
import org.hibernate.Session;


import java.sql.SQLException;
import java.util.List;

public class AdminDaoImpl extends SessionUtil implements Dao<Admin> {

    @Override
    public Admin add(Admin admin) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(admin);
        closeTransactionSesstion();
        return admin;
    }

    @Override
    public List<Admin> findAll() throws SQLException {
        openTransactionSession();
        Session session = getSession();
        List<Admin> admins = session.createQuery("FROM Admin").list();
        closeTransactionSesstion();
        return admins;
    }

    @Override
    public Admin findById(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        Admin admin = session.get(Admin.class, id);
        closeTransactionSesstion();
        return admin;
    }

    @Override
    public Admin update(Admin data) throws SQLException {
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
        Admin admin = session.get(Admin.class, id);
        session.remove(admin);
        closeTransactionSesstion();
    }
}
