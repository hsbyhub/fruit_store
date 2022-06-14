package module;

import logic.Customer;
import logic.CustomerManager;
import logic.FruitManager;
import logic.FruitType;
import menu.Menu;
import menu.Option;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Scanner;

public class MenuTrading extends Menu {
    private CustomerManager customerManager;

    public MenuTrading(FruitStore fruitStore) {
        super(fruitStore);
        this.customerManager = fruitStore.getCustomerManager();
        registerOption(new OptionAddShopping(fruitStore));
        registerOption(new OptionSettle(fruitStore));
    }

    @Override
    public String name() {
        return "交易";
    }

    @Override
    public void showHeader() {
        System.out.println("当前正在购物的客户:");
        customerManager.showShppingCustomer();
    }
}

class OptionAddShopping extends Option {
    private CustomerManager customerManager;

    public OptionAddShopping(FruitStore fruitStore) {
        super(fruitStore);
        this.customerManager = fruitStore.getCustomerManager();
    }

    @Override
    public String onHandler() {
        System.out.println("正在添加水果到购物车...");
        System.out.println("货架:");
        System.out.println("----------------------------");
        System.out.println(getFruitStore().getFruitStockManager());
        System.out.println("----------------------------");
        Scanner sc = new Scanner(System.in);
        Customer customer = null;
        FruitType fruitType = null;
        int count;
        try {
            System.out.print("客户名:");
            String name = sc.next();
            customer = customerManager.getCustomerByName(name);
            if (customer == null) {
                return "错误的用户名";
            }

            System.out.print("水果名:");
            String fruitName = sc.next();
            fruitType = getFruitStore().getFruitTypeManager().getFruitTypeByName(fruitName);
            if (fruitType == null) {
                return "错误的水果名";
            }

            System.out.print("数量:");
            count = sc.nextInt();
            if (count <= 0) {
                return "错误的数量";
            }
        } catch (Exception e) {
            return "参数错误";
        }

        FruitManager fruitCount = new FruitManager(getFruitStore().getFruitTypeManager());
        boolean ok = fruitCount.AdjustFruit(fruitType.getId(), count);
        if (!ok) {
            return "系统错误, 请联系管理员";
        }
        ok = customer.getShoppingCar().AdjustFruit(fruitCount);
        if (!ok) {
            return "添加到购物车失败";
        }

        return "添加到购物车成功, 添加金额:" + fruitCount.getTotalValue() + "， 折后金额为:";
    }

    @Override
    public String name() {
        return "购物车添加水果";
    }
}

// 结账
class OptionSettle extends Option {
    private CustomerManager customerManager;

    public OptionSettle(FruitStore fruitStore) {
        super(fruitStore);
        this.customerManager = fruitStore.getCustomerManager();
    }

    @Override
    public String onHandler() {
        System.out.println("正在结算...");
        customerManager.showShppingCustomer();
        System.out.print("客户名:");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        Customer customer = customerManager.getCustomerByName(name);
        if (customer == null) {
            return "找不到用户";
        }

        String res = "交易成功\n";
        res += customer.getShoppingCar() + "\n";

        float distant = customer.getDistant();
        float amount = customer.getShoppingCar().getTotalValue() * distant / 10;
        boolean ok = getFruitStore().getAccount().AdjustBalance(amount);
        if (!ok) {
            return "交易失败";
        }
        ok = customer.getAccount().AdjustBalance(-amount);
        if (!ok) {
            getFruitStore().getAccount().AdjustBalance(-amount);
            return "交易失败";
        }
        if (distant < 10) {
            res += "折扣:" + distant + " ";
        }
        res += "实付:$" + amount;
        return res;
    }

    @Override
    public String name() {
        return "购物车结算";
    }
}