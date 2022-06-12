package manager;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FruitTypeManager implements Serializable {
    private int generateFruitTypeId = 1000;
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

