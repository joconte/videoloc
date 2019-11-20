package fr.epsi.jconte.refactoring.model.impl;

import fr.epsi.jconte.refactoring.model.ICalculatorRentalCost;
import fr.epsi.jconte.refactoring.model.IRental;

public class CalculatorRentalCost implements ICalculatorRentalCost {
    @Override
    public double calculateRentalCost(IRental rental) {
        double thisAmount = 0;
        switch (rental.getMovie().getMovieType()) {
            case REGULAR:
                thisAmount += 2;
                if (rental.getDaysRented() > 2) {
                    thisAmount += (rental.getDaysRented() - 2) * 1.5;
                }
                break;

            case NEW_RELEASE:
                thisAmount += rental.getDaysRented() * 3;
                break;

            case CHILDREN:
                thisAmount += 1.5;
                if (rental.getDaysRented() > 3) {
                    thisAmount += (rental.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }
}
