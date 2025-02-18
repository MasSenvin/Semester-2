package vscode.Modul5;

import vscode.Modul1.Larik;

public class InsertionSortMain {
    public static void main(String[] args) {
        int data [] = {5, 8, 26, 15, 11, 31};

        System.out.println("Data: ");
        Larik.cetak(data);
        System.out.println("");

        Larik.InsertionSortAcending(data);
        Larik.cetak(data);
    }
}
