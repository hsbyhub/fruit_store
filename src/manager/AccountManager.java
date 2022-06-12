package manager;

import java.io.Serializable;
import java.util.HashMap;

// 账户
public class AccountManager implements Serializable {
    private HashMap<Integer, Integer> fruit_count;
    private float balance;

    public AccountManager() {
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

    public boolean AdjustBalance(float count) {
        float tmp = balance + count;
        if (tmp < 0) {
            return false;
        }
        balance = tmp;
        return true;
    }
}
