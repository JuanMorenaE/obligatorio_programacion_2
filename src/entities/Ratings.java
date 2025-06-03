package entities;

import java.util.Date;

public class Ratings {
    private int userId;
    private int filmId;
    private int rating;
    private Date date;

    public Ratings(int userId, int filmId, int rating, Date date) {
        this.userId = userId;
        this.filmId = filmId;
        this.rating = rating;
        this.date = date;
    }

    public int getUserId() {return userId;}
    public int getFilmId() {return filmId;}
    public int getRating() {return rating;}
    public Date getDate() {return date;}

}
