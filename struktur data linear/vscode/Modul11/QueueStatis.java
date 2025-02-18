package vscode.Modul11;

import java.util.NoSuchElementException;

public class QueueStatis {

        private Object[] elemen;
        private int front;
        private int rear;
        private int size;
    
        // Default constructor
        public QueueStatis() {
            this(10); // Default size of 10
        }
    
        public QueueStatis(int s) {
            elemen = new Object[s];
            front = 0;
            rear = 0;
            size = 0;
        }
    
        public boolean enqueue(Object x) {
            if (size != elemen.length) {
                elemen[rear] = x;
                rear = (rear + 1) % elemen.length;
                size++;
                return true;
            }
            return false;
        }
    
        public Object dequeue() {
            if (!isEmpty()) {
                Object temp = elemen[front];
                front = (front + 1) % elemen.length;
                size--;
                return temp;
            } else {
                throw new NoSuchElementException();
            }
        }
    
        public int size() {
            return size;
        }
    
        public boolean isEmpty() {
            return size == 0;
        }
    }