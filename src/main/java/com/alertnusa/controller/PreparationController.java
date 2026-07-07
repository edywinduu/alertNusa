/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alertnusa.controller;
import com.alertnusa.model.PreparationRepository;
import com.alertnusa.view.PreparationPanel;
import java.util.List;

/**
 *
 * @author edy
 */
public class PreparationController {
    private PreparationPanel view;
    private PreparationRepository repo;

    public PreparationController(PreparationPanel view) {
        this.view = view;
        this.repo = new PreparationRepository();
    }

    // Constructor Kosong Tambahan agar pemicuan di panel tidak eror parameter
    public PreparationController() {
        this.repo = new PreparationRepository();
    }

    // Method lama yang memicu eror 'cannot find symbol' dihapus/dikosongkan kodenya
    public void loadPreparationData(int userId) {
        System.out.println("[AlertNusa] Menggunakan load dinamis di panel view.");
    }
    
}
