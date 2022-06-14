package module;

import logic.*;
import menu.Menu;

import java.io.*;

public class FruitStore extends Menu {
    private String file;
    Account account;
    FruitTypeManager fruitTypeManager;
    CustomerManager customerManager;
    FruitManager fruitStockManager;
    OrderManager orderManager;

    public FruitStore(String file) {
        super(null);
        this.file = file;
        this.fruitTypeManager = new FruitTypeManager();
        this.customerManager = new CustomerManager();
        this.fruitStockManager = new FruitManager(this.fruitTypeManager);
        this.orderManager = new OrderManager();
        this.account = new Account();
        registerOption(new MenuTrading(this));
        registerOption(new MenuCustomerManager(this));
        registerOption(new MenuFruitManager(this));
    }

    public Account getAccount() {
        return account;
    }

    public FruitTypeManager getFruitTypeManager() {
        return fruitTypeManager;
    }

    public CustomerManager getCustomerManager() {
        return customerManager;
    }

    public FruitManager getFruitStockManager() {
        return fruitStockManager;
    }

    public OrderManager getOrderManager() {
        return orderManager;
    }

    @Override
    public String name() {
        return "Fine水果店";
    }

    @Override
    public void showHeader() {
        System.out.println("营收:" + account);
        System.out.println("---------------------------------------------------------------");
        System.out.println("货架:");
        System.out.println(getFruitStockManager());
        System.out.println("---------------------------------------------------------------");
    }

    public static FruitStore read(String file) {
        FruitStore fruitStore = null;
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
            fruitStore = (FruitStore)(is.readObject());
            is.close();
        } catch (Exception e) {
        }
        return fruitStore;
    }

    public void write() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(this.file));
            os.writeObject(this);
            os.close();
        } catch (Exception e) {
            System.out.println("备份系统写入文件失败， 将在下一次启动时重新初始化");
        }
    }
}
