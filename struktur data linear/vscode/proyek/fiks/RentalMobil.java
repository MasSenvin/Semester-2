package vscode.proyek.fiks;

import java.util.Scanner;

public class RentalMobil {
    static MyLinkedList daftarMobil = new MyLinkedList();
    static MyLinkedList pesananSelesai = new MyLinkedList();
    static Penyewa sewa = null;

    public static void main(String[] args) {
        daftarMobil.add(new Mobil("Fortuner", 1200000, 1, "B 413 I"));
        daftarMobil.add(new Mobil("City", 3000000, 1, "R 41 MU"));
        daftarMobil.add(new Mobil("Civic", 4000000, 1, "B 360 LU"));
        daftarMobil.add(new Mobil("Mazda", 6500000, 1, "B 144 DAB"));
        daftarMobil.add(new Mobil("Toyota Supra", 7000000, 1, "L 38 AY"));
        daftarMobil.add(new Mobil("Pajero", 1200000, 1, "D 14 RE"));
        daftarMobil.add(new Mobil("JEEP", 1500000, 1, "A 55 U"));
        daftarMobil.add(new Mobil("RUBICON", 2500000, 1, "W I BU"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("===========================================");
        System.out.println("            SELAMAT DATANG DI");
        System.out.println("   <<<<< JASA RENTAL MOBIL PIOOOOO >>>>>");
        System.out.println("KAMI SIAP MELAYANI ANDA DENGAN SEPENUH HATI");
        System.out.println("===========================================");
        while (true) {
            System.out.println("\nPilihan Menu:");
            System.out.println("1. Pesan Mobil");
            System.out.println("2. Tampilkan Stok Mobil");
            System.out.println("3. Tambah Mobil Baru");
            System.out.println("4. Hapus Mobil dari Daftar");
            System.out.println("5. Tampilkan Daftar Mobil yang Disewa");
            System.out.println("6. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    pesanMobil(scanner);
                    break;
                case "2":
                    tampilkanDaftarStok();
                    break;
                case "3":
                    tambahMobilBaru(scanner);
                    break;
                case "4":
                    hapusMobilMenu(scanner);
                    break;
                case "5":
                    tampilkanMobilDisewa();
                    break;
                case "6":
                    System.out.println("Terima kasih telah menggunakan layanan kami!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    public static void tampilkanDaftarStok() {
        System.out.println("Daftar Mobil Rental:");
        System.out.println("-----------------------------------------------------------");
        System.out.println("  No. |    Nama Mobil      | Harga (per hari)  | Plat Mobil");
        System.out.println("-----------------------------------------------------------");
        for (int i = 0; i < daftarMobil.size(); i++) {
            Mobil mobil = (Mobil) daftarMobil.get(i);
            System.out.printf("  %-3d | %-18s | %-17d | %-11s%n", i + 1, mobil.getnama(), mobil.getHarga(), mobil.getPlatnomer());
        }
        System.out.println("-----------------------------------------------------------");
    }

    public static void tampilkanIdentitas(Scanner scanner) {
        if (sewa != null) {
            System.out.println("Data diri Anda sudah tersimpan.");
            return;
        }
        System.out.println("Silakan masukkan data diri anda:");
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Nomor Telepon: ");
        String nomorTelepon = scanner.nextLine();
        System.out.print("Alamat: ");
        String alamat = scanner.nextLine();
        System.out.print("NIK: ");
        String nIK = scanner.nextLine();
        sewa = new Penyewa(nama, nomorTelepon, alamat, nIK);
    }

    public static void pesanMobil(Scanner scanner) {
        if (sewa == null) {
            tampilkanIdentitas(scanner);
        }
        tampilkanDaftarStok();
        MyLinkedList pesanan = new MyLinkedList();
        while (true) {
            System.out.println("  ");
            System.out.println("Jika menyewa lebih dari satu maka pisahkan dengan koma contoh: 1,2,3/input dengan angka");
            System.out.print("Masukkan mobil yang ingin disewa (0 untuk selesai): ");
            String pilihan = scanner.nextLine();

            if (pilihan.equals("0")) {
                break;
            }

            String[] pilihanMobil = pilihan.split(",");

            for (String p : pilihanMobil) {
                try {
                    int pilihanIndividu = Integer.parseInt(p.trim());
                    if (pilihanIndividu < 1 || pilihanIndividu > daftarMobil.size()) {
                        System.out.println("Nomor mobil tidak valid!");
                        continue;
                    }

                    Mobil mobilDipilih = (Mobil) daftarMobil.get(pilihanIndividu - 1);

                    pesanan.add(new Pesanan(mobilDipilih, 1));
                    mobilDipilih.stok--;

                    if (mobilDipilih.getStok() == 0) {
                        daftarMobil.remove(pilihanIndividu - 1);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Masukan tidak valid!");
                }
            }
        }

        if (pesanan.isEmpty()) {
            System.out.println("Pesanan tidak valid!");
            return;
        }

        int lamaSewa = 0;
        while (true) {
            try {
                System.out.print("Berapa hari anda akan menyewa? ");
                lamaSewa = Integer.parseInt(scanner.nextLine());
                if (lamaSewa <= 0) {
                    System.out.println("Lama sewa harus lebih dari 0.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukan tidak valid! Harap masukkan angka.");
            }
        }

        int totalHarga = 0;
        for (int i = 0; i < pesanan.size(); i++) {
            Pesanan p = (Pesanan) pesanan.get(i);
            totalHarga += p.getMobil().getHarga() * lamaSewa;
        }

        System.out.printf("Total harga: Rp %d\n", totalHarga);
        System.out.print("Masukkan jumlah pembayaran: ");
        int pembayaran = Integer.parseInt(scanner.nextLine());

        int kembalian = pembayaran - totalHarga;
        if (kembalian < 0) {
            System.out.println("Uang yang Anda masukkan kurang!");
            return;
        } else {
            System.out.printf("Kembalian: Rp %d\n", kembalian);
            tampilkanStruk(pesanan, lamaSewa, totalHarga, pembayaran, kembalian);
            simpanDataPemesanan();
            for (int i = 0; i < pesanan.size(); i++) {
                Pesanan p = (Pesanan) pesanan.get(i);
                p.getMobil().stok -= p.getJumlah();
                pesananSelesai.add(p);
            }
            System.out.println("=====================================================");
            System.out.println("          Terima kasih atas pemesanan Anda!");
            System.out.println("\njangan lupa order lagi!! Nomor yang bisa dihubungi:");
            System.out.println("                                        082157543115");
            System.out.println("=====================================================");
        }
    }

    public static void simpanDataPemesanan() {
        System.out.println("Data pesanan telah disimpan.");
    }

    public static void tampilkanMobilDisewa() {
        if (pesananSelesai.isEmpty()) {
            System.out.println("Belum ada mobil yang disewa.");
            return;
        }

        System.out.println("Daftar Mobil yang Disewa:");
        System.out.println("-------------------------------------------------------");
        System.out.println("  No. |    Nama Mobil      | Jumlah  | Plat Mobil");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < pesananSelesai.size(); i++) {
            Pesanan pesanan = (Pesanan) pesananSelesai.get(i);
            Mobil mobil = pesanan.getMobil();
            System.out.printf("  %-3d | %-18s | %-7d | %-11s%n", i + 1, mobil.getnama(), pesanan.getJumlah(), mobil.getPlatnomer());
        }
        System.out.println("-------------------------------------------------------");
    }

    private static boolean autentikasiAdmin(Scanner scanner) {
        System.out.print("Masukkan username admin: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();
        return username.equals("admin") && password.equals("admin123");
    }

    public static void tambahMobilBaru(Scanner scanner) {
        if (!autentikasiAdmin(scanner)) {
            System.out.println("Akses ditolak: Anda bukan admin.");
            return;
        }
        System.out.print("Masukkan nama mobil: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan harga sewa per hari: ");
        int harga = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan jumlah stok: ");
        int stok = Integer.parseInt(scanner.nextLine());
        System.out.print("Masukkan plat nomor: ");
        String platnomer = scanner.nextLine();

        daftarMobil.add(new Mobil(nama, harga, stok, platnomer));
        System.out.println("Mobil baru berhasil ditambahkan.");
    }

    private static void hapusMobilMenu(Scanner scanner) {
        tampilkanDaftarStok();
        System.out.print("Masukkan nomor mobil yang ingin dihapus: ");
        int nomorMobil = Integer.parseInt(scanner.nextLine());

        if (nomorMobil < 1 || nomorMobil > daftarMobil.size()) {
            System.out.println("Nomor mobil tidak valid!");
            return;
        }

        hapusMobil(nomorMobil - 1);
    }

    private static void hapusMobil(int indeks) {
        if (indeks < 0 || indeks >= daftarMobil.size()) {
            System.out.println("Indeks mobil tidak valid!");
            return;
        }
        daftarMobil.remove(indeks);
        System.out.println("Mobil telah dihapus dari daftar.");
    }

    private static void tampilkanStruk(MyLinkedList pesanan, int lamaSewa, int totalHarga, int pembayaran, int kembalian) {
        System.out.println("\n====================== STRUK PEMESANAN ======================");
        System.out.println("Nama Penyewa: " + sewa.getNama());
        System.out.println("Nomor Telepon: " + sewa.getNoHP());
        System.out.println("Alamat: " + sewa.getAlamat());
        System.out.println("NIK: " + sewa.getNIK());
        System.out.println("---------------------------------------------------------------");
        System.out.println("Daftar Mobil yang Disewa:");
        System.out.println("No. | Nama Mobil       | Plat Nomor  | Lama Sewa | Harga");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < pesanan.size(); i++) {
            Pesanan p = (Pesanan) pesanan.get(i);
            Mobil mobil = p.getMobil();
            System.out.printf("%-3d | %-15s | %-11s | %-9d | Rp %-10d%n", i + 1, mobil.getnama(), mobil.getPlatnomer(), lamaSewa, mobil.getHarga() * lamaSewa);
        }
        System.out.println("---------------------------------------------------------------");
        System.out.printf("Total Harga: Rp %d%n", totalHarga);
        System.out.printf("Pembayaran: Rp %d%n", pembayaran);
        System.out.printf("Kembalian: Rp %d%n", kembalian);
    }
}

