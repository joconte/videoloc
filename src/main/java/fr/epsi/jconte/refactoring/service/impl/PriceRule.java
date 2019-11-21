package fr.epsi.jconte.refactoring.service.impl;

import fr.epsi.jconte.refactoring.model.MovieType;
import fr.epsi.jconte.refactoring.service.IPriceRule;

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
