package io.everyonecodes.basket;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    // TODO: Injects the SummaryCalculator bean.
    //  Has a method that receives one ItemSelection,
    //  transforms it into a Summary and stores it.
    //  Has a method that returns a list of all the processed Summary entries.

    private final SummaryCalculator summaryCalculator;
    private List<Summary> summaries = new ArrayList<>();

    public Basket(SummaryCalculator summaryCalculator, List<Summary> summaries) {
        this.summaryCalculator = summaryCalculator;
        this.summaries = summaries;
    }

    public Basket(SummaryCalculator summaryCalculator) {
        this.summaryCalculator = summaryCalculator;
    }

    public List<Summary> getSummaries() {
        return summaries;
    }

    public void transformItemSelection(ItemSelection itemSelection) {
        var transformedSelection = summaryCalculator.getSummary(itemSelection);
        summaries.add(transformedSelection);
    }
}
