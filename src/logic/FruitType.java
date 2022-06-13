package logic;

import java.io.Serializable;

public class FruitType implements Serializable {
    private int id;
    private String name;
    private float price;
    private float purchasePrice;

    public FruitType(int id, String name, float price, float purchasePrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.purchasePrice = purchasePrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    @Override
    public String toString() {
        String priceStr = String.format("%.2f", price);
        return "编号:" + id + " 名称:" + name + " 价格:" + priceStr + " 进货价格:" + purchasePrice;
    }
}
