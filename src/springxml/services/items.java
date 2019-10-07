package springxml.services;

import java.util.ArrayList;

public class items implements ordering {

    private double cost = 0.00;
    private ArrayList<String> items = new ArrayList<String>();

    @Override
    public double getCost() {
        return 0;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public ArrayList<String> getItemsInCart() {
        return null;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }
}
