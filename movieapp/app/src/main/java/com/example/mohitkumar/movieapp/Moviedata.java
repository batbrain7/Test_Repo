package com.example.mohitkumar.movieapp;

/**
 * Created by mohitkumar on 09/08/16.
 */
public class Moviedata {

    private int moviesposter;
    private String movie_title;
    private String movie_rating;

    public Moviedata(int moviesposter,String movie_title,String movie_rating)
    {
        this.setMovieposter(moviesposter);
        this.setMovie_title(movie_title);
        this.setMovie_rating(movie_rating);
    }
    public int getMovieposter() {
        return moviesposter;
    }

    public String getMovie_rating() {
        return movie_rating;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_rating(String movie_rating) {
        this.movie_rating = movie_rating;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public void setMovieposter(int moviesposter) {
        this.moviesposter = moviesposter;
    }
}
