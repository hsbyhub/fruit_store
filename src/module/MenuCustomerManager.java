package module;

import logic.FruitTypeManager;
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
        registerOption(new OptionRecharge(fruitStore, this.customerManager));
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
        Customer customer = customerManager.AddCustomer(getFruitStore().getFruitTypeManager(), name, type);
        return "添加用户成功：" + customer;
    }

    @Override
    public String name() {
        return "添加客户";
    }
}

class OptionRecharge extends Option {
    CustomerManager customerManager;

    public OptionRecharge(FruitStore fruitStore, CustomerManager customerManager) {
        super(fruitStore);
        this.customerManager = customerManager;
    }

    @Override
    public String onHandler() {
        System.out.println("正在充值...");
        System.out.print("客户名:");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        Customer customer = customerManager.getCustomerByName(name);
        if (customer == null) {
            return "找不到客户, 请检查用户名";
        }
        float amount = 0;
        try {
            System.out.print("充值金额:");
            amount = sc.nextFloat();
            if (amount <= 0) {
                return "非法金额";
            }
        } catch (Exception e) {
            return "非法金额";
        }
        boolean ok = customer.getAccount().addBalance(amount);
        if (!ok) {
            return "充值失败";
        }
        return "充值成功";
    }

    @Override
    public String name() {
        return "充值";
    }
}