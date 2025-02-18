package vscode.Modul1;



public class Larik {
    double array;
    
    public static void cetak(int[]x){
        for(int i = 0; i < x.length; i++){
            System.out.print(x[i]+" ");
    }
}
    public static void cetak(Object[]x){
        for(int i = 0; i < x.length; i++){
        System.out.println(x[i]+" ");
}
}
    public static void cetak2(int[]array){
     
        for (int counter = 0; counter < array.length;counter++){
            System.out.printf("%5d%8d\n", counter, array[counter]);
        }
        
    }
    public static void cetak3(int[]i){
        for (int value : i)
        System.out.printf("  %d", value);
    }
    public static void modifyArray(int[]array2){
        for (int counter = 0; counter <array2.length;counter++)
        array2[counter]*=2;
    }
    public static void modifyElement(int element)
    {
        element *=2;
        System.out.printf(
            "value of element in modifyElement: %d%n", element
        );
    }
   
    
    public static int sequentialSearch(int[] Larik, int kunci){
        for(int counter = 0;counter <Larik.length;counter++) {
        if (kunci ==Larik[counter]){
            return counter;
        } 
               
         
    }
    return -1;

}
public static int sequentialSearch(Object[] Larik, Object kunci){
    for(int counter = 0;counter <Larik.length;counter++) {
        if (((Comparable)kunci).compareTo(Larik[counter]) == 0){
         return counter;
    } 
    
}
return -1;

}
public static int BinarySearch(int [] Larik, int kunci){
    int indexAwal = 0;
    int indexAkhir = Larik.length;
    int indexTengah;

    while (indexAwal <= indexAkhir) {
        indexTengah = (indexAwal + indexAkhir)/2;
        if (Larik[indexTengah] == kunci) {
            return indexTengah;
            
        }else {
            if (Larik[indexTengah]> kunci) {
                indexAkhir = indexTengah -1;
                
            }else{
                indexAwal = indexTengah +1;
            }
        }
        
    }
    return -1;


}
public static int interpolasiSearch(int [] data, int key){
    int low = 0;
    int high = data.length -1;
    while (low <= high && key >= data[low] && key <= data[high]) {
        int mid = low + ((key - data[low])*(high - low))/ (data[high]- data[low]);

        if (data[mid]==key) {
            return mid;
        }
        if (data[mid] > key) {
            high = mid -1;

        }else{
            low = mid +1;
        }
    }
    return -1;
}
public static void BubleSort (int[] larik){
    for (int iterasi = 1; iterasi <= larik.length -1; iterasi++) {
        for (int elemet = 0; elemet <= larik.length -1 -iterasi; elemet++) {
            if (larik[elemet]> larik[elemet+1]) {
                int tukar = larik[elemet];
                larik[elemet]= larik[elemet+1];
                larik[elemet+1]= tukar;

            }            
        }
        
    }
}
public static void BubleSort (Object[] larik){
    for (int iterasi = 1; iterasi <= larik.length -1; iterasi++) {
        for (int elemet = 0; elemet <= larik.length -1 -iterasi; elemet++) {
            if (((Comparable)larik[elemet]).compareTo(larik[elemet+1])> 0) {
                Object tukar = larik[elemet];
                larik[elemet]= larik[elemet+1];
                larik[elemet+1]= tukar;

            }            
        }
        
    }
}
public static void SelectionSort (int[] larik){
    for (int iterasi = 0; iterasi < larik.length-2; iterasi++) {
      int minIndek = iterasi;
      for (int elemen = iterasi + 1; elemen < larik.length; elemen++) {
        if (larik[elemen]< larik[minIndek]) {
            minIndek = elemen;
            int tukar = larik[iterasi];
            larik[iterasi] = larik[minIndek];
            larik[minIndek]= tukar;
        }
        
      }  
        
    }
}
public static void BubbleSortDesending (int [] larik){
    for (int iterasi = 1; iterasi <= larik.length -1; iterasi++) {
        for (int elemet = 0; elemet <= larik.length -1 -iterasi; elemet++) {
            if (larik[elemet]< larik[elemet+1]) {
                int tukar = larik[elemet];
                larik[elemet]= larik[elemet+1];
                larik[elemet+1]= tukar;

            }            
        }
        
    }
}
public static void SelectionSortDecending(int []larik){
    for (int iterasi = 0; iterasi < larik.length-2; iterasi++) {
        int minIndek = iterasi;
        for (int elemen = iterasi + 1; elemen < larik.length; elemen++) {
          if (larik[elemen]> larik[minIndek]) {
              minIndek = elemen;
              int tukar = larik[iterasi];
              larik[iterasi] = larik[minIndek];
              larik[minIndek]= tukar;
          }
          
        }  
          
      }
}
public static void InsertionSortAcending (int []larik){
    for (int iterasi = 1; iterasi <larik.length; iterasi++) {
        int kunci = larik[iterasi];
        int elemen = iterasi -1;
        while (elemen >= 0 && larik[elemen ]> kunci) {
            larik[elemen +1] = larik[elemen];
            elemen = elemen - 1;
        }
        larik[elemen + 1] = kunci;
        }
        
        
        
    }
public static void InsertionSortDecending(int[]larik){
    for (int iterasi = 1; iterasi < larik.length; iterasi++) {
        int kunci = larik[iterasi];
        int elemen = iterasi -1;
        while (elemen >= 0 && larik[elemen ]< kunci) {
            larik[elemen +1] = larik[elemen];
            elemen = elemen - 1;
        }
        larik[elemen + 1] = kunci;
        
        }

}
public static void QuickSortAcending(int[]x, int awal, int akhir){
    if (awal < akhir) {
        int i = awal + 1;
        int j = akhir;
        while (i <= akhir && x[i] <= x[awal]) {
            i = i + 1;
        }
        while (j > awal && x[j] > x[awal]) {
            j = i -1;
        }
        while (i < j) {
            int tukar = x[i];
            x[i] = x[j];
            x[j] = tukar;

        while (i <= akhir && x[i] <= x[awal]) {
            i = i + 1;
        }
        while (j >awal && x[j] > x[awal]) {
            j--;
        }
        }
        int temp = x[awal];
        x[awal] = x[j];
        x[j] = temp;

        QuickSortAcending(x, awal, j-1);
        QuickSortAcending(x, j + 1, akhir);
    }
    
    
}
public static void QuickSortDecending(int[]x, int awal, int akhir){
    if (awal < akhir) {
        int i = awal + 1;
        int j = akhir;
        while (i <= j) {
            while (i <= akhir && x[i] >= x[awal]) {
                i++;
            }
            while (j > awal && x[j] < x[awal]) {
                j--;
            }
            if (i < j) {
                int tukar = x[i];
                x[i] = x[j];
                x[j] = tukar;
            }
        }
        int temp = x[awal];
        x[awal] = x[j];
        x[j] = temp;

        QuickSortDecending(x, awal, j - 1);
        QuickSortDecending(x, j + 1, akhir);
    }
}
}




