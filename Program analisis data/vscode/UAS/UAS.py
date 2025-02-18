import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg
import tkinter as tk
from tkinter import ttk, messagebox

# File CSV untuk menyimpan data alat camping dan pemesanan
FILE_ALAT = r'C:\Users\LENOVO\Documents\KEVIN\KULIAH\SEMESTER 2\Program analisis data\vscode\UAS\coba.csv'
FILE_PEMESANAN = r"C:\Users\LENOVO\Documents\KEVIN\KULIAH\SEMESTER 2\Program analisis data\vscode\UAS\database.csv"

class AnakRimba:
    def __init__(self):
        self.df_alat = pd.read_csv(FILE_ALAT)
        self.df_pemesanan = pd.read_csv(FILE_PEMESANAN)
        self.data_diri = None

    def tampilkan_daftar_stok(self):
        print(self.df_alat.to_string(index=False))

    def tampilkan_identitas(self):
        if self.data_diri:
            print("Data diri Anda sudah tersimpan.")
            return
        print("Silakan masukkan data diri anda:")
        self.data_diri = {
            "Nama": input("Nama: "),
            "Nomor Telepon": input("Nomor Telepon: "),
            "Alamat": input("Alamat: "),
            "E-Mail": input("E-Mail: ")
        }

    def hitung_total_harga(self, alat_index, lama_sewa, jumlah):
        harga = self.df_alat.iloc[alat_index]["Harga (per hari)"] * lama_sewa * jumlah
        return harga


    def pesan_alat(self):
        if not self.data_diri:
            self.tampilkan_identitas()
        self.tampilkan_daftar_stok()
        pesanan = {}
        while True:
            try:
                print("Jika memesan lebih dari satu maka pisahkan dengan koma contoh: 1,2,3/input dengan angka")
                pilihan = input("Masukkan alat camping yang ingin disewa (0 untuk selesai): ")
                if pilihan == '0':
                    break
                pilihan_alat = [int(x.strip()) for x in pilihan.split(",")]
                for pilihan_individu in pilihan_alat:
                    if pilihan_individu < 1 or pilihan_individu > len(self.df_alat):
                        print("Nomor alat tidak valid!")
                        continue
                    if self.df_alat.iloc[pilihan_individu - 1]["Stok"] == 0:
                        print(f"Maaf, stok alat camping '{self.df_alat.iloc[pilihan_individu - 1]['Daftar Barang']}' sudah habis.")
                        continue
                    jumlah = int(input(f"Masukkan jumlah alat camping '{self.df_alat.iloc[pilihan_individu - 1]['Daftar Barang']}' yang ingin disewa: "))
                    if jumlah <= 0:
                        print("Jumlah alat camping harus lebih dari 0.")
                        continue
                    if jumlah > self.df_alat.iloc[pilihan_individu - 1]["Stok"]:
                        print("Maaf, stok tidak mencukupi.")
                        continue
                    if self.df_alat.iloc[pilihan_individu - 1]["Daftar Barang"] in pesanan:
                        pesanan[self.df_alat.iloc[pilihan_individu - 1]["Daftar Barang"]] += jumlah
                    else:
                        pesanan[self.df_alat.iloc[pilihan_individu - 1]["Daftar Barang"]] = jumlah
            except ValueError:
                print("Masukan tidak valid!")
        if not pesanan:
            print("Pesanan tidak valid!")
            return
        lama_sewa = 0
        while True:
            try:
                lama_sewa = int(input("Berapa hari anda akan menyewa? "))
                if lama_sewa <= 0:
                    print("Lama sewa harus lebih dari 0.")
                else:
                    break
            except ValueError:
                print("Masukan tidak valid! Harap masukkan angka.")
        total_harga = sum(self.hitung_total_harga(pilihan_individu - 1, lama_sewa, jumlah) for pilihan_individu, jumlah in pesanan.items())
        print(f"Total harga: Rp {total_harga}")
        pembayaran = int(input("Masukkan jumlah pembayaran: "))
        kembalian = self.hitung_pembayaran_kembalian(total_harga, pembayaran)
        if kembalian < 0:
            print("Uang yang Anda masukkan kurang!")
            return
        else:
            print(f"Kembalian: Rp {kembalian}")
            self.simpan_data_pemesanan(pesanan, lama_sewa, total_harga)
            # Mengurangi stok barang
            for pesanan_alat, pesanan_jumlah in pesanan.items():
                index = self.df_alat[self.df_alat["Daftar Barang"] == pesanan_alat].index[0]
                self.df_alat.at[index, "Stok"] -= pesanan_jumlah
            self.df_alat.to_csv(FILE_ALAT, index=False)
            return kembalian

    def tampilkan_grafik_stok(self):
        fig, ax = plt.subplots()
        ax.bar(self.df_alat["Daftar Barang"], self.df_alat["Stok"])
        ax.set_title("Stok Alat Camping")
        ax.set_xlabel("Nama Alat")
        ax.set_ylabel("Jumlah Stok")
        plt.xticks(rotation=90)
        plt.tight_layout()
        plt.show()

# GUI
class AnakRimbaGUI:
    def __init__(self, root):
        self.root = root
        self.root.title("Anak Rimba - Penyewaan Alat Camping")
        self.ar = AnakRimba()
        self.create_widgets()

    def create_widgets(self):
        self.label = tk.Label(self.root, text="SELAMAT DATANG DI Anak Rimba")
        self.label.pack()

        self.button_pesan = tk.Button(self.root, text="Pesan Alat Camping", command=self.pesan_alat)
        self.button_pesan.pack()

        self.notebook = ttk.Notebook(self.root)
        self.tab_stok = ttk.Frame(self.notebook)
        self.tab_grafik = ttk.Frame(self.notebook)

        self.notebook.add(self.tab_stok, text="Stok Alat Camping")
        self.notebook.add(self.tab_grafik, text="Grafik Stok Alat Camping")
        self.notebook.pack(expand=1, fill="both")

        self.create_stok_tab()
        self.create_grafik_tab()

        self.button_keluar = tk.Button(self.root, text="Keluar", command=self.root.quit)
        self.button_keluar.pack()

    def pesan_alat(self):
        self.ar.pesan_alat()

    def create_stok_tab(self):
        stok_text = tk.Text(self.tab_stok)
        stok_text.pack()
        stok_text.insert(tk.END, self.ar.df_alat.to_string(index=False))

    def create_grafik_tab(self):
        self.ar.tampilkan_grafik_stok()

def main():
    root = tk.Tk()
    app = AnakRimbaGUI(root)
    root.mainloop()

if __name__ == "__main__":
    main()

