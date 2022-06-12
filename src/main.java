import menu.FruitStore;

public class main {
    public static void main(String[] args) {
        String storage = "storage.txt";
        FruitStore fruitStore = FruitStore.read(storage);
        if (fruitStore == null) {
            fruitStore = new FruitStore(storage);
        }
        fruitStore.handler();
        fruitStore.write();
    }
}
