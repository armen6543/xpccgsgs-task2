package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class StackImpl implements Stack {
    private  Object[] stackArray;
    private int count;

    public StackImpl() {
        this.stackArray = new Object[10];
        this.count = 0;}

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

        int index = size()-1;
        Object   obj= stackArray[index];

        stackArray[index]=null;
        count--;


        //int j = count - index - 1;
        //if (j > 0) {
            //System.arraycopy(stackArray, index + 1, stackArray, index, j);

        //}
        return obj;
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
        StackImpl stack=new StackImpl();
        stack.push(34);
        stack.push(56);
        stack.push(78);
        stack.push(31);

        System.out.println(stack);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.top());




    }

}
