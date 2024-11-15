/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventoryproject.models;

import com.mycompany.inventoryproject.models.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author tsany
 */
public class StokOpname {
    private int barangId;
    private int stokFisik;

    public StokOpname(int barangId, int stokFisik) {
        this.barangId = barangId;
        this.stokFisik = stokFisik;
    }

    public void cocokkanStok() {
        try (Connection conn = DatabaseConnection.Connector.connect()) {
            String query = "SELECT stok FROM barang WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, barangId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int stokSistem = rs.getInt("stok");
                if (stokFisik != stokSistem) {
                    System.out.println("Perbedaan ditemukan! Mengupdate stok...");
                    String updateQuery = "UPDATE barang SET stok = ? WHERE id = ?";
                    PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                    updateStmt.setInt(1, stokFisik);
                    updateStmt.setInt(2, barangId);
                    updateStmt.executeUpdate();
                } else {
                    System.out.println("Stok sesuai.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
