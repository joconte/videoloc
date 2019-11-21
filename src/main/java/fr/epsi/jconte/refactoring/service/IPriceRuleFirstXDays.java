package fr.epsi.jconte.refactoring.service;

public interface IPriceRuleFirstXDays {

    double getPriceForFirstXDays();

    int getxDays();

    double getPriceForMoreDays();
}
