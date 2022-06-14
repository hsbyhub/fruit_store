package logic;

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
    private Account account;
    private FruitManager shoppingCar;

    public Customer(FruitTypeManager fruitTypeManager, String id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.account= new Account();
        this.shoppingCar = new FruitManager(fruitTypeManager);
    }

    public float getDistant() {
        return typeDistant.get(type);
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }

    public FruitManager getShoppingCar() {
        return shoppingCar;
    }

    @Override
    public String toString() {
        return "Id:" + id + " 名称:" + name + " 类型:" + type + " 账户余额:" + account;
    }

    public void showWithShoppingCar() {
        System.out.println(this);
        System.out.println("购物车:");
        System.out.println(shoppingCar);
        System.out.println("---------------------------");
    }
}