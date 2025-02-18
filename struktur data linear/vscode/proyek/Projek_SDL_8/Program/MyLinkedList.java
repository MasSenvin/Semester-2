package vscode.proyek.fiks;

public class MyLinkedList {
    private MyListNode head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(Object obj) {
        MyListNode newNode = new MyListNode(obj);
        if (head == null) {
            head = newNode;
        } else {
            MyListNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        MyListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.getNext();
        } else {
            MyListNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
