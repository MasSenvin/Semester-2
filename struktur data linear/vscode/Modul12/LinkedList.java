package vscode.Modul12;

import java.util.NoSuchElementException;

public class LinkedList<E> {
    ListNode<E> head;
    int size;

    public LinkedList() {
        head = new ListNode<E>();
        head.next = head;
        head.prev = head;
        size =0;
    }

    public ListNode<E> getHead() {
        return head;
    }

    public void setHead(ListNode<E> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addBefore(E x, ListNode<E> bantu) {
        ListNode<E> baru = new ListNode<E>();
        baru.next = bantu;
        baru.prev = bantu.prev;
        bantu.prev.next = baru;
        bantu.prev = baru;
        size++;
    }
    public E remove(ListNode<E> bantu){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        bantu.prev.next = bantu.next;
        bantu.next.prev = bantu.prev;
        size--;
        return bantu.elemen;
    }

    public void print() {
        ListNode<E> bantu = head.next;
        while (bantu != head) {
            System.out.println(bantu.elemen);
            bantu = bantu.next;
        }
    }

    public void addFirst(E x) {
        addBefore(x, head.next);
    }

    public void addLast(E x) {
        addBefore(x, head);
    }

    // public E removeFirst() {
    //     if (head.next != head) { // Check if the list is not empty
    //         E value = head.next.elemen;
    //         head.next = head.next.next;
    //         if (head.next != head) {
    //             head.next.prev = head;
    //         }
    //         size--;
    //         return value;
    //     } else {
    //         return -1; // Return -1 or any value that indicates an error
    //     }
    // }
    public E removeLast(){
        return remove(head.prev);
    }
    public ListNode<E> search(E key){
        ListNode<E> bantu = head;
        while (bantu!= head) {
            if (bantu.elemen == key) {
                return bantu;
            }
            bantu = bantu.next;
        }
        return null;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public String toString(){

        ListNode<E> bantu = head.next;
        while (bantu != head) {
            System.out.println(bantu.elemen);
            bantu = bantu.next;
        }
        return null;
    }
}

