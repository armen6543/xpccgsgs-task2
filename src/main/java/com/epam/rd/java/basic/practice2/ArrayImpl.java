package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class ArrayImpl implements Array {
    private Object[] data;
    private int count;


    public ArrayImpl() {
        this.data = new Object[10];
        this.count = 0;

    }

    public ArrayImpl(int a) {
        this.data = new Object[a];
        this.count = 0;
    }


    @Override
    public void clear() {
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
        count=0;

    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        @Override
        public boolean hasNext() {
            return (count < data.length);
        }

        @Override
        public Object next() {
            return data[count++];
        }

    }

    @Override
    public void add(Object element) {
        if (count < data.length) {
            this.data[count] = element;
            count++;
        } else if (count == data.length) {
            Object[] arr2 = new Object[data.length + 1];
            System.arraycopy(data, 0, arr2, 0, data.length);
            arr2[arr2.length - 1] = element;
            data = arr2;
            count++;
        }
    }

    @Override
    public void set(int index, Object element) {
        if (index < count) {
            data[index] = element;
        } else if (index >= count) {
            data[index] = element;
            count++;
        }

    }

    @Override
    public Object get(int index) {
        return data[index];
    }

    @Override
    public int indexOf(Object element) {
        Object[] es = data;
        if (element == null) {
            for (int i = 0; i < es.length; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < es.length; i++) {
                if (element.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }


    @Override
    public void remove(int index) {
        data[index] = null;
        count--;

    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < data.length - 1; i++) {
            s.append(data[i] + ", ");
        }
        s.append(data[data.length - 1]);
        s.append("]");
        return s.toString();
    }

    public static void main(String[] args) {
        Array array = new ArrayImpl();
        array.add(3);
        array.add(5);
        array.add(10);
        array.set(3, 20);
        array.add(10);
        array.add(10);


        System.out.println(array);

        System.out.println(array.get(1));
        System.out.println(array.size());
        System.out.println(array.indexOf(10));
        System.out.println(array);
        array.remove(3);
        System.out.println(array);
        array.clear();
        System.out.println(array);


    }

}
