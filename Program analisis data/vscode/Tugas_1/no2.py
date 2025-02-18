print("Menghitung Luas dan Keliling segi empat")#mencetak di layar
while True :
    # meminta inputan dari user melalui keyboard
    Panjang = float(input("Masukkan panjang: "))
    lebar = float(input("Masukkan lebar: "))
    #jika ini true akan melanjutkan ke luas dan keliling 
    if Panjang > 0 and lebar > 0:
        luas = Panjang * lebar 
        keliling = 2 * (Panjang + lebar)
        # mencetak ke layar 
        print(" Luasnya: {0}".format(luas)) 
        print("Keliling segi empat: {0}".format(keliling))
        
          #untuk mengulang untuk menghitung kembali atau tidak 
        ulangi = int(input(" ketik 1 untuk menghitung  kembali / ketik 0 untuk berhenti: "))
        
        if ulangi != 1:
            print("Terima kasih")
            break
        # bila tidak sesuai akan mencetak sisi tidak valid
    else:
        print("Masukan panjang dan lebar yang benar")       