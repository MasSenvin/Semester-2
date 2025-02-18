package vscode.Modul3;

import vscode.Modul1.Larik;

public class sequentialMain {
    public static void main(String[] args) {
        
        int data[] = {5, 8, 26, 15, 11, 31} ;

        System.out.println("Data: ");
        Larik.cetak(data);

        System.out.println("");

        int key = 26;
        int hasil = Larik.sequentialSearch(data, key);
        if (hasil >=0) {
            System.out.println("Data: " + key +" ada di index ke: "+ hasil);

        }else{
            System.out.println("Data: " + key +" Tidak ditemukan");
        }
        
    }
    
}
