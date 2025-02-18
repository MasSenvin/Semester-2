package vscode.Modul10;

@SuppressWarnings("rawtypes")
public class Mahasiswa implements Comparable{
    private String nama;
    private int nim;
    public Mahasiswa(String nama, int nim) {
        this.nama = nama;
        this.nim = nim;
    }
    
    public Mahasiswa(int nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public int getNim() {
        return nim;
    }
    public void setNim(int nim) {
        this.nim = nim;
    }
    @Override
    public int compareTo(Object o) {
        if (nim ==((Mahasiswa)o).nim) {
            return 0;
        }else if (nim <((Mahasiswa)o).nim) {
            return -1;
        }else{
            return 1;
        }
        
    }
    public String toString(){
        return "Nim : "+ nim + ", Nama : " + nama;
    }
    
}
