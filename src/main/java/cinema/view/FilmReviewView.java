package cinema.view;

import cinema.model.Film;
import cinema.model.FilmReview;
import cinema.model.Admin;
import cinema.model.User;
import cinema.service.FilmService;
import cinema.service.FilmReviewsService;
import cinema.service.AdminService;
import cinema.service.UserService;
import org.hibernate.service.spi.ServiceException;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FilmReviewView {

    private FilmReviewsService filmReviewsService = new FilmReviewsService();
    private FilmService filmService = new FilmService();
    private UserService userService = new UserService();
    private AdminService adminService = new AdminService();

    private Scanner firstScan = new Scanner(System.in);
    private Scanner secondScan = new Scanner(System.in);

    private static void actions() {
        System.out.println("\nChoose filmReview action:\n"
                + "1-Insert new row.\n"
                + "2-Show all row.\n"
                + "3-Delete row.\n"
                + "4-Update row.\n"
                + "5-Search by id.\n"
                + "\t0-Exit.");
    }

    public void runFilmReviewView() throws SQLException {
        actions();
        Scanner mainScan = new Scanner(System.in);
        try {
            int numOfPoint = mainScan.nextInt();
            while (numOfPoint != 0) {
                switch (numOfPoint) {
                    case 1:
                        addFilmReview();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 2:
                        printAllFilmReviews();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 3:
                        deleteFilmReview();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 4:
                        updateFilmReview();

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

    public void addFilmReview() throws SQLException {
        try {
            FilmReview filmReview = new FilmReview();

            System.out.println("Enter issued film title: ");
            String filmReviewTitle = firstScan.nextLine();
            filmReview.setTitle(filmReviewTitle);

            System.out.println("Enter date of issue:");
            String filmReviewDateOfIssue = firstScan.nextLine();
            filmReview.setDateOfReview(filmReviewDateOfIssue);

            System.out.println("Enter return date:");
            String filmReviewReturnDate = firstScan.nextLine();
            filmReview.setReviewRating(filmReviewReturnDate);

            System.out.println("Enter numb of copies issued:");
            String filmReviewNumbOfCopiesIssued = firstScan.nextLine();
            filmReview.setNumbOfReviews(filmReviewNumbOfCopiesIssued);

            Film testFilm = filmService.getFilmById(1L);
            if (testFilm != null) {
                System.out.println("Enter film_id:");
                String filmReviewFilmId = secondScan.nextLine();
                Film film = filmService.getFilmById((long) Integer.parseInt(filmReviewFilmId));
                filmReview.setFilm(film);
            } else filmReview.setFilm(null);

            User testUser = userService.getUserById(1L);
            if (testUser != null) {
                System.out.println("Enter user_id:");
                String filmReviewUserId = secondScan.nextLine();
                User user = userService.getUserById((long) Integer.parseInt(filmReviewUserId));
                filmReview.setUser(user);
            } else filmReview.setUser(null);

            Admin testAdmin = adminService.getAdminById(1L);
            if (testAdmin != null) {
                System.out.println("Enter admin_id:");
                String filmReviewAdminId = secondScan.nextLine();
                Admin admin = adminService.getAdminById((long) Integer.parseInt(filmReviewAdminId));
                filmReview.setAdmin(admin);
            } else filmReview.setAdmin(null);

            filmReviewsService.saveFilmReview(filmReview);
            System.out.println("Issued Film has been created successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void updateFilmReview() throws SQLException {
        try {
            System.out.println("Enter id in order to find element :");
            Long id = Long.parseLong(secondScan.next());

            FilmReview newFilmReview = filmReviewsService.getFilmReviewById(id);

            System.out.println("Enter issued film title: ");
            String filmReviewTitle = firstScan.nextLine();
            newFilmReview.setTitle(filmReviewTitle);

            System.out.println("Enter date of issue:");
            String filmReviewDateOfIssue = firstScan.nextLine();
            newFilmReview.setDateOfReview(filmReviewDateOfIssue);

            System.out.println("Enter return date:");
            String filmReviewReturnDate = firstScan.nextLine();
            newFilmReview.setReviewRating(filmReviewReturnDate);

            System.out.println("Enter numb of copies issued:");
            String filmReviewNumbOfCopiesIssued = firstScan.nextLine();
            newFilmReview.setNumbOfReviews(filmReviewNumbOfCopiesIssued);

            Film testFilm = filmService.getFilmById(1L);
            if (testFilm != null) {
                System.out.println("Enter film_id:");
                String filmReviewFilmId = secondScan.nextLine();
                Film film = filmService.getFilmById((long) Integer.parseInt(filmReviewFilmId));
                newFilmReview.setFilm(film);
            } else newFilmReview.setFilm(null);

            User testUser = userService.getUserById(1L);
            if (testUser != null) {
                System.out.println("Enter user_id:");
                String filmReviewUserId = secondScan.nextLine();
                User user = userService.getUserById((long) Integer.parseInt(filmReviewUserId));
                newFilmReview.setUser(user);
            } else newFilmReview.setUser(null);

            Admin testAdmin = adminService.getAdminById(1L);
            if (testAdmin != null) {
                System.out.println("Enter admin_id:");
                String filmReviewAdminId = secondScan.nextLine();
                Admin admin = adminService.getAdminById((long) Integer.parseInt(filmReviewAdminId));
                newFilmReview.setAdmin(admin);
            } else newFilmReview.setAdmin(null);

            filmReviewsService.updateFilmReview(newFilmReview);
            System.out.println("Issued Film has been created successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void deleteFilmReview() throws SQLException {
        System.out.println("Enter id in order to delete row:");
        Long id = Long.parseLong(secondScan.next());
        try {
            filmReviewsService.deleteFilmReview(id);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Issued Film with id " + id + " has been deleted successfully");
    }

    public void printAllFilmReviews() throws SQLException {
        List<FilmReview> filmReviews = filmReviewsService.printAllFilmReviews();
        System.out.println("List of all issued issued films:");
        filmReviews.forEach(admin1 -> System.out.println(admin1.toString()));
    }

    public void getByIdAdmin() throws SQLException {
        System.out.println("Enter id in order to get issued film:");
        Long id = Long.parseLong(firstScan.next());
        try {
            if (filmReviewsService.getFilmReviewById(id) != null) {
                System.out.println(filmReviewsService.getFilmReviewById(id).toString());
            } else {
                System.out.println("This id is doesn't exist.");
            }

        } catch (NullPointerException e) {
            System.out.println("There is no such number.");
            getByIdAdmin();
        }
    }
}
