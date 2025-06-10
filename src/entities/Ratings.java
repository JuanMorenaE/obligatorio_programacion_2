package entities;

import java.time.LocalDate;
import java.util.Date;

public class Ratings {
    private int userId;
    private int filmId;
    private int rating;
    private LocalDate date;

    public Ratings(int userId, int filmId, int rating, LocalDate date) {
        this.userId = userId;
        this.filmId = filmId;
        this.rating = rating;
        this.date = date;
    }

    public int getUserId() {return userId;}
    public int getFilmId() {return filmId;}
    public int getRating() {return rating;}
    public LocalDate getDate() {return date;}

}
