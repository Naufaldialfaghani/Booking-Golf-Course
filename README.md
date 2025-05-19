# 🏌️ Golf Course Booking System

Sistem pemesanan lapangan golf berbasis Java yang mendukung berbagai metode pembayaran dan fitur keanggotaan VIP. Proyek ini mencakup pemesanan jadwal, pemrosesan pembayaran (kartu kredit dan transfer bank), serta penanganan menu makanan untuk VIP.

## 📁 Struktur Proyek

```
.
├── BankTransferPayment.java
├── Booking.java
├── CreditCardPayment.java
├── GolfCourse.java
├── Hole.java
├── Main.java
├── MenuItem.java
├── PaymentMethod.java
├── VIPMember.java
```

## 🚀 Fitur Utama

* Pemesanan tee time di lapangan golf
* Pembayaran melalui:

  * Kartu kredit
  * Transfer bank
* Sistem keanggotaan VIP:

  * Akses menu eksklusif
  * Privilege khusus
* Representasi lapangan golf dan lubang (hole)
* Interface `PaymentMethod` untuk mendukung ekstensi metode pembayaran

## 🛠️ Teknologi

* Java Standard Edition (Java SE)
* Berbasis OOP (Object-Oriented Programming)

## 📦 Cara Menjalankan

1. **Kompilasi Semua File Java:**

   ```bash
   javac *.java
   ```

2. **Jalankan Program:**

   ```bash
   java Main
   ```

## 🧩 Penjelasan Kelas

| Kelas                 | Deskripsi                                        |
| --------------------- | ------------------------------------------------ |
| `Main`                | Entry point program                              |
| `GolfCourse`          | Representasi lapangan golf dan lubangnya         |
| `Hole`                | Representasi satu lubang (hole)                  |
| `Booking`             | Mengelola informasi pemesanan dan waktu          |
| `PaymentMethod`       | Interface untuk strategi pembayaran              |
| `CreditCardPayment`   | Implementasi pembayaran via kartu kredit         |
| `BankTransferPayment` | Implementasi pembayaran via transfer bank        |
| `VIPMember`           | Representasi anggota VIP dan fasilitas tambahan  |
| `MenuItem`            | Item makanan/minuman eksklusif untuk anggota VIP |
