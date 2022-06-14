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

    public FruitType getFruitTypeByName(String name) {
        for (Map.Entry entry : fruitTypes.entrySet()) {
            FruitType fruitType = (FruitType)entry.getValue();
            if (fruitType.getName().equals(name)) {
                return fruitType;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String res = "";
        for (Map.Entry entry : fruitTypes.entrySet()) {
            res += entry.getValue();
        }
        return res;
    }
}

