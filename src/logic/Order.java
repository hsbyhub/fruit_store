package logic;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private int id;
    private Customer customer;
    private Date date;
    private FruitManager fruitManager;

    public Order(int id, Customer customer, Date date, FruitManager fruitManager) {
        this.id = id;
        this.customer = customer;
        this.date = date;
        this.fruitManager = fruitManager;
    }

    @Override
    public String toString() {
        return id + "|" + customer + "|" + date + "|" + fruitManager;
    }
}
