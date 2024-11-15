/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inventoryproject;

import com.mycompany.inventoryproject.models.Barang;
import com.mycompany.inventoryproject.models.Supplier;

import com.mycompany.inventoryproject.models.Transaksi;
import java.util.Scanner;

/**
 *
 * @author tsany
 */
public class InventoryApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Aplikasi Inventory ===");
            System.out.println("1. Kelola Barang");
            System.out.println("2. Kelola Transaksi");
            System.out.println("3. Kelola Supplier");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Clear newline

            switch (pilihan) {
                case 1:
                    kelolaBarang();
                    break;
                case 2:
                    kelolaTransaksi();
                    break;
                case 3:
                    kelolaSupplier();
                    break;
                case 4:
                    running = false;
                    System.out.println("Keluar dari aplikasi. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }
    }

    private static void kelolaBarang() {
        Barang barang = new Barang();

        System.out.println("\n=== Kelola Barang ===");
        System.out.println("1. Tambah Barang");
        System.out.println("2. Lihat Barang");
        System.out.println("3. Update Barang");
        System.out.println("4. Hapus Barang");
        System.out.print("Pilih menu: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Clear newline

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan Nama Barang: ");
                barang.setNama(scanner.nextLine());
                System.out.print("Masukkan Harga Barang: ");
                barang.setHarga(scanner.nextDouble());
                System.out.print("Masukkan Stok Barang: ");
                barang.setStok(scanner.nextInt());
                barang.create();
                break;
            case 2:
                barang.read();
                break;
            case 3:
                System.out.print("Masukkan ID Barang yang akan diupdate: ");
                barang.setId(scanner.nextInt());
                scanner.nextLine(); // Clear newline
                System.out.print("Masukkan Nama Barang Baru: ");
                barang.setNama(scanner.nextLine());
                System.out.print("Masukkan Harga Barang Baru: ");
                barang.setHarga(scanner.nextDouble());
                System.out.print("Masukkan Stok Barang Baru: ");
                barang.setStok(scanner.nextInt());
                barang.update();
                break;
            case 4:
                System.out.print("Masukkan ID Barang yang akan dihapus: ");
                barang.setId(scanner.nextInt());
                barang.delete();
                break;
            default:
                System.out.println("Pilihan tidak valid, kembali ke menu utama.");
        }
    }

    private static void kelolaTransaksi() {
        Transaksi transaksi = new Transaksi();

        System.out.println("\n=== Kelola Transaksi ===");
        System.out.println("1. Tambah Transaksi");
        System.out.println("2. Lihat Transaksi");
        System.out.println("3. Hapus Transaksi");
        System.out.print("Pilih menu: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Clear newline

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan Jenis Transaksi (Pembelian/Penjualan): ");
                transaksi.setJenisTransaksi(scanner.nextLine());
                System.out.print("Masukkan ID Barang: ");
                transaksi.setBarangId(scanner.nextInt());
                System.out.print("Masukkan Jumlah: ");
                transaksi.setJumlah(scanner.nextInt());
                System.out.print("Masukkan Total Harga: ");
                transaksi.setTotalHarga(scanner.nextDouble());
                transaksi.create();
                break;
            case 2:
                transaksi.read();
                break;
            case 3:
                System.out.print("Masukkan ID Transaksi yang akan dihapus: ");
                transaksi.setId(scanner.nextInt());
                transaksi.delete();
                break;
            default:
                System.out.println("Pilihan tidak valid, kembali ke menu utama.");
        }
    }

    private static void kelolaSupplier() {
        Supplier supplier = new Supplier();

        System.out.println("\n=== Kelola Supplier ===");
        System.out.println("1. Tambah Supplier");
        System.out.println("2. Lihat Supplier");
        System.out.println("3. Update Supplier");
        System.out.println("4. Hapus Supplier");
        System.out.print("Pilih menu: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Clear newline

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan Nama Supplier: ");
                supplier.setNama(scanner.nextLine());
                System.out.print("Masukkan Alamat Supplier: ");
                supplier.setAlamat(scanner.nextLine());
                // System.out.print("Masukkan Kontak Supplier: ");
                // supplier.setKontak(scanner.nextLine());
                supplier.create();
                break;
            case 2:
                supplier.read();
                break;
            case 3:
                System.out.print("Masukkan ID Supplier yang akan diupdate: ");
                supplier.setId(scanner.nextInt());
                scanner.nextLine(); // Clear newline
                System.out.print("Masukkan Nama Supplier Baru: ");
                supplier.setNama(scanner.nextLine());
                System.out.print("Masukkan Alamat Supplier Baru: ");
                supplier.setAlamat(scanner.nextLine());
                // System.out.print("Masukkan Kontak Supplier Baru: ");
                // supplier.setKontak(scanner.nextLine());
                supplier.update();
                break;
            case 4:
                System.out.print("Masukkan ID Supplier yang akan dihapus: ");
                supplier.setId(scanner.nextInt());
                supplier.delete();
                break;
            default:
                System.out.println("Pilihan tidak valid, kembali ke menu utama.");
        }
    }
}
