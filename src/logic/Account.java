package logic;

import java.io.Serializable;

// 账户
public class Account implements Serializable {
    private float balance;

    public boolean AdjustBalance(float count) {
        float tmp = balance + count;
        if (tmp < 0) {
            return false;
        }
        balance = tmp;
        return true;
    }

    public float getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        String str = String.format("%.2f", balance);
        return "$" + str;
    }
}
