package fr.epsi.jconte.refactoring.model.impl;

import fr.epsi.jconte.refactoring.model.IPriceRuleSamePriceEveryDay;
import fr.epsi.jconte.refactoring.model.MovieType;

public class PriceRuleSamePriceEveryDay extends PriceRule implements IPriceRuleSamePriceEveryDay {

    private double price;

    public PriceRuleSamePriceEveryDay(MovieType movieType, double price) {
        super(movieType);
        this.price = price;
    }
}
