package fr.epsi.jconte.refactoring.model;

import fr.epsi.jconte.refactoring.model.impl.Movie;

public interface IMovie {
    MovieType getMovieType();

    String getTitle();

    Movie setMovieType(MovieType movieType);
}
