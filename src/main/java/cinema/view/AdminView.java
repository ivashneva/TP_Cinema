package cinema.view;

import cinema.model.Admin;
import cinema.service.AdminService;
import org.hibernate.service.spi.ServiceException;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AdminView {

    private AdminService adminService = new AdminService();
    private Scanner firstScan = new Scanner(System.in);
    private Scanner secondScan = new Scanner(System.in);

    private static void actions() {
        System.out.println("\nChoose admin action:\n"
                + "1-Insert new row.\n"
                + "2-Show all row.\n"
                + "3-Delete row.\n"
                + "4-Update row.\n"
                + "5-Search by id.\n"
                + "\t0-Exit.");
    }

    public void runAdminView() throws SQLException {
        actions();
        Scanner mainScan = new Scanner(System.in);
        try {
            int numOfPoint = mainScan.nextInt();
            while (numOfPoint != 0) {
                switch (numOfPoint) {
                    case 1:
                        addAdmin();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 2:
                        printAllAdmins();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 3:
                        deleteAdmin();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 4:
                        updateAdmin();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 5:
                        getByIdAdmin();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 0:
                        numOfPoint = 0;
                        break;
                    default:
                        System.out.println("There is no such command.");
                        actions();
                        numOfPoint = mainScan.nextInt();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addAdmin() throws SQLException {
        try {
            Admin admin = new Admin();

            System.out.println("Enter admin name: ");
            String userName = firstScan.nextLine();
            admin.setName(userName);

            System.out.println("Enter phonenumber:");
            String adminPhonenumber = secondScan.nextLine();
            admin.setPhoneNumber(adminPhonenumber);

            adminService.saveAdmin(admin);
            System.out.println("Admin has been created successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void updateAdmin() throws SQLException {
        try {
            System.out.println("Enter id in order to find element :");
            Long id = Long.parseLong(secondScan.next());

            Admin newAdmin = adminService.getAdminById(id);

            System.out.println("Enter admin name: ");
            String userName = firstScan.nextLine();
            newAdmin.setName(userName);

            System.out.println("Enter phonenumber:");
            String adminPhonenumber = secondScan.nextLine();
            newAdmin.setPhoneNumber(adminPhonenumber);

            adminService.updateAdmin(newAdmin);
            System.out.println("Admin has been created successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void deleteAdmin() throws SQLException {
        System.out.println("Enter id in order to delete row:");
        Long id = Long.parseLong(secondScan.next());
        try {
            adminService.deleteAdmin(id);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Admin with id " + id + " has been deleted successfully");
    }

    public void printAllAdmins() throws SQLException {
        List<Admin> admins = adminService.printAllAdmins();
        System.out.println("List of all admins:");
        admins.forEach(admin1 -> System.out.println(admin1.toString()));
    }

    public void getByIdAdmin() throws SQLException {
        System.out.println("Enter id in order to get admin:");
        Long id = Long.parseLong(firstScan.next());
        try {
            if (adminService.getAdminById(id) != null) {
                System.out.println(adminService.getAdminById(id).toString());
            } else {
                System.out.println("This id is doesn't exist.");
            }

        } catch (NullPointerException e) {
            System.out.println("There is no such number.");
            getByIdAdmin();
        }
    }
}
