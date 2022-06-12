package manager.customer;

import manager.AccountManager;

import java.io.Serializable;
import java.util.HashMap;

public class Customer implements Serializable {
    public enum Type {
        Normal,
        Vip1,
        Vip2,
        Vip3,
    }
    static HashMap<Type, Integer> typeDistant = new HashMap<>() {{
        put(Type.Normal, 10);
        put(Type.Vip1, 9);
        put(Type.Vip2, 8);
        put(Type.Vip3, 7);
    }};
    static public void showTypes() {
        System.out.println("客户类型有:");
        for (Type type : Type.values()) {
            System.out.println("" + type.ordinal() + "." + type);
        }
    }

    private String id;
    private String name;
    private Type type;
    private AccountManager accountManager;

    public Customer(String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.accountManager = new AccountManager();
    }

    double getDistant() {
        return typeDistant.get(type) / 10.0;
    }

    public String getName() {
        return name;
    }

    public AccountManager getAccountManager() {
        return accountManager;
    }

    @Override
    public String toString() {
        return this.id + " " +
                this.name + " " +
                this.type;
    }
}
