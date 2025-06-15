package entities;

import java.time.LocalDate;

public class Rating implements Comparable<Rating> {
    private int userId;
    private int filmId;
    private int rating;
    private LocalDate date;

    public Rating(int userId, int filmId, int rating, LocalDate date) {
        this.userId = userId;
        this.filmId = filmId;
        this.rating = rating;
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public int compareTo(Rating o) {
        return Integer.compare(rating, o.rating);
    }
}
