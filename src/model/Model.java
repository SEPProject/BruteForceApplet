package model;

import controller.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
     * a list of existing file
     */
    public ArrayList<String> dictList;
    
    /**
     * hashmap of dictionnary
     */
    public HashMap<String,File> dictMap;
    

    /**
     * the description of the applet : summary
     */
    //private String description;

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
            passwordFile = new File("./data/passwordFile");
            
            initDictList(); 
    }
    
    public void initDictList(){
        this.dictList = new ArrayList<>();
        dictMap = new HashMap<>();
        File testDico = new File("./data/testDico");
        File worstList = new File("./data/worstList.txt");
        File disney = new File("./data/disney");
        
        dictMap.put("testDico",testDico);
        dictMap.put("worstList",worstList);
        dictMap.put("disney",disney);
              
        for(String s : dictMap.keySet()) {
            if(dictMap.get(s).exists()){
                dictList.add(s);
            }
        }
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
    public ArrayList<String> getDictList(){
        return this.dictList;
    }
    
    @Override
    public void addWordToDict(String word, String dict){
        System.out.println("## model : AddwordToDict __ param word = "+word+" __ param dictionnary = "+dict+" ##");
        
        FileWriter fw = null;
        try{
            fw = new FileWriter(dictMap.get(dict),true);
            fw.write(word+ "\n");
            fw.close();
        }catch(IOException e){
            System.err.println(e);
        }
        
    }
    
    /*
    @Override
    public String getDescription(){
        return description;
    }

    @Override
    public void setDescription(String s){
        description = s;
    }
*/

}
