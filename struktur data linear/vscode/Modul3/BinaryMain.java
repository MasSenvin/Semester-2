package vscode.Modul3;

import java.util.Arrays;

import vscode.Modul1.Larik;

public class BinaryMain {
    public static void main(String[] args) {
        int data [] = {5, 8, 26, 15, 11, 31};
        Arrays.sort(data);// untuk mengurutkan

        int key = 26;
        int hasil = Larik.BinarySearch(data, key);
        if (hasil >= 0) {
            System.out.println("Data ditemukan di indeks ke- " + hasil );

            
        } else{
            System.out.println("data tidak ditemukan");
        }
        //System.out.println();
       // System.out.println(Larik.BinarySearch(data, 11));




    }
}
