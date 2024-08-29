/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.model.Model;
import com.mycompany.mavenproject1.view.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author fredd
 */
public class Controller implements ActionListener {

    private App view;
    private Model model;

    public Controller(App view, Model model) {
        this.view = view;
        this.model = model;
        view.loadFile.addActionListener(this);
    }

    public void start() {
        view.setTitle("SO");
        view.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == view.loadFile) {
            handleLoadFile();
        } else {
            System.out.println("Event unknown.");
        }
    }
    
    public void handleLoadFile() {
        JFileChooser fileChooser = new JFileChooser();
        ArrayList<String> lines = new ArrayList<>();
        
        
        int returnValue = fileChooser.showOpenDialog(null);

       
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("File selected: " + selectedFile.getAbsolutePath());

            
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace(); 
            }
        } else {
            System.out.println("No file found.");
        }
        
        model.setLines(lines);
        model.setUserInsToMemo();
    }
}
