/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.alertnusa.main;

import com.alertnusa.view.DashboardFrame;

/**
 *
 * @author edy
 */
public class App {
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("Gagal memuat tema Nimbus: " + ex.getMessage());
        }

        // 2. BARU PANGGIL DASHBOARD-NYA
        java.awt.EventQueue.invokeLater(() -> {
            new DashboardFrame().setVisible(true);
        });
    }
}