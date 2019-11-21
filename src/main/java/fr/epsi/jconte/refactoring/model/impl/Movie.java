package fr.epsi.jconte.refactoring.model.impl;

import fr.epsi.jconte.refactoring.model.IMovie;
import fr.epsi.jconte.refactoring.model.MovieType;

/**
 * The Movie class represents a movie in our store
 */
public class Movie implements IMovie {
    private MovieType movieType;
    private String title;
    public Movie(String title, MovieType movieType) {
        this.title = title;
        this.movieType = movieType;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public String getTitle() {
        return title;
    }

    public Movie setMovieType(MovieType movieType) {
        this.movieType = movieType;
        return this;
    }
}
