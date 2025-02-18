from math import pi

class Lingkaran:
    def __init__(self, a, b, r):
        # Inisialisasi lingkaran dengan pusat (a, b) dan radius r
        self.a = a
        self.b = b
        self.r = r

    def keliling(self):
        # Menghitung keliling lingkaran
        return 2 * pi * self.r

    def luas(self):
        # Menghitung luas lingkaran
        return pi * self.r**2

    def formEquation(self, x, y):
        # Formula persamaan lingkaran
        return (x-self.a)**2 + (y-self.b)**2 - self.r**2
    
    def test_belong(self, x, y):
        # Menguji apakah titik berada di dalam lingkaran
        if self.formEquation(x, y) == 0:
            return True
        else:
            return False

# Membuat objek lingkaran
circle1 = Lingkaran(1, 2, 3)

# Menghitung luas dan keliling lingkaran
luas = circle1.luas()
keliling = circle1.keliling()

# Menguji titik-titik apakah berada di dalam atau di luar lingkaran
titik_di_dalam = circle1.test_belong(2, 3)
titik_di_luar = circle1.test_belong(5, 7)

# Menampilkan hasil
print(f"Luas lingkaran1: {luas:.2f}")
print(f"Keliling lingkaran1: {keliling:.2f}")
print(f"Titik (2, 3) di dalam lingkaran1: {titik_di_dalam}")
print(f"Titik (5, 7) di dalam lingkaran1: {titik_di_luar}")
