package menu;

import module.FruitStore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends Option implements IMenu, Serializable {
    private String top;
    private String bottom;
    private ArrayList<Option> options;

    public Menu(FruitStore fruitStore) {
        super(fruitStore);
        top = "==============================" + name() + "==============================";
        bottom = "";
        for (int i = 0; i < top.length(); i++) {
            bottom += "=";
        }
        options = new ArrayList<>();
    }

    public void registerOption(Option opt) {
        options.add(opt);
    }

    private void showOptions() {
        System.out.println();
        for(int i = 0; i < options.size(); i++) {
            System.out.println("" + (i + 1) + "." + options.get(i).name());
        }
        System.out.println("0" + "." + "退出");
    }

    private int getOption() {
        int opt = -1;
        while(!IsValidOption(opt)) {
            System.out.print("Select:");
            Scanner sc = new Scanner(System.in);
            try {
                opt = sc.nextInt();
            }catch (Exception e) {

            }
        }
        return opt;
    }

    private boolean IsValidOption(int opt) {
        return opt >= 0 && opt <= options.size();
    }

    @Override
    public String onHandler() {
        String res = null;
        while(true) {
            System.out.println(top);
            showHeader();
            showOptions();
            System.out.println(bottom);
            if (res != null) {
                System.out.println(res);
            }
            int opt = getOption();
            if (opt == 0) {
                break;
            }
            res = options.get(opt-1).handler();
        }
        return "返回";
    }

    @Override
    public String name() {
        return "Menu";
    }

    @Override
    public void showHeader() {
    }
}
