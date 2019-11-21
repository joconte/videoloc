package fr.epsi.jconte.refactoring.model;

public interface IPriceRuleFirstXDays {

    double getPriceForFirstXDays();

    int getxDays();

    double getPriceForMoreDays();
}
