package vscode.Modul3;

import vscode.Modul1.Larik;

public class BubleSort {
    public static void main(String[] args) {
        int data[] = {5, 8, 26, 15, 11, 31} ;

        System.out.println("Data: ");
        Larik.cetak(data);
        System.out.println("");
        
        Larik.BubleSort(data);
        Larik.cetak(data);

        

    }
    
}
