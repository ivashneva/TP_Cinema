package cinema.view;

import cinema.model.User;
import cinema.service.UserService;
import org.hibernate.service.spi.ServiceException;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserView {

    private UserService userService = new UserService();
    private Scanner firstScan = new Scanner(System.in);
    private Scanner secondScan = new Scanner(System.in);

    private static void actions() {
        System.out.println("\nChoose user action:\n"
                + "1-Insert new row.\n"
                + "2-Show all row.\n"
                + "3-Delete row.\n"
                + "4-Update row.\n"
                + "5-Search by id.\n"
                + "\t0-Exit.");
    }

    public void runUserView() throws SQLException {
        actions();
        Scanner mainScan = new Scanner(System.in);
        try {
            int numOfPoint = mainScan.nextInt();
            while (numOfPoint != 0) {
                switch (numOfPoint) {
                    case 1:
                        addUser();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 2:
                        printAllUsers();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 3:
                        deleteUser();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 4:
                        updateUser();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 5:
                        getByIdUser();

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

    public void addUser() throws SQLException {
        try {
            User user = new User();

            System.out.println("Enter user name: ");
            String userName = firstScan.nextLine();
            user.setName(userName);

            System.out.println("Enter dateOfBirth:");
            String userDateOfBirth = secondScan.nextLine();
            user.setDateOfBirth(userDateOfBirth);

            System.out.println("Enter phone number:");
            String userPhoneNumber = firstScan.nextLine();
            user.setPhoneNumber(userPhoneNumber);

            System.out.println("Enter email:");
            String userEmail = secondScan.nextLine();
            user.setEmail(userEmail);

            userService.saveUser(user);
            System.out.println("User has been created successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void updateUser() throws SQLException {
        try {
            System.out.println("Enter id in order to find element :");
            Long id = Long.parseLong(secondScan.next());

            User newUser = userService.getUserById(id);

            System.out.println("Enter user name: ");
            String userName = firstScan.nextLine();
            newUser.setName(userName);

            System.out.println("Enter dateOfBirth:");
            String userDateOfBirth = secondScan.nextLine();
            newUser.setDateOfBirth(userDateOfBirth);

            System.out.println("Enter phone number:");
            String userPhoneNumber = firstScan.nextLine();
            newUser.setPhoneNumber(userPhoneNumber);

            System.out.println("Enter email:");
            String userEmail = secondScan.nextLine();
            newUser.setEmail(userEmail);

            userService.updateUser(newUser);
            System.out.println("User with id " + id + " has been updated successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void deleteUser() throws SQLException {
        System.out.println("Enter id in order to delete row:");
        Long id = Long.parseLong(secondScan.next());
        try {
            userService.deleteUser(id);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("User with id " + id + " has been deleted successfully");
    }

    public void printAllUsers() throws SQLException {
        List<User> users = userService.printAllUsers();
        System.out.println("List of all users:");
        users.forEach(user1 -> System.out.println(user1.toString()));
    }

    public void getByIdUser() throws SQLException {
        System.out.println("Enter id in order to get user:");
        Long id = Long.parseLong(firstScan.next());
        try {
            if (userService.getUserById(id) != null) {
                System.out.println(userService.getUserById(id).toString());
            } else {
                System.out.println("This id is doesn't exist.");
            }

        } catch (NullPointerException e) {
            System.out.println("There is no such number.");
            getByIdUser();
        }
    }
}
