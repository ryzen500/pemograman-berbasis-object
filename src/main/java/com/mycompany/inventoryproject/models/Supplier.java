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
public class Supplier extends BaseEntity implements CrudOperations {
    private int id;
    private String nama;
    private String alamat;

    public Supplier(int id, String nama, String alamat) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
    }

    public Supplier() {}


       public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDetail() {
        return "ID: " + id + ", Nama: " + nama + ", Alamat: " + alamat;
    }

    @Override
    public void create() {
        try (Connection conn = DatabaseConnection.Connector.connect()) {
            String query = "INSERT INTO supplier (nama, alamat) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nama);
            stmt.setString(2, alamat);
            stmt.executeUpdate();
            System.out.println("Supplier berhasil ditambahkan.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void read() {
        try (Connection conn = DatabaseConnection.Connector.connect()) {
            String query = "SELECT * FROM supplier";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                        ", Nama: " + rs.getString("nama") +
                        ", Alamat: " + rs.getString("alamat")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        try (Connection conn = DatabaseConnection.Connector.connect()) {
            String query = "UPDATE supplier SET nama = ?, alamat = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nama);
            stmt.setString(2, alamat);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            System.out.println("Supplier berhasil diperbarui.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        try (Connection conn = DatabaseConnection.Connector.connect()) {
            String query = "DELETE FROM supplier WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Supplier berhasil dihapus.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
