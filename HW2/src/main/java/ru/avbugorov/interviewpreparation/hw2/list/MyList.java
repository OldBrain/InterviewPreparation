package ru.avbugorov.interviewpreparation.hw2.list;

public interface MyList<E> {

    int size();

    boolean isEmpty();

    boolean add(E item);

    boolean removeFromItem(E item);

    E get(int index);

    public int indexOf(E item);

    public E remove(int index);
}
