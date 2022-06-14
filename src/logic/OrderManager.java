package logic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

    public Order addOrder(Customer customer, FruitManager fruitManager, float distant, float amount) {
        Order order = new Order(generateOrderId++, customer, new Date(), fruitManager, distant, amount);
        orders.add(order);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(order + "\n");
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return order;
    }

}

