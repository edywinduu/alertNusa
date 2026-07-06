/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.alertnusa.view;
/**
 *
 * @author edy
 */
public class admUserPanel extends javax.swing.JPanel {

    /**
     * Creates new form DashboardPanel
     */
    public admUserPanel() {
        initComponents();
        loadDaftarUser("");
    }
    
    public void loadDaftarUser(String kataKunci) {
        listAkun.removeAll();
        listAkun.setLayout(new javax.swing.BoxLayout(listAkun, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // 1. Logika Query dinamis: Jika kataKunci tidak kosong, pakai WHERE LIKE
        String query = "SELECT id, username, email, role FROM users";
        if (kataKunci != null && !kataKunci.trim().isEmpty()) {
            query += " WHERE username LIKE ? OR email LIKE ?";
        }

        try (java.sql.Connection conn = com.alertnusa.util.DatabaseConnection.getConnection(); java.sql.PreparedStatement ps = conn.prepareStatement(query)) {

            // 2. Jika sedang mencari sesuatu, isi parameter tanda tanya (?) di SQL
            if (kataKunci != null && !kataKunci.trim().isEmpty()) {
                String formatCari = "%" + kataKunci + "%";
                ps.setString(1, formatCari);
                ps.setString(2, formatCari);
            }

            try (java.sql.ResultSet rs = ps.executeQuery()) {
                boolean adaData = false;
                while (rs.next()) {
                    adaData = true;
                    int id = rs.getInt("id");
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    String role = rs.getString("role");

                    com.alertnusa.view.ListUserAdminPanel kartuUser = new com.alertnusa.view.ListUserAdminPanel();
                    kartuUser.lblUsername.setText(username);
                    kartuUser.lblEmail.setText(email);
                    kartuUser.lblRole.setText(role);

                    // Ukuran safe box layout yang sudah pas tadi
                    java.awt.Dimension ukuranTetap = new java.awt.Dimension(400, 95);
                    kartuUser.setPreferredSize(ukuranTetap);
                    kartuUser.setMinimumSize(ukuranTetap);
                    kartuUser.setMaximumSize(ukuranTetap);
                    kartuUser.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

                    // Event Listener Tombol
                    kartuUser.btnUpdatePass.addActionListener(e -> tampilkanFormResetPassword(id, username));
                    kartuUser.btnDelete.addActionListener(e -> {
                        int konfirm = javax.swing.JOptionPane.showConfirmDialog(null, "Hapus akun " + username + "?", "Konfirmasi", javax.swing.JOptionPane.YES_NO_OPTION);
                        if (konfirm == javax.swing.JOptionPane.YES_OPTION) {
                            hapusUser(id);
                        }
                    });

                    listAkun.add(kartuUser);
                    listAkun.add(javax.swing.Box.createVerticalStrut(10));
                }

                // 3. Opsi tambahan: Kalau data yang dicari gak ketemu di DB
                if (!adaData && kataKunci != null && !kataKunci.trim().isEmpty()) {
                    javax.swing.JLabel lblKosong = new javax.swing.JLabel("User '" + kataKunci + "' tidak ditemukan.");
                    lblKosong.setForeground(java.awt.Color.GRAY);
                    lblKosong.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
                    listAkun.add(lblKosong);
                }
            }
        } catch (Exception e) {
            System.err.println("Error load daftar user: " + e.getMessage());
        }

        listAkun.revalidate();
        listAkun.repaint();
    }
    
    private void tampilkanFormTambahUser() {
        // 1. Inisialisasi JDialog Pop-up
        javax.swing.JDialog dialog = new javax.swing.JDialog((java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this), "Tambah User Baru", true);
        dialog.setSize(400, 500);
        dialog.setLocationRelativeTo(this);

        // Panel Utama Latar Belakang (Dark Mode Senada)
        javax.swing.JPanel pnlUtama = new javax.swing.JPanel();
        pnlUtama.setBackground(new java.awt.Color(24, 24, 36)); // Warna gelap dasar AlertNusa
        pnlUtama.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pnlUtama.setLayout(new java.awt.GridLayout(0, 1, 0, 8)); // Menyusun input berbaris ke bawah

        // Font Style Konsisten
        java.awt.Font fontLabel = new java.awt.Font("SansSerif", java.awt.Font.BOLD, 12);
        java.awt.Color warnaTeks = java.awt.Color.WHITE;
        java.awt.Color warnaInputBg = new java.awt.Color(40, 40, 56);

        // 2. Pembuatan Komponen Input GUI
        javax.swing.JLabel lblUsername = new javax.swing.JLabel("Username:");
        lblUsername.setForeground(warnaTeks);
        lblUsername.setFont(fontLabel);
        javax.swing.JTextField txtUsername = new javax.swing.JTextField();
        txtUsername.setBackground(warnaInputBg);
        txtUsername.setForeground(warnaTeks);
        txtUsername.setCaretColor(warnaTeks);

        javax.swing.JLabel lblEmail = new javax.swing.JLabel("Email:");
        lblEmail.setForeground(warnaTeks);
        lblEmail.setFont(fontLabel);
        javax.swing.JTextField txtEmail = new javax.swing.JTextField();
        txtEmail.setBackground(warnaInputBg);
        txtEmail.setForeground(warnaTeks);
        txtEmail.setCaretColor(warnaTeks);

        javax.swing.JLabel lblPassword = new javax.swing.JLabel("Password:");
        lblPassword.setForeground(warnaTeks);
        lblPassword.setFont(fontLabel);
        javax.swing.JPasswordField txtPassword = new javax.swing.JPasswordField();
        txtPassword.setBackground(warnaInputBg);
        txtPassword.setForeground(warnaTeks);
        txtPassword.setCaretColor(warnaTeks);

        javax.swing.JLabel lblPhone = new javax.swing.JLabel("Nomor HP:");
        lblPhone.setForeground(warnaTeks);
        lblPhone.setFont(fontLabel);
        javax.swing.JTextField txtPhone = new javax.swing.JTextField();
        txtPhone.setBackground(warnaInputBg);
        txtPhone.setForeground(warnaTeks);
        txtPhone.setCaretColor(warnaTeks);

        javax.swing.JLabel lblDomicile = new javax.swing.JLabel("Domisili:");
        lblDomicile.setForeground(warnaTeks);
        lblDomicile.setFont(fontLabel);
        javax.swing.JTextField txtDomicile = new javax.swing.JTextField();
        txtDomicile.setBackground(warnaInputBg);
        txtDomicile.setForeground(warnaTeks);
        txtDomicile.setCaretColor(warnaTeks);

        javax.swing.JLabel lblRole = new javax.swing.JLabel("Role Akses:");
        lblRole.setForeground(warnaTeks);
        lblRole.setFont(fontLabel);
        String[] pilihanRole = {"member", "admin"};
        javax.swing.JComboBox<String> cmbRole = new javax.swing.JComboBox<>(pilihanRole);
        cmbRole.setBackground(warnaInputBg);
        cmbRole.setForeground(warnaTeks);

        // 3. Tombol Simpan Modern (Senada dengan tema toska tombol "+ Tambah")
        javax.swing.JButton btnSimpan = new javax.swing.JButton("Simpan User");
        btnSimpan.setBackground(new java.awt.Color(0, 128, 128)); // Warna teal/toska
        btnSimpan.setForeground(warnaTeks);
        btnSimpan.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
        btnSimpan.setFocusPainted(false);

        // 4. Memasukkan Komponen ke Dalam Layout Panel
        pnlUtama.add(lblUsername);
        pnlUtama.add(txtUsername);
        pnlUtama.add(lblEmail);
        pnlUtama.add(txtEmail);
        pnlUtama.add(lblPassword);
        pnlUtama.add(txtPassword);
        pnlUtama.add(lblPhone);
        pnlUtama.add(txtPhone);
        pnlUtama.add(lblDomicile);
        pnlUtama.add(txtDomicile);
        pnlUtama.add(lblRole);
        pnlUtama.add(cmbRole);
        pnlUtama.add(new javax.swing.JLabel("")); // Spacer kosong biar ga terlalu dempet
        pnlUtama.add(btnSimpan);

        // 5. Logika Action Listener Klik Tombol Simpan Ke Database
        btnSimpan.addActionListener(e -> {
            String username = txtUsername.getText().trim();
            String email = txtEmail.getText().trim();
            String password = new String(txtPassword.getPassword()).trim();
            String phone = txtPhone.getText().trim();
            String domicile = txtDomicile.getText().trim();
            String role = cmbRole.getSelectedItem().toString();

            // Validasi form kosong
            if (role.equals("admin")) {
                // Jika role ADMIN: Hanya Username dan Password yang wajib diisi mutlak
                if (username.isEmpty() || password.isEmpty()) {
                    javax.swing.JOptionPane.showMessageDialog(dialog, "Untuk role Admin, Username dan Password wajib diisi!", "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
                    return;
                }
            } else {
                // Jika role MEMBER: Semua kolom input tanpa terkecuali WAJIB diisi
                if (username.isEmpty() || email.isEmpty() || password.isEmpty() || phone.isEmpty() || domicile.isEmpty()) {
                    javax.swing.JOptionPane.showMessageDialog(dialog, "Semua kolom input wajib diisi untuk user biasa!", "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            // Query SQL Insert Data
            String sql = "INSERT INTO users (username, email, password, role, phone_number, domicile) VALUES (?, ?, ?, ?, ?, ?)";

            try (java.sql.Connection conn = com.alertnusa.util.DatabaseConnection.getConnection(); java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, username);
                ps.setString(2, email.isEmpty() ? "" : email);
                ps.setString(3, password);
                ps.setString(4, role);
                ps.setString(5, phone.isEmpty() ? "" : phone);
                ps.setString(6, domicile.isEmpty() ? "" : domicile); 

                int rows = ps.executeUpdate();
                if (rows > 0) {
                    javax.swing.JOptionPane.showMessageDialog(null, "User '" + username + "' berhasil ditambahkan!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    dialog.dispose(); // Tutup form pop-up setelah sukses
                    loadDaftarUser(""); // Refresh list kartu user di halaman admin secara otomatis
                }
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(dialog, "Gagal menambah user: " + ex.getMessage(), "Database Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.add(pnlUtama);
        dialog.setVisible(true);
    }
    
    private void tampilkanFormResetPassword(int idUser, String username) {
        // Membuat JDialog pop-up modal
        javax.swing.JDialog resetDialog = new javax.swing.JDialog((java.awt.Frame) null, "Reset Password - " + username, true);
        resetDialog.setSize(380, 280);
        resetDialog.setLocationRelativeTo(null);
        resetDialog.getContentPane().setBackground(new java.awt.Color(24, 24, 24)); // Background Secondary
        resetDialog.setLayout(new java.awt.BorderLayout(10, 10));

        // Panel Utama Konten [40, 40, 56]
        javax.swing.JPanel pnlUtama = new javax.swing.JPanel();
        pnlUtama.setBackground(new java.awt.Color(40, 40, 56));
        pnlUtama.setLayout(new java.awt.GridLayout(4, 1, 5, 5));
        pnlUtama.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 20, 15, 20));

        // Komponen Input Password Baru
        javax.swing.JLabel lblPassBaru = new javax.swing.JLabel("Password Baru:");
        lblPassBaru.setForeground(java.awt.Color.WHITE);
        javax.swing.JPasswordField txtPassBaru = new javax.swing.JPasswordField();
        txtPassBaru.setBackground(new java.awt.Color(24, 24, 24));
        txtPassBaru.setForeground(java.awt.Color.WHITE);
        txtPassBaru.setCaretColor(java.awt.Color.WHITE);

        // Komponen Input Konfirmasi Password Baru
        javax.swing.JLabel lblKonfirmasi = new javax.swing.JLabel("Konfirmasi Password Baru:");
        lblKonfirmasi.setForeground(java.awt.Color.WHITE);
        javax.swing.JPasswordField txtKonfirmasi = new javax.swing.JPasswordField();
        txtKonfirmasi.setBackground(new java.awt.Color(24, 24, 24));
        txtKonfirmasi.setForeground(java.awt.Color.WHITE);
        txtKonfirmasi.setCaretColor(java.awt.Color.WHITE);

        // Masukkan ke panel utama
        pnlUtama.add(lblPassBaru);
        pnlUtama.add(txtPassBaru);
        pnlUtama.add(lblKonfirmasi);
        pnlUtama.add(txtKonfirmasi);

        // Panel Tombol Aksi (Bawah)
        javax.swing.JPanel pnlTombol = new javax.swing.JPanel();
        pnlTombol.setBackground(new java.awt.Color(24, 24, 24));
        pnlTombol.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 10));

        javax.swing.JButton btnBatal = new javax.swing.JButton("Batal");
        btnBatal.setBackground(new java.awt.Color(40, 40, 56));
        btnBatal.setForeground(java.awt.Color.WHITE);
        btnBatal.addActionListener(e -> resetDialog.dispose());

        javax.swing.JButton btnSimpan = new javax.swing.JButton("Simpan");
        btnSimpan.setBackground(new java.awt.Color(0, 153, 102)); // Warna Hijau Sukses
        btnSimpan.setForeground(java.awt.Color.WHITE);

        // Logika Validasi saat tombol Simpan ditekan
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String passBaru = new String(txtPassBaru.getPassword());
                String konfirmasi = new String(txtKonfirmasi.getPassword());

                // 1. Cek jika kolom masih kosong
                if (passBaru.trim().isEmpty() || konfirmasi.trim().isEmpty()) {
                    javax.swing.JOptionPane.showMessageDialog(resetDialog, "Semua kolom password wajib diisi!", "Peringatan", javax.swing.JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // 2. Cek apakah password cocok dengan konfirmasinya
                if (!passBaru.equals(konfirmasi)) {
                    javax.swing.JOptionPane.showMessageDialog(resetDialog, "Password baru dan Konfirmasi tidak cocok!", "Eror", javax.swing.JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // 3. Jika lolos validasi, tembak ke database
                updatePasswordDatabase(idUser, passBaru, resetDialog);
            }
        });

        pnlTombol.add(btnBatal);
        pnlTombol.add(btnSimpan);

        resetDialog.add(pnlUtama, java.awt.BorderLayout.CENTER);
        resetDialog.add(pnlTombol, java.awt.BorderLayout.SOUTH);
        resetDialog.setVisible(true);
    }

    private void updatePasswordDatabase(int idUser, String passwordBaru, javax.swing.JDialog dialog) {
        String sql = "UPDATE users SET password = ? WHERE id = ?";

        try (java.sql.Connection conn = com.alertnusa.util.DatabaseConnection.getConnection();
             java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

            // Tips: Jika password di enkripsi (misal MD5), ubah query menjadi UPDATE users SET password = MD5(?) ...
            ps.setString(1, passwordBaru);
            ps.setInt(2, idUser);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                javax.swing.JOptionPane.showMessageDialog(null, "Password berhasil diubah!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose(); // Tutup pop-up input password setelah sukses
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(dialog, "Gagal mengubah password ke database: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    private void hapusUser(int idUser) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (java.sql.Connection conn = com.alertnusa.util.DatabaseConnection.getConnection();
             java.sql.PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idUser);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                javax.swing.JOptionPane.showMessageDialog(null, "Akun user berhasil dihapus!", "Sukses", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                loadDaftarUser(""); // Refresh daftar otomatis
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Gagal menghapus user: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        searchBar = new javax.swing.JPanel();
        txtCari = new javax.swing.JTextField();
        ButtonCari = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        jScrollPane1 = new javax.swing.JScrollPane();
        listAkun = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(420, 720));
        setMinimumSize(new java.awt.Dimension(420, 720));
        setPreferredSize(new java.awt.Dimension(420, 720));

        jPanel2.setBackground(new java.awt.Color(24, 24, 24));
        jPanel2.setMaximumSize(new java.awt.Dimension(420, 720));
        jPanel2.setMinimumSize(new java.awt.Dimension(420, 720));
        jPanel2.setPreferredSize(new java.awt.Dimension(420, 720));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(420, 20));

        jLabel1.setFont(new java.awt.Font("Poppins ExtraBold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ALERTNUSA");
        jLabel1.setAlignmentX(0.5F);

        jButton11.setBackground(new java.awt.Color(0, 0, 0));
        jButton11.setFont(new java.awt.Font("Poppins SemiBold", 0, 10)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Kembali");
        jButton11.setAlignmentY(0.0F);
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        jButton11.addActionListener(this::jButton11ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton11)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton11)
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel2.add(jPanel1);
        jPanel2.add(filler1);

        jPanel3.setBackground(new java.awt.Color(40, 40, 56));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel3.setPreferredSize(new java.awt.Dimension(410, 50));
        jPanel3.setLayout(new java.awt.GridLayout(1, 2, 20, 20));

        jLabel2.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Manajemen User");
        jPanel3.add(jLabel2);

        jButton8.setBackground(new java.awt.Color(0, 102, 102));
        jButton8.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("+ Tambah");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(this::jButton8ActionPerformed);
        jPanel3.add(jButton8);

        jPanel2.add(jPanel3);
        jPanel2.add(filler2);

        searchBar.setBackground(new java.awt.Color(40, 40, 56));
        searchBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        searchBar.setMaximumSize(new java.awt.Dimension(410, 50));
        searchBar.setPreferredSize(new java.awt.Dimension(400, 50));
        searchBar.setLayout(new java.awt.BorderLayout(20, 0));
        searchBar.add(txtCari, java.awt.BorderLayout.CENTER);

        ButtonCari.setBackground(new java.awt.Color(0, 102, 102));
        ButtonCari.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        ButtonCari.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCari.setText("Cari");
        ButtonCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonCariMouseClicked(evt);
            }
        });
        ButtonCari.addActionListener(this::ButtonCariActionPerformed);
        searchBar.add(ButtonCari, java.awt.BorderLayout.EAST);

        jPanel2.add(searchBar);
        jPanel2.add(filler3);

        jScrollPane1.setBackground(new java.awt.Color(40, 40, 56));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 450));
        jScrollPane1.setViewportView(null);

        listAkun.setBackground(new java.awt.Color(40, 40, 56));
        listAkun.setLayout(new javax.swing.BoxLayout(listAkun, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(listAkun);

        jPanel2.add(jScrollPane1);

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

    private void ButtonCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonCariActionPerformed

    private void ButtonCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonCariMouseClicked
        String kataKunci = txtCari.getText();

        // Panggil fungsi load dengan mempassing teks pencarian tadi
        loadDaftarUser(kataKunci);        // TODO add your handling code here:
    }//GEN-LAST:event_ButtonCariMouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        tampilkanFormTambahUser();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        java.awt.Window ancestor = javax.swing.SwingUtilities.getWindowAncestor(this);

        // 2. Jika ketemu dan benar itu AdminFrame, langsung suruh panggilLayar menu utama
        if (ancestor instanceof AdminFrame) {
            AdminFrame frameUtama = (AdminFrame) ancestor;

            // Panggil fungsi bawaan abang, arahkan ke nama card menu utama admin (misal: "adminPanel")
            frameUtama.panggilLayar("adminPanel");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCari;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel listAkun;
    private javax.swing.JPanel searchBar;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
