print("Menghitung Luas Jajar Genjang")# mencetak di layar
while True:
       # meminta inputan dari user melalui keyboard
    alas = float(input("Masukan panjang alas: "))
    tinggi = float(input("Masukan panjang tinggi: "))
     #jika ini true akan melanjutkan ke luas
    if alas > 0 and tinggi > 0:
        luas = alas * tinggi
        
        # mencetak ke layar
        print(" Luas Jajar genjang {0}".format(luas))
        #untuk mengulang untuk menghitung kembali atau tidak 
        ulangi = int(input(" ketik 1 untuk menghitung  kembali / ketik 0 untuk berhenti: "))
        
        if ulangi != 1:
            print("Terima kasih")
            break
            
       # bila tidak sesuai akan mencetak sisi tidak valid     
    else:
        print("Masukkan denga benar")
        
    
