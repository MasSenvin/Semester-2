import tkinter as tk
from tkinter import messagebox
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg

class PersewaanAlatCamping:
    def __init__(self):
        self.jenis_alatnya = {
            "Tenda": 500000,
            "Tali": 30000,
            "Tas Gunung": 30000,
            "Sepatu Gunung": 20000,
            "Senter": 10000
        }
        self.barang = []
        self.hari = {}

    def tambah_alat(self, alat, durasi):
        if alat not in self.barang:
            self.barang.append(alat)
            self.hari[alat] = durasi

    def hitung_total(self):
        if not self.barang:
            return 0
        harga = np.array([self.jenis_alatnya[alat] for alat in self.barang])
        durasi = np.array([self.hari[alat] for alat in self.barang])
        total = np.sum(harga * durasi)
        return total

    def bayar(self, bayar):
        total = self.hitung_total()
        kembalian = bayar - total
        return kembalian

    def daftar_sewa(self):
        if not self.barang:
            return pd.DataFrame()
        daftar_sewa = pd.DataFrame({
            "Alat": self.barang,
            "Durasi": [self.hari[alat] for alat in self.barang],
            "Harga": [self.jenis_alatnya[alat] for alat in self.barang],
            "Total": [self.jenis_alatnya[alat] * self.hari[alat] for alat in self.barang]
        })
        return daftar_sewa

    def tampilkan_grafik(self, frame):
        daftar_sewa = self.daftar_sewa()
        if daftar_sewa.empty:
            return
        
        fig, ax = plt.subplots()
        ax.bar(daftar_sewa["Alat"], daftar_sewa["Total"])
        ax.set_xlabel("Alat")
        ax.set_ylabel("Total")
        ax.set_title("Daftar Sewa")

        canvas = FigureCanvasTkAgg(fig, master=frame)
        canvas.draw()
        canvas.get_tk_widget().pack(fill=tk.BOTH, expand=True)
        
    def reset(self):
        self.barang = []
        self.hari = {}

class GUI:
    def __init__(self, master):
        self.master = master
        self.master.title("Persewaan Alat Camping ANAK RIMBA")
        self.master.geometry("400x500")

        self.persewaan_alat_camping = PersewaanAlatCamping()

        self.create_widgets()

    def create_widgets(self):
        # Label dan Combobox untuk memilih alat
        self.alat_label = tk.Label(self.master, text="<<<<< Pilih Alat >>>>>")
        self.alat_label.pack()
        
        # Create a list with item names and prices
        self.alat_list = [f"{alat} - Rp {harga:,}" for alat, harga in self.persewaan_alat_camping.jenis_alatnya.items()]
        
        self.alat_combobox = tk.StringVar()
        self.alat_combobox.set("Pilih Alat")
        self.alat_combobox_widget = tk.OptionMenu(self.master, self.alat_combobox, *self.alat_list)
        self.alat_combobox_widget.pack()

        # Label dan Entry untuk durasi persewaan
        self.durasi_label = tk.Label(self.master, text="Durasi Persewaan (hari):")
        self.durasi_label.pack()
        self.durasi_entry = tk.Entry(self.master)
        self.durasi_entry.pack()

        # Button untuk tambah alat
        self.tambah_alat_button = tk.Button(self.master, text="Tambah Alat", command=self.tambah_alat)
        self.tambah_alat_button.pack()

        # Button untuk hitung total
        self.hitung_total_button = tk.Button(self.master, text="Hitung Total", command=self.hitung_total)
        self.hitung_total_button.pack()

        # Label untuk menampilkan total
        self.total_label = tk.Label(self.master, text="Total:")
        self.total_label.pack()
        self.total_text = tk.Text(self.master, height=1, width=20)
        self.total_text.pack()

        # Label dan Entry untuk jumlah bayar
        self.bayar_label = tk.Label(self.master, text="Jumlah Bayar:")
        self.bayar_label.pack()
        self.bayar_entry = tk.Entry(self.master)
        self.bayar_entry.pack()

        # Button untuk bayar
        self.bayar_button = tk.Button(self.master, text="Bayar", command=self.bayar)
        self.bayar_button.pack()

        # Label untuk menampilkan kembalian
        self.kembalian_label = tk.Label(self.master, text="Kembalian:")
        self.kembalian_label.pack()
        self.kembalian_text = tk.Text(self.master, height=1, width=20)
        self.kembalian_text.pack()

        # Button untuk menampilkan daftar sewa
        self.daftar_sewa_button = tk.Button(self.master, text="Tampilkan Daftar Sewa", command=self.tampilkan_daftar_sewa)
        self.daftar_sewa_button.pack()
        
        # Label untuk menampilkan ucapan terima kasih
        self.Ucapan_label = tk.Label(self.master, text="<<<<<Terima kasih sudah sewa ditempat kami>>>>>")
        self.Ucapan_label.pack()
        
        self.reset_button = tk.Button(self.master, text="Reset", command=self.reset)
        self.reset_button.pack()
        

    def tambah_alat(self):
        selected = self.alat_combobox.get()
        alat = selected.split(" - ")[0]  # Extract the name of the item
        try:
            durasi = int(self.durasi_entry.get())
            self.persewaan_alat_camping.tambah_alat(alat, durasi)
            self.durasi_entry.delete(0, tk.END)
        except ValueError:
            messagebox.showerror("Error", "Masukkan durasi yang valid!")

    def hitung_total(self):
        total = self.persewaan_alat_camping.hitung_total()
        self.total_text.delete(1.0, tk.END)
        self.total_text.insert(tk.END, f"Rp {total:,}")

    def bayar(self):
        try:
            bayar = float(self.bayar_entry.get())
            kembalian = self.persewaan_alat_camping.bayar(bayar)
            if kembalian < 0:
                messagebox.showerror("Error", "Jumlah bayar kurang!")
            else:
                self.kembalian_text.delete(1.0, tk.END)
                self.kembalian_text.insert(tk.END, f"Rp {kembalian:,}")
        except ValueError:
            messagebox.showerror("Error", "Masukkan jumlah bayar yang valid!")

    def tampilkan_daftar_sewa(self):
        daftar_sewa = self.persewaan_alat_camping.daftar_sewa()

        daftar_sewa_window = tk.Toplevel(self.master)
        daftar_sewa_window.title("Daftar Sewa")
        daftar_sewa_window.geometry("800x600")

        text_frame = tk.Frame(daftar_sewa_window)
        text_frame.pack(side=tk.TOP, fill=tk.BOTH, expand=True)

        text_widget = tk.Text(text_frame)
        text_widget.pack(fill=tk.BOTH, expand=True)

        formatted_list = "Alat\tDurasi\tHarga\tTotal\n"
        formatted_list += "-"*40 + "\n"
        for index, row in daftar_sewa.iterrows():
            formatted_list += f"{row['Alat']}\t{row['Durasi']}\tRp {row['Harga']:,}\tRp {row['Total']:,}\n"

        text_widget.insert(tk.END, formatted_list)

        # Create a frame for the graph
        graph_frame = tk.Frame(daftar_sewa_window)
        graph_frame.pack(side=tk.BOTTOM, fill=tk.BOTH, expand=True)

        # Display the graph
        self.persewaan_alat_camping.tampilkan_grafik(graph_frame)
        
    def reset(self):
        self.persewaan_alat_camping.reset()
        self.durasi_entry.delete(0, tk.END)
        self.total_text.delete(1.0, tk.END)
        self.bayar_entry.delete(0, tk.END)
        self.kembalian_text.delete(1.0, tk.END)

root = tk.Tk()
gui = GUI(root)
root.mainloop()
