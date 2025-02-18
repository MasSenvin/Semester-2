package vscode.Modul3;

import vscode.Modul1.Larik;

public class DecendingDataRandom {
    public static void main(String[] args) {
          int  [] dataRandom = new int[1000000];
        for (int i = 0; i < dataRandom.length; i++) {
            dataRandom[i] = (int) (Math.random()* 1000);
        } 
        //bubbleSort
        long mulai = System.nanoTime();
        Larik.BubbleSortDesending(dataRandom.clone());
        long selesai = System.nanoTime() - mulai;

        //SelectionSort
        long mulai2 = System.nanoTime();
        Larik.SelectionSortDecending(dataRandom.clone());
        long selesai2 = System.nanoTime() - mulai2;     


        System.out.println("Untuk = " + dataRandom);
        System.out.println("Waktu untuk BubbleSort: " + selesai);
        System.out.println("Waktu untuk SelectionSort: " + selesai2);

    }
}
