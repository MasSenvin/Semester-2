def Karyawan(nama, Gaji= 9000):
    print("Nama Karyawan: ",nama)
    print("Gaji Karyawan: ",Gaji)
    
Nama = str(input("Masukan Nama Karyawan: "))
gaji = input("Masukan Gaji Karyawan(JIka tidak diisi akan diisi dengan 9000)")

if gaji :
    Karyawan(Nama, int(gaji))
else :
    Karyawan(Nama)
    
    
    
    
    



