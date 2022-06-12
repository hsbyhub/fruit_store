package logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FruitTypeManager implements Serializable {
    private int generateFruitTypeId = 100;
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

    public FruitType addFruitType(String name, float price, float purchasePrice) {
        int id = generateFruitTypeId++;
        FruitType fruitType = new FruitType(id, name, price, purchasePrice);
        fruitTypes.put(id, fruitType);
        return fruitType;
    }

    public boolean deleteFruitType(int id) {
        return fruitTypes.remove(id) != null;
    }

    public FruitType getFruitType(int id) {
        return fruitTypes.get(id);
    }

}

