import fruit_store.FruitStore;

public class main {
    public static void main(String[] args) {
        FruitStore fruitStore = FruitStore.read("fruit_store.file");
        if (fruitStore == null) {
            fruitStore = new FruitStore("fruit_store.file");
        }
        fruitStore.run(null);
        fruitStore.write();
    }
}
