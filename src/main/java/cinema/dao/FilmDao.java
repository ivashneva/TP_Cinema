package cinema.dao;

import cinema.model.Film;

import java.sql.SQLException;

public interface FilmDao extends Dao<Film>{
    Film findFilmByTitle(String title) throws SQLException;
}
