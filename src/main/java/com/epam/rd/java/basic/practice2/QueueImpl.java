package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueImpl implements Queue {
    private QNode head;
    private QNode tail;
    private int count;

    static class QNode {
        public Object object;
        public QNode next;

        public QNode(Object object, QNode next) {
            this.object = object;
            this.next = next;
        }
    }

    public QueueImpl() {

    }

    @Override
    public void clear() {
        Iterator it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }

    }

    @Override
    public int size() {
        return count;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        private QueueImpl.QNode lastReturned;
        private QueueImpl.QNode  next;
        private int nextIndex;

        @Override
        public boolean hasNext() {
            return nextIndex < count;
        }

        @Override
        public Object next() {
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.object;
        }

    }

    @Override
    public void enqueue(Object element) {
        if (head == null) {
            head = tail = new QNode(element, null);
            count++;
        } else {
            tail.next = new QNode(element, null);
            tail = tail.next;
            count++;
        }
    }

    @Override
    public Object dequeue() {
        if (head == null) {
            throw new NoSuchElementException("No more elements");
        }

        Object retval = head.object;
        QNode oldHead = head;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            oldHead.next = null;
        }
        return retval;
    }

    @Override
    public Object top() {
        if (head == null) {
            throw new NoSuchElementException("No more elements");
        }

        return head.object;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (QueueImpl.QNode x = head; x != null; x = x.next) {
            s.append(x.object);
            if (x.next == null) break;
            s.append(", ");
        }
        s.append("]");
        return s.toString();
    }

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl();
        queue.enqueue(34);
        queue.enqueue(56);

        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.top());

    }

}
