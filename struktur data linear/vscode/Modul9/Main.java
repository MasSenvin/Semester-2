package vscode.Modul9;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        LinkedList senarai = new LinkedList();
        senarai.addFirst(8);
        senarai.addFirst(15);
        senarai.addLast(26);
        senarai.addLast(14);
        senarai.print();

        int cari = 26;
        ListNode hasil = senarai.search(cari);
        if (hasil != null) {
            System.out.println("Data: " + hasil.getElemen() + "ditemnukan");
        }else{
            System.out.println("data tidak ditemukan ");
        }
        System.out.println();
        try{
            senarai.removeLast();
            System.out.println("Isinya: " + senarai + " ");
            senarai.removeLast();
            System.out.println("isinya: "+ senarai + " ");
            senarai.removeFirst();
            System.out.println("Isinya "+ senarai + " ");
            senarai.removeFirst();
            System.out.println("Isinya "+ senarai + " ");
            senarai.removeFirst();
            System.out.println("isinya " + senarai + " ");
        }catch(NoSuchElementException e){
            System.out.println("Senarai ksosong");
        }
    }
}
