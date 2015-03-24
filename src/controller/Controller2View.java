package controller;
import view.*;

public interface Controller2View {

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
     * initialise the password file + model to start mission1
     */
    public void initMission1();
}
