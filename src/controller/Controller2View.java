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
     * from view : add the word to the dictionnary
     * @param word
     * @param dictionnary
     */
    public void performAddWordToDict(String word,String dictionnary);
    
    
    /**
     * from view : clean the applet ressources
     */
    public void performCloseApplet();
    
    /**
     * launch the brute force attempt
     * @param dictionnary 
     */
    public void performAttack(String dictionnary);
    
    
    /**
     * what ?
     */
    //public void initMission1();
    
    
    
}
