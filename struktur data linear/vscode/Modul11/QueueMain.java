package vscode.Modul11;

import vscode.Modul8.Queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue antrian = new Queue();

        antrian.Enqueue(14);
        antrian.Enqueue(24);
        antrian.Enqueue(8);

        while (!antrian.isEmpty()) {
            System.out.println(antrian.dequeue());
        }
    }
}
