package com.alertnusa.view;

public class DashboardFrame extends javax.swing.JFrame {

    public DashboardFrame() {
        initComponents();
        progressBar.setValue(70);
        this.pack();
        this.setLocationRelativeTo(null);
        
        java.util.List<com.alertnusa.model.Bencana> list = com.alertnusa.model.BencanaRepository.getAllBencana();
        
        // 2. Pasang ke label Gempa Bumi (Urutan ke-0)
        // Kita menggunakan tag <html> agar teksnya bisa turun ke baris bawah (word-wrap) jika kepanjangan
        lblDescGempa.setText("<html><p style='width:180px;'>" + list.get(0).getDeskripsiSingkat() + "</p></html>");
        
        // 3. Pasang ke label Tsunami (Urutan ke-1)
        lblDescTsunami.setText("<html><p style='width:180px;'>" + list.get(1).getDeskripsiSingkat() + "</p></html>");
        
        // 4. Pasang ke label Banjir (Urutan ke-2)
        lblDescBanjir.setText("<html><p style='width:180px;'>" + list.get(2).getDeskripsiSingkat() + "</p></html>");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSidebar = new javax.swing.JPanel();
        panelHeader1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        panelMain = new javax.swing.JPanel();
        panelHeader = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        panelContent = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tsunamiPanel = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lblDescTsunami = new javax.swing.JLabel();
        gempaBumiPanel = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        lblDescGempa = new javax.swing.JLabel();
        kebakaranPanel1 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        kebakaranPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        lblDescBanjir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AlertNusa v1.0 - Pusat Informasi Kebencanaan");
        setMinimumSize(new java.awt.Dimension(1000, 650));

        panelSidebar.setBackground(new java.awt.Color(37, 37, 53));
        panelSidebar.setPreferredSize(new java.awt.Dimension(240, 650));

        panelHeader1.setBackground(new java.awt.Color(40, 40, 56));
        panelHeader1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(81, 81, 83)));
        panelHeader1.setPreferredSize(new java.awt.Dimension(760, 80));

        jLabel7.setFont(new java.awt.Font("Poppins Medium", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("AlertNusa v1.0");

        javax.swing.GroupLayout panelHeader1Layout = new javax.swing.GroupLayout(panelHeader1);
        panelHeader1.setLayout(panelHeader1Layout);
        panelHeader1Layout.setHorizontalGroup(
            panelHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeader1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel7)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        panelHeader1Layout.setVerticalGroup(
            panelHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeader1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(17, 17, 17))
        );

        jLabel1.setFont(new java.awt.Font("Poppins ExtraBold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(">");

        jButton1.setBackground(new java.awt.Color(15, 20, 23));
        jButton1.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("<html>INFORMASI BENCANA<br>PANDUAN MITIGASI</html>");
        jButton1.setBorder(null);
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setBackground(new java.awt.Color(15, 20, 23));
        jButton2.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("DASHBOARD");
        jButton2.setBorder(null);
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jLabel2.setFont(new java.awt.Font("Poppins ExtraBold", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("*");

        jButton3.setBackground(new java.awt.Color(15, 20, 23));
        jButton3.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("KATALOG BENCANA");
        jButton3.setBorder(null);
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton4.setBackground(new java.awt.Color(15, 20, 23));
        jButton4.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("CHECKLIST KESIAPAN");
        jButton4.setBorder(null);
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jLabel3.setFont(new java.awt.Font("Poppins ExtraBold", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(">");

        jLabel4.setFont(new java.awt.Font("Poppins ExtraBold", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(">");

        jButton5.setBackground(new java.awt.Color(15, 20, 23));
        jButton5.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 51, 51));
        jButton5.setText("LOGOUT");
        jButton5.setBorder(null);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelSidebarLayout = new javax.swing.GroupLayout(panelSidebar);
        panelSidebar.setLayout(panelSidebarLayout);
        panelSidebarLayout.setHorizontalGroup(
            panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
            .addGroup(panelSidebarLayout.createSequentialGroup()
                .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSidebarLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
                    .addGroup(panelSidebarLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        panelSidebarLayout.setVerticalGroup(
            panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSidebarLayout.createSequentialGroup()
                .addComponent(panelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSidebarLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSidebarLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2)))
                .addGap(40, 40, 40)
                .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(44, 44, 44)
                .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(48, 48, 48)
                .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 512, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        getContentPane().add(panelSidebar, java.awt.BorderLayout.WEST);

        panelMain.setBackground(new java.awt.Color(24, 24, 24));
        panelMain.setLayout(new java.awt.BorderLayout());

        panelHeader.setBackground(new java.awt.Color(40, 40, 56));
        panelHeader.setPreferredSize(new java.awt.Dimension(760, 80));

        jLabel6.setFont(new java.awt.Font("Poppins Light", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Welcome, [User]");

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addContainerGap(679, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(17, 17, 17))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(22, 22, 22))
        );

        panelMain.add(panelHeader, java.awt.BorderLayout.NORTH);

        panelContent.setBackground(new java.awt.Color(24, 24, 24));

        jLabel8.setFont(new java.awt.Font("Poppins Medium", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Selamat Datang di Aplikasi AlertNusa!");

        jLabel9.setFont(new java.awt.Font("Poppins ExtraBold", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DASHBOARD");

        jPanel1.setBackground(new java.awt.Color(40, 40, 56));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 224, 224)));

        jLabel11.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Status Checklist Persiapan:");

        jButton7.setBackground(new java.awt.Color(0, 102, 102));
        jButton7.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("LANJUTKAN CHECKLIST");

        progressBar.setBackground(new java.awt.Color(51, 51, 51));
        progressBar.setForeground(new java.awt.Color(50, 150, 70));
        progressBar.setString("");
        progressBar.setStringPainted(true);

        jLabel16.setFont(new java.awt.Font("Poppins SemiBold", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("[ m / n Siaga Bencana ]");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jButton7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel16)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(37, 37, 37)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Poppins SemiBold", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Katalog Bencana");

        tsunamiPanel.setBackground(new java.awt.Color(40, 40, 56));
        tsunamiPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 224, 224)));

        jButton9.setBackground(new java.awt.Color(0, 102, 102));
        jButton9.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Baca Selengkapnya");
        jButton9.addActionListener(this::jButton9ActionPerformed);

        jLabel13.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tsunami");

        lblDescTsunami.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        lblDescTsunami.setForeground(new java.awt.Color(255, 255, 255));
        lblDescTsunami.setText("Berikut adalah....");

        javax.swing.GroupLayout tsunamiPanelLayout = new javax.swing.GroupLayout(tsunamiPanel);
        tsunamiPanel.setLayout(tsunamiPanelLayout);
        tsunamiPanelLayout.setHorizontalGroup(
            tsunamiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tsunamiPanelLayout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(tsunamiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tsunamiPanelLayout.createSequentialGroup()
                        .addComponent(jButton9)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tsunamiPanelLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(125, 125, 125))))
            .addGroup(tsunamiPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblDescTsunami)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        tsunamiPanelLayout.setVerticalGroup(
            tsunamiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tsunamiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(lblDescTsunami)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addContainerGap())
        );

        gempaBumiPanel.setBackground(new java.awt.Color(40, 40, 56));
        gempaBumiPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 224, 224)));

        jLabel12.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Gempa Bumi");

        jButton8.setBackground(new java.awt.Color(0, 102, 102));
        jButton8.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Baca Selengkapnya");
        jButton8.addActionListener(this::jButton8ActionPerformed);

        lblDescGempa.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        lblDescGempa.setForeground(new java.awt.Color(255, 255, 255));
        lblDescGempa.setText("Berikut adalah....");

        javax.swing.GroupLayout gempaBumiPanelLayout = new javax.swing.GroupLayout(gempaBumiPanel);
        gempaBumiPanel.setLayout(gempaBumiPanelLayout);
        gempaBumiPanelLayout.setHorizontalGroup(
            gempaBumiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gempaBumiPanelLayout.createSequentialGroup()
                .addGroup(gempaBumiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gempaBumiPanelLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jButton8))
                    .addGroup(gempaBumiPanelLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel12))
                    .addGroup(gempaBumiPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblDescGempa)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        gempaBumiPanelLayout.setVerticalGroup(
            gempaBumiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gempaBumiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(lblDescGempa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addContainerGap())
        );

        kebakaranPanel1.setBackground(new java.awt.Color(40, 40, 56));
        kebakaranPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 224, 224)));

        jButton11.setBackground(new java.awt.Color(0, 102, 102));
        jButton11.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("LIHAT BENCANA LAINNYA");
        jButton11.addActionListener(this::jButton11ActionPerformed);

        javax.swing.GroupLayout kebakaranPanel1Layout = new javax.swing.GroupLayout(kebakaranPanel1);
        kebakaranPanel1.setLayout(kebakaranPanel1Layout);
        kebakaranPanel1Layout.setHorizontalGroup(
            kebakaranPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kebakaranPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton11)
                .addGap(62, 62, 62))
        );
        kebakaranPanel1Layout.setVerticalGroup(
            kebakaranPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kebakaranPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton11)
                .addGap(100, 100, 100))
        );

        kebakaranPanel.setBackground(new java.awt.Color(40, 40, 56));
        kebakaranPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(224, 224, 224)));

        jLabel14.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Banjir");

        jButton10.setBackground(new java.awt.Color(0, 102, 102));
        jButton10.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Baca Selengkapnya");
        jButton10.addActionListener(this::jButton10ActionPerformed);

        lblDescBanjir.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        lblDescBanjir.setForeground(new java.awt.Color(255, 255, 255));
        lblDescBanjir.setText("Berikut adalah....");

        javax.swing.GroupLayout kebakaranPanelLayout = new javax.swing.GroupLayout(kebakaranPanel);
        kebakaranPanel.setLayout(kebakaranPanelLayout);
        kebakaranPanelLayout.setHorizontalGroup(
            kebakaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kebakaranPanelLayout.createSequentialGroup()
                .addGroup(kebakaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kebakaranPanelLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jButton10))
                    .addGroup(kebakaranPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDescBanjir))
                    .addGroup(kebakaranPanelLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel14)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kebakaranPanelLayout.setVerticalGroup(
            kebakaranPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kebakaranPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDescBanjir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(jButton10)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelContentLayout = new javax.swing.GroupLayout(panelContent);
        panelContent.setLayout(panelContentLayout);
        panelContentLayout.setHorizontalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentLayout.createSequentialGroup()
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContentLayout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jLabel9))
                    .addGroup(panelContentLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelContentLayout.createSequentialGroup()
                                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(kebakaranPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(gempaBumiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tsunamiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(kebakaranPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(panelContentLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel8))
                    .addGroup(panelContentLayout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabel10)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        panelContentLayout.setVerticalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gempaBumiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tsunamiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kebakaranPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kebakaranPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelMain.add(panelContent, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelMain, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Bencana formBencana = new Bencana();
    formBencana.setLocationRelativeTo(null);
    formBencana.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

    java.util.List<com.alertnusa.model.Bencana> list = com.alertnusa.model.BencanaRepository.getAllBencana();
    
    com.alertnusa.model.Bencana dataGempa = list.get(0);
    
    javax.swing.JOptionPane.showMessageDialog(
        this, 
        dataGempa.getDeskripsiPanjang(), 
        "Detail Informasi: " + dataGempa.getNama(), 
        javax.swing.JOptionPane.INFORMATION_MESSAGE
    );
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
    
    java.util.List<com.alertnusa.model.Bencana> list = com.alertnusa.model.BencanaRepository.getAllBencana();
    
    com.alertnusa.model.Bencana dataGempa = list.get(1);
    
    javax.swing.JOptionPane.showMessageDialog(
        this, 
        dataGempa.getDeskripsiPanjang(), 
        "Detail Informasi: " + dataGempa.getNama(), 
        javax.swing.JOptionPane.INFORMATION_MESSAGE
    );
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
    
    java.util.List<com.alertnusa.model.Bencana> list = com.alertnusa.model.BencanaRepository.getAllBencana();
    
    com.alertnusa.model.Bencana dataGempa = list.get(2);
    
    javax.swing.JOptionPane.showMessageDialog(
        this, 
        dataGempa.getDeskripsiPanjang(), 
        "Detail Informasi: " + dataGempa.getNama(), 
        javax.swing.JOptionPane.INFORMATION_MESSAGE
    );
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        Bencana formBencana = new Bencana();
        formBencana.setLocationRelativeTo(null);
        formBencana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new DashboardFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gempaBumiPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel kebakaranPanel;
    private javax.swing.JPanel kebakaranPanel1;
    private javax.swing.JLabel lblDescBanjir;
    private javax.swing.JLabel lblDescGempa;
    private javax.swing.JLabel lblDescTsunami;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelHeader1;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelSidebar;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JPanel tsunamiPanel;
    // End of variables declaration//GEN-END:variables
}