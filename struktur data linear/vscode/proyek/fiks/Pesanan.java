package vscode.proyek.fiks;

public class Pesanan {
    private Mobil mobil;
    private int jumlah;

    
    public Pesanan(Mobil mobil, int jumlah) {
        this.mobil = mobil;
        this.jumlah = jumlah;
    }


    public Mobil getMobil() {
        return mobil;
    }


    public void setMobil(Mobil mobil) {
        this.mobil = mobil;
    }


    public int getJumlah() {
        return jumlah;
    }


    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    
}
