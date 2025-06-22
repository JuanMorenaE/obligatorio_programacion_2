package entities;

import java.time.LocalDate;

public class Rating implements Comparable<Rating> {
    private int userId;
    private int movieId;
    private float rating;
    private LocalDate date;

    public Rating(int userId, int movieId, float rating, LocalDate date) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
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
        return Float.compare(rating, o.rating);
    }
}
