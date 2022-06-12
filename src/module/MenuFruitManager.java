package module;

import manager.FruitManager;
import manager.FruitTypeManager;
import menu.Menu;
import menu.Option;

import java.util.Scanner;

// 库存管理
public class MenuFruitManager extends Menu {
    FruitManager fruitManager;

    public MenuFruitManager(FruitStore fruitStore) {
        super(fruitStore);
        fruitManager = fruitStore.getFruitStockManager();
        registerOption(new OptionAddFruitStock(fruitStore));
    }

    @Override
    public String name() {
        return "库存管理";
    }

    @Override
    public void showHeader() {
        System.out.println("当前库存:");
        fruitManager.show();
    }
}

class OptionAddFruitStock extends Option {
    FruitManager fruitManager;
    FruitTypeManager fruitTypeManager;

    public OptionAddFruitStock(FruitStore fruitStore) {
        super(fruitStore);
        fruitManager = fruitStore.getFruitStockManager();
        fruitTypeManager = fruitStore.getFruitTypeManager();
    }

    @Override
    public int onHandler() {
        System.out.println("正在添加库存...");
        fruitTypeManager.show();
        int id = -1;
        int count = 0;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("类型编号:");
            id = sc.nextInt();
            if (fruitTypeManager.getFruitType(id) == null) {
                System.out.println("找不到该水果类型!");
                return -1;
            }
            System.out.print("数量:");
            count = sc.nextInt();
            if (count <= 0) {
                System.out.println("无效数量!");
                return -1;
            }
        }catch (Exception e) {
            System.out.println("无效参数");
        }
        boolean ok = fruitManager.AdjustFruit(id, count);
        if (ok) {
            System.out.println("添加成功!");
        } else {
            System.out.println("添加失败!");
        }
        return 0;
    }

    @Override
    public String name() {
        return "添加库存";
    }
}