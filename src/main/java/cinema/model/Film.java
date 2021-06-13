package cinema.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "title", nullable = false)
    private String title;

    @Basic
    @Column(name = "author", nullable = false)
    private String author;

    @Basic
    @Column(name = "release_date", nullable = false)
    private String releaseDate;

    @Basic
    @Column(name = "genre", nullable = false)
    private String genre;

    @Basic
    @Column(name = "price", nullable = false)
    private String price;

    @OneToMany(targetEntity= FilmReview.class, mappedBy = "film", cascade = {CascadeType.ALL})
    private Collection<FilmReview> filmReviews;

    @Override
    public String toString() {
        return "Film_" + id +
                ", title=" + title +
                ", author=" + author +
                ", releaseDate=" + releaseDate +
                ", genre=" + genre +
                ", price=" + price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Collection<FilmReview> getFilmReviews() {
        return filmReviews;
    }

    public void setFilmReviews(Collection<FilmReview> filmReviews) {
        this.filmReviews = filmReviews;
    }
}
