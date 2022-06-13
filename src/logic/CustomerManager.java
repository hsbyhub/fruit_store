package logic;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerManager implements Serializable {
    private int customerIdSeq = 0;
    private ArrayList<Customer> customers;

    public CustomerManager() {
        this.customers = new ArrayList<>();
    }

    public void showCustomers() {
        System.out.println("当前客户有:");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println("" + i + ". " + customers.get(i));
        }
    }

    public Customer AddCustomer(FruitTypeManager fruitTypeManager, String name, Customer.Type type) {
        SimpleDateFormat sdt = new SimpleDateFormat("yyyyMMdd");
        String id = sdt.format(new Date()) + "-" + type.ordinal() + "-" + customerIdSeq++;
        Customer customer = new Customer(fruitTypeManager, id, name, type);
        customers.add(customer);
        return customer;
    }

    public Customer getCustomer(int i) {
        if (i < 0 || i >= customers.size()) {
            return null;
        }
        return customers.get(i);
    }

    public Customer getCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    // 展示购物车非空的用户
    public void showShppingCustomer() {
        for (Customer customer : customers) {
            if (!customer.getShoppingCar().isEmpty()) {
                customer.showWithShoppingCar();
            }
        }
    }
}

