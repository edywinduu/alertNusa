package com.alertnusa.model;

import java.awt.Color;

public class Bencana {
    private String nama;
    private String deskripsiSingkat;
    private String deskripsiPanjang;
    private Color warnaTema;

    // Konstruktor
    public Bencana(String nama, String deskripsiSingkat, String deskripsiPanjang, Color warnaTema) {
        this.nama = nama;
        this.deskripsiSingkat = deskripsiSingkat;
        this.deskripsiPanjang = deskripsiPanjang;
        this.warnaTema = warnaTema;
    }

    // Getter
    public String getNama() { return nama; }
    public String getDeskripsiSingkat() { return deskripsiSingkat; }
    public String getDeskripsiPanjang() { return deskripsiPanjang; }
    public Color getWarnaTema() { return warnaTema; }
}