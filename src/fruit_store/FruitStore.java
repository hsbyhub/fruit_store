package fruit_store;

import common.Menu;

import java.io.*;

public class FruitStore extends Menu {
    String file;

    public FruitStore(String file) {
        this.file = file;
        RegisterOption(new FruitTypeManager());
    }

    @Override
    public String Name() {
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
            fruitStore.file = file;
            is.close();
        } catch (FileNotFoundException e) {
            fruitStore = new FruitStore(file);
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return fruitStore;
    }

    public void write() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(this.file));
            os.writeObject(this);
            os.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
