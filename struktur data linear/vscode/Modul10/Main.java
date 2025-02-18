package vscode.Modul10;

import vscode.Modul1.Larik;

public class Main {
    public static void main(String[] args) {
        Mahasiswa[] mhs = new Mahasiswa[5];

        mhs [0]= new Mahasiswa("Dion", 100);
        mhs [1]= new Mahasiswa("dioa", 103);
        mhs [2]= new Mahasiswa("oiii", 105);
        mhs [3]= new Mahasiswa("opoi", 300);
        mhs [4]= new Mahasiswa("asii", 109);

        Larik.cetak(mhs);
        Mahasiswa cariMhs = new Mahasiswa(100);
        int hasil = Larik.sequentialSearch(mhs, cariMhs);
        if (hasil >= 0) {
            System.out.println("Data Didapat di index "+ hasil);

        }else{
            System.out.println( " Data "+cariMhs+ "Tidak ditemukan ");
        }

        Larik.BubleSort(mhs);
        System.out.println("Data urut ");
        Larik.cetak(mhs);
    }
}
