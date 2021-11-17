package ru.avbugorov.interviewpreparation.list_impl;

import ru.avbugorov.interviewpreparation.list.MyList;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {
    private E[] list;
    private int capacity;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        this.list = (E[]) new Object[capacity];
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            this.capacity = DEFAULT_CAPACITY;
        }
        this.capacity = capacity;
        this.list = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public final boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public final E remove(int index) {
        checkIndex(index);
        E temp = this.list[index];
        for (int i = index; i < this.size; ++i) {
            if (index == size - 1) {
                this.list[i] = null;
                --this.size;
                return temp;
            }
            this.list[i] = this.list[i + 1];
        }
        --this.size;
        this.list[this.size] = null;
        return temp;
    }

    private final void checkIndex(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Неверный индекс");
        }
    }

    @Override
    public boolean add(E item) {
        if (checkingLoadFactor()) {
            arrayExpansion();
        }
        list[this.size] = item;
        size++;
        return true;
    }

    private boolean checkingLoadFactor() {
        return size == capacity;
    }

    private void arrayExpansion() {
        capacity = (capacity * 3) / 2 + 1;
        list = Arrays.copyOf(list, capacity);
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean removeFromItem(E item) {
        if (indexOf(item) == -1) {
            return false;
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(item)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return this.list[index];
    }

    @Override
    public int indexOf(E item) {
        for (int i = 0; i < this.size; ++i) {
            if (this.list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(list[i]).append(", ");
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }

        sb.append(" ]");
        return sb.toString();
    }


}
