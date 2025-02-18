print("Menghitung Keliling Lingkaran")# mencetak di layar
import math # mengimport math untuk mengitung kelilingnya dari lingkaran 
while True:
    # meminta inputan dari user melalui keyboard
    jari = float(input("Masukkan Jari Jari: "))
    
    # jika ini true akan melanjutkan ke keliling 
    if jari > 0:
        keliling = 2 * math.pi * jari
        # mencetak ke layar
        print("Keliling Lingkarannya: {0}".format(keliling))
        #untuk mengulang untuk menghitung kembali atau tidak 
        ulangi = int(input(" ketik 1 untuk menghitung  kembali / ketik 0 untuk berhenti: "))
        
        if ulangi != 1:
            print("Terima kasih")
            break
        # bila tidak sesuai akan mencetak sisi tidak valid     
    else:
        print("Masukkan Jari jari dengan benar ")
        
    
    
    