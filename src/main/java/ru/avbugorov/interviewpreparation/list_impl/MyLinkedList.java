package ru.avbugorov.interviewpreparation.list_impl;

import ru.avbugorov.interviewpreparation.list.MyList;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E> {
    private Node first;
    private Node last;
    private int size;


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean add(E item) {
        Node addedNode = new Node(item);
        if (isEmpty()) {
            first = addedNode;
            first.value = item;
        } else {
            addedNode.setPrev(last);
            last.setNext(addedNode);
        }
        last = addedNode;
        size++;
        return true;
    }

    @Override
    public boolean removeFromItem(Object item) {
        if (isEmpty()) {
            return false;
        }
        if (first.value.equals(item)) {
            removeFirst();
            return true;
        }

        Node current = first;
        while (current != null && !current.getValue().equals(item)) {
            current = current.getNext();
        }
        if (current == null) {
            return false;
        }
        if (current == last) {
            removeLast();
            return true;
        }

        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
        return true;

    }

    private final E removeLast() {
        E temp = getLast();
        if (last.getPrev() == null) {
            first = null;
        } else {
            last.getPrev().setNext(null);
        }
        last = last.getPrev();
        size--;
        return temp;
    }

    private final E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty");
        }
        return last.value;
    }

    private final E removeFirst() {
        E temp = getFirst();
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrev(null);
        }
        size--;
        return temp;
    }

    private final E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty");
        }
        return first.value;
    }

    @Override
    public E get(int index) {
        Node current = first;
        int i = 0;
        while (current != null) {
            if (i == index) {
                return current.value;
            }
            i++;
            current = current.getNext();
        }
        return null;
    }

    @Override
    public int indexOf(E item) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.value.equals(item)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        Node current = first;
        int i = 0;
        while (current != null) {
            if (i == index) {
                E tmp = current.value;
                removeFromItem(current.value);
                return tmp;
            }
            i++;
            current = current.getNext();
        }
        return null;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = first;
        while (current != null) {
            sb.append(current.value).append(", ");
            current = current.getNext();
        }
        if (!isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    private class Node {
        Node prev;
        E value;
        Node next;

        public Node(Node prev, E value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

    }
}
