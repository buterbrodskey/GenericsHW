public class BoxUtil {

    // скопировать содержимое из одной коробки в другую
    //Box(dest) в которую будем копировать может быть типизирована любым родителем объекта содержащимся в Box(src)
    public static <T> void copyFromBoxToBox(Box<T> src, Box<? super T> dest) {
        dest.put(src.get());
    }

    // скопировать содержимое из Box(src) которая может быть типизирована только классом Fruit и его наследниками,
    // при условии, что содержащийся фрукт свежий (fresh == true).
    //Box(dest) в которую будем копировать может быть типизирована любым родителем объекта содержащимся в Box(src)
    public static <T extends Fruit> void copyFreshFruitFromBoxToBox(Box<T> src, Box<? super T> dest) {
        if (src.get().isFresh() == true) {
            dest.put(src.get());
        }
        else System.out.println("Гнилые не примем!");
    }

    //вывести в консоль (toString()) объект второй коробки
    public static <T> void printElementFromTwoBoxes(Box<T> box) {
        System.out.println(((Box<T>) box.get()).get());
    }

    /**
     * вывести в консоль (toString()) объект последней коробки
     * <p>
     * box Box, которая содержит в себе любое кол-во вложенных Box, в последней из которых может быть любой объект.
     */
    public static <T> void printElementFromBoxes(Box<T> box) {
        if (box.get() instanceof Box) {
            printElementFromBoxes((Box<T>) box.get());
        }
        else System.out.println(box.get());
    }
}