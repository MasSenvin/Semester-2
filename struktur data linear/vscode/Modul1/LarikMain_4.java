package vscode.Modul1;

import vscode.Modul1.Larik;

public class LarikMain_4 {
    public static void main(String[] args) {
        final int ARRAY_LENGTH = 10;
        int array[] = new int [ARRAY_LENGTH];
        for( int counter = 0; counter < array.length; counter++)
            array[counter] = 2 + 2 * counter;

        System.out.printf("%s%8s\n", "Index", "Value");

        Larik.cetak2(array);




        


    }
}
