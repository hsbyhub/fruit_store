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

    public boolean AdjustFruit(FruitManager fruitManager) {
        for (Map.Entry entry : fruitManager.getFruit_count().entrySet()) {
            boolean ok = AdjustFruit((int)entry.getKey(), (int)entry.getValue());
            if (!ok) {
                return false;
            }
        }
        return true;
    }

    public HashMap<Integer, Integer> getFruit_count() {
        return fruit_count;
    }

    public float getTotalValue() {
        float value = 0;
        for (Map.Entry entry : fruit_count.entrySet()) {
            FruitType fruitType = fruitTypeManager.getFruitType((int)entry.getKey());
            if (fruitType == null) {
                continue;
            }
            value += fruitType.getPrice() * (int)entry.getValue();
        }
        return value;
    }

    public void clear() {
        fruit_count.clear();
    }

    public boolean isEmpty() {
        return fruit_count.isEmpty();
    }

    @Override
    public String toString() {
        String res = "";
        if (fruit_count.isEmpty()) {
            res += "空\n";
        } else {
            for (Map.Entry entry : fruit_count.entrySet()) {
                FruitType fruitType = fruitTypeManager.getFruitType((int)entry.getKey());
                if (fruitType == null) {
                    continue;
                }
                res += fruitType + " 数量:" + entry.getValue() + " 价值:" + fruitType.getPrice() * (int)entry.getValue() + "\n";
            }
        }
        res += "总价值:" + String.format("%.2f", getTotalValue());
        return res;
    }
}
