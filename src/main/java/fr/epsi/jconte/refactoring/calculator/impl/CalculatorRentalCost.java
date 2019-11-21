package fr.epsi.jconte.refactoring.calculator.impl;

import fr.epsi.jconte.refactoring.calculator.ICalculatorRentalCost;
import fr.epsi.jconte.refactoring.calculator.ICalculatorRentalCostPriceRuleFirstXDays;
import fr.epsi.jconte.refactoring.calculator.ICalculatorRentalCostPriceRuleSamePriceEveryDay;
import fr.epsi.jconte.refactoring.exception.FunctionnalException;
import fr.epsi.jconte.refactoring.model.IPriceRule;
import fr.epsi.jconte.refactoring.model.IPriceRuleFirstXDays;
import fr.epsi.jconte.refactoring.model.IPriceRuleSamePriceEveryDay;
import fr.epsi.jconte.refactoring.model.IRental;

import java.util.List;
import java.util.stream.Collectors;

public class CalculatorRentalCost implements ICalculatorRentalCost {

    private List<IPriceRule> priceRules;

    private ICalculatorRentalCostPriceRuleFirstXDays calculatorRentalCostPriceRuleFirstXDays;

    private ICalculatorRentalCostPriceRuleSamePriceEveryDay calculatorRentalCostPriceRuleSamePriceEveryDay;

    public CalculatorRentalCost(List<IPriceRule> priceRules, ICalculatorRentalCostPriceRuleFirstXDays calculatorRentalCostPriceRuleFirstXDays, ICalculatorRentalCostPriceRuleSamePriceEveryDay calculatorRentalCostPriceRuleSamePriceEveryDay) {
        this.priceRules = priceRules;
        this.calculatorRentalCostPriceRuleFirstXDays = calculatorRentalCostPriceRuleFirstXDays;
        this.calculatorRentalCostPriceRuleSamePriceEveryDay = calculatorRentalCostPriceRuleSamePriceEveryDay;
    }

    @Override
    public double calculateRentalCost(IRental rental) throws FunctionnalException {

        IPriceRule priceRule = findCorrespondingPriceRule(rental);

        double rentalCost = 0;
        if (priceRule instanceof IPriceRuleSamePriceEveryDay) {
            rentalCost = calculatorRentalCostPriceRuleSamePriceEveryDay.getRentalCost(rental);
        } else if (priceRule instanceof IPriceRuleFirstXDays) {
            rentalCost = calculatorRentalCostPriceRuleFirstXDays.getRentalCost(rental, (IPriceRuleFirstXDays) priceRule);
        }
        return rentalCost;
    }

    private IPriceRule findCorrespondingPriceRule(final IRental rental) throws FunctionnalException {
        List<IPriceRule> priceRulesExpectedOnlyOne = priceRules.stream().filter(e -> e.getMovieType() == rental.getMovie().getMovieType()).collect(Collectors.toList());

        if (priceRulesExpectedOnlyOne == null || priceRulesExpectedOnlyOne.isEmpty()) {
            throw new FunctionnalException("Missing price rule for " + rental.getMovie().getMovieType().toString());
        }

        if (priceRulesExpectedOnlyOne.size() > 1) {
            throw new FunctionnalException("Only one rule is expected per movie type, found " + priceRulesExpectedOnlyOne.size());
        }

        return priceRulesExpectedOnlyOne.get(0);
    }
}
