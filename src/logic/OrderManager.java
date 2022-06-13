package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class OrderManager implements Serializable {
    private static String file = "orders.log";
    private int generateOrderId = 1;
    private ArrayList<Order> orders;

    public OrderManager() {
        orders = new ArrayList<>();
    }

    public Order AddOrder(Customer customer, FruitManager fruitManager) {
        Order order = new Order(generateOrderId++, customer, new Date(), fruitManager);
        orders.add(order);
        return order;
    }

}

