/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemtransaksilaundrykiloan2;

/**
 *
 * @author LENOVO
 */
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import model.CuciKering;
import model.CuciSetrika;
import model.LayananLaundry;

public class Main {

    private static final String NAMA_USAHA = "LAUNDRY KILOAN BERSIH";
    private static final int LEBAR_NOTA = 44;

    private static final Locale LOCALE_ID = Locale.forLanguageTag("id-ID");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean ulangi = true;

        while (ulangi) {
            tampilkanMenu();

            String nama = bacaNama(scanner);
            int pilihan = bacaPilihanLayanan(scanner);
            double berat = bacaBerat(scanner);
            double diskon = bacaDiskon(scanner);

            LayananLaundry layanan;
            if (pilihan == 1) {
                layanan = new CuciKering(nama, berat);
            } else {
                layanan = new CuciSetrika(nama, berat);
            }

            cetakNota(layanan, diskon);

            System.out.print("\nTransaksi baru? (y/n): ");
            ulangi = scanner.nextLine().trim().equalsIgnoreCase("y");
            System.out.println();
        }

        System.out.println("Terima kasih telah menggunakan sistem ini.");
        scanner.close();
    }

    private static void tampilkanMenu() {
        System.out.println("=".repeat(LEBAR_NOTA));
        System.out.println(tengah(NAMA_USAHA));
        System.out.println(tengah("SISTEM TRANSAKSI LAUNDRY"));
        System.out.println("=".repeat(LEBAR_NOTA));
        System.out.println("Pilihan Layanan:");
        System.out.println("  1. Cuci Kering  - " + formatRupiah(6000) + "/kg");
        System.out.println("  2. Cuci Setrika - " + formatRupiah(9000) + "/kg");
        System.out.println("-".repeat(LEBAR_NOTA));
    }

    private static String bacaNama(Scanner scanner) {
        while (true) {
            System.out.print("Nama Pelanggan   : ");
            String nama = scanner.nextLine().trim();
            if (!nama.isEmpty()) {
                return nama;
            }
            System.out.println("  ! Nama tidak boleh kosong.");
        }
    }

    private static int bacaPilihanLayanan(Scanner scanner) {
        while (true) {
            System.out.print("Pilih Layanan (1/2): ");
            String input = scanner.nextLine().trim();
            if (input.equals("1") || input.equals("2")) {
                return Integer.parseInt(input);
            }
            System.out.println("  ! Pilihan tidak valid, masukkan 1 atau 2.");
        }
    }

    private static double bacaBerat(Scanner scanner) {
        while (true) {
            System.out.print("Berat Laundry (kg): ");
            String input = scanner.nextLine().trim().replace(',', '.');
            try {
                double berat = Double.parseDouble(input);
                if (berat > 0) {
                    return berat;
                }
                System.out.println("  ! Berat harus lebih dari 0.");
            } catch (NumberFormatException e) {
                System.out.println("  ! Masukkan angka yang valid, contoh: 2.5");
            }
        }
    }

    private static double bacaDiskon(Scanner scanner) {
        while (true) {
            System.out.print("Diskon % (kosongkan jika tidak ada): ");
            String input = scanner.nextLine().trim().replace(',', '.');
            if (input.isEmpty()) {
                return 0;
            }
            try {
                double diskon = Double.parseDouble(input);
                if (diskon >= 0 && diskon <= 100) {
                    return diskon;
                }
                System.out.println("  ! Diskon harus di antara 0 sampai 100.");
            } catch (NumberFormatException e) {
                System.out.println("  ! Masukkan angka yang valid, contoh: 10");
            }
        }
    }

    private static void cetakNota(LayananLaundry layanan, double diskonPersen) {
        String tanggal = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));

        System.out.println();
        System.out.println("=".repeat(LEBAR_NOTA));
        System.out.println(tengah(NAMA_USAHA));
        System.out.println(tengah("NOTA TRANSAKSI"));
        System.out.println("=".repeat(LEBAR_NOTA));
        cetakBaris("Tanggal", tanggal);
        cetakBaris("Pelanggan", layanan.getNamaPelanggan());
        System.out.println("-".repeat(LEBAR_NOTA));
        cetakBaris("Layanan", layanan.getJenisLayanan());
        cetakBaris("Berat", formatBerat(layanan.getBeratKg()) + " kg");
        cetakBaris("Harga per kg", formatRupiah(layanan.getHargaPerKg()));
        System.out.println("-".repeat(LEBAR_NOTA));

        double total;
        if (diskonPersen > 0) {
            cetakBaris("Diskon", formatBerat(diskonPersen) + "%");
            total = layanan.hitungTotalBayar(diskonPersen);
        } else {
            total = layanan.hitungTotalBayar();
        }
        cetakBaris("TOTAL BAYAR", formatRupiah(total));
        System.out.println("=".repeat(LEBAR_NOTA));
        System.out.println(tengah("Terima kasih atas kepercayaan Anda!"));
        System.out.println("=".repeat(LEBAR_NOTA));
    }

    private static void cetakBaris(String label, String nilai) {
        System.out.printf("%-14s: %s%n", label, nilai);
    }

    private static String tengah(String teks) {
        int spasi = Math.max(0, (LEBAR_NOTA - teks.length()) / 2);
        return " ".repeat(spasi) + teks;
    }

    private static String formatRupiah(double nilai) {
        NumberFormat nf = NumberFormat.getIntegerInstance(LOCALE_ID);
        return "Rp" + nf.format(Math.round(nilai));
    }

    private static String formatBerat(double berat) {
        NumberFormat nf = NumberFormat.getNumberInstance(LOCALE_ID);
        nf.setMaximumFractionDigits(2);
        return nf.format(berat);
    }
}
