package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class ArrayImpl implements Array {
    private Object[] data;
    private int count;



    public ArrayImpl () {
       this.data=new Object[10];
       this.count=0;

    }
    public ArrayImpl (int a) {
        this.data=new Object[a];
        this.count=0;
    }


	@Override
    public void clear() {
	    data=null;
        
    }

	@Override
    public int size() {
        return data.length;
    }
	
	@Override
    public Iterator<Object> iterator() {
	    return new IteratorImpl();
    }
	
	private class IteratorImpl implements Iterator<Object> {

        @Override
        public boolean hasNext() {
            return (count<data.length);
        }

        @Override
        public Object next() {
            return data[count++];
        }

    }
	
	@Override
    public void add(Object element) {
        this.data[count] = element;
        count++;

        
    }

	@Override
    public void set(int index, Object element) {
        data[index]=element;
        
    }

	@Override
    public Object get(int index) {
        return data[index];
    }

	@Override
    public int indexOf(Object element) {
        if (element == null) {
            for (int i = 0; i < data.length; i++)
                if (data[i]==null)
                    return i;
        } else {
            for (int i = 0; i < data.length; i++)
                if (element.equals(data[i]))
                    return i;
        }
        return -1;
    }

	@Override
    public void remove(int index) {
        data[index]=null;
        
    }

    @Override
    public String toString() {
        StringBuilder s=new StringBuilder();
        s.append("[");
        for (int i=0;i<data.length-1;i++) {
            s.append(data[i]+" ");
        }
        s.append(data[data.length-1]);
        s.append("]");
        String s1=s.toString();
        return s1;
    }

    public static void main(String[] args) {
	    Array array=new ArrayImpl();
	    array.add(3);
	    array.add(5);
	    array.add(10);
	    array.set(3,20);
        System.out.println(array.get(1));
        System.out.println(array.size());
        System.out.println(array.indexOf(10));
        System.out.println(array);







    }

}
