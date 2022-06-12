package menu;

import module.FruitStore;

import java.io.Serializable;

public class Option implements IOption, Serializable {
    FruitStore fruitStore;

    public Option(FruitStore fruitStore) {
        this.fruitStore = fruitStore;
    }

    public FruitStore getFruitStore() {
        return fruitStore;
    }

    public int handler() {
        util.Console.clean();
        int res = onHandler();
        util.Console.clean();
        fruitStore.write();
        return res;
    }

    @Override
    public int onHandler() {
        return 0;
    }

    @Override
    public String name() {
        return null;
    }
}
