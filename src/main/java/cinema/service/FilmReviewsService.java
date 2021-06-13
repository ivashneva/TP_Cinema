package cinema.service;

import cinema.dao.Dao;
import cinema.dao.impl.FilmReviewDaoImpl;
import cinema.model.FilmReview;

import java.sql.SQLException;
import java.util.List;

public class FilmReviewsService {

    private Dao<FilmReview> filmReviewDao = new FilmReviewDaoImpl();

    public List<FilmReview> printAllFilmReviews() throws SQLException {
        return filmReviewDao.findAll();
    }

    public void saveFilmReview(FilmReview filmReview) throws SQLException {
        filmReviewDao.add(filmReview);
    }

    public void deleteFilmReview(Long id) throws SQLException {
        filmReviewDao.deleteById(id);
    }

    public void updateFilmReview(FilmReview newFilmReview) throws SQLException {
        filmReviewDao.update(newFilmReview);
    }

    public FilmReview getFilmReviewById(Long id) throws SQLException {
        return filmReviewDao.findById(id);
    }
}
