# UTS PBO — Sistem Transaksi Laundry Kiloan

> Nama : Awang Rifky Muhadzib NIM : 2509116059

## Deskripsi Proyek

Program ini adalah aplikasi konsol (CLI) berbahasa Java untuk mencatat transaksi laundry kiloan. Kasir memilih jenis layanan, memasukkan nama pelanggan dan berat cucian, lalu program menghitung total bayar dan mencetak nota di terminal.

Ada dua jenis layanan:

| Layanan | Tarif |
|---|---|
| Cuci Kering | Rp6.000 / kg |
| Cuci Setrika | Rp9.000 / kg |

**Struktur file:**

<img width="415" height="182" alt="image" src="https://github.com/user-attachments/assets/7274ec1e-7713-4875-a896-4388a341457b" />

### Penerapan Konsep OOP

**1. Inheritance (2 tipe)**
`CuciKering` dan `CuciSetrika` mewarisi `LayananLaundry` lewat `extends`, sehingga keduanya memakai atribut dan method yang sama tanpa menulis ulang.

</p>
<img width="493" height="30" alt="image" src="https://github.com/user-attachments/assets/70515c77-06a5-4c09-beda-d6e53e36e9fc" />
</p>

</p>
<img width="507" height="25" alt="image" src="https://github.com/user-attachments/assets/e269958b-845a-4aa1-abb4-238785453c6b" />
</p>

**2. Polymorphism (Method Overriding dan Method Overloading)**

*Overriding:* kedua subclass mengganti method `getJenisLayanan()` dari superclass agar nota menampilkan nama layanan yang sesuai.

</p>
<img width="343" height="70" alt="image" src="https://github.com/user-attachments/assets/144fe35e-fc67-4244-97e7-954acd462b85" />
</p>

</p>
<img width="338" height="66" alt="image" src="https://github.com/user-attachments/assets/56490f98-0c04-4054-b388-d1614e6a6560" />
</p>

Variabel bertipe superclass bisa menampung objek dari subclass mana pun:

</p>
<img width="441" height="135" alt="image" src="https://github.com/user-attachments/assets/fc17dfba-2407-4cba-9eac-81f0757a2d3e" />
</p>

*Overloading:* `LayananLaundry` punya dua method bernama sama, `hitungTotalBayar()`, tetapi parameternya berbeda. Versi tanpa parameter menghitung total biasa, versi dengan parameter `diskonPersen` menghitung total setelah dipotong diskon.

</p>
<img width="647" height="207" alt="image" src="https://github.com/user-attachments/assets/2959e0c7-8ba1-435b-832b-d762f2386d2d" />
</p>

Java memilih method yang dipanggil berdasarkan jumlah dan tipe parameternya:

</p>
<img width="765" height="657" alt="image" src="https://github.com/user-attachments/assets/1244632d-886d-472f-968d-a67349e5b70e" />
</p>

**3. Condition (if-else)**
Dipakai untuk memvalidasi input, contoh pada pembacaan berat:

</p>
<img width="522" height="106" alt="image" src="https://github.com/user-attachments/assets/8ddad042-38ef-492a-a4cc-ad9f10cddc73" />
</p>

**4. Looping**
`while` dipakai di dua tempat: mengulang transaksi selama pengguna menjawab "y", dan mengulang permintaan input sampai datanya valid.

</p>
<img width="232" height="63" alt="image" src="https://github.com/user-attachments/assets/0fa693fc-e365-44e9-8a01-577c45f477bc" />
</p>

## Alur Program

1. Program menampilkan menu dan dua pilihan layanan beserta tarifnya.
2. Pengguna mengetik nama pelanggan. Jika kosong, program meminta ulang.
3. Pengguna memilih layanan (1 atau 2). Jika input selain itu, program meminta ulang.
4. Pengguna mengetik berat cucian dalam kg. Jika bukan angka atau kurang dari atau sama dengan 0, program meminta ulang.
5. Pengguna mengetik persen diskon, atau dikosongkan jika tidak ada. Jika diisi tapi bukan angka 0-100, program meminta ulang.
6. Program membuat objek `CuciKering` atau `CuciSetrika` sesuai pilihan. Jika diskon lebih dari 0, program memanggil `hitungTotalBayar(diskonPersen)`; jika tidak, memanggil `hitungTotalBayar()`.
7. Program mencetak nota: tanggal, nama pelanggan, jenis layanan, berat, harga per kg, diskon (jika ada), dan total bayar.
8. Program menanyakan apakah ingin transaksi baru. Jika "y", ulangi dari langkah 1. Jika bukan, program berhenti.

## Penjelasan Gambar

**Gambar 1 — Menu dan input pengguna**

</p>
<img width="450" height="276" alt="image" src="https://github.com/user-attachments/assets/c4290625-c684-42b0-a96e-e838a6042057" />
</p>

Program menampilkan dua pilihan layanan beserta tarifnya, kemudian meminta nama pelanggan, nomor layanan, dan berat cucian.

**Gambar 2 — Nota Cuci Kering**

</p>
<img width="453" height="357" alt="image" src="https://github.com/user-attachments/assets/6abe5c01-1153-4579-a426-3fba304605e7" />
</p>

Hasil transaksi saat pengguna memilih layanan Cuci Kering. Total bayar dihitung dari berat dikali Rp6.000.

**Gambar 3 — Nota Cuci Setrika**

</p>
<img width="447" height="330" alt="image" src="https://github.com/user-attachments/assets/b1d69f1e-6e0e-46cc-b09e-aab075d21ed9" />
</p>

Hasil transaksi saat pengguna memilih layanan Cuci Setrika. Total bayar dihitung dari berat dikali Rp9.000.

**Gambar 4 — Validasi input salah**

</p>
<img width="451" height="310" alt="image" src="https://github.com/user-attachments/assets/116ef124-cca0-4627-aca9-79097da95687" />
</p>

Program menolak input yang tidak valid, misalnya pilihan layanan selain 1 atau 2, atau berat yang bukan angka, lalu meminta pengguna mengetik ulang.
