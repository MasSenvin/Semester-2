package vscode.Modul8;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Queue antrian = new Queue(7);
        antrian.Enqueue(26);
        antrian.Enqueue(15);
        antrian.Enqueue(8);
        antrian.Enqueue(14);
        try{
            System.out.println(antrian.dequeue());
            System.out.println(antrian.dequeue());
            System.out.println(antrian.dequeue());
        } catch (NoSuchElementException x){
            System.out.println("amtrian kosong");
        }
    }
}
