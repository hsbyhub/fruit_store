package logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FruitManager implements Serializable {
    private FruitTypeManager fruitTypeManager;
    private HashMap<Integer, Integer> fruitCount;

    public FruitManager(FruitTypeManager fruitTypeManager) {
        this.fruitTypeManager = fruitTypeManager;
        fruitCount = new HashMap<>();
    }

    public boolean addFruit(int id, int count) {
        if (count < 0) {
            return false;
        }
        Integer i = fruitCount.get(id);
        if (i == null) {
            fruitCount.put(id, count);
        } else  {
            fruitCount.replace(id, i + count);
        }
        return true;
    }

    public boolean add(FruitManager fruitManager) {
        for (Map.Entry entry : fruitManager.getFruitCount().entrySet()) {
            addFruit((int)entry.getKey(), (int)entry.getValue());
        }
        return true;
    }

    boolean subFruit(int id, int count) {
        if (count < 0) {
            return false;
        }
        Integer i = fruitCount.get(id);
        if (i == null || i < count) {
            return false;
        }
        fruitCount.replace(id, i - count);
        return true;
    }

    public boolean sub(FruitManager fruitManager) {
        if (!isEnough(fruitManager)) {
            return false;
        }
        for (Map.Entry entry : fruitManager.getFruitCount().entrySet()) {
            subFruit((int)entry.getKey(), (int)entry.getValue());
        }
        return true;
    }

    public boolean isEnough(FruitManager fruitManager) {
        for (Map.Entry entry : fruitManager.getFruitCount().entrySet()) {
            if (getCount((int)entry.getKey()) < (int)entry.getValue()) {
                return false;
            }
        }
        return true;

    }

    public HashMap<Integer, Integer> getFruitCount() {
        return fruitCount;
    }
    
    public int getCount(int id) {
        return fruitCount.get(id);
    }

    public float getTotalValue() {
        float value = 0;
        for (Map.Entry entry : fruitCount.entrySet()) {
            FruitType fruitType = fruitTypeManager.getFruitType((int)entry.getKey());
            if (fruitType == null) {
                continue;
            }
            value += fruitType.getPrice() * (int)entry.getValue();
        }
        return value;
    }

    public void clear() {
        fruitCount.clear();
    }

    public boolean isEmpty() {
        return fruitCount.isEmpty();
    }

    @Override
    public String toString() {
        String res = "";
        if (fruitCount.isEmpty()) {
            res += "空\n";
        } else {
            for (Map.Entry entry : fruitCount.entrySet()) {
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

    @Override
    public FruitManager clone() {
        FruitManager fruitManager = new FruitManager(fruitTypeManager);
        fruitManager.add(this);
        return fruitManager;
    }
}
