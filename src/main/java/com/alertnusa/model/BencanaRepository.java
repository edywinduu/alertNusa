package com.alertnusa.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class BencanaRepository {
    
    public static List<Bencana> getAllBencana() {
        List<Bencana> daftarBencana = new ArrayList<>();
        
        daftarBencana.add(new Bencana(
            "Gempa Bumi", 
            "Panduan keselamatan saat gempa bumi, evakuasi, dan titik kumpul.", 
            "Gempa bumi adalah getaran di permukaan bumi akibat pelepasan energi dari dalam secara tiba-tiba. \n\nLangkah Keselamatan:\n1. Berlindung di bawah meja yang kuat.\n2. Jauhi kaca, jendela, dan lemari.\n3. Jika di luar, jauhi gedung, pohon, dan tiang listrik.\n4. Segera menuju titik kumpul terbuka.",
            new Color(180, 60, 60)
        ));
        
        daftarBencana.add(new Bencana(
            "Tsunami", 
            "Panduan menghadapi ancaman gelombang tsunami di wilayah pesisir.", 
            "Tsunami adalah serangkaian gelombang air laut besar yang dipicu oleh gempa bumi di dasar laut. \n\nLangkah Keselamatan:\n1. Jika air laut surut tiba-tiba setelah gempa, itu tanda tsunami.\n2. Segera lari ke dataran tinggi atau bukit.\n3. Jauhi area pantai dan sungai yang bermuara ke laut.\n4. Tunggu arahan resmi sebelum kembali.",
            new Color(50, 100, 180)
        ));
        
        daftarBencana.add(new Bencana(
            "Banjir", 
            "Panduan keselamatan saat musim hujan dan banjir di pemukiman.", 
            "Banjir terjadi ketika air merendam daratan yang biasanya kering. \n\nLangkah Keselamatan:\n1. Matikan aliran listrik dari meteran utama.\n2. Amankan dokumen penting ke tempat tinggi.\n3. Jangan berjalan atau mengemudi menerjang arus banjir.\n4. Mengungsi segera jika air terus naik.",
            new Color(120, 60, 180)
        ));
        
        daftarBencana.add(new Bencana(
            "Kebakaran", 
            "Panduan keselamatan di pemukiman saat terjadi kebakaran.", 
            "Kebakaran di area padat penduduk dapat menyebar dengan sangat cepat. \n\nLangkah Keselamatan:\n1. Jangan panik, segera hubungi pemadam kebakaran.\n2. Gunakan kain basah untuk menutupi hidung jika banyak asap.\n3. Merayaplah di lantai karena udara bersih ada di bawah.\n4. Jangan kembali ke dalam rumah untuk mengambil barang.",
            new Color(200, 100, 30)
        ));

        return daftarBencana;
    }
}