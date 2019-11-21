package fr.epsi.jconte.refactoring.model.impl;

import fr.epsi.jconte.refactoring.model.IPriceRule;
import fr.epsi.jconte.refactoring.model.MovieType;

public class PriceRule implements IPriceRule {

    private MovieType movieType;

    public PriceRule(MovieType movieType) {
        this.movieType = movieType;
    }

    @Override
    public MovieType getMovieType() {
        return this.movieType;
    }
}
