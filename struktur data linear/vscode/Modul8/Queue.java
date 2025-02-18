package vscode.Modul8;

import java.util.NoSuchElementException;

public class Queue {
    private int[] elemen;
    private int front;
    private int rear;
    private int size;

    public Queue(){
        front = 0;
        size = 0;
        rear = 0;
        elemen = new int[5];

    }
    public Queue (int ukuran){
        front = 0;
        size = 0;
        rear = 0;
        elemen = new int[ukuran];
    }
    public  boolean Enqueue(int x){
        if (size != elemen.length) {
            size ++;
            elemen[rear]= x;
            if (rear < elemen.length -1) {
                rear ++;
            }else{
                rear = 0;
            }
           return true ;
        }
        return false;
        
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if (size == 0) {
            return true;
            
        }
        return false;
    }
    public int dequeue(){
        int temp;
        if (!isEmpty()) {
            size --;
            temp = elemen[front];
            if (front < elemen.length-1) {
                front ++;
            } else {
                front= 0;
            }
            return temp;
        }
        throw new NoSuchElementException();
    }
}
