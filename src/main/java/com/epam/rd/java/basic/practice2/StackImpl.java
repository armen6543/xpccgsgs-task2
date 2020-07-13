package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class StackImpl implements Stack {
    private Object[] stackArray;
    private int count;

    public StackImpl() {
        this.stackArray = new Object[10];
        this.count = 0;
    }

    public StackImpl(int max) {
        this.stackArray = new Object[max];
        this.count = 0;
    }

    @Override
    public void clear() {
        final Object[] es = stackArray;
        for (int to = count, i = count = 0; i < to; i++)
            es[i] = null;
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
        int count1 = 0;

        @Override
        public boolean hasNext() {
            return (count1 < count);
        }

        @Override
        public Object next() {
            return stackArray[count1++];
        }

    }

    @Override
    public void push(Object element) {
        stackArray[count] = element;
        count++;

    }

    @Override
    public Object pop() {
        Object obj;

        obj = top();

        count--;
        stackArray[count] = null;
        return obj;
    }

    @Override
    public Object top() {
        int     len = size();
        if (len == 0)
            return null;
        return stackArray[count - 1];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < stackArray.length; i++) {
            if (i == stackArray.length - 1) {
                s.append(stackArray[stackArray.length - 1]);
                break;
            }
            s.append(stackArray[i] + ", ");
        }
        s.append("]");
        return s.toString();
    }

    public static void main(String[] args) {
        StackImpl stack = new StackImpl();
        stack.push(34);
        stack.push(56);
        stack.push(78);
        stack.push(31);

        System.out.println(stack);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack);

        Iterator<Object> iterator=stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }

}
