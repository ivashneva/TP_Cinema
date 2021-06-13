package cinema.service;

import cinema.dao.FilmDao;
import cinema.dao.impl.FilmDaoImpl;
import cinema.model.Film;

import java.sql.SQLException;
import java.util.List;

public class FilmService {

    private FilmDao filmDao = new FilmDaoImpl();

    public List<Film> printAllFilms() throws SQLException {
        return filmDao.findAll();
    }

    public void saveFilm(Film film) throws SQLException {
        filmDao.add(film);
    }

    public void deleteFilm(Long id) throws SQLException {
        filmDao.deleteById(id);
    }

    public void updateFilm(Film newFilm) throws SQLException {
        filmDao.update(newFilm);
    }

    public Film getFilmById(Long id) throws SQLException {
        return filmDao.findById(id);
    }

    public Film getFilmByTitle(String title) throws SQLException {
        return filmDao.findFilmByTitle(title);
    }
}
