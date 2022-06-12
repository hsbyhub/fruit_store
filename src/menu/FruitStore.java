package menu;

import manager.customer.CustomerManager;
import manager.FruitTypeManager;

import java.io.*;

public class FruitStore extends Menu {
    private String file;
    FruitTypeManager fruitTypeManager;
    CustomerManager customerManager;

    public FruitStore(String file) {
        super(null);
        this.file = file;
        this.fruitTypeManager = new FruitTypeManager();
        this.customerManager = new CustomerManager();
        registerOption(new MenuFruitTypeManager(this));
        registerOption(new MenuCustomerManager(this));
    }

    public FruitTypeManager getFruitTypeManager() {
        return fruitTypeManager;
    }

    public CustomerManager getCustomerManager() {
        return customerManager;
    }

    @Override
    public String name() {
        return "Fine水果店";
    }

    public static FruitStore read(String file) {
        FruitStore fruitStore = null;
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
            fruitStore = (FruitStore)(is.readObject());
            if (fruitStore == null) {
                fruitStore = new FruitStore(file);
            }
            is.close();
        } catch (Exception e) {
            fruitStore = new FruitStore(file);
        }
        return fruitStore;
    }

    public void write() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(this.file));
            os.writeObject(this);
            os.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
