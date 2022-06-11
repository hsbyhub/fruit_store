package fruit_store;

import java.util.HashMap;

public class FruitManager {
    private HashMap<Integer, Integer> fruit_count;

    public FruitManager() {
        fruit_count = new HashMap<>();
    }

    public boolean AdjustFruit(int id, int count) {
        if (!fruit_count.containsKey(id)) {
            return false;
        }
        int tmp = fruit_count.get(id) + count;
        if (tmp < 0) {
            return false;
        }
        fruit_count.replace(id, tmp);
        return true;
    }


}
