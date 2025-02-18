package vscode.Modul12;

public class ListNode<E> {
     E elemen;
     ListNode<E> next;
     ListNode<E> prev;

    public  ListNode(){
        this.elemen = null;
        next= null;
        prev = null;
    }
    public  ListNode(E x) {
        this.elemen = x;
        this.next = null;
        this.prev = null;
    }
    public E getElemen() {
        return elemen;
    }
    public void setElemen(E elemen) {
        this.elemen = elemen;
    }
    public ListNode<E> getNext() {
        return next;
    }
    public void setNext(ListNode<E> next) {
        this.next = next;
    }
    public ListNode<E> getPrev() {
        return prev;
    }
    public void setPrev(ListNode<E> prev) {
        this.prev = prev;
    }
    

    }

