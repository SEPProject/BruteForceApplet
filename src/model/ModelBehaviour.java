package model;
import controller.*;
import java.io.*;
import java.util.ArrayList;

/**
 * model interface
 */
public interface ModelBehaviour {

    /**
     * set the controller of the model
     * @param c
     */
    public void setController(Controller c);

    /**
     * return the password File where the hash is stored
     * @return
     */
    public File getPasswordFile();

    /**
     * return the password manager of the model
     * @return
     */
    public PasswordManager getPasswordManager();
    
    /**
     * return the list of existing dictionnary
     * @return 
     */
    public ArrayList<String> getDictList();
    
    /**
     * add the word to the dictonnary
     */
    public void addWordToDict(String word,String dict);
    
    /**
     * clean the model ressources
     */
    public void cleanModel(); 
   
    /**
     * return the description of the applet
     * @return
     */
     //public String getDescription();

    /**
     * set the description of the applet
     * @param s
     */
    //public void setDescription(String s);
}
