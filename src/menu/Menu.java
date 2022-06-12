package menu;

import menu.imenu.IMenu;
import menu.imenu.IOption;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends Option implements Serializable, IMenu {
    private ArrayList<IOption> options;

    public Menu(FruitStore fruitStore) {
        super(fruitStore);
        options = new ArrayList<>();
    }

    public void registerOption(IOption opt) {
        options.add(opt);
    }

    private void showOptions() {
        for(int i = 0; i < options.size(); i++) {
            System.out.println("" + (i + 1) + "." + options.get(i).name());
        }
        System.out.println("0" + "." + "退出");
    }

    private int getOption() {
        int opt = -1;
        while(!IsValidOption(opt)) {
            System.out.print("Input your option:");
            Scanner sc = new Scanner(System.in);
            opt = sc.nextInt();
        }
        return opt;
    }

    private boolean IsValidOption(int opt) {
        return opt >= 0 && opt <= options.size();
    }

    @Override
    public int handler() {
        while(true) {
            System.out.println("============" + name() + "============");
            showHeader();
            showOptions();
            int opt = getOption();
            if (opt == 0) {
                break;
            }
            options.get(opt-1).handler();
        }
        return 0;
    }

    @Override
    public String name() {
        return "Menu";
    }

    @Override
    public void showHeader() {
    }
}
