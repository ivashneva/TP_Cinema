package cinema.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;

    @OneToMany(targetEntity= FilmReview.class, mappedBy = "admin", cascade = {CascadeType.ALL})
    private Collection<FilmReview> filmReviews;

    @Override
    public String toString() {
        return "Admin_" + id +
                ", name=" + name +
                ", phoneNumber=" + phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Collection<FilmReview> getFilmReviews() {
        return filmReviews;
    }

    public void setFilmReviews(Collection<FilmReview> filmReviews) {
        this.filmReviews = filmReviews;
    }
}
