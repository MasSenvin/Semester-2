# daftar tipe kamar dan harga
tipe = ["1. Satu Bed -", "2. Dua Bed -", "3. Super Besar Bed-"]
harga = [950000, 5200000, 8450000]

# loop untuk pemesanan
while True:
    # nampilkan tipe kamar dan harga 
    print("========= TIPE KAMAR HOTEL =========")
    print("")
    print(tipe[0], harga[0])
    print(tipe[1], harga[1])
    print(tipe[2], harga[2])
    print("\nNOTE : Harga  per Malam.")
    print("==============================================")

    # Meminta input dari user untuk memasukan tipe kamar dan jumlahnya
    tipe_kamar = int(input("\nTipe Kamar Yang Ingin Dipesan (1 - 3) : ")) - 1
    jumlah_malam = int(input("Masukkan Jumlah Yang Akan Dipesan : "))\
    # untuk menghitung totalnya
    total_biaya = float(harga[tipe_kamar]) * jumlah_malam
    # Menampilkan
    print("\nTotal Biaya Sewa Kamar Anda Adalah Rp.", total_biaya)

    # nampilkan opsi pembayaran
    print("\n========= METODE PEMBAYARAN  =========")
    print("")
    bayar = ["1. Transfer ATM.", "2. Bayar Cash di Hotel", "3. Kartu Kredit"]
    print(bayar[0])
    print(bayar[1])
    print(bayar[2])
    opsibayar = int(input("\nPilih Metode Pembayaran (1 - 3) : "))

    # if untuk pilihan opsi pembayaran
    if opsibayar == 1:
        # dengan atm
        print("==============================================")
        print("Silahkan Melakukan Pembayaran Ke Rekening Bank Kami.")
        print("no rek ....................")
        print("Pembayaran Akan Diverifikasi Dalam Waktu 1x24 Jam.")
        print("==============================================")
    elif opsibayar == 2:
        # dengan tunai
        print("==============================================")
        print("\nSilahkan Menunjukkan Kode Verifikasi Yang  \n Dikirimkan Melalui Email ke Resepsionis Kami")
        print("\nTerima Kasih Telah Menggunakan Jasa kami !")
    elif opsibayar == 3:
        # dengan kartu kredit
        print ("=============================================")
        print ("Silahkan melakukan Pembayaran ke kami dengan kartu kredit")
        nomer_kartu = int(input("Masukan Nomor Kartu : "))
        print (nomer_kartu,"Telah Berhasil")
        print("Terima kasih")
    # meminta input dari user untuk memesan kamar lagi atau tidak
    ulangi = input("\nApakah Anda Ingin Memesan Kamar Lagi? (ya/tidak): ")
    if ulangi.lower() != 'ya':
        break
