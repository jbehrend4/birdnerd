package springxml.services;

import java.util.ArrayList;

public class store implements ordering{

    double totalCost = 0.00;
    ArrayList<String> itemsInCart = new ArrayList<String>();

    @Override
    public double getCost() {
        return totalCost;
    }

    @Override
    public ArrayList<String> getItemsInCart() {
        return itemsInCart;
    }
}
