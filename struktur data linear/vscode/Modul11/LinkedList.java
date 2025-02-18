package vscode.Modul11;

import java.util.NoSuchElementException;

public class LinkedList {
    private ListNode head;
    private int size;

    public LinkedList(){
        head = new ListNode();
        head.setNext(head);
        head.setPrev(head);
        size = 0;
    }

    public void addBefore(Object elemen, ListNode bantu){
        ListNode baru = new ListNode(elemen);
        baru.setNext(bantu);
        baru.setPrev(bantu.getPrev());
        bantu.getPrev().setNext(baru);
        bantu.setPrev(baru);
        size++;
    }
    public Object remove (ListNode bantu){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object elemen = bantu.getElemen();
        bantu.getPrev().setNext(bantu.getNext());
        bantu.getNext().setPrev(bantu.getPrev());
        size--;
        return elemen;
    }
    public void print() {
        ListNode bantu = head.getNext();
        while (bantu != head) {
            System.out.println(bantu.getElemen());
            bantu = bantu.getNext();
        }
    }
    public void addFirst(Object x) {
        addBefore(x, head);
    }

    public void addLast(Object x) {
        addBefore(x, head);
    }
    public Object removeLast(){
        return remove(head.getPrev());
    }
    public ListNode search(Object key){
        ListNode bantu = head;
        while (bantu!= head) {
            if (bantu.getElemen() == key) {
                return bantu;
            }
            bantu = bantu.getNext();
        }
        return null;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return head.getNext() == head;
    }
    @Override
    public String toString(){
        if (isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        ListNode bantu = head.getNext();
        while (bantu != head) {
            result.append(bantu.getElemen().toString());
            bantu = bantu.getNext();
            if (bantu != head) {
                result.append("null");
                
            }
            
        }
       return toString();
    }
}
