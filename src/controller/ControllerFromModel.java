package controller;
import model.*;
import view.View;

public interface ControllerFromModel {
    
    /**
     * set the view of the controller
     * @param v
     */
    public void setView(View v);

    /**
     * return the view of the controller
     * @return
     */
    public View getView();
    
    /**
     * print a message to the view from the model
     * @param message 
     * @param style
     */
    public void printToView(String message,String style);

}
