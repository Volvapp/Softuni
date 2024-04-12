package implementations;

import interfaces.Deque;

import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E> {
    private final int INIT_CAPACITY = 7;
    private int size;
    private Object[] elements;

    private int head;
    private int tail;

    public ArrayDeque() {
        size = 0;
        elements = new Object[INIT_CAPACITY];

        int middle = INIT_CAPACITY / 2;
        head = tail = middle;
    }

    @Override
    public void add(E element) {
        if (this.size == 0) {
            this.elements[this.tail] = element;
        } else {
            if (this.tail == this.elements.length - 1) {
                grow();
            }
            this.elements[++this.tail] = element;
        }
        this.size++;
    }

    private void grow() {
        int newCapacity = size * 2 + 1;
        Object[] tmp = new Object[newCapacity];
        int middle = newCapacity / 2;
        int begin = middle - this.size / 2;

        int index = head;

        for (int i = begin; index <= this.tail; i++) {
            tmp[i] = elements[index++];
        }
        this.head = begin;
        this.tail = this.head + this.size - 1;
        elements = tmp;
    }

    @Override
    public void offer(E element) {
        add(element);
    }

    @Override
    public void addFirst(E element) {
        if (this.size == 0) {
            this.add(element);
        } else {
            if (this.head == 0) {
                grow();
            }
            this.elements[--this.head] = element;
            this.size++;
        }
    }

    @Override
    public void addLast(E element) {
        this.add(element);
    }

    @Override
    public void push(E element) {
        this.addFirst(element);
    }

    @Override
    public void insert(int index, E element) {
        int realIndex = this.head + index;
        validation(realIndex);

        if (realIndex - this.head < this.tail - realIndex) {
            insertAndShiftLeft(realIndex - 1, element);
        } else {
            insertAndShiftRight(realIndex, element);
        }
    }

    private void insertAndShiftRight(int index, E element) {
        E lastElement = (E) this.elements[tail];
        for (int i = this.tail; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[index] = element;
        this.addLast(lastElement);
    }

    private void insertAndShiftLeft(int index, E element) {
        E firstElement = (E) this.elements[head];
        for (int i = this.head; i <= index; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[index] = element;
        this.addLast(firstElement);
    }

    @Override
    public void set(int index, E element) {
        int realIndex = index + this.head;
        validation(realIndex);
        this.elements[realIndex] = element;
    }

    @Override
    public E peek() {
        if (!isEmpty()) {
            return (E) this.elements[this.head];
        }
        return null;
    }

    @Override
    public E poll() {
        return removeFirst();
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public E get(int index) {
        int realIndex = this.head + index;
        validation(realIndex);
        return (E) this.elements[realIndex];
    }

    @Override
    public E get(Object object) {
        if (isEmpty()){
            return null;
        }

        for (int i = this.head; i <= this.tail; i++) {
            if (this.elements[i].equals(object)) {
                return (E) this.elements[i];
            }
        }
        return null;
    }

    @Override
    public E remove(int index) {
        int realIndex = this.head + index;
        validation(realIndex);

        return (E) elements[realIndex];
    }

    private void validation(int index) {
        if (index > this.tail || index < this.head) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E remove(Object object) {
        if (isEmpty()){
            return null;
        }
        for (int i = this.head; i <= this.tail; i++) {
            if (this.elements[i].equals(object)) {
                E element = (E) this.elements[i];
                this.elements[i] = null;

                for (int j = i; j < this.tail; j++) {
                    this.elements[j] = this.elements[j + 1];
                }
                this.removeLast();

                return element;

            }
        }

        return null;
    }

    @Override
    public E removeFirst() {
        if (!isEmpty()) {
            E element = (E) this.elements[head];
            this.elements[this.head] = null;
            this.head++;
            this.size--;

            return element;
        }
        return null;
    }

    @Override
    public E removeLast() {
        if (!isEmpty()) {
            E element = (E) this.elements[tail];
            this.elements[this.tail--] = null;
            this.size--;
            return element;
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.elements.length;
    }

    @Override
    public void trimToSize() {
        Object[] tmp = new Object[this.size];
        int index = 0;

        for (int i = this.head; i <= this.tail; i++) {
            tmp[index++] = this.elements[i];
        }
        this.elements = tmp;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = head;

            @Override
            public boolean hasNext() {
                return index <= tail;
            }

            @Override
            public E next() {
                return (E) elements[index++];
            }
        };
    }
}
