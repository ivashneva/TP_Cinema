package cinema.model;

import javax.persistence.*;

@Entity
@Table(name = "film_review")
public class FilmReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "title", nullable = false)
    private String title;

    @Basic
    @Column(name = "date_of_review", nullable = false)
    private String dateOfReview;

    @Basic
    @Column(name = "review_rating", nullable = true)
    private String reviewRating;

    @Basic
    @Column(name = "numb_of_reviews", nullable = false)
    private String numbOfReviews;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_film", referencedColumnName = "id")
    private Film film;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_admin", referencedColumnName = "id")
    private Admin admin;

    @Override
    public String toString() {
        return "FilmReview_" + id +
                ", title='" + title +
                ", dateOfReview='" + dateOfReview +
                ", reviewRating='" + reviewRating +
                ", numbOfReviews='" + numbOfReviews +
                ", film=" + film +
                ", user=" + user +
                ", admin=" + admin;
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

    public String getDateOfReview() {
        return dateOfReview;
    }

    public void setDateOfReview(String dateOfReview) {
        this.dateOfReview = dateOfReview;
    }

    public String getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(String reviewRating) {
        this.reviewRating = reviewRating;
    }

    public String getNumbOfReviews() {
        return numbOfReviews;
    }

    public void setNumbOfReviews(String numbOfReviews) {
        this.numbOfReviews = numbOfReviews;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
