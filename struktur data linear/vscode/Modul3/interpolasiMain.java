package vscode.Modul3;

import java.util.Arrays;

import vscode.Modul1.Larik;

public class interpolasiMain {
    public static void main(String[] args) {
         int data [] = {5, 8, 26, 15, 11, 31};
        Arrays.sort(data);

        int key = 15;
        int hasil = Larik.interpolasiSearch(data, key);

        if (hasil >= 0) {
            System.out.println("Data ditemukan pada indeks: " + hasil);
        }else{
            System.out.println("Data tidak ditemukan");
        }


    }
}
