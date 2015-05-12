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
     * @param view where you want the message to be printed
     */
    public void printMessage(String view, String message,String style);
    
    /**
     * set the hackerView to blank
     */
    public void newMessage();

}
