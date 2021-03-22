public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Fruit> fruitBox = new Box<>();
        Box<Object> objectBox = new Box<>();

        Apple freshApple = new Apple();
        freshApple.setFresh(true);

        Apple rottenApple = new Apple();
        rottenApple.setFresh(false);

        appleBox.put(freshApple);

        System.out.println("Копирование из коробки: \n");
        BoxUtil.copyFromBoxToBox(appleBox, fruitBox);
        System.out.println(fruitBox.get());

        BoxUtil.copyFromBoxToBox(appleBox, objectBox);
        System.out.println(objectBox.get());

        BoxUtil.copyFromBoxToBox(fruitBox, objectBox);
        System.out.println(objectBox.get());

        System.out.println("\nТо же, с учётом свежести: \n");

        copyIfFresh(appleBox, fruitBox);

        appleBox.put(null);
        copyIfFresh(appleBox, fruitBox);

        copyIfFresh(appleBox, objectBox);

        copyIfFresh(fruitBox, objectBox);

        appleBox.put(rottenApple); // положил гнилое

        copyIfFresh(appleBox, fruitBox);

        copyIfFresh(appleBox, objectBox);

        fruitBox.put(rottenApple);
        copyIfFresh(fruitBox, objectBox);

        System.out.println("Матрёшка из двух коробок: ");
        Box<Box<Apple>> box = new Box<>();
        box.put(appleBox);

        BoxUtil.printElementFromTwoBoxes(box);

        System.out.println("\nПроизвольная матрёшка:");

        Box<Box<Apple>> box1 = new Box<>();
        Box<Box<Box<Apple>>> box2 = new Box<>();
        Box<Box<Box<Box<Apple>>>> box3 = new Box<>();

        box1.put(appleBox);
        box2.put(box1);
        box3.put(box2);

        BoxUtil.printElementFromBoxes(box3);

    }

    public static <T extends Fruit> void copyIfFresh(Box<T> src, Box<? super T> dest) {
        dest.put(null);
        System.out.println(dest);
        System.out.println("выполняется копирование...");
        BoxUtil.copyFreshFruitFromBoxToBox(src, dest);
        System.out.println(dest + "\n");
    }

}
