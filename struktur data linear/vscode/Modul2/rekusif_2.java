package vscode.Modul2;

public class rekusif_2 {
  
    public static int paijo (int x){
        if (x==0) 
            return 0;
            return 2 * paijo(x-1) + x * x;
            
        
    }
}
