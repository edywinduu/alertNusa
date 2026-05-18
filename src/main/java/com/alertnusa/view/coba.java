/*
 * AlertNusa v1.0 - Main Frame
 * Styling dark navy theme diterapkan di applyDarkTheme()
 * setelah initComponents() dipanggil — aman untuk NetBeans GUI Builder.
 */
package com.alertnusa.view;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Dhio
 */
public class coba extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
        java.util.logging.Logger.getLogger(coba.class.getName());

    // ============================================================
    //  WARNA - dark navy sesuai screenshot AlertNusa
    // ============================================================
    private static final Color BG_MAIN      = new Color(18,  28,  42);   // background kanan
    private static final Color BG_SIDEBAR   = new Color(22,  35,  52);   // background sidebar
    private static final Color BG_TOPBAR    = new Color(22,  35,  52);   // background topbar
    private static final Color BG_CARD      = new Color(28,  42,  62);   // card / list item
    private static final Color BG_ACTIVE    = new Color(30,  58,  95);   // menu aktif (diklik)
    private static final Color BG_HOVER     = new Color(26,  48,  74);   // menu hover
    private static final Color BORDER_COL   = new Color(38,  58,  82);   // garis border tipis
    private static final Color TEXT_WHITE   = new Color(220, 230, 242);  // teks utama
    private static final Color TEXT_DIM     = new Color(130, 155, 185);  // teks redup
    private static final Color TEXT_WARN    = new Color(255, 200,  80);  // kuning ⚠
    private static final Color LOGOUT_COL   = new Color(210,  80,  70);  // merah logout

    // ============================================================
    //  STATE
    // ============================================================
    private JButton activeMenuBtn = null;   // tombol menu yang sedang aktif
    private CardLayout cardLayout;          // layout panel konten
    private JPanel    cardPanel;            // panel konten yang pakai CardLayout

    // ============================================================
    //  KONSTRUKTOR
    // ============================================================
    public coba() {
        initComponents();       // generated oleh NetBeans — jangan diubah
        applyDarkTheme();       // styling dark navy kita
        buildCardContent();     // isi halaman-halaman konten
        wireMenuButtons();      // hubungkan tombol sidebar ke CardLayout
        setActiveButton(jButton1, "dashboard");
    }

    // ============================================================
    //  GENERATED CODE - jangan edit manual di sini
    // ============================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTopBar = new javax.swing.JPanel();
        lblAppTitle = new javax.swing.JLabel();
        lblUserInfo = new javax.swing.JLabel();
        panelCenter = new javax.swing.JPanel();
        panelSidebar = new javax.swing.JPanel();
        lblMenuUtama = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        kanan = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(18, 28, 42));
        setTitle("AlertNusa v1.0");

        panelTopBar.setBackground(new java.awt.Color(22, 35, 52));
        panelTopBar.setPreferredSize(new java.awt.Dimension(980, 46));
        panelTopBar.setLayout(new java.awt.BorderLayout());

        lblAppTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAppTitle.setForeground(new java.awt.Color(220, 230, 242));
        lblAppTitle.setText("  ⚠  AlertNusa v1.0");
        lblAppTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0));
        panelTopBar.add(lblAppTitle, java.awt.BorderLayout.WEST);

        lblUserInfo.setForeground(new java.awt.Color(130, 155, 185));
        lblUserInfo.setText("● Halo, Us   ···  ");
        lblUserInfo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        panelTopBar.add(lblUserInfo, java.awt.BorderLayout.EAST);

        getContentPane().add(panelTopBar, java.awt.BorderLayout.NORTH);

        panelCenter.setBackground(new java.awt.Color(18, 28, 42));
        panelCenter.setLayout(new java.awt.BorderLayout());

        panelSidebar.setBackground(new java.awt.Color(22, 35, 52));
        panelSidebar.setPreferredSize(new java.awt.Dimension(210, 594));

        lblMenuUtama.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblMenuUtama.setForeground(new java.awt.Color(130, 155, 185));
        lblMenuUtama.setText("  MENU UTAMA");

        jButton1.setText("🏠   Dashboard");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setBackground(new java.awt.Color(22, 35, 52));
        jButton1.setForeground(new java.awt.Color(220, 230, 242));
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 12, 6, 8));
        jButton1.setFocusPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("ℹ   Informasi Bencana");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setBackground(new java.awt.Color(22, 35, 52));
        jButton2.setForeground(new java.awt.Color(130, 155, 185));
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 12, 6, 8));
        jButton2.setFocusPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setText("🗺   Panduan Evakuasi");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setBackground(new java.awt.Color(22, 35, 52));
        jButton3.setForeground(new java.awt.Color(130, 155, 185));
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 12, 6, 8));
        jButton3.setFocusPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton4.setBackground(new java.awt.Color(22, 35, 52));
        jButton4.setForeground(new java.awt.Color(130, 155, 185));
        jButton4.setText("📞   Kontak Darurat");
        jButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 12, 6, 8));
        jButton4.setContentAreaFilled(false);
        jButton4.setFocusPainted(false);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jButton5.setBackground(new java.awt.Color(22, 35, 52));
        jButton5.setForeground(new java.awt.Color(130, 155, 185));
        jButton5.setText("✅   Checklist Kesiapan");
        jButton5.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 12, 6, 8));
        jButton5.setContentAreaFilled(false);
        jButton5.setFocusPainted(false);
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.addActionListener(this::jButton5ActionPerformed);

        jSeparator1.setForeground(new java.awt.Color(38, 58, 82));

        jButton6.setText("🔴   Keluar (Logout)");
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.setForeground(new java.awt.Color(210, 80, 70));
        jButton6.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 12, 6, 8));
        jButton6.setFocusPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(this::jButton6ActionPerformed);

        javax.swing.GroupLayout panelSidebarLayout = new javax.swing.GroupLayout(panelSidebar);
        panelSidebar.setLayout(panelSidebarLayout);
        panelSidebarLayout.setHorizontalGroup(
            panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSidebarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMenuUtama)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelSidebarLayout.setVerticalGroup(
            panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSidebarLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblMenuUtama)
                .addGap(8, 8, 8)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, Short.MAX_VALUE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        panelCenter.add(panelSidebar, java.awt.BorderLayout.WEST);

        kanan.setBackground(new java.awt.Color(18, 28, 42));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(220, 230, 242));
        jLabel3.setText("Halo, Us");
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jSeparator2.setForeground(new java.awt.Color(38, 58, 82));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(220, 230, 242));
        jLabel4.setText("🏠  DASHBOARD");

        jLabel5.setForeground(new java.awt.Color(130, 155, 185));
        jLabel5.setText("Selamat datang di Pusat Informasi Kebencanaan");

        javax.swing.GroupLayout kananLayout = new javax.swing.GroupLayout(kanan);
        kanan.setLayout(kananLayout);
        kananLayout.setHorizontalGroup(
            kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kananLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(168, 168, Short.MAX_VALUE))
        );
        kananLayout.setVerticalGroup(
            kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kananLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addGap(8, 8, 8)
                .addComponent(jLabel5)
                .addContainerGap(Short.MAX_VALUE, Short.MAX_VALUE))
        );

        panelCenter.add(kanan, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelCenter, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // ============================================================
    //  ACTION HANDLERS (tombol sidebar)
    // ============================================================
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setActiveButton(jButton1, "dashboard");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setActiveButton(jButton2, "infoBencana");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setActiveButton(jButton3, "evakuasi");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        setActiveButton(jButton4, "kontak");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        setActiveButton(jButton5, "checklist");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton6ActionPerformed

    // ============================================================
    //  DARK THEME - dipanggil setelah initComponents()
    //  Override warna & font semua komponen GEN
    // ============================================================
    private void applyDarkTheme() {
        // Frame
        setSize(980, 640);
        setMinimumSize(new Dimension(800, 520));
        setLocationRelativeTo(null);
        getContentPane().setBackground(BG_MAIN);

        // TopBar
        panelTopBar.setBackground(BG_TOPBAR);
        panelTopBar.setBorder(new MatteBorder(0, 0, 1, 0, BORDER_COL));
        lblAppTitle.setForeground(TEXT_WHITE);
        lblAppTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        // Warna kuning untuk ⚠ tidak bisa per-karakter di JLabel biasa,
        // jadi kita pakai HTML:
        lblAppTitle.setText("<html><font color='#ffc850'>⚠</font>&nbsp;&nbsp;AlertNusa v1.0</html>");
        lblUserInfo.setForeground(TEXT_DIM);

        // Sidebar
        panelSidebar.setBackground(BG_SIDEBAR);
        panelSidebar.setBorder(new MatteBorder(0, 0, 0, 1, BORDER_COL));
        lblMenuUtama.setForeground(TEXT_DIM);

        // Semua tombol sidebar
        JButton[] menuBtns = {jButton1, jButton2, jButton3, jButton4, jButton5};
        for (JButton btn : menuBtns) {
            styleMenuButton(btn);
        }

        // Tombol logout
        jButton6.setBackground(BG_SIDEBAR);
        jButton6.setForeground(LOGOUT_COL);
        jButton6.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        jButton6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButton6.setOpaque(false);

        // Panel kanan (sebelum CardLayout aktif, ini placeholder)
        kanan.setBackground(BG_MAIN);
        jLabel3.setForeground(TEXT_WHITE);
        jSeparator2.setForeground(BORDER_COL);
        jLabel4.setForeground(TEXT_WHITE);
        jLabel5.setForeground(TEXT_DIM);
    }

    private void styleMenuButton(JButton btn) {
        btn.setBackground(BG_SIDEBAR);
        btn.setForeground(TEXT_DIM);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setOpaque(false);

        btn.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) {
                if (btn != activeMenuBtn) {
                    btn.setBackground(BG_HOVER);
                    btn.setForeground(TEXT_WHITE);
                    btn.setOpaque(true);
                    btn.repaint();
                }
            }
            @Override public void mouseExited(MouseEvent e) {
                if (btn != activeMenuBtn) {
                    btn.setBackground(BG_SIDEBAR);
                    btn.setForeground(TEXT_DIM);
                    btn.setOpaque(false);
                    btn.repaint();
                }
            }
        });
    }

    // ============================================================
    //  CARD CONTENT - semua halaman konten dibangun di sini
    //  dan dipasang ke panel kanan dengan CardLayout
    // ============================================================
    private void buildCardContent() {
        cardLayout = new CardLayout();
        cardPanel  = new JPanel(cardLayout);
        cardPanel.setBackground(BG_MAIN);

        cardPanel.add(buildDashboard(),   "dashboard");
        cardPanel.add(buildInfoBencana(), "infoBencana");
        cardPanel.add(buildEvakuasi(),    "evakuasi");
        cardPanel.add(buildKontak(),      "kontak");
        cardPanel.add(buildChecklist(),   "checklist");

        // Ganti isi panel kanan dengan cardPanel
        kanan.removeAll();
        kanan.setLayout(new BorderLayout());
        kanan.add(cardPanel, BorderLayout.CENTER);
        kanan.revalidate();
    }

    // ---- halaman DASHBOARD ----
    private JPanel buildDashboard() {
        JPanel p = basePage("🏠  DASHBOARD",
            "Selamat datang di Pusat Informasi Kebencanaan");

        JPanel cards = new JPanel(new GridLayout(1, 4, 10, 0));
        cards.setOpaque(false);
        cards.setAlignmentX(Component.LEFT_ALIGNMENT);
        cards.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));

        Object[][] data = {
            {"Gempa",  "3 Aktif", new Color(220, 80,  70)},
            {"Banjir", "2 Aktif", new Color(74, 144, 210)},
            {"Tsunami","0 Aman",  new Color(70, 180, 110)},
            {"Gunung", "1 Aktif", new Color(210,150,  60)},
        };
        for (Object[] d : data)
            cards.add(statusCard((String)d[0], (String)d[1], (Color)d[2]));

        p.add(cards);
        p.add(Box.createVerticalGlue());
        return p;
    }

    // ---- halaman INFO BENCANA ----
    private JPanel buildInfoBencana() {
        JPanel p = basePage("ℹ  INFORMASI BENCANA",
            "Data kejadian bencana terkini di seluruh Indonesia.");
        for (String s : new String[]{
            "Gempa M5.2  —  Cianjur, Jawa Barat  —  2 jam lalu",
            "Banjir bandang  —  Jakarta Barat  —  5 jam lalu",
            "Banjir  —  Bandung Selatan  —  1 hari lalu",
            "Tanah longsor  —  Garut  —  2 hari lalu",
            "Gempa M4.7  —  Lombok  —  3 hari lalu",
        }) p.add(listItem(s));
        p.add(Box.createVerticalGlue());
        return p;
    }

    // ---- halaman PANDUAN EVAKUASI ----
    private JPanel buildEvakuasi() {
        JPanel p = basePage("🗺  PANDUAN EVAKUASI",
            "Rute dan prosedur evakuasi darurat.");
        for (String s : new String[]{
            "Langkah 1  —  Tetap tenang, jangan panik",
            "Langkah 2  —  Ikuti jalur evakuasi yang telah ditandai",
            "Langkah 3  —  Hubungi seluruh anggota keluarga",
            "Langkah 4  —  Pergi ke titik kumpul terdekat",
            "Langkah 5  —  Ikuti arahan petugas BNPB / BPBD",
            "Langkah 6  —  Jangan kembali sebelum ada izin resmi",
        }) p.add(listItem(s));
        p.add(Box.createVerticalGlue());
        return p;
    }

    // ---- halaman KONTAK DARURAT ----
    private JPanel buildKontak() {
        JPanel p = basePage("📞  KONTAK DARURAT",
            "Nomor penting yang bisa dihubungi saat bencana.");
        for (String s : new String[]{
            "BNPB Pusat                  :  117",
            "Basarnas                    :  115",
            "PMI                         :  021-7992325",
            "Polisi                      :  110",
            "Pemadam Kebakaran           :  113",
            "Ambulans / Gawat Darurat    :  118 / 119",
        }) p.add(listItem(s));
        p.add(Box.createVerticalGlue());
        return p;
    }

    // ---- halaman CHECKLIST ----
    private JPanel buildChecklist() {
        JPanel p = basePage("✅  CHECKLIST KESIAPAN",
            "Persiapan yang perlu dilakukan sebelum bencana terjadi.");
        for (String s : new String[]{
            "☐   Siapkan tas darurat (go-bag) dengan kebutuhan 72 jam",
            "☐   Simpan salinan dokumen penting di tempat aman",
            "☐   Pastikan stok air minum minimal untuk 3 hari",
            "☐   Hafalkan jalur dan titik evakuasi terdekat",
            "☐   Simpan nomor darurat di ponsel",
            "☐   Pastikan anggota keluarga tahu rencana darurat",
        }) p.add(listItem(s));
        p.add(Box.createVerticalGlue());
        return p;
    }

    // ============================================================
    //  HELPER: basePage — header konten
    // ============================================================
    private JPanel basePage(String title, String subtitle) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(BG_MAIN);
        p.setBorder(new EmptyBorder(24, 28, 24, 28));

        JLabel t = new JLabel(title);
        t.setForeground(TEXT_WHITE);
        t.setFont(new Font("Segoe UI", Font.BOLD, 16));
        t.setAlignmentX(Component.LEFT_ALIGNMENT);
        p.add(t);

        JLabel s = new JLabel(subtitle);
        s.setForeground(TEXT_DIM);
        s.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        s.setAlignmentX(Component.LEFT_ALIGNMENT);
        p.add(s);

        p.add(Box.createVerticalStrut(12));

        JSeparator sep = new JSeparator();
        sep.setForeground(BORDER_COL);
        sep.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        sep.setAlignmentX(Component.LEFT_ALIGNMENT);
        p.add(sep);
        p.add(Box.createVerticalStrut(16));
        return p;
    }

    // ============================================================
    //  HELPER: listItem — baris konten gelap
    // ============================================================
    private JPanel listItem(String text) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(BG_CARD);
        card.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 46));
        card.setBorder(new CompoundBorder(
            new MatteBorder(0, 0, 1, 0, BORDER_COL),
            new EmptyBorder(10, 16, 10, 16)
        ));
        JLabel lbl = new JLabel(text);
        lbl.setForeground(TEXT_WHITE);
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        card.add(lbl, BorderLayout.WEST);

        card.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) { card.setBackground(BG_HOVER); }
            @Override public void mouseExited(MouseEvent e)  { card.setBackground(BG_CARD);  }
        });
        return card;
    }

    // ============================================================
    //  HELPER: statusCard — kartu ringkasan di dashboard
    // ============================================================
    private JPanel statusCard(String title, String value, Color valueColor) {
        JPanel c = new JPanel();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        c.setBackground(BG_CARD);
        c.setBorder(new CompoundBorder(
            new LineBorder(BORDER_COL, 1, true),
            new EmptyBorder(14, 16, 14, 16)
        ));
        JLabel t = new JLabel(title);
        t.setForeground(TEXT_DIM);
        t.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        JLabel v = new JLabel(value);
        v.setForeground(valueColor);
        v.setFont(new Font("Segoe UI", Font.BOLD, 17));
        c.add(t);
        c.add(Box.createVerticalStrut(6));
        c.add(v);
        return c;
    }

    // ============================================================
    //  HELPER: wireMenuButtons — tambah hover listener
    // ============================================================
    private void wireMenuButtons() {
        // Hover sudah di-attach di applyDarkTheme() → styleMenuButton()
        // Method ini ada untuk kemudahan extend ke depannya
    }

    // ============================================================
    //  HELPER: setActiveButton — highlight menu aktif + ganti halaman
    // ============================================================
    private void setActiveButton(JButton btn, String cardKey) {
        // Reset tombol sebelumnya
        if (activeMenuBtn != null) {
            activeMenuBtn.setBackground(BG_SIDEBAR);
            activeMenuBtn.setForeground(TEXT_DIM);
            activeMenuBtn.setOpaque(false);
            activeMenuBtn.repaint();
        }
        // Aktifkan tombol baru
        activeMenuBtn = btn;
        btn.setBackground(BG_ACTIVE);
        btn.setForeground(TEXT_WHITE);
        btn.setOpaque(true);
        btn.repaint();

        // Ganti halaman konten
        if (cardLayout != null && cardPanel != null) {
            cardLayout.show(cardPanel, cardKey);
        }
    }

    // ============================================================
    //  MAIN
    // ============================================================
    public static void main(String args[]) {
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        try {
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new coba().setVisible(true));
    }

    // ============================================================
    //  VARIABLES DECLARATION — jangan diubah manual
    // ============================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel kanan;
    private javax.swing.JLabel lblAppTitle;
    private javax.swing.JLabel lblMenuUtama;
    private javax.swing.JLabel lblUserInfo;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelSidebar;
    private javax.swing.JPanel panelTopBar;
    // End of variables declaration//GEN-END:variables
}
