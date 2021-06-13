package cinema.dao.impl;

import cinema.dao.Dao;
import cinema.hiber.SessionUtil;
import cinema.model.FilmReview;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class FilmReviewDaoImpl extends SessionUtil implements Dao<FilmReview> {

    @Override
    public FilmReview add(FilmReview filmReview) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(filmReview);
        closeTransactionSesstion();
        return filmReview;
    }

    @Override
    public List<FilmReview> findAll() throws SQLException {
        openTransactionSession();
        Session session = getSession();
        List<FilmReview> filmReviews = session.createQuery("FROM FilmReview").list();
        closeTransactionSesstion();
        return filmReviews;
    }

    @Override
    public FilmReview findById(Long id) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        FilmReview filmReview = session.get(FilmReview.class, id);
        closeTransactionSesstion();
        return filmReview;
    }

    @Override
    public FilmReview update(FilmReview data) throws SQLException {
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
        FilmReview filmReview = session.get(FilmReview.class, id);
        session.remove(filmReview);
        closeTransactionSesstion();
    }
}
