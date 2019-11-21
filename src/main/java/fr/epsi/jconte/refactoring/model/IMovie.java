package fr.epsi.jconte.refactoring.model;

import fr.epsi.jconte.refactoring.model.impl.Movie;

/**
 * This interface represents the minimum we need to build a movie class :
 * The type of the movie, the title
 */
public interface IMovie {
    MovieType getMovieType();

    String getTitle();

    Movie setMovieType(MovieType movieType);
}
