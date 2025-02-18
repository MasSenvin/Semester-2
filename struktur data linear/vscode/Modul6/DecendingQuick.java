package vscode.Modul6;

import vscode.Modul1.Larik;

public class DecendingQuick {
    public static void main(String[] args) {
        int data [] = {5, 8, 26, 15, 11, 31, 7, 40, 23, 25};

        System.out.println("Data: ");
        Larik.cetak(data);
        System.out.println("");

        Larik.QuickSortDecending(data, 0, 9);
        Larik.cetak(data);
    }
}
