package vscode.Modul11;

import java.util.NoSuchElementException;

public class QueueDinamis {
    private LinkedList antrian;

    public QueueDinamis(){
        antrian = new LinkedList();
    }
    public boolean enqueue(Object x){
        antrian.addLast(x);
        return true;
    }
    public Object dequeue(){
        if (!isEmpty()) {
            return antrian.remove(null);

        }else {
            throw new NoSuchElementException(" ");
        }
    }
    public int size(){
        return antrian.size();
    }
    public boolean isEmpty(){
        return antrian.isEmpty();
    }
}
