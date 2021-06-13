package cinema.view;

import cinema.model.Film;
import cinema.service.FilmService;
import org.hibernate.service.spi.ServiceException;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FilmView {

    private FilmService filmService = new FilmService();
    private Scanner firstScan = new Scanner(System.in);
    private Scanner secondScan = new Scanner(System.in);

    private static void actions() {
        System.out.println("\nChoose film action:\n"
                + "1-Insert new row.\n"
                + "2-Show all row.\n"
                + "3-Delete row.\n"
                + "4-Update row.\n"
                + "5-Search by id.\n"
                + "6-Search by title.\n"
                + "\t0-Exit.");
    }

    public void runFilmView() throws SQLException {
        actions();
        Scanner mainScan = new Scanner(System.in);
        try {
            int numOfPoint = mainScan.nextInt();
            while (numOfPoint != 0) {
                switch (numOfPoint) {
                    case 1:
                        addFilm();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 2:
                        printAllFilms();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 3:
                        deleteFilm();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 4:
                        updateFilm();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 5:
                        getByIdFilm();

                        actions();
                        numOfPoint = mainScan.nextInt();
                        break;
                    case 6:
                        getFilmByTitle();

                        actions();
                        numOfPoint = mainScan.nextInt();
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

    public void addFilm() throws SQLException {
        try {
            Film film = new Film();

            System.out.println("Enter film title:");
            String filmTitle = firstScan.nextLine();
            film.setTitle(filmTitle);

            System.out.println("Enter author:");
            String filmAuthor = firstScan.nextLine();
            film.setAuthor(filmAuthor);

            System.out.println("Enter publication year:");
            String filmPublicationYear = firstScan.nextLine();
            film.setReleaseDate(filmPublicationYear);

            System.out.println("Enter genre:");
            String filmGenre = firstScan.nextLine();
            film.setGenre(filmGenre);

            System.out.println("Enter price:");
            String filmPrice = firstScan.nextLine();
            film.setPrice(filmPrice);

            filmService.saveFilm(film);
            System.out.println("Film has been created successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void updateFilm() throws SQLException {
        try {
            System.out.println("Enter id in order to find element:");
            Long id = Long.parseLong(secondScan.next());

            Film newFilm = filmService.getFilmById(id);

            System.out.println("Enter film title: ");
            String filmTitle = firstScan.nextLine();
            newFilm.setTitle(filmTitle);

            System.out.println("Enter author:");
            String filmAuthor = firstScan.nextLine();
            newFilm.setAuthor(filmAuthor);

            System.out.println("Enter publication year:");
            String filmPublicationYear = firstScan.nextLine();
            newFilm.setReleaseDate(filmPublicationYear);

            System.out.println("Enter genre:");
            String filmGenre = firstScan.nextLine();
            newFilm.setGenre(filmGenre);

            System.out.println("Enter price:");
            String filmPrice = firstScan.nextLine();
            newFilm.setPrice(filmPrice);


            filmService.updateFilm(newFilm);
            System.out.println("Film with id " + id + " has been updated successfully");
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void deleteFilm() throws SQLException {
        System.out.println("Enter id in order to delete row:");
        Long id = Long.parseLong(secondScan.next());
        try {
            filmService.deleteFilm(id);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Film with id " + id + " has been deleted successfully");
    }

    public void printAllFilms() throws SQLException {
        List<Film> films = filmService.printAllFilms();
        System.out.println("List of all films:");
        films.forEach(film1 -> System.out.println(film1.toString()));
    }

    public void getByIdFilm() throws SQLException {
        System.out.println("Enter id in order to get film:");
        Long id = Long.parseLong(firstScan.next());
        try {
            if (filmService.getFilmById(id) != null) {
                System.out.println(filmService.getFilmById(id).toString());
            } else {
                System.out.println("This id is doesn't exist.");
            }

        } catch (NullPointerException e) {
            System.out.println("There is no such number.");
            getByIdFilm();
        }
    }

    public void getFilmByTitle() throws SQLException {
        System.out.println("Enter title in order to get film:");
        String title = secondScan.next();
        try {
            if (filmService.getFilmByTitle(title) != null) {
                System.out.println(filmService.getFilmByTitle(title).toString());
            } else {
                System.out.println("This title is doesn't exist.");
            }

        } catch (NullPointerException e) {
            System.out.println("There is no such number.");
            getFilmByTitle();
        }
    }
}
