package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements Option, Serializable {
    ArrayList<Option> options;

    public Menu() {
        options = new ArrayList<>();
    }

    @Override
    public int run(Object obj) {
        while(true) {
            System.out.println("============" + name() + "============");
            header();
            ShowOptions();
            int opt = GetOption();
            if (opt == 0) {
                break;
            }
            options.get(opt-1).run(this);
        }
        return 0;
    }

    @Override
    public String name() {
        return "Menu";
    }

    @Override
    public void header() {

    }

    public void RegisterOption (Option opt) {
        options.add(opt);
    }

    private void ShowOptions() {
        System.out.println();
        for(int i = 0; i < options.size(); i++) {
            System.out.println("" + (i + 1) + "." + options.get(i).name());
        }
        System.out.println("0" + "." + "退出");
    }

    private int GetOption() {
        int opt = -1;
        while(!IsValidOption(opt)) {
            System.out.print("Please input your option:");
            Scanner sc = new Scanner(System.in);
            opt = sc.nextInt();
        }
        return opt;
    }

    private boolean IsValidOption(int opt) {
        return opt >= 0 && opt <= options.size();
    }
}
