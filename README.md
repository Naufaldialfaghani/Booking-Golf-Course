# GolfKacaw Booking App

**GolfKacaw** adalah aplikasi pemesanan lapangan golf berbasis Java yang dilengkapi dengan fitur pemesanan driving range, pemesanan makanan/minuman, dan berbagai metode pembayaran. Aplikasi ini memiliki antarmuka grafis (GUI) berbasis Java Swing.

---

## 📦 Fitur Utama

* 📅 Pemesanan lapangan golf dan driving range
* 🕒 Pemilihan waktu yang tersedia dengan validasi double booking
* 🍽 Pemesanan makanan dan minuman dari menu
* 💳 Metode pembayaran:

  * Transfer Bank
  * Kartu Kredit (dengan validasi dan diskon untuk anggota VIP)
* 🧾 Ringkasan transaksi dan konfirmasi pembayaran
* 🖼 Tampilan GUI modern dengan latar belakang gambar

---

## 🛠 Struktur Kelas

### `MainFrame.java`

* Komponen utama GUI aplikasi.
* Mengelola alur pemesanan melalui berbagai panel (Welcome, Booking, Food, Payment, Confirmation).
* Mendukung logika VIP, pemilihan waktu, dan kalkulasi pembayaran.

### `GolfCourse.java`

* Menyimpan informasi tentang lapangan golf, termasuk hole, harga, dan fasilitas.

### `Booking.java`

* Menangani logika pemesanan, termasuk validasi waktu yang sudah dipesan.

### `Member.java` & `VIPMember.java`

* Representasi pengguna.
* `VIPMember` memiliki diskon otomatis 20%.

### `MenuItem.java`

* Representasi item menu makanan/minuman yang dapat dipesan.

### `PaymentMethod.java` (abstrak)

* Kelas dasar untuk metode pembayaran.

### `BankTransferPayment.java` & `CreditCardPayment.java`

* Implementasi metode pembayaran.

### `BackgroundPanel.java`

* Panel dengan dukungan gambar latar belakang yang responsif.

---

## 🧪 Cara Menjalankan

1. **Pastikan Java JDK telah terinstal.**

2. **Compile semua file Java:**

   ```bash
   javac *.java
   ```

3. **Jalankan aplikasi:**

   ```bash
   java MainFrame
   ```

---

## 🖼 Pratinjau UI

Antarmuka pengguna didesain dengan `CardLayout` dan dilengkapi latar belakang gambar dari internet.

---

## 📌 Catatan Tambahan

* File `Booking.java` menyimpan waktu booking secara global menggunakan `static Set<String>`, sehingga sesi yang baru akan tetap mengingat waktu yang telah dipesan sebelumnya.
* Gambar latar diambil dari URL, pastikan koneksi internet tersedia saat menjalankan GUI.
* Input kartu kredit divalidasi untuk 16 digit nomor, format MM/YY untuk tanggal, dan CVV 3–4 digit.

---

## ✍️ Pengembangan Selanjutnya

* Integrasi penyimpanan data ke file atau database.
* Penjadwalan otomatis dan reminder via email.
* Opsi pembayaran QRIS atau e-wallet.

---

## 👨‍💻 Penulis

Dikembangkan sebagai aplikasi simulasi untuk pemesanan lapangan golf.
