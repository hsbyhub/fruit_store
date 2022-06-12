import module.FruitStore;

public class main {
    public static void main(String[] args) {
        String storage = "storage.txt";
        FruitStore fruitStore = FruitStore.read(storage);
        if (fruitStore == null) {
            fruitStore = new FruitStore(storage);
        }
        fruitStore.onHandler();
        System.out.println("已退出，感谢使用Fine水果店管理系统!");
    }
}
