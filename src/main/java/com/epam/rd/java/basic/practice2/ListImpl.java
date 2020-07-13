package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl implements List {
    private Node first;
    private Node last;
    private int count;

    public ListImpl() {
        last = null;
        first = null;
        count = 0;
    }

    private static class Node {
        private Object element;
        private Node next;
        private Node previous;

        private Node(Node prev, Object element, Node next) {
            this.element = element;
            this.next = next;
            this.previous = prev;
        }
    }

    @Override
    public void clear() {
        for (ListImpl.Node x = first; x != null; ) {
            ListImpl.Node next = x.next;
            x.element = null;
            x.next = null;
            x.previous = null;
            x = next;
        }
        first = last = null;
        count = 0;

    }

    @Override
    public int size() {
        return count;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;

        }

        @Override
        public Object next() {

            if (hasNext()) {
                Object data = current.element;
                current = current.next;
                return data;
            }
            return null;

        }

    }

    @Override
    public void addFirst(Object element) {
        final Node currFirst = first;
        final Node newNode = new Node(null, element, currFirst);
        first = newNode;
        if (currFirst == null)
            last = newNode;
        else
            currFirst.previous = newNode;
        count++;

    }

    @Override
    public void addLast(Object element) {
        final Node currLast = last;
        final Node newNode = new Node(currLast, element, null);
        last = newNode;
        if (currLast == null)
            first = newNode;
        else
            currLast.next = newNode;
        count++;
    }

    @Override
    public void removeFirst() {
        final ListImpl.Node f = first;
        if (f == null)
            throw new NoSuchElementException();
        final Object element = f.element;
        final ListImpl.Node next = f.next;
        f.element = null;
        f.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.previous = null;
        count--;
    }

    @Override
    public void removeLast() {
        final ListImpl.Node l = last;
        if (l == null)
            throw new NoSuchElementException();
        final Object element = l.element;
        final ListImpl.Node prev = l.previous;
        l.element = null;
        l.previous = null;
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        count--;

    }

    @Override
    public Object getFirst() {
        final ListImpl.Node f = first;
        if (f == null)
            return null;
        return f.element;
    }


    @Override
    public Object getLast() {
        final ListImpl.Node l = last;
        if (l == null)
            return null;
        return l.element;
    }

    @Override
    public Object search(Object element) {

        int index = 0;
        if (element == null) {
            for (ListImpl.Node x = first; x != null; x = x.next) {
                if (x.element == null)
                    return index;
                index++;
            }
        } else {
            for (ListImpl.Node x = first; x != null; x = x.next) {
                if (element.equals(x.element))
                    return x.element;
                index++;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Object element) {
        if (element == null) {
            for (ListImpl.Node x = first; x != null; x = x.next) {
                if (x.element == null) {
                    final Object el = x.element;
                    final ListImpl.Node next = x.next;
                    final ListImpl.Node prev = x.previous;

                    if (prev == null) {
                        first = next;
                    } else {
                        prev.next = next;
                        x.previous = null;
                    }

                    if (next == null) {
                        last = prev;
                    } else {
                        next.previous = prev;
                        x.next = null;
                    }

                    x.element = null;
                    count--;
                    return true;
                }
            }
        } else {
            for (ListImpl.Node x = first; x != null; x = x.next) {
                if (element.equals(x.element)) {
                    final Object el = x.element;
                    final ListImpl.Node next = x.next;
                    final ListImpl.Node prev = x.previous;

                    if (prev == null) {
                        first = next;
                    } else {
                        prev.next = next;
                        x.previous = null;
                    }

                    if (next == null) {
                        last = prev;
                    } else {
                        next.previous = prev;
                        x.next = null;
                    }

                    x.element = null;
                    count--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (ListImpl.Node x = first; x != null; x = x.next) {
            s.append(x.element);
            if (x.next == null) break;
            s.append(", ");
        }
        s.append("]");
        return s.toString();
    }


    public static void main(String[] args) {
        ListImpl list = new ListImpl();
        list.addLast(45);
        list.addFirst(23);
        list.addFirst(67);
        System.out.println(list);
        System.out.println(list.size());
        list.remove(23);
        System.out.println(list);
        System.out.println(list.size());
        //ist.clear();
        //System.out.println(list);
        //System.out.println(list.getFirst());
       // System.out.println(list.getLast());
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }
    }
}
