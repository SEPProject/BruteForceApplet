package controller;
import model.Model;

public interface ControllerFromView {

     /**
     * set the model of the controller
     * @param m
     */
    public void setModel(Model m);

    /**
     * return the model of the controller
     * @return
     */
    public Model getModel();
    
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
     * launch auto generation of words
     * @param dictionnary 
     */
    public void launchAutoGenerator(String dictionnary);
 
}
