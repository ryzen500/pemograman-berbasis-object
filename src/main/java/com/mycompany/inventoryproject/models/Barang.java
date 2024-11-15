/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventoryproject.models;

import com.mycompany.inventoryproject.interfaces.CrudOperations;
import com.mycompany.inventoryproject.models.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tsany
 */
public class Barang extends BaseEntity implements CrudOperations {
    private int id;
    private String nama;
    private int stok;
    private double harga;

    public Barang(int id, String nama, int stok, double harga) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public Barang() {}

    public int getId() {
        return id;
    }
       public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getDetail() {
        return "ID: " + id + ", Nama: " + nama + ", Stok: " + stok + ", Harga: " + harga;
    }

    public void create() {
        try (Connection conn = DatabaseConnection.Connector.connect()) {
            String query = "INSERT INTO barang (nama, stok, harga) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nama);
            stmt.setInt(2, stok);
            stmt.setDouble(3, harga);
            stmt.executeUpdate();
            System.out.println("Barang berhasil ditambahkan.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void read() {
        try (Connection conn = DatabaseConnection.Connector.connect()) {
            String query = "SELECT * FROM barang";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                        ", Nama: " + rs.getString("nama") +
                        ", Stok: " + rs.getInt("stok") +
                        ", Harga: " + rs.getDouble("harga")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        try (Connection conn = DatabaseConnection.Connector.connect()) {
            String query = "UPDATE barang SET nama = ?, stok = ?, harga = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nama);
            stmt.setInt(2, stok);
            stmt.setDouble(3, harga);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Barang berhasil diperbarui.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        try (Connection conn = DatabaseConnection.Connector.connect()) {
            String query = "DELETE FROM barang WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Barang berhasil dihapus.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
