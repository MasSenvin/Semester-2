print("Menghitung Body cuyy")

BeratBadan = float(input("Masukan berat badan: "));

TinggiBadan = float(input("Masukan tinggi badan: "));

Rumus = BeratBadan / (TinggiBadan **2 )

print ("orang dengan berat{0}kg dan tinggi {1} cm mempunyai BMI {2}".format(BeratBadan, TinggiBadan, Rumus))

print("=============================================")

if Rumus < 18.5:
    print("terlalu kkurus")
elif Rumus >= 18.5 and Rumus <= 25:
    print("Normal")
elif Rumus > 25 and Rumus <=30:
    print("Kelebihan berat badan ")
elif Rumus >30:
    print("Obesitas")
else:
    print("gatau")


 