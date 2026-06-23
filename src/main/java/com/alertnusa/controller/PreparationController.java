/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alertnusa.controller;
import com.alertnusa.model.PreparationRepository;
import com.alertnusa.model.PreparationItem;
import com.alertnusa.view.PreparationPanel;
import java.util.List;
import java.util.ArrayList;

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

    public void loadPreparationData(int userId) {
        List<com.alertnusa.model.PreparationItem> allItems = repo.getAllPreparations();
    
        // 2. AMBIL DATA CENTANG ASLI DARI DATABASE BERDASARKAN USER ID
        List<Integer> checkedIds = repo.getCheckedPreparationIds(userId); 

        // 3. Lempar ke UI untuk digambar di layar
        view.initPreparationChecklist(allItems, checkedIds);
    }

    public void saveChecklist(int userId, List<Integer> checkedIds) {
        repo.saveUserChecklist(userId, checkedIds);
    }
}
