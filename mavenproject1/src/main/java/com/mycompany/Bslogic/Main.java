package com.mycompany.Bslogic;

import com.mycompany.mavenproject1.controller.Controller;
import com.mycompany.mavenproject1.model.Model;
import com.mycompany.mavenproject1.view.App;

/**
 *
 * @author fredd
 */
public class Main {

    public static void main(String[] args) {
        
        App view = new App();
        Model model = new Model();
        
        Controller controller = new Controller(view, model);
        controller.start();
        view.setVisible(true);
    }

}
