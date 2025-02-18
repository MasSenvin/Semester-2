print("Nilai Akhir Mahasiswa ")

NilaiMahasiswa = float(input("Masukan Nilai Anda: "))
print("=====================================")

if NilaiMahasiswa <55 :
    print("E")
elif 56 <=NilaiMahasiswa <= 59:
    print ("D")
elif  60 <= NilaiMahasiswa <=69:
    print("C")
elif 70 <= NilaiMahasiswa <=79:
    print("B")
else:
    print("A")
    