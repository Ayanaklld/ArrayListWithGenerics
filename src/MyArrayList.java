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
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (comparator.compare((T) items[j], (T) items[j + 1]) > 0) {
                    // Обмен элементов, если они находятся в неправильном порядке
                    T temp = (T) items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }
    }
}
