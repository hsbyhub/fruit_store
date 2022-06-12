package logic;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private Customer customer;
    private Date date;
    private FruitManager fruitManager;

    public Order(Customer customer, Date date, FruitManager fruitManager) {
        this.customer = customer;
        this.date = date;
        this.fruitManager = fruitManager;
    }

    @Override
    public String toString() {
        return customer + "|" + date + "|" + fruitManager;
    }
}
