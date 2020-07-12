package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class StackImpl implements Stack {
    private final Object[] stackArray;
    private int count;

    public StackImpl(int max) {
        this.stackArray = new Object[max];
        this.count = 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < stackArray.length; i++) {
            stackArray[i] = null;
        }
        count=0;
        
    }

    @Override
    public int size() {
        return count;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        @Override
        public boolean hasNext() {
            return (count < stackArray.length);
        }

        @Override
        public Object next() {
            return stackArray[count++];
        }

    }

    @Override
    public void push(Object element) {
        stackArray[count] = element;
        count++;
        
    }

    @Override
    public Object pop() {
        Object result = stackArray[--count];
        stackArray[count] = null;
        return result;
    }

    @Override
    public Object top() {
        return stackArray[count-1];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < stackArray.length - 1; i++) {
            s.append(stackArray[i] + ", ");
        }
        s.append(stackArray[stackArray.length - 1]);
        s.append("]");
        return s.toString();
    }

    public static void main(String[] args) {
        StackImpl stack=new StackImpl(10);
        stack.push(34);
        stack.push(56);
        System.out.println(stack);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack);



    }

}
