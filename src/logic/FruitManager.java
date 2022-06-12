package logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FruitManager implements Serializable {
    private FruitTypeManager fruitTypeManager;
    private HashMap<Integer, Integer> fruit_count;

    public FruitManager(FruitTypeManager fruitTypeManager) {
        this.fruitTypeManager = fruitTypeManager;
        fruit_count = new HashMap<>();
    }

    public boolean AdjustFruit(int id, int count) {
        if (!fruit_count.containsKey(id)) {
            if (count < 0) {
                return false;
            }
            fruit_count.put(id, 0);
        }
        int tmp = fruit_count.get(id) + count;
        if (tmp < 0) {
            return false;
        }
        if (tmp == 0) {
            fruit_count.remove(id);
            return true;
        }
        fruit_count.replace(id, tmp);
        return true;
    }

    public void show() {
        for (Map.Entry entry : fruit_count.entrySet()) {
            FruitType fruitType = fruitTypeManager.getFruitType((int)entry.getKey());
            if (fruitType == null) {
                continue;
            }
            System.out.println(fruitType + " 数量:" + entry.getValue());
        }
    }
}
