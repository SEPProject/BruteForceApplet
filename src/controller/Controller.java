package controller;

import model.*;
import view.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Controller implements ControllerFromModel, ControllerFromView {
    
    private Model model;
    private View view;
    
    public Controller(){
        //Model mod = new Model(this);
        //this.model=mod;
        //this.view = v;
    }
    
    
    /********************************** From VIEW **************************************/
    
    
    @Override
    public void setModel(Model m){
        this.model=m;
    }
    
    @Override
    public Model getModel(){
        return model;
    }
    
    @Override
    public void performAddWordToDict(String word,String dictionnary){
        
        System.out.println("## CONTROLLER : performAddwordToDict __ param word = "+word+" __ param dictionnary = "+dictionnary+" ##");
        model.addWordToDict(word, dictionnary);
    }
    
    @Override
    public void performCloseApplet(){
        System.out.println("## CONTROLLER : performCloseApplet ##");
        model.cleanModel();
    }
    
    @Override
    public void performAttack(String dictionnary){
        
        String passHashed = "";
        FileReader fr ;
        BufferedReader br ;
        String attempt;
        String hashAttempted;
        Boolean found = false;
        
        // relevant data
        long startTime ;
        long endTime ;
        int compteur = 0;
        
        System.out.println("## CONTROLLER : performATTACK ##");
        view.printMessage("infoView","\n\n","infoStyle");
        // view.printMessage("infoView","** TENTATIVE DE BRUTE FORCE **\n","infoStyle");
        
        passHashed = model.getPasswordManager().getHashStored();
        // view.printMessage("infoView","> rappel :\nHASH = "+ passHashed +"\n","infoStyle");
        // view.printMessage("infoView","DICTIONNAIRE = "+ dictionnary +"\n\n","infoStyle");
        
        try{
            fr = new FileReader(model.getDictionnary(dictionnary));
            br = new BufferedReader(fr);
            
            System.out.println("## CONTROLLER  Attack starting... ##");
            
            
            
            startTime = System.currentTimeMillis();
            while (((attempt = br.readLine())!= null) && !found)  {
                compteur++;
                hashAttempted = model.getPasswordManager().hash(attempt);
                System.out.println("## CONTROLLER >> attempting :" + attempt + " ##");
                
                view.newMessage();
                view.printMessage("hackerView","                [ JOHN ]     \n","attackStyle");
                view.printMessage("hackerView","\n","attackerStyle");
                view.printMessage("hackerView","HASH           : ["+passHashed+"]\n","attackStyle");
                view.printMessage("hackerView","ATTEMPT        : ["+attempt+"]\n","attackStyle");
                view.printMessage("hackerView","ATTEMPTED HASH : ["+hashAttempted+"]\n","attackStyle");
                
                if (hashAttempted.equals(passHashed)){
                    found = true;
                    endTime = System.currentTimeMillis();
                    System.out.println("## CONTROLLER >> SUCCEED password = " + attempt + " ##");
                    //view.printMessage("infoView","***********************\n\n","infoStyle");
                    //view.printMessage("infoView","PASSWORD = "+ attempt +"\n","succeedStyle");
                    model.getPasswordManager().setPasswordFound(attempt);
                    
                    view.printMessage("hackerView","KEY FOUND! : ["+attempt+"]\n","attackStyle");
                    view.printMessage("hackerView","DURATION   : ["+(endTime-startTime)+" ms]\n","attackStyle");
                    view.printMessage("hackerView","KEYTESTED  : ["+compteur+"]\n","attackStyle");
                    
                    view.printMessage("hackerView","SPEED      : ["+ (((long) (compteur*1000)) /(endTime-startTime))+ " word/sec]\n","attackStyle");
                }
            }
            
            if(!found){
                endTime = System.currentTimeMillis();
                System.out.println("## CONTROLLER >> FAILED password not found ##");
                //view.printMessage("infoView","***********************\n\n","infoStyle");
                view.printMessage("infoView","ECHEC DE LA TENTATIVE \n\n","errorStyle");
                view.printMessage("hackerView","KEY NOT FOUND !\n","attackStyle");
                view.printMessage("hackerView","DURATION   : ["+(endTime-startTime)+" ms]\n","attackStyle");
                view.printMessage("hackerView","KEYTESTED  : ["+compteur+"]\n","attackStyle");
                view.printMessage("hackerView","SPEED      : ["+((long) (compteur*1000)/(endTime-startTime))+" word/sec]\n","attackStyle");
                
            }
            br.close();
            
            System.out.println("## CONTROLLER >> done ! ##");
        }catch(IOException e){
            System.err.println(e);
        }
        
    }
    
    @Override
    public void launchAutoGenerator(String dictionnary){
        
        
        model.autoGeneration(dictionnary);
        
        
    }  
    
    /********************************** From MODEL **************************************/
    
    
    @Override
    public void setView(View v){
        this.view=v;
    }
    
    @Override
    public View getView(){
        return view;
    }
    
    @Override
    public void printToView(String message,String style){
        view.printMessage("infoView",message,style);
    }
    
    
    
    
    
    
    
}
