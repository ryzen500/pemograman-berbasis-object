/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventoryproject.models;

/**
 *
 * @author tsany
 */

import com.mycompany.inventoryproject.models.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transaksi {
    private int id;
    private String jenisTransaksi; // "Pembelian" atau "Penjualan"
    private int barangId;
    private int jumlah;
    private double totalHarga;

    // Getters dan Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }

    public int getBarangId() {
        return barangId;
    }

    public void setBarangId(int barangId) {
        this.barangId = barangId;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

  public void create() {
    if (jenisTransaksi == null || barangId <= 0 || jumlah <= 0 || totalHarga <= 0) {
        System.err.println("Input data transaksi tidak valid.");
        return;
    }

    String sql = "INSERT INTO transaksi (jenis_transaksi, barang_id, jumlah, total_harga) VALUES (?, ?, ?, ?)";
    try (Connection conn = DatabaseConnection.Connector.connect();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, jenisTransaksi);
        stmt.setInt(2, barangId);
        stmt.setInt(3, jumlah);
        stmt.setDouble(4, totalHarga);

        int affectedRows = stmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Transaksi berhasil ditambahkan.");
        } else {
            System.out.println("Gagal menambahkan transaksi.");
        }
    } catch (SQLException | ClassNotFoundException e) {
        System.err.println("Error saat menambahkan transaksi: " + e.getMessage());
        e.printStackTrace();
    } catch (Exception e) {
        System.err.println("Unexpected error: " + e.getMessage());
        e.printStackTrace();
    }
}

public void read() {
    String sql = "SELECT t.id, t.jenis_transaksi, b.nama AS barang, t.jumlah, t.total_harga " +
                 "FROM transaksi t LEFT JOIN barang b ON t.barang_id = b.id";
    try (Connection conn = DatabaseConnection.Connector.connect();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        System.out.println("\n=== Daftar Transaksi ===");
        System.out.printf("%-5s %-12s %-20s %-8s %-12s\n", "ID", "Jenis", "Barang", "Jumlah", "Total");
        while (rs.next()) {
            System.out.printf("%-5d %-12s %-20s %-8d %-12.2f\n",
                    rs.getInt("id"),
                    rs.getString("jenis_transaksi"),
                    rs.getString("barang"),
                    rs.getInt("jumlah"),
                    rs.getDouble("total_harga"));
        }
    } catch (SQLException e) {
        System.err.println("Error saat membaca transaksi: " + e.getMessage());
        e.printStackTrace();
    } catch (Exception e) {
        System.err.println("Unexpected error: " + e.getMessage());
        e.printStackTrace();
    }
}

public void delete() {
    if (id <= 0) {
        System.err.println("ID transaksi tidak valid.");
        return;
    }

    String sql = "DELETE FROM transaksi WHERE id = ?";
    try (Connection conn = DatabaseConnection.Connector.connect();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        int affectedRows = stmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Transaksi berhasil dihapus.");
        } else {
            System.out.println("Gagal menghapus transaksi. ID mungkin tidak ditemukan.");
        }
    } catch (SQLException | ClassNotFoundException e) {
        System.err.println("Error saat menghapus transaksi: " + e.getMessage());
        e.printStackTrace();
    } catch (Exception e) {
        System.err.println("Unexpected error: " + e.getMessage());
        e.printStackTrace();
    }
}

}
