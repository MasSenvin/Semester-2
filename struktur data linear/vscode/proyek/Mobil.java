package vscode.proyek;

public class Mobil {
    String nomorPlat;
    String merk;
    String model;
    boolean status;
    public Mobil(String nomorPlat, String merk, String model, boolean status) {
        this.nomorPlat = nomorPlat;
        this.merk = merk;
        this.model = model;
        this.status = status;
    }
    @Override
    public String toString() {
        return "Nomor Plat: " + nomorPlat + ", Merk: " + merk + ", Model: " + model + ", Status: " + (status ? "Tersedia" : "Dirental");
    }
    
}




