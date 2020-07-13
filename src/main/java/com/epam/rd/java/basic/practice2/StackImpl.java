package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class StackImpl implements Stack {
    private Object[] stackArray;
    private int count;

    public StackImpl() {
        this.stackArray = new Object[4];
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

        int cursor=count-1;
        int lastRet = -1;

        @Override
        public boolean hasNext() {

            return (cursor != -1);
        }

        @Override
        public Object next() {

            int i = cursor;

            Object[] elementData = stackArray;

            cursor = i - 1;

            return  elementData[lastRet = i];
        }

    }

    @Override
    public void push(Object element) {

        if (count < stackArray.length) {
            this.stackArray[count] = element;
            count++;
        } else if (count == stackArray.length) {
            Object[] arr2 = new Object[stackArray.length + 1];
            System.arraycopy(stackArray, 0, arr2, 0, stackArray.length);
            arr2[arr2.length - 1] = element;
            stackArray = arr2;
            count++;}

    }

    @Override
    public Object pop() {
        Object obj = top();
        int     len = size();
        if (len == 0)
            return null;

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

        if (stackArray == null)
            return "null";
        int iMax = stackArray.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(stackArray[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

    public static void main(String[] args) {
        StackImpl stack = new StackImpl(4);
        stack.push(34);
        stack.push(56);
        stack.push(78);
        stack.push(31);

        System.out.println(stack);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack);

        for (Object o : stack) {
            System.out.print((o)+" ");
        }
        System.out.println();
        System.out.println(stack);
        System.out.println(stack);



    }

}
