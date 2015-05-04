
import controller.Controller;
import model.Model;
import view.View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author seb
 */
public class BruteForceApplet {
    
    /**
     * Main of this application
     */
    
    private static View view ;
    private static Controller ctrl ;
    private static Model model;
    
    public static void main(String[] args) {
        ctrl = new Controller();
        view = new View(ctrl);
        model = new Model(ctrl);
        view.setVisible(true);
    }
    
}
