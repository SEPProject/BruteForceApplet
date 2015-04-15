package view;

import controller.*;
import javax.swing.*;
import javax.swing.text.Style;

/**
 * view interface
 */
public interface ViewBehaviour {

    /**
     * set the controller of the view
     * @param p
     */
    public void setController(Controller p);

    /**
     * return the controller of the view
     * @return
     */
    public Controller getController();
    
    /**
     * print a message from controller
     * @param message
     * @param style 
     */
    public void printMessage(String message,String style);
    
    

    /**
     * set the applet description on the first page
     * @param s
     */
    //public void setAppletDescriptionText(String s);

    /**
     * set the description of the mission
     * @param s
     */
    //public void setMissionDescriptionText(String s);
}
