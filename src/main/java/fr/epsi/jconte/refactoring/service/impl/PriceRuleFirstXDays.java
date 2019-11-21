package fr.epsi.jconte.refactoring.service.impl;

import fr.epsi.jconte.refactoring.model.MovieType;
import fr.epsi.jconte.refactoring.service.IPriceRuleFirstXDays;

public class PriceRuleFirstXDays extends PriceRule implements IPriceRuleFirstXDays {

    private double priceForFirstXDays;

    private int xDays;

    private double priceForMoreDays;

    public PriceRuleFirstXDays(MovieType movieType, double priceForFirstXDays, int xDays, double priceForMoreDays) {
        super(movieType);
        this.priceForFirstXDays = priceForFirstXDays;
        this.xDays = xDays;
        this.priceForMoreDays = priceForMoreDays;
    }

    public double getPriceForFirstXDays() {
        return priceForFirstXDays;
    }

    public int getxDays() {
        return xDays;
    }

    public double getPriceForMoreDays() {
        return priceForMoreDays;
    }
}
