
package com.mycompany.mavenproject1.controller;

import com.mycompany.mavenproject1.model.Model;
import com.mycompany.mavenproject1.view.App;

/**
 *
 * @author fredd
 */
public class ControllerBlockMemory {
    private App view;
    private Model model;
    
    public ControllerBlockMemory(App view, Model model) {
        this.view = view;
        this.model = model;
        initTextArea();
    }
    
    public void initTextArea() {
        String text = "";
        int indexUs = model.getMemory().getIndexUser();
        
        for (int i = 0; i < model.getMemorySize(); i++) {
            if (i <= indexUs) {
                text = text + (String.valueOf(i) + " BCP empty space\n\n");
                continue;
            }
            text = text + (String.valueOf(i) + " User empty space\n\n");
        }
        
        view.memoryBlock.setText(text);
    }
}
