package vscode.Modul1;

public class LarikMain {
    public static void main(String[] args) {
        //7.13
        int[] array = {1, 2, 3, 4, 5};


        System.out.printf(
            "Effects of passing reference to entire array:%n" +
            "The vslues of the originsl array are:%n"
        );
        Larik.cetak3(array);

        Larik.modifyArray(array);
        System.out.printf("%n%n The values of the modified array are:%n");

        Larik.cetak3(array);
        System.out.printf( 
            "%n%nEffects of passing array elemnt value:%n" +
            "array[3] before modifyElement: %d%n", array[3]

        );

    }
}
