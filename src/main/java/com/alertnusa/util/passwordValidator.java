/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alertnusa.util;

/**
 *
 * @author edy
 */
public class passwordValidator {
    public static boolean checker(String pass, int index, int type) {
        // Base Case 1: Jika sudah sampai ujung string dan tidak ketemu
        if (index == pass.length()) {
            return false;
        }

        char c = pass.charAt(index);
        boolean ditemukan = false;

        // Logika pengecekan berdasarkan tipe
        switch (type) {
            case 1: // Cek Angka
                ditemukan = Character.isDigit(c);
                break;
            case 2: // Cek Huruf Besar
                ditemukan = Character.isUpperCase(c);
                break;
            case 3: // Cek Simbol (Non-huruf dan Non-angka)
                ditemukan = !Character.isLetterOrDigit(c);
                break;
        }

        // Base Case 2: Jika karakter saat ini sesuai kriteria
        if (ditemukan) {
            return true;
        }

        // Recursive Step: Cek karakter berikutnya
        return checker(pass, index + 1, type);
    }
}
