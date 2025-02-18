package vscode.Modul6;

import vscode.Modul1.Larik;

public class AcendingDataRandom {
    public static void main(String[] args) {
            int  [] dataRandom = new int[1000000];
        for (int i = 0; i < dataRandom.length; i++) {
            dataRandom[i] = (int) (Math.random()* 1000);
        } 
       
        long mulai = System.nanoTime();
        Larik.QuickSortAcending(dataRandom.clone(),0,999999);
        long selesai = System.nanoTime() - mulai;

        System.out.println("Untuk = " + dataRandom);
        System.out.println("Waktu untuk Quick Sort: " + selesai + " nanoseconds ");
    }
}
