package vscode.Modul2;

public class rekursif_3 {

    public static void upAndDown(int n){
        System.out.print("\nLevel: " + n);
        if (n < 4) 
            upAndDown(n+1);
        System.out.print("\nLevel: " + n);
        
    }
}
