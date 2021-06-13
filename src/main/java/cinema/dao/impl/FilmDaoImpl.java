package cinema.dao.impl;

import cinema.dao.FilmDao;
import cinema.hiber.SessionUtil;
import cinema.model.Film;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class FilmDaoImpl extends SessionUtil implements FilmDao {

    @Override
    public Film add(Film film) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(film);
        closeTransactionSesstion();
        return film;
    }

    @Override
    public List<Film> findAll() throws SQLException {
        openTransactionSession();
        Session session = getSession();
        List<Film> films = session.createQuery("FROM Film").list();
        closeTransactionSesstion();
        return films;
    }

    @Override
    public Film findById(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        Film film = session.get(Film.class, id);
        closeTransactionSesstion();
        return film;
    }

    @Override
    public Film update(Film data) throws SQLException {
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
        Film film = session.get(Film.class, id);
        session.remove(film);
        closeTransactionSesstion();
    }

    @Override
    public Film findFilmByTitle(String title) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        List<Film> films = session.createQuery("FROM Film").list();
        Film searchingFilm = new Film();
        for (Film film : films) {
            if (film.getTitle().equals(title)) {
                return searchingFilm = film;
            }
        }
        closeTransactionSesstion();
        return searchingFilm;
    }
}
