package cinema.service;

import cinema.dao.Dao;
import cinema.dao.impl.AdminDaoImpl;
import cinema.model.Admin;

import java.sql.SQLException;
import java.util.List;

public class AdminService {

    private Dao<Admin> adminDao = new AdminDaoImpl();

    public List<Admin> printAllAdmins() throws SQLException {
        return adminDao.findAll();
    }

    public void saveAdmin(Admin admin) throws SQLException {
        adminDao.add(admin);
    }

    public void deleteAdmin(Long id) throws SQLException {
        adminDao.deleteById(id);
    }

    public void updateAdmin(Admin newAdmin) throws SQLException {
        adminDao.update(newAdmin);
    }

    public Admin getAdminById(Long id) throws SQLException {
        return adminDao.findById(id);
    }
}
