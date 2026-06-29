/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.alertnusa.view;

/**
 *
 * @author edy
 */
public class DisasterCardPanel extends javax.swing.JPanel {

    /**
     * Creates new form DisasterCardPanel
     */
    public DisasterCardPanel() {
        initComponents();
        
    }
    
    private void tampilkanDetailKatalog(String namaBencana) {
        // 1. Cari Frame induk tempat panel kartu ini menempel
        java.awt.Window parentWindow = javax.swing.SwingUtilities.getWindowAncestor(this);
        java.awt.Frame parentFrame = (parentWindow instanceof java.awt.Frame) ? (java.awt.Frame) parentWindow : null;

        // 2. Buat objek JDialog secara langsung lewat kode
        javax.swing.JDialog dialog = new javax.swing.JDialog(parentFrame, "Detail Edukasi: " + namaBencana, true);
        dialog.setSize(450, 500);
        dialog.setLocationRelativeTo(parentFrame);
        dialog.getContentPane().setBackground(new java.awt.Color(33, 37, 41)); // Menyesuaikan tema gelap AlertNusa
        dialog.setLayout(new java.awt.BorderLayout(10, 10));

        // 3. Buat komponen Header Judul Pop-up
        javax.swing.JLabel lblJudul = new javax.swing.JLabel(namaBencana.toUpperCase(), javax.swing.SwingConstants.CENTER);
        lblJudul.setFont(new java.awt.Font("Poppins", java.awt.Font.BOLD, 18));
        lblJudul.setForeground(java.awt.Color.WHITE);
        lblJudul.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 10, 5, 10));
        dialog.add(lblJudul, java.awt.BorderLayout.NORTH);

        // 4. Buat JTabbedPane untuk memisahkan pilar penanggulangan
        javax.swing.JTabbedPane tabbedPane = new javax.swing.JTabbedPane();
        tabbedPane.setFont(new java.awt.Font("Poppins", java.awt.Font.PLAIN, 12));

        // Buat 3 JTextArea pengisi tab (tidak bisa diedit & wrap text otomatis)
        javax.swing.JTextArea txtSebelum = createTextAreaEdukasi();
        javax.swing.JTextArea txtSaat = createTextAreaEdukasi();
        javax.swing.JTextArea txtSetelah = createTextAreaEdukasi();

        tabbedPane.addTab("Sebelum Terjadi", new javax.swing.JScrollPane(txtSebelum));
        tabbedPane.addTab("Saat Terjadi", new javax.swing.JScrollPane(txtSaat));
        tabbedPane.addTab("Setelah Terjadi", new javax.swing.JScrollPane(txtSetelah));

        dialog.add(tabbedPane, java.awt.BorderLayout.CENTER);

        // 5. Buat Tombol Tutup di bagian bawah dialog
        javax.swing.JButton btnTutup = new javax.swing.JButton("Tutup Panduan");
        btnTutup.setBackground(new java.awt.Color(0, 128, 128)); // Warna toska khas AlertNusa
        btnTutup.setForeground(java.awt.Color.WHITE);
        btnTutup.setFocusPainted(false);
        btnTutup.addActionListener(e -> dialog.dispose());

        javax.swing.JPanel panelBawah = new javax.swing.JPanel();
        panelBawah.setOpaque(false);
        panelBawah.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 15, 10));
        panelBawah.add(btnTutup);
        dialog.add(panelBawah, java.awt.BorderLayout.SOUTH);

        // 6. Tarik data penanggulangan secara spesifik dari MySQL berdasarkan nama bencana kartu ini
        String query = "SELECT p.title, p.description FROM preparations p "
                + "INNER JOIN disasters d ON p.disaster_id = d.id "
                + "WHERE d.disaster_name = ?";

        try (java.sql.Connection conn = com.alertnusa.util.DatabaseConnection.getConnection(); java.sql.PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, namaBencana);

            try (java.sql.ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String title = rs.getString("title").toLowerCase();
                    String description = rs.getString("description");

                    if (title.contains("sebelum")) {
                        txtSebelum.setText(description);
                    } else if (title.contains("saat")) {
                        txtSaat.setText(description);
                    } else if (title.contains("setelah")) {
                        txtSetelah.setText(description);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Gagal memuat detail katalog: " + e.getMessage());
        }

        // Munculkan pop-up dialognya
        dialog.setVisible(true);
    }
    
    private javax.swing.JTextArea createTextAreaEdukasi() {
        javax.swing.JTextArea ta = new javax.swing.JTextArea();
        ta.setEditable(false);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setBackground(new java.awt.Color(43, 48, 53));
        ta.setForeground(java.awt.Color.WHITE);
        ta.setFont(new java.awt.Font("Poppins", java.awt.Font.PLAIN, 13));
        ta.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return ta;
    }
    
    public javax.swing.JLabel getLblTitle() {
        return jLabel1;
    }

    public javax.swing.JTextArea getLblDesc() {
        return jTextArea1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();

        setBackground(new java.awt.Color(40, 40, 56));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setMaximumSize(new java.awt.Dimension(32767, 150));
        setMinimumSize(new java.awt.Dimension(10, 150));
        setPreferredSize(new java.awt.Dimension(10, 150));
        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");
        add(jLabel1, java.awt.BorderLayout.NORTH);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(24, 24, 24));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setOpaque(false);
        jTextArea1.setPreferredSize(new java.awt.Dimension(84, 84));
        add(jTextArea1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(40, 40, 56));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButton9.setBackground(new java.awt.Color(0, 102, 102));
        jButton9.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Baca Selengkapnya");
        jButton9.addActionListener(this::jButton9ActionPerformed);
        jPanel1.add(jButton9);

        add(jPanel1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String namaBencanaDinamis = jLabel1.getText().trim();
        tampilkanDetailKatalog(namaBencanaDinamis);
    }//GEN-LAST:event_jButton9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
