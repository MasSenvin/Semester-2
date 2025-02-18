package vscode.Modul12;

import vscode.Modul10.Mahasiswa;

public class Main {
    public static void main(String[] args) {
        LinkedList <Mahasiswa> senarai = new LinkedList<Mahasiswa>();

        senarai.addFirst(new Mahasiswa(100));
        senarai.addFirst(new Mahasiswa(103));
        senarai.addLast(new Mahasiswa(102));

        System.out.println("Isinya senarai" + senarai);
        
        
    }
   


       
    
}
