package logic;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private int id;
    private Customer customer;
    private Date date;
    private FruitManager fruitManager;
    private float distant;
    private float amount;

    public Order(int id,
                 Customer customer,
                 Date date,
                 FruitManager fruitManager,
                 float distant,
                 float amount) {
        this.id = id;
        this.customer = customer;
        this.date = date;
        this.fruitManager = fruitManager;
        this.distant = distant;
        this.amount = amount;
    }

    @Override
    public String toString() {
        String res = "账单Id:" + id +
                " " + customer +
                " " + date + " \n" +
                fruitManager + "\n";
        if (distant < 10) {
            res += "折扣:" + distant + " ";
        }
        res += "实际付款:" + amount;
        return res;
    }
}
