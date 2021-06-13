package cinema.view;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {

    private FilmView filmView;
    private UserView userView;
    private AdminView adminView;
    private FilmReviewView filmReviewView;

    private static MainView mainView;

    private MainView() {
        filmView = new FilmView();
        userView = new UserView();
        adminView = new AdminView();
        filmReviewView = new FilmReviewView();
    }

    public static MainView getInstance() {
        if (mainView == null) {
            mainView = new MainView();
        }
        return mainView;
    }

    private static void actions() {
        System.out.println("\nChoose action:\n"
                + "1-Films.\n"
                + "2-Users.\n"
                + "3-Admins.\n"
                + "4-FilmReviews.\n"
                + "\t0-Exit.");
    }

    public void runMainView() throws SQLException {
        actions();
        Scanner mainScan = new Scanner(System.in);

        try {
            int numOfPoint = mainScan.nextInt();
            while (numOfPoint != 0) {
                switch (numOfPoint) {
                    case 1:
                        runFilm();
                        break;
                    case 2:
                        runUser();
                        break;
                    case 3:
                        runAdmin();
                        break;
                    case 4:
                        runFilmReview ();
                        break;
                    case 0:
                        numOfPoint = 0;
                        break;
                    default:
                        System.out.println("There is no such command.");
                        System.out.println("Choose action:");
                        numOfPoint = mainScan.nextInt();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        }
        mainScan.close();
    }

    public void runFilm() throws SQLException {
        filmView.runFilmView();
    }

    public void runUser() throws SQLException {
        userView.runUserView();
    }

    public void runAdmin() throws SQLException {
        adminView.runAdminView();
    }

    public void runFilmReview () throws SQLException {
        filmReviewView.runFilmReviewView();
    }
}
