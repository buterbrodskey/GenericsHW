public class Box<T> {
    private T element;

    public void put(T element) {
        this.element = element;
    }

    public T get() {
        return element;
    }

    @Override
    public String toString() {
        if (element == null) {
            return "коробка пуста";
        }
        else {
            return "в коробке лежит " + element.toString();
        }
    }
}
