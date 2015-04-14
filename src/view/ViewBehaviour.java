package view;

import controller.*;
import javax.swing.*;

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
     */
    public void printMessage(String message);
    
    

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
