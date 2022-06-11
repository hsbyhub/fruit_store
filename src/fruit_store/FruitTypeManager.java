package fruit_store;

import common.IOption;
import common.Menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class FruitTypeManager extends Menu {
    private ArrayList<FruitType> fruitTypes;

    public FruitTypeManager() {
        fruitTypes = new ArrayList<>();
        RegisterOption(new OptionAddFruitType(this));
    }

    @Override
    public void Header() {
        System.out.println("当前水果类型:");
        for (int i = 0; i < fruitTypes.size(); i++) {
            System.out.println(""+i+"."+fruitTypes.get(i));
        }
    }

    @Override
    public String Name() {
        return "水果类型管理";
    }

    public int addFruitType(String name, float price) {
        fruitTypes.add(new FruitType(name, price));
        return fruitTypes.size() - 1;
    }

    public void subFruitType(int id) {
        if (id < 0 || id >= fruitTypes.size()) {
            throw new RuntimeException("invalid fruit type id");
        }
        fruitTypes.remove(id);
    }

    public FruitType getFruitType(int id) {
        if (id < 0 || id >= fruitTypes.size()) {
            throw new RuntimeException("invalid fruit type id");
        }
        return fruitTypes.get(id);
    }

}

class OptionAddFruitType implements IOption, Serializable{
    FruitTypeManager fruitTypeManager;

    public OptionAddFruitType(FruitTypeManager fruitTypeManager) {
        this.fruitTypeManager = fruitTypeManager;
    }

    @Override
    public int run(Object obj) {
        System.out.println("正在添加水果...");
        Scanner sc = new Scanner(System.in);
        System.out.print("水果名称:");
        String name = sc.next();
        System.out.print("价格:");
        float price = sc.nextFloat();
        fruitTypeManager.addFruitType(name, price);
        return 0;
    }

    @Override
    public String Name() {
        return "添加水果类型";
    }

    @Override
    public void Header() {
    }
}

class FruitType implements Serializable{
    private String  name;
    private float   price;

    public FruitType(String name, float price) {
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
        return name + " $" + priceStr;
    }
}