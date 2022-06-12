package manager;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FruitTypeManager implements Serializable {
    static int generateFruitTypeId = 1000;
    private HashMap<Integer, FruitType> fruitTypes;

    public FruitTypeManager() {
        fruitTypes = new HashMap<>();
    }

    public void show() {
        System.out.println("当前水果类型:");
        for (Map.Entry entry : fruitTypes.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public int addFruitType(String name, float price) {
        int id = generateFruitTypeId++;
        fruitTypes.put(id, new FruitType(id, name, price));
        return id;
    }

    public boolean deleteFruitType(int id) {
        if (!fruitTypes.containsKey(id)) {
            return false;
        }
        fruitTypes.remove(id);
        return true;
    }

    public FruitType getFruitType(int id) {
        if (!fruitTypes.containsKey(id)) {
            return null;
        }
        return fruitTypes.get(id);
    }

}

class FruitType implements Serializable{
    private int     id;
    private String  name;
    private float   price;

    public FruitType(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String priceStr = String.format("%.2f", price);
        return "编号:" + id + " 名称:" + name + " 价格:" + priceStr;
    }
}
