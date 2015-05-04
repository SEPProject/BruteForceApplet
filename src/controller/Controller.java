package controller;

import model.*;
import view.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.SwingUtilities;

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
        Boolean found = false;
        
        System.out.println("## CONTROLLER : performATTACK ##");
        view.printMessage("\n\n","infoStyle");
        view.printMessage("** TENTATIVE DE BRUTE FORCE **\n","infoStyle");
        
        passHashed = model.getPasswordManager().getHashStored();
        view.printMessage("> rappel :\nHASH = "+ passHashed +"\n","infoStyle");
        view.printMessage("DICTIONNAIRE = "+ dictionnary +"\n\n","infoStyle");
        
        try{
            fr = new FileReader(model.getDictionnary(dictionnary));
            br = new BufferedReader(fr);
            
            System.out.println("## CONTROLLER  Attack starting... ##");
            
            while (((attempt = br.readLine())!= null) && !found)  {
                System.out.println("## CONTROLLER >> attempting :" + attempt + " ##");
                //view.printMessage("tentative = "+ attempt +"\n");
                if (model.getPasswordManager().hash(attempt).equals(passHashed)){
                    found = true;
                    System.out.println("## CONTROLLER >> SUCCEED password = " + attempt + " ##");
                    view.printMessage("***********************\n\n","infoStyle");
                    view.printMessage("PASSWORD = "+ attempt +"\n","succeedStyle");
                    model.getPasswordManager().setPasswordFound(attempt);
                }
            }
            
            if(!found){
                System.out.println("## CONTROLLER >> FAILED password not found ##");
                view.printMessage("***********************\n\n","infoStyle");
                view.printMessage("ECHEC DE LA TENTATIVE \n\n","errorStyle");
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
        view.printMessage(message,style);
    }
    
    /*
    @Override
    public boolean performAttack(String dictionnary){
    String password = "" ;
    String passHashed = "";
    Scanner sc = new Scanner(System.in);
    FileReader fr ;
    BufferedReader br ;
    String attempt;
    Boolean found = false;
    
    System.out.println("### Starting TEST ###");
    System.out.println(">> Aim of this is to provide a password and the attack is launched !");
    
    do {
    System.out.println(">> chose a password to Test : ");
    password = sc.nextLine();
    }while (password.equals(""));
    
    System.out.println(">> hashing the password...");
    model.getPasswordManager().setHashStored(password);
    passHashed = model.getPasswordManager().getHashStored();
    System.out.println(">> password hashed : " + passHashed);
    System.out.println(">> now the aim is to find the password from the hash you succeed to find :" + passHashed);
    System.out.println(" choosing dictionary : worstlist...");
    
    try{
    
    fr = new FileReader(model.getDictionnary(dictionnary));
    br = new BufferedReader(fr);
    
    System.out.println(">> Attack starting... ");
    
    while (((attempt = br.readLine())!= null) && !found)  {
    System.out.println(">> attempting :" + attempt );
    if (model.getPasswordManager().hash(attempt).equals(passHashed)){
    found = true;
    System.out.println(">> SUCCEED password = " + attempt );
    }
    }
    
    if(!found){
    System.out.println(">> FAILED password not found");
    }
    br.close();
    
    System.out.println(">> done !");
    }catch(IOException e){
    System.err.println(e);
    }
    
    return found ;
    }*/
    
    /*
    @Override
    public void initMission1(){
    // model.getFile();
    }*/
    
    
    
    
    /**
     * set the mission description + parts
     */
    /*public void setMissionApplet(){
    
    model.getMission().setDescription("We lost the password of our computer, but we" +
    " have the file where it's stored in the computer that you can see" +
    " clicking on the : passwordfile button. To retrieve it we propose to you" +
    " to use a Brute force attack. ");
    
    view.setMissionDescriptionText(getModel().getMission().getDescription());
    
    model.getMission().setPart(0, "1) As you can see the passwordFile is unreadable." +
    " That's because the computer stores encrypted password. Hopefully" +
    " you know the encryption algorithm, then you just need to try words," +
    " encrypt them then compare them to the stored encrypted password. Hopefully" +
    " the encryption is made by the applet. The next step is to build a dictionnary." +
    " It's a file where every suggestion of password are stored and will be browsed " +
    "to be tried. Now add words that you think can be the password. ");
    
    view.setMissionPart1(getModel().getMission().getPart(0));
    
    }*/
    
    
    
    
    
    
    
}
