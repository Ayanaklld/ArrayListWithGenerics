import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<T> implements MyList<T> {

    private Object[] items;
    private int size;

    public MyArrayList() {
        items = new Object[10];
        size = 0;
    }

    @Override
    public void add(T value) {
        capacity(size + 1);
        items[size++] = value;
    }

    @Override
    public void add(int index, T value) {
        capacity(size + 1);

        for (int i = size; i > index; i--){
            items[i] = items[i -1];
        }

        items[index] = value;
        size++;
    }

    @Override
    public void set(int index, T value) {
        items[index] = value;
    }

    @Override
    public T get(int index) {
        return (T) items[index];
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }

        items[size - 1] = null;
        size--;
    }

    @Override
    public boolean contain(T value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(items[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void capacity(int requiredCapacity) {
        if (requiredCapacity > items.length){
            double newCapacity = Math.max((items.length * 1.5) + 1, requiredCapacity);
            items = Arrays.copyOf(items, (int) newCapacity);
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        // sort для сортировки массивов
        // (T[]) items приводим тип, так как изначально items объявлен как Object[]
        // 0, size диапазон элементов от 0 до size
        // comparator объект, реализующий интерфейс Comparator

        Arrays.sort((T[]) items, 0, size, comparator);
    }
}
