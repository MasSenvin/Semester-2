
# class membuat metod nama umur dan self
class Person:
    def __init__(self, nama, umur):
        self.name = nama
        self.age = umur
# metod tampil untuk nama umur
    def tampil(self):
        print(f"Name: {self.nama}, Umur: {self.umur}")
# class membuat metod dari metod person
class murid(Person):
    def __init__(self, nama, umur, seleksi):
        super().__init__(nama, umur)
        self.section = seleksi
# metod tampil dari self 
    def TampilMurid(self):
        print(f"Nama: {self.name}, Umur: {self.age}, Seleksi: {self.section}")
        
# Membuat objek dari murid
student1 = murid("kepin", 20, "A")

# menampilkan metod TampilMurid
student1.TampilMurid()