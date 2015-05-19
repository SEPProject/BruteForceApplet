package model;

import controller.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
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
     * initialize the model :
     * set the worst password file
     * set the password manager
     * set the dictionnaries
     */
    public Model(Controller ctrl){
        System.out.println("## MODEL : init ##");
        this.controller = ctrl;
        controller.setModel(this);
        passManager = new PasswordManager();
        passwordFile = new File("./data/passwordFile");
        initDictList();
    }
    
    
    
    
    private void initDictList(){
        System.out.println("## MODEL : initDictList ##");
        
        this.dictList = new ArrayList<>();
        dictMap = new HashMap<>();
        File testDico = new File("./data/tonDicoInit");
        File worstList = new File("./data/worstListInit");
        
        dictMap.put("tonDico",testDico);
        dictMap.put("worstList",worstList);
        
        for(String s : dictMap.keySet()) {
            if(dictMap.get(s).exists()){
                File f = new File("./data/"+s);
                copieFile(dictMap.get(s),f);
                dictMap.replace(s,f);
                dictList.add(s);
            }
        }
    }
    
    
    private String pourcentage(int a,int b){
        double c = new Double(b);
        double resultat = a/c;
        double resultatFinal = resultat*100;
        DecimalFormat df = new DecimalFormat("###.##");
        return df.format(resultatFinal) + " %";
    }
    
    
    private void copieFile(File source,File dest){
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
        
        FileWriter fw = null;
        try{
            fw = new FileWriter(dictMap.get(dict),true);
            fw.write(word+ "\n");
            fw.close();
        }catch(IOException e){
            System.err.println(e);
        }
    }
    
    @Override
    public File getDictionnary(String dictName){
        return dictMap.get(dictName);
    }
    
    @Override
    public void autoGeneration(String dictionnary){
        System.out.println("## CONTROLLER : launchAtutoGenerator ##");
        
        int size  = 6;
        FileWriter fw = null;
        String charset = "abcdefghijklmnopqrstuvwxyz";
        
        StringBuffer word = new StringBuffer();
        word.setLength(size);
        
        try{
            fw = new FileWriter(dictMap.get(dictionnary),true);
            
            int lettre_1 = 21;
            int lettre_2 = 8;
            int lettre_3 = 10;
            int lettre_4;
        
            for (lettre_4 = 0; lettre_4<charset.length() ; lettre_4++ ){
                controller.printToView("generated: "+pourcentage(lettre_4,charset.length()) +" \n","infoStyle");
                try {
                    sleep(60);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int lettre_5 = 0; lettre_5<charset.length() ; lettre_5++ ){
                    for (int lettre_6 = 0; lettre_6<charset.length() ; lettre_6++ ){
                        
                        if(lettre_1 != lettre_2
                                && lettre_2 != lettre_3
                                && lettre_3 != lettre_4
                                && lettre_4 != lettre_5
                                && lettre_5 != lettre_6)
                        {
                            
                            word.setCharAt(0,charset.charAt(lettre_1));
                            word.setCharAt(1,charset.charAt(lettre_2));
                            word.setCharAt(2,charset.charAt(lettre_3));
                            word.setCharAt(3,charset.charAt(lettre_4));
                            word.setCharAt(4,charset.charAt(lettre_5));
                            word.setCharAt(5,charset.charAt(lettre_6));
                            fw.write(word+ "\n");
                        }
                    }
                }
            }
            controller.printToView("generated: "+pourcentage(lettre_4,charset.length())+ " \n","infoStyle");
            fw.close();
        }catch(IOException e){
            System.err.println(e);
        }
    }
}
