package logic;

import java.io.Serializable;

// 账户
public class Account implements Serializable {
    private float balance;

    public boolean addBalance(float count) {
        if (count < 0) {
            return false;
        }
        balance += count;
        return true;
    }

    public boolean subBalance(float count) {
        if (count < 0 || !isEnough(count)) {
            return false;
        }
        balance -= count;
        return true;
    }

    public boolean isEnough(float count) {
        if (count < 0) {
            return false;
        }
        return balance >= count;
    }

    @Override
    public String toString() {
        String str = String.format("%.2f", balance);
        return "$" + str;
    }
}
