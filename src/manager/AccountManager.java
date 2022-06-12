package manager;

import java.io.Serializable;
import java.util.HashMap;

// 账户
public class AccountManager implements Serializable {
    private float balance;

    public boolean AdjustBalance(float count) {
        float tmp = balance + count;
        if (tmp < 0) {
            return false;
        }
        balance = tmp;
        return true;
    }
}
