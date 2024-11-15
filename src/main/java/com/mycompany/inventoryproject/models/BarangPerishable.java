/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventoryproject.models;

/**
 *
 * @author tsany
 */
public class BarangPerishable extends Barang {
    private String tanggalKadaluarsa;

    public BarangPerishable(int id, String nama, int stok, double harga, String tanggalKadaluarsa) {
        super(id, nama, stok, harga);
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    @Override
    public String getDetail() {
        return super.getDetail() + ", Kadaluarsa: " + tanggalKadaluarsa;
    }
}
