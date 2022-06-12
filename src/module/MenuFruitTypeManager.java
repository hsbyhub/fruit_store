package module;

import logic.FruitType;
import logic.FruitTypeManager;
import menu.Menu;
import menu.Option;

import java.io.Serializable;
import java.util.Scanner;

public class MenuFruitTypeManager extends Menu {

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
    public String onHandler() {
        System.out.println("正在添加水果...");
        Scanner sc = new Scanner(System.in);
        System.out.print("水果名称:");
        String name = sc.next();
        float price = 0;
        float purPrice = 0;
        try {
            System.out.print("价格:");
            price = sc.nextFloat();
            System.out.print("进货价格:");
            purPrice = sc.nextFloat();
            if (price <= 0 || purPrice <= 0 || price <= purPrice) {
                return "添加水果失败，非法价格格式";
            }
        } catch (Exception e) {
            return "添加水果失败，非法价格格式";
        }
        FruitType fruitType = getFruitStore().getFruitTypeManager().addFruitType(name, price, purPrice);
        return fruitType.toString() + " 添加成功";
    }

    @Override
    public String name() {
        return "添加水果类型";
    }
}

