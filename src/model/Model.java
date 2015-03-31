package model;

import controller.*;
import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * model : manage the stored data of the application
 */
public class Model implements ModelBehaviour {

    public Controller controller;

    /**
     * a list of the worst password
     */
    public File worstList;

    /**
     * the file where the password to find is stored
     */
    private File passwordFile;

    /**
     * the password manager
     */
    private PasswordManager passManager;

    /**
     * the description of the applet : summary
     */
    private String description;

    public Model(){
        init();
    }

    /**
     * initialize the model :
     * set the worst password file
     * set the password manager
     */
    
    public void init(){
           // worstList = new File("./data/worstList.txt");
            passManager = new PasswordManager();
           // createPasswordFile();
            passwordFile = new File("./data/passwordFile");
    }

    /*public void createPasswordFile(){
      
        FileWriter fw;
        BufferedReader br ;
        BufferedWriter bw;
        
        try{
            fw = new FileWriter("./data/passwordFile");
            bw = new BufferedWriter(fw);
            
            bw.write("Administrator:500:" + passManager.getHashStored() +":::");
            bw.write("Bob:100: :::");
            bw.write("guest:501: :::");
            
            bw.close();
        }catch(IOException e){
            System.err.println(e);
        }
        
        passwordFile = new File("./data/passwordFile");
    }*/
    
    
    @Override
    public File getWorstList() {
        return worstList;
    }

    @Override
    public void setController(Controller c){
        this.controller = c;
    }

    @Override
    public File getPasswordFile(){
        return passwordFile;
    }

    @Override
    public PasswordManager getPasswordManager(){
        return passManager;
    }

    @Override
    public String getDescription(){
        return description;
    }

    @Override
    public void setDescription(String s){
        description = s;
    }


}
