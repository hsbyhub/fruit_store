package fruit_store;

import common.Menu;

import java.io.*;
import java.rmi.server.ExportException;

public class FruitStore extends Menu {
    private String file;

    public FruitStore(String file) {
        this.file = file;
        RegisterOption(new FruitTypeManager());
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
        fruitStore.file = file;
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
