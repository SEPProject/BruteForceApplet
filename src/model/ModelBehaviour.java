package model;
import controller.*;
import java.io.*;

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
    * return the worst list of password
    * @return
    */
    public File getWorstList();
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
     * return the description of the applet
     * @return
     */
    public String getDescription();

    /**
     * set the description of the applet
     * @param s
     */
    public void setDescription(String s);
}
