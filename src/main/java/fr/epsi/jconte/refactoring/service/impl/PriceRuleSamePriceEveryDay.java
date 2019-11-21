package fr.epsi.jconte.refactoring.service.impl;

import fr.epsi.jconte.refactoring.model.MovieType;
import fr.epsi.jconte.refactoring.service.IPriceRuleSamePriceEveryDay;

public class PriceRuleSamePriceEveryDay extends PriceRule implements IPriceRuleSamePriceEveryDay {

    private double price;

    public PriceRuleSamePriceEveryDay(MovieType movieType, double price) {
        super(movieType);
        this.price = price;
    }
}
