package vscode.proyek;
import java.util.LinkedList;
import java.util.Scanner;

public class RentalMobil {
    LinkedList<Mobil> daftarMobil = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);
    public void tambahMobil() {
        System.out.print("Masukkan nomor plat: ");
        String nomorPlat = scanner.nextLine();
        System.out.print("Masukkan merk: ");
        String merk = scanner.nextLine();
        System.out.print("Masukkan model: ");
        String model = scanner.nextLine();
        daftarMobil.add(new Mobil(nomorPlat, merk, model, true));
        System.out.println("Mobil berhasil ditambahkan!");
    }
    public void hapusMobil() {
        System.out.print("Masukkan nomor plat mobil yang ingin dihapus: ");
        String nomorPlat = scanner.nextLine();
        boolean ditemukan = false;

        for (Mobil mobil : daftarMobil) {
            if (mobil.nomorPlat.equals(nomorPlat)) {
                daftarMobil.remove(mobil);
                System.out.println("Mobil berhasil dihapus!");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Mobil dengan nomor plat tersebut tidak ditemukan.");
        }
    }
    public void tampilkanMobil() {
        if (daftarMobil.isEmpty()) {
            System.out.println("Tidak ada mobil yang tersedia.");
        } else {
            for (Mobil mobil : daftarMobil) {
                System.out.println(mobil);
            }
        }
    }
    public void menu() {
        int pilihan;
        do {
            System.out.println("\n== Pengelolaan Data Rental Mobil ==");
            System.out.println("1. Tambah Mobil");
            System.out.println("2. Hapus Mobil");
            System.out.println("3. Tampilkan Daftar Mobil");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // membersihkan buffer

            switch (pilihan) {
                case 1:
                    tambahMobil();
                    break;
                case 2:
                    hapusMobil();
                    break;
                case 3:
                    tampilkanMobil();
                    break;
                case 4:
                    System.out.println("Keluar dari program...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (pilihan != 4);
    }
}
