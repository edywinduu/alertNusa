/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.alertnusa.view;
/**
 *
 * @author edy
 */

public class admBencanaPanel extends javax.swing.JPanel {
    private void tampilkanDetailWindow(String judul, String isiDeskripsi) {
        javax.swing.JDialog detailFrame = new javax.swing.JDialog((java.awt.Frame) null, "Detail Bencana", true);
        detailFrame.setSize(400, 450);
        detailFrame.setLocationRelativeTo(null);
        detailFrame.getContentPane().setBackground(new java.awt.Color(24, 24, 24)); // Background Secondary
        detailFrame.setLayout(new java.awt.BorderLayout(15, 15));

        // Panel Konten Utama (Warna Utama [40, 40, 56])
        javax.swing.JPanel pnlKonten = new javax.swing.JPanel();
        pnlKonten.setBackground(new java.awt.Color(40, 40, 56));
        pnlKonten.setLayout(new java.awt.BorderLayout(10, 10));
        pnlKonten.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Label Judul Bencana
        javax.swing.JLabel lblJudul = new javax.swing.JLabel(judul);
        lblJudul.setFont(new java.awt.Font("Poppins", java.awt.Font.BOLD, 18));
        lblJudul.setForeground(java.awt.Color.WHITE);
        pnlKonten.add(lblJudul, java.awt.BorderLayout.NORTH);

        // Area Teks Deskripsi
        javax.swing.JTextArea txtArea = new javax.swing.JTextArea(isiDeskripsi);
        txtArea.setEditable(false);
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        txtArea.setFont(new java.awt.Font("SansSerif", java.awt.Font.PLAIN, 13));
        txtArea.setBackground(new java.awt.Color(24, 24, 24)); // Background isi teks dibuat kontras
        txtArea.setForeground(new java.awt.Color(220, 220, 220));
        txtArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));

        javax.swing.JScrollPane scrollDeskripsi = new javax.swing.JScrollPane(txtArea);
        scrollDeskripsi.setBorder(null);
        pnlKonten.add(scrollDeskripsi, java.awt.BorderLayout.CENTER);

        // Tombol Tutup
        javax.swing.JButton btnTutup = new javax.swing.JButton("Tutup");
        btnTutup.setBackground(new java.awt.Color(24, 24, 24));
        btnTutup.setForeground(java.awt.Color.WHITE);
        btnTutup.setFocusPainted(false);
        btnTutup.addActionListener(e -> detailFrame.dispose());

        detailFrame.add(pnlKonten, java.awt.BorderLayout.CENTER);
        detailFrame.add(btnTutup, java.awt.BorderLayout.SOUTH);

        detailFrame.setVisible(true);
    }
    
    private void hapusDataBencana(int idBencana) {
        String sql = "DELETE FROM disasters WHERE id = ?";
        try (java.sql.Connection conn = com.alertnusa.util.DatabaseConnection.getConnection();
             java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idBencana);
            int hasil = ps.executeUpdate();

            if (hasil > 0) {
                javax.swing.JOptionPane.showMessageDialog(null, "Data bencana berhasil dihapus!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                loadKatalogAdmin(); // Refresh katalog secara otomatis agar datanya hilang dari layar
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Creates new form DashboardPanel
     */
    public admBencanaPanel() {
        initComponents();
    }
    public void loadKatalogAdmin() {
        katalogPanel.removeAll();
        katalogPanel.setLayout(new javax.swing.BoxLayout(katalogPanel, javax.swing.BoxLayout.Y_AXIS));

        // Kunci ukuran scroll pane agar konsisten di lebar 420
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        String query = "SELECT id, name, description FROM disasters";

        try (java.sql.Connection conn = com.alertnusa.util.DatabaseConnection.getConnection();
             java.sql.PreparedStatement ps = conn.prepareStatement(query);
             java.sql.ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("name");
                String deskripsi = rs.getString("description");

                // Instansiasi komponen kartu admin baru
                com.alertnusa.view.ItemBencanaAdminPanel kartu = new com.alertnusa.view.ItemBencanaAdminPanel();

                // Atur teks di dalam komponen kartu (sesuaikan nama label/text area di kartu adminmu)
                // Contoh asumsi: kartu.lblJudul dan kartu.txtDeskripsi
                kartu.lblJudul.setText(nama);

                // Kunci ukuran komponen agar pas dengan batas BoxLayout (Lebar 380 agar muat di area 400)
                java.awt.Dimension ukuranTetap = new java.awt.Dimension(380, 140);
                kartu.setPreferredSize(ukuranTetap);
                kartu.setMinimumSize(ukuranTetap);
                kartu.setMaximumSize(ukuranTetap);
                kartu.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

                // --- EVENT CLICK 1: KLIK KARTU UNTUK DETAIL POP-UP ---
                kartu.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        tampilkanDetailWindow(nama, deskripsi);
                    }
                });

                // --- EVENT CLICK 2: TOMBOL HAPUS DATA ---
                // Sesuaikan 'btnHapus' dengan nama variabel tombol hapus di ItemBencanaAdminPanel-mu
                kartu.btnHapus.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent e) {
                        int konfirmasi = javax.swing.JOptionPane.showConfirmDialog(
                            null, 
                            "Apakah Anda yakin ingin menghapus data bencana '" + nama + "'?", 
                            "Konfirmasi Hapus", 
                            javax.swing.JOptionPane.YES_NO_OPTION,
                            javax.swing.JOptionPane.WARNING_MESSAGE
                        );

                        if (konfirmasi == javax.swing.JOptionPane.YES_OPTION) {
                            hapusDataBencana(id);
                        }
                    }
                });

                katalogPanel.add(kartu);
                katalogPanel.add(javax.swing.Box.createVerticalStrut(12)); // Jarak antar kartu
            }

        } catch (Exception e) {
            System.err.println("Error load katalog admin: " + e.getMessage());
        }

        katalogPanel.revalidate();
        katalogPanel.repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        katalogPanel = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(420, 720));
        setMinimumSize(new java.awt.Dimension(420, 720));

        jPanel2.setBackground(new java.awt.Color(24, 24, 24));
        jPanel2.setMaximumSize(new java.awt.Dimension(420, 720));
        jPanel2.setMinimumSize(new java.awt.Dimension(420, 720));

        jPanel11.setBackground(new java.awt.Color(29, 151, 165));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Poppins ExtraBold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ALERTNUSA");

        jPanel3.setBackground(new java.awt.Color(40, 40, 56));

        jLabel2.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Manajemen Bencana");

        jButton8.setBackground(new java.awt.Color(255, 0, 0));
        jButton8.setFont(new java.awt.Font("Poppins SemiBold", 0, 8)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("+ Tambah");
        jButton8.addActionListener(this::jButton8ActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Poppins SemiBold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Katalog Bencana");

        jScrollPane1.setBackground(new java.awt.Color(40, 40, 56));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(400, 500));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(400, 500));

        katalogPanel.setBackground(new java.awt.Color(40, 40, 56));
        katalogPanel.setLayout(new javax.swing.BoxLayout(katalogPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(katalogPanel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(92, 92, 92))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(97, 97, 97))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel katalogPanel;
    // End of variables declaration//GEN-END:variables
}
