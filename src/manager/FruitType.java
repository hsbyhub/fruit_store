package manager;

import java.io.Serializable;

public class FruitType implements Serializable {
    private int id;
    private String name;
    private float price;

    public FruitType(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String priceStr = String.format("%.2f", price);
        return "编号:" + id + " 名称:" + name + " 价格:" + priceStr;
    }
}
