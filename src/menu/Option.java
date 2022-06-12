package menu;

import imenu.IOption;

import java.io.Serializable;

public class Option implements IOption, Serializable {
    FruitStore fruitStore;

    public Option(FruitStore fruitStore) {
        this.fruitStore = fruitStore;
    }

    public FruitStore getFruitStore() {
        return fruitStore;
    }

    @Override
    public int handler() {
        return 0;
    }

    @Override
    public String name() {
        return null;
    }
}
