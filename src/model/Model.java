package model;

import controller.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * model : manage the stored data of the application
 */
public class Model implements ModelBehaviour {

    private Controller controller;

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
    private ArrayList<String> dictList;
    
    /**
     * hashmap of dictionnary
     */
    private HashMap<String,File> dictMap;
    

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
            System.out.println("## MODEL : init ##");
            passManager = new PasswordManager();
            passwordFile = new File("./data/passwordFile");
            initDictList(); 
    }
    
    public void initDictList(){
        System.out.println("## MODEL : initDictList ##");
        
        this.dictList = new ArrayList<>();
        dictMap = new HashMap<>();
        File testDico = new File("./data/testDicoInit");
        File worstList = new File("./data/worstListInit");
        File disney = new File("./data/disneyInit");
        
        dictMap.put("testDico",testDico);
        dictMap.put("worstList",worstList);
        dictMap.put("disney",disney);
              
        for(String s : dictMap.keySet()) {
            if(dictMap.get(s).exists()){
                File f = new File("./data/"+s);
                copieFile(dictMap.get(s),f);
                dictMap.replace(s,f);
                dictList.add(s);
            }
        }
    }
    
    public void copieFile(File source,File dest){
        FileChannel in = null;
        FileChannel out = null;
        
        System.out.println("## MODEL : copieFile ##");
        
        try{
            in = new FileInputStream(source).getChannel();
            out = new FileOutputStream(dest).getChannel();
            
            
            in.transferTo(0, in.size(), out);
            
        }catch (IOException ex) {
            System.err.println(ex);
        }finally{
            if (in != null){
                try{
                    in.close();
                }catch(IOException e){
                    System.err.println(e);
                }
            }
            if(out!= null){
                try{
                    out.close();
                }catch(IOException e){
                    System.err.println(e);
                }
            }
            
        }      
    }
    
    @Override
    public void cleanModel(){
        System.out.println("## MODEL : cleanModel ##");     
        for(String s : dictMap.keySet()){
            dictMap.get(s).delete();
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
        System.out.println("## MODEL : AddwordToDict __ param word = "+word+" __ param dictionnary = "+dict+" ##");
        
        FileWriter fw = null;
        try{
            fw = new FileWriter(dictMap.get(dict),true);
            fw.write(word+ "\n");
            fw.close();
        }catch(IOException e){
            System.err.println(e);
        }   
    }
    
    public File getDictionnary(String dictName){
        return dictMap.get(dictName);
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
