package skypro.com.springhomework;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {

    private static final int DEFAULT_CAPACITY = 8;

    private Integer[] data;
    private int size;

    public IntegerListImpl() {
        this(DEFAULT_CAPACITY);
    }

    public IntegerListImpl(int capacity) {
        this.data = new Integer[capacity];
    }

    @Override
    public Integer add(Integer item) {
        checkNoNull(item);
        checkCapacity();
        data[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkNoNull(item);
        checkIndex(index);
        checkCapacity();
        System.arraycopy(data, index, data, index + 1, data.length - index);
        data[size++] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkNoNull(item);
        checkIndex(index);
        data[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        checkNoNull(item);
        checkItemExist(item);
        int index = indexOf(item);
        removeItem(index);
        return item;
    }

    private void removeItem(int index) {
        if (size - 1 > index) {
            System.arraycopy(data, index + 1, data, index, data.length - index);
        }
        data[--size] = null;
    }

    @Override
    public Integer remove(int index) {
        checkIndex(index);
        Integer item = get(index);
        removeItem(index);
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) >= 0;
    }

    @Override
    public int indexOf(Integer item) {
        checkNoNull(item);
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        checkNoNull(item);
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            return false;
        }
        if (size != otherList.size()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (!get(i).equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        data = new Integer[DEFAULT_CAPACITY];
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(data, data.length);
    }

    private Integer[] grow() {
        return Arrays.copyOf(data, size * 2);
    }

    private void checkCapacity() {
        if (size == data.length) {
            data = grow();
        }
    }

    private void checkNoNull(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Not null item value is required");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index must be positive and less than" + size);
        }
    }

    private void checkItemExist(Integer item) {
        if (indexOf(item) == -1) {
            throw new IllegalArgumentException("Item doesn't exist in list:" + item);
        }
    }


    public static int[] sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                }
            }
        }

        int[] generateRandomArray; {
            java.util.Random random = new java.util.Random();
            arr = new int[30];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(100_000) + 100_000;
            }
            return arr;

        }

    }


}
