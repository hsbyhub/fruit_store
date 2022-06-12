package module;

import menu.Menu;
import menu.Option;
import logic.Customer;
import logic.CustomerManager;

import java.io.Serializable;
import java.util.Scanner;

public class MenuCustomerManager extends Menu {
    CustomerManager customerManager;

    public MenuCustomerManager(FruitStore fruitStore) {
        super(fruitStore);
        this.customerManager = fruitStore.getCustomerManager();
        registerOption(new OptionAddCustomer(fruitStore));
    }

    @Override
    public String name() {
        return "客户管理";
    }

    @Override
    public void showHeader() {
        customerManager.showCustomers();
    }
}

class OptionAddCustomer extends Option implements Serializable {
    CustomerManager customerManager;

    public OptionAddCustomer(FruitStore fruitStore) {
        super(fruitStore);
        this.customerManager = fruitStore.getCustomerManager();
    }

    @Override
    public String onHandler() {
        System.out.println("正在添加客户...");
        Scanner sc = new Scanner(System.in);
        System.out.print("客户名:");
        String name = sc.next();
        Customer.showTypes();
        System.out.print("客户类型:");
        Customer.Type type = Customer.Type.Normal;
        try {
            int tmp = sc.nextInt();
            type = Customer.Type.values()[tmp];
        } catch (Exception e) {
            return "无效用户类型!";
        }
        Customer customer = customerManager.AddCustomer(name, type);
        return "添加用户成功：" + customer;
    }

    @Override
    public String name() {
        return "添加客户";
    }
}