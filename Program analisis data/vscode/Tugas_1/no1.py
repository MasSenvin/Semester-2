print("Menghitung Luas dan Keliling dari segitiga")
#memasukan sisi dari segitiga
while True :
    Sisi_A = float(input("Masukkan sisi a: "))
    Sisi_B = float(input("Masukkan sisi b: "))
    Sisi_c = float(input("Masukkan sisi b: "))

#Jika ini true maka masuk ke luas dan keliling
    if Sisi_A + Sisi_B > Sisi_c and Sisi_A + Sisi_c > Sisi_B and Sisi_B + Sisi_c > Sisi_A:
        s = Sisi_A + Sisi_B + Sisi_c /2
        luas = (s *(s - Sisi_A)* (s - Sisi_B) * (s - Sisi_c)) ** 5
    
     #keliling
        keliling = Sisi_A + Sisi_B + Sisi_c
    
    # akan mencetak di layar seperti dibawah
        print(" Luas Segitiga: {0} ".format(luas))
        print(" Keliling Segitiga: {0}".format(keliling))
        
        #untuk mengulang untuk menghitung kembali atau tidak 
        ulangi = int(input(" ketik 1 untuk menghitung  kembali / ketik 0 untuk berhenti: "))
        
        if ulangi != 1:
            print("Terima kasih")
            break
# bila tidak sesuai akan mencetak sisi tidak valid
    else:
        print("Sisi tidak Valid")
     
