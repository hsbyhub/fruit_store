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

    public String handler() {
        util.Console.clean();
        String res = onHandler();
        util.Console.clean();
        fruitStore.write();
        return res;
    }

    @Override
    public String onHandler() {
        return null;
    }

    @Override
    public String name() {
        return null;
    }
}
