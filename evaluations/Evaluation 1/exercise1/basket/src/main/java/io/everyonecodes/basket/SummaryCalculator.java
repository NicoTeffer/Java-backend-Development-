package io.everyonecodes.basket;

import org.springframework.stereotype.Service;

@Service
public class SummaryCalculator {

    // TODO:  Injects the UsersClient bean.
    //  Has a method that receives one ItemSelection and returns a Summary
    //  that has the appropriate delivery costs and final price.

    private final UsersClient usersClient;

    public SummaryCalculator(UsersClient usersClient) {
        this.usersClient = usersClient;
    }

    public Summary getSummary(ItemSelection itemSelection) {
        double deliveryCostStandard = 2.50;
        var mailCheck = usersClient.getUserFromUsersApp(itemSelection.getUserEmail());
        var isPremium = mailCheck.getAccountType().equals("premium account");
        var userEmail = itemSelection.getUserEmail();
        var itemName = itemSelection.getItemName();
        var itemPrice = itemSelection.getItemPrice();
        var deliveryCost = 0.00;
        if (!isPremium) {
            deliveryCost = deliveryCostStandard;
        }
        var totalPrice = itemPrice + deliveryCost;
        return new Summary(userEmail, itemName, itemPrice, deliveryCost, totalPrice
        );
    }
}
