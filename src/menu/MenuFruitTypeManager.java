package menu;

import manager.FruitTypeManager;

import java.io.Serializable;
import java.util.Scanner;

public class MenuFruitTypeManager extends Menu{

    private FruitTypeManager fruitTypeManager;

    public MenuFruitTypeManager(FruitStore fruitStore) {
        super(fruitStore);
        this.fruitTypeManager = fruitStore.getFruitTypeManager();
        registerOption(new OptionAddFruitType(fruitStore));
    }

    @Override
    public void showHeader() {
        fruitTypeManager.show();
    }

    @Override
    public String name() {
        return "水果类型管理";
    }

}

class OptionAddFruitType extends Option implements Serializable {

    public OptionAddFruitType(FruitStore fruitStore) {
        super(fruitStore);
    }

    @Override
    public int handler() {
        System.out.println("正在添加水果...");
        Scanner sc = new Scanner(System.in);
        System.out.print("水果名称:");
        String name = sc.next();
        System.out.print("价格:");
        float price = 0;
        try {
            price = sc.nextFloat();
        } catch (Exception e) {
            System.out.println("添加水果失败，非法价格格式");
            return 0;
        }
        getFruitStore().getFruitTypeManager().addFruitType(name, price);
        return 0;
    }

    @Override
    public String name() {
        return "添加水果类型";
    }
}

