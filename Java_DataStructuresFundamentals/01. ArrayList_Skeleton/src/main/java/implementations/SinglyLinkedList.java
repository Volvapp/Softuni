package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {
    private static final int INIT_SIZE = 4;
    private Object[] elements;
    private int size;
    private int capacity;

    public SinglyLinkedList() {
        this.elements = new Object[INIT_SIZE];
        this.size = 0;
        this.capacity = INIT_SIZE;
    }

    @Override
    public void addFirst(E element) {
        ensureCapacity();

        shiftRight(element);

        this.size++;
    }

    @Override
    public void addLast(E element) {
        if (size == 0) {
            this.elements[0] = element;
            this.size++;
        } else {
            ensureCapacity();
            this.elements[size] = element;
            size++;
        }
    }

    @Override
    public E removeFirst() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        Object element = this.elements[0];
        shiftLeft();
        size--;
        return (E) element;
    }

    @Override
    public E removeLast() {
        Object tmp = this.elements[size - 1];
        Object[] arr = new Object[capacity];
        for (int i = 0; i < size - 1; i++) {
            arr[i] = this.elements[i];
        }
        this.elements = arr;
        size--;
        return (E)tmp;
    }

    @Override
    public E getFirst() {
        ensureSize();
        return (E) this.elements[0];
    }

    @Override
    public E getLast() {
        ensureSize();
        return (E) this.elements[size - 1];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < size();
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }

    private E get(int index) {
        ensureCapacity();
        return (E) this.elements[index];
    }

    private void ensureCapacity() {
        if (this.size == this.capacity) {
            grow();
            this.capacity = this.elements.length;
        }
    }

    private void grow() {
        Object[] tmp = new Object[size * 2];
        for (int i = 0; i < this.size; i++) {
            tmp[i] = this.elements[i];
        }
        this.elements = tmp;
    }

    private void shiftRight(E element) {

        Object[] tmp = new Object[capacity + 1];
        tmp[0] = element;
        for (int i = 0; i < this.size; i++) {
            tmp[i + 1] = this.elements[i];
        }
        this.elements = tmp;
    }

    private void ensureSize() {
        if (this.size == 0){
            throw new IllegalStateException();
        }
    }

    private void shiftLeft() {
        Object[] tmp = new Object[size];
        for (int i = 0; i < size; i++) {
            tmp[i] = elements[i + 1];
        }
        this.elements = tmp;
    }
}
