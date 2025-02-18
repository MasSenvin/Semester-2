package vscode.Modul9;

import java.util.NoSuchElementException;

public class LinkedList {
    ListNode head;
    int size;

    public LinkedList() {
        head = new ListNode();
        head.next = head;
        head.prev = head;
        size =0;
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addBefore(int x, ListNode bantu) {
        ListNode baru = new ListNode(x);
        baru.next = bantu;
        baru.prev = bantu.prev;
        bantu.prev.next = baru;
        bantu.prev = baru;
        size++;
    }
    public int remove(ListNode bantu){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        bantu.prev.next = bantu.next;
        bantu.next.prev = bantu.prev;
        size--;
        return bantu.elemen;
    }

    public void print() {
        ListNode bantu = head.next;
        while (bantu != head) {
            System.out.println(bantu.elemen);
            bantu = bantu.next;
        }
    }

    public void addFirst(int x) {
        addBefore(x, head.next);
    }

    public void addLast(int x) {
        addBefore(x, head);
    }

    public int removeFirst() {
        if (head.next != head) { // Check if the list is not empty
            int value = head.next.elemen;
            head.next = head.next.next;
            if (head.next != head) {
                head.next.prev = head;
            }
            size--;
            return value;
        } else {
            return -1; // Return -1 or any value that indicates an error
        }
    }
    public int removeLast(){
        return remove(head.prev);
    }
    public ListNode search(int key){
        ListNode bantu = head;
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

        ListNode bantu = head.next;
        while (bantu != head) {
            System.out.println(bantu.elemen);
            bantu = bantu.next;
        }
        return null;
    }
}