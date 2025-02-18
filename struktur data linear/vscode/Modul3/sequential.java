package vscode.Modul3;

public class sequential {
    public void cetak (int[] n){
        for(int i = 0; i < n.length; i++){
            System.out.print(n[i]);

        }
    
    }
    public static int sequentialSearch(int[] Larik, int kunci){
        for(int i = 0;i <Larik.length;i++) if (kunci ==Larik[i]) return 1;
        return -1;
            
        
    }
}
