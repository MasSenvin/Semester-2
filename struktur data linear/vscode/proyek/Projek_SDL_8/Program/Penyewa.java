package vscode.proyek.fiks;

public class Penyewa {
    private String nama, noHP, alamat, NIK;

    public Penyewa(String nama, String noHP, String alamat, String nIK) {
        this.nama = nama;
        this.noHP = noHP;
        this.alamat = alamat;
        NIK = nIK;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String nIK) {
        NIK = nIK;
    }

    
    

    
}
