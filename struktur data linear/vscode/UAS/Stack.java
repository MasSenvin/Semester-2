package vscode.UAS;

import java.util.LinkedList;

public class Stack {
    private LinkedList<Character> elemen;
    private int size;

    public Stack() {
        this.elemen = new LinkedList<>();
        this.size = 0;
    }

    public boolean push(char x) {
        elemen.addFirst(x);
        size++;
        System.out.println( x );
        return true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong");
            return '0'; // Mengembalikan karakter null jika stack kosong
        }
        char x = elemen.removeFirst();
        size--;
        System.out.println( x);
        return x;
    }

    public String toString() {
        if (isEmpty()) {
            return "Stack Kosong";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < elemen.size(); i++) {
            builder.append(elemen.get(i));
            if (i < elemen.size() - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
}
