package vscode.proyek.fiks;

public class Mobil {
    private String nama;
    private int harga;
    int stok;
    private String Platnomer;


    public Mobil(String nama, int harga, int stok, String platnomer) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        Platnomer = platnomer;
    }


    public String getnama() {
        return nama;
    }


    public void setNama(String nama) {
        this.nama = nama;
    }


    public int getHarga() {
        return harga;
    }


    public void setHarga(int harga) {
        this.harga = harga;
    }


    public int getStok() {
        return stok;
    }


    public void setStok(int stok) {
        this.stok = stok;
    }


    public String getPlatnomer() {
        return Platnomer;
    }


    public void setPlatnomer(String platnomer) {
        Platnomer = platnomer;
    }
    
    
    }
    


