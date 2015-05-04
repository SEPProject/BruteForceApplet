/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package view;

import MainComponents.Mission;
import MainComponents.MissionPanel;
import MainComponents.Submission;
import controller.Controller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author seb
 */
public class View extends JFrame implements ViewBehaviour {
    
    /**
     *
     * Initializes the applet View
     */
    
    private Controller controller;
    
    private StyledDocument hackerView, infoView;
    private Style  errorStyle, succeedStyle, infoStyle, attackStyle, cmdStyle;
    private boolean firstVisit;
    private String dictionnary;
    
    public View(Controller ctrl){
        
        this.setController(ctrl);
        initComponents();
        getController().setView(this);
        
        firstVisit = true;
        
        
        infoView = infoPane.getStyledDocument();
        errorStyle = infoPane.addStyle("errStyle", null);
        infoStyle = infoPane.addStyle("infoStyle", null);
        succeedStyle = infoPane.addStyle("suceedStyle",null);
        
        hackerView = hackerPane.getStyledDocument();
        attackStyle = hackerPane.addStyle("attackStyle",null);
        cmdStyle = hackerPane.addStyle("cmdStyle",null);
        
        StyleConstants.setForeground(infoStyle, Color.BLACK);
        StyleConstants.setForeground(succeedStyle, Color.GREEN);
        StyleConstants.setForeground(errorStyle, Color.RED);
        StyleConstants.setForeground(attackStyle,Color.BLACK);
        StyleConstants.setForeground(cmdStyle,Color.GRAY);
        
        //entryPanel.setVisible(true);
        missionLayeredPanel.setVisible(false);
        
    }
    
    
   /* public void init() {
        Controller ctrl = new Controller(this);
        this.setController(ctrl);
        firstVisit = true;
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                    // init the list of dictionnary
                    initDictList();
                   
                    * styles' initialization
                    * Red for error printed for user
                    * Black for normal info
                    * Green for succeed mission
                    * Gray for real commands
                    
                    
                    infoView = infoPane.getStyledDocument();
                    errorStyle = infoPane.addStyle("errStyle", null);
                    infoStyle = infoPane.addStyle("infoStyle", null);
                    succeedStyle = infoPane.addStyle("suceedStyle",null);
                    
                    hackerView = hackerPane.getStyledDocument();
                    attackStyle = hackerPane.addStyle("attackStyle",null);
                    cmdStyle = hackerPane.addStyle("cmdStyle",null);
                    
                    StyleConstants.setForeground(infoStyle, Color.BLACK);
                    StyleConstants.setForeground(succeedStyle, Color.GREEN);
                    StyleConstants.setForeground(errorStyle, Color.RED);
                    StyleConstants.setForeground(attackStyle,Color.BLACK);
                    StyleConstants.setForeground(cmdStyle,Color.GRAY);
                    
                    //entryPanel.setVisible(true);
                    missionLayeredPanel.setVisible(false);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/
    
   /* @Override
    public void stop(){
        System.out.println("## VIEW : stop applet ##");
        controller.performCloseApplet();
    }*/
    
    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layoutPanel = new javax.swing.JLayeredPane();
        entryPanel = new javax.swing.JPanel();
        entryPanelTitle = new javax.swing.JLabel();
        entryPanelButton = new javax.swing.JButton();
        entryPanelScrollPanel = new javax.swing.JScrollPane();
        entryPanelText = new javax.swing.JTextArea();
        fullPanel = new javax.swing.JPanel();
        controlPanel = new javax.swing.JPanel();
        missionLayeredPanel = new javax.swing.JLayeredPane();
        mission1Panel = new javax.swing.JPanel();
        m1Filebutton = new javax.swing.JButton();
        m1HashButton = new javax.swing.JButton();
        m1HashField = new javax.swing.JTextField();
        mission2Panel = new javax.swing.JPanel();
        m2ChoisirDic = new javax.swing.JLabel();
        m2ListDic = new javax.swing.JComboBox<String>();
        m2TextField = new javax.swing.JTextField();
        m2AutoButton = new javax.swing.JButton();
        m2AddWordButton = new javax.swing.JButton();
        m2Mission3Button = new javax.swing.JButton();
        mission3Panel = new javax.swing.JPanel();
        m3FillDicoButton = new javax.swing.JButton();
        m3AttackButton = new javax.swing.JButton();
        m3ConfirmButton = new javax.swing.JButton();
        m3PassField = new javax.swing.JTextField();
        m3FinButton = new javax.swing.JToggleButton();
        viewPanel = new javax.swing.JPanel();
        hackerLabel = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();
        scrollInfoPane = new javax.swing.JScrollPane();
        infoPane = new javax.swing.JTextPane();
        scrollHackPane = new javax.swing.JScrollPane();
        hackerPane = new javax.swing.JTextPane();
        missionPlacePanel = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1020, 530));
        setSize(new java.awt.Dimension(1020, 470));

        layoutPanel.setPreferredSize(new java.awt.Dimension(1020, 430));
        layoutPanel.setSize(new java.awt.Dimension(1020, 430));

        entryPanel.setPreferredSize(new java.awt.Dimension(1020, 430));

        entryPanelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        entryPanelTitle.setText("Bienvenue sur l'applet de Brute Force");

        entryPanelButton.setText("Commencer");
        entryPanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryPanelButtonActionPerformed(evt);
            }
        });

        entryPanelScrollPanel.setBackground(new java.awt.Color(238, 238, 238));
        entryPanelScrollPanel.setBorder(null);

        entryPanelText.setEditable(false);
        entryPanelText.setBackground(new java.awt.Color(238, 238, 238));
        entryPanelText.setColumns(20);
        entryPanelText.setRows(5);
        entryPanelText.setText("Dans cette applet vous allez découvrir comment se passe une vrai attaque par brute force. \nVous allez devoir trouver un mot de passe que nous avons perdu. Dès que vous êtes près \nappuyez sur commencer");
        entryPanelText.setBorder(null);
        entryPanelScrollPanel.setViewportView(entryPanelText);

        javax.swing.GroupLayout entryPanelLayout = new javax.swing.GroupLayout(entryPanel);
        entryPanel.setLayout(entryPanelLayout);
        entryPanelLayout.setHorizontalGroup(
            entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(entryPanelLayout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(entryPanelScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 219, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, entryPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, entryPanelLayout.createSequentialGroup()
                        .addComponent(entryPanelButton)
                        .addGap(446, 446, 446))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, entryPanelLayout.createSequentialGroup()
                        .addComponent(entryPanelTitle)
                        .addGap(391, 391, 391))))
        );
        entryPanelLayout.setVerticalGroup(
            entryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, entryPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(entryPanelTitle)
                .addGap(58, 58, 58)
                .addComponent(entryPanelScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(entryPanelButton)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        fullPanel.setPreferredSize(new java.awt.Dimension(1020, 430));

        controlPanel.setPreferredSize(new java.awt.Dimension(720, 430));

        missionLayeredPanel.setPreferredSize(new java.awt.Dimension(720, 149));

        mission1Panel.setPreferredSize(new java.awt.Dimension(720, 145));

        m1Filebutton.setText("fichier mot de passe");
        m1Filebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m1FilebuttonMouseClicked(evt);
            }
        });

        m1HashButton.setText("confirm hash");
        m1HashButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m1HashButtonMouseClicked(evt);
            }
        });

        m1HashField.setForeground(new java.awt.Color(102, 102, 102));
        m1HashField.setText("Enter Hash");
        m1HashField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m1HashFieldMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mission1PanelLayout = new javax.swing.GroupLayout(mission1Panel);
        mission1Panel.setLayout(mission1PanelLayout);
        mission1PanelLayout.setHorizontalGroup(
            mission1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mission1PanelLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(mission1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mission1PanelLayout.createSequentialGroup()
                        .addComponent(m1HashField, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(m1HashButton)
                        .addContainerGap(106, Short.MAX_VALUE))
                    .addGroup(mission1PanelLayout.createSequentialGroup()
                        .addComponent(m1Filebutton)
                        .addGap(0, 477, Short.MAX_VALUE))))
        );
        mission1PanelLayout.setVerticalGroup(
            mission1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mission1PanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(m1Filebutton)
                .addGap(50, 50, 50)
                .addGroup(mission1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(m1HashButton)
                    .addComponent(m1HashField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        mission2Panel.setPreferredSize(new java.awt.Dimension(720, 145));

        m2ChoisirDic.setText("Choisir dictionnaire");

        m2TextField.setForeground(new java.awt.Color(102, 102, 102));
        m2TextField.setText("Entrer un mot");
        m2TextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m2TextFieldMouseClicked(evt);
            }
        });

        m2AutoButton.setText("auto-generation");
        m2AutoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m2AutoButtonMouseClicked(evt);
            }
        });

        m2AddWordButton.setText("ajouter mot au dictionnaire");
        m2AddWordButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m2AddWordButtonMouseClicked(evt);
            }
        });

        m2Mission3Button.setText("MISSION 3");
        m2Mission3Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m2Mission3ButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mission2PanelLayout = new javax.swing.GroupLayout(mission2Panel);
        mission2Panel.setLayout(mission2PanelLayout);
        mission2PanelLayout.setHorizontalGroup(
            mission2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mission2PanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(mission2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mission2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(m2ListDic, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(m2ChoisirDic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mission2PanelLayout.createSequentialGroup()
                        .addComponent(m2AddWordButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(m2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mission2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mission2PanelLayout.createSequentialGroup()
                        .addComponent(m2Mission3Button)
                        .addGap(113, 113, 113))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mission2PanelLayout.createSequentialGroup()
                        .addComponent(m2AutoButton)
                        .addGap(92, 92, 92))))
        );
        mission2PanelLayout.setVerticalGroup(
            mission2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mission2PanelLayout.createSequentialGroup()
                .addGroup(mission2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mission2PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(m2ChoisirDic))
                    .addGroup(mission2PanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(mission2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(m2ListDic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(m2AutoButton))))
                .addGap(18, 18, 18)
                .addGroup(mission2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(m2AddWordButton)
                    .addComponent(m2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m2Mission3Button))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        mission3Panel.setPreferredSize(new java.awt.Dimension(720, 145));

        m3FillDicoButton.setText("remplir dictionnaire");
        m3FillDicoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m3FillDicoButtonMouseClicked(evt);
            }
        });

        m3AttackButton.setText("lancer attaque");
        m3AttackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m3AttackButtonMouseClicked(evt);
            }
        });

        m3ConfirmButton.setText("confirmer password");
        m3ConfirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m3ConfirmButtonMouseClicked(evt);
            }
        });

        m3PassField.setForeground(new java.awt.Color(102, 102, 102));
        m3PassField.setText("Entrer le mot de passe");
        m3PassField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m3PassFieldMouseClicked(evt);
            }
        });

        m3FinButton.setText("FIN");
        m3FinButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                m3FinButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mission3PanelLayout = new javax.swing.GroupLayout(mission3Panel);
        mission3Panel.setLayout(mission3PanelLayout);
        mission3PanelLayout.setHorizontalGroup(
            mission3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mission3PanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(mission3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mission3PanelLayout.createSequentialGroup()
                        .addComponent(m3PassField, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(m3ConfirmButton))
                    .addGroup(mission3PanelLayout.createSequentialGroup()
                        .addComponent(m3FillDicoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(m3AttackButton)))
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mission3PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(m3FinButton)
                .addGap(319, 319, 319))
        );
        mission3PanelLayout.setVerticalGroup(
            mission3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mission3PanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(mission3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(m3FillDicoButton)
                    .addComponent(m3AttackButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mission3PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(m3ConfirmButton)
                    .addComponent(m3PassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(m3FinButton)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout missionLayeredPanelLayout = new javax.swing.GroupLayout(missionLayeredPanel);
        missionLayeredPanel.setLayout(missionLayeredPanelLayout);
        missionLayeredPanelLayout.setHorizontalGroup(
            missionLayeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(missionLayeredPanelLayout.createSequentialGroup()
                .addComponent(mission1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(missionLayeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(missionLayeredPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mission2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(missionLayeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(missionLayeredPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mission3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        missionLayeredPanelLayout.setVerticalGroup(
            missionLayeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(missionLayeredPanelLayout.createSequentialGroup()
                .addComponent(mission1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
            .addGroup(missionLayeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(missionLayeredPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(mission2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(missionLayeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(missionLayeredPanelLayout.createSequentialGroup()
                    .addGap(0, 61, Short.MAX_VALUE)
                    .addComponent(mission3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 61, Short.MAX_VALUE)))
        );
        missionLayeredPanel.setLayer(mission1Panel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        missionLayeredPanel.setLayer(mission2Panel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        missionLayeredPanel.setLayer(mission3Panel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        viewPanel.setPreferredSize(new java.awt.Dimension(720, 285));

        hackerLabel.setText("hacker view");

        infoLabel.setText("info view");

        infoPane.setFocusable(false);
        scrollInfoPane.setViewportView(infoPane);

        scrollHackPane.setViewportView(hackerPane);

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(hackerLabel)
                .addGap(300, 300, 300)
                .addComponent(infoLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollHackPane, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollInfoPane, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hackerLabel)
                    .addComponent(infoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollInfoPane)
                    .addComponent(scrollHackPane, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(missionLayeredPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addComponent(viewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(missionLayeredPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        missionPlacePanel.setPreferredSize(new java.awt.Dimension(300, 430));
        missionPlacePanel.setSize(new java.awt.Dimension(300, 430));

        javax.swing.GroupLayout missionPlacePanelLayout = new javax.swing.GroupLayout(missionPlacePanel);
        missionPlacePanel.setLayout(missionPlacePanelLayout);
        missionPlacePanelLayout.setHorizontalGroup(
            missionPlacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        missionPlacePanelLayout.setVerticalGroup(
            missionPlacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout fullPanelLayout = new javax.swing.GroupLayout(fullPanel);
        fullPanel.setLayout(fullPanelLayout);
        fullPanelLayout.setHorizontalGroup(
            fullPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fullPanelLayout.createSequentialGroup()
                .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(missionPlacePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fullPanelLayout.setVerticalGroup(
            fullPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fullPanelLayout.createSequentialGroup()
                .addGroup(fullPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(missionPlacePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layoutPanelLayout = new javax.swing.GroupLayout(layoutPanel);
        layoutPanel.setLayout(layoutPanelLayout);
        layoutPanelLayout.setHorizontalGroup(
            layoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layoutPanelLayout.createSequentialGroup()
                .addComponent(entryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layoutPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(fullPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layoutPanelLayout.setVerticalGroup(
            layoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(entryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layoutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layoutPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(fullPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layoutPanel.setLayer(entryPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        layoutPanel.setLayer(fullPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layoutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layoutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void initMission(){
        System.out.println("## VIEW : initMission ##");
        
        MissionPanel mp = new MissionPanel(300,430,"BruteForce Mission");
        mp.getPannelFrame().setPreferredSize(new java.awt.Dimension(300, 430));
        mp.getPannelFrame().setSize(new java.awt.Dimension(300, 430));
        
        Mission mission1 = new Mission("mission 1","Trouver le HASH");
        mission1.addSubmission(new Submission("indice :","Le hash se situe dans le fichier .password, il faut récupérer le hash intéressant!"));
        mp.addMission(mission1);
        
        Mission mission2 = new Mission("mission 2","Construire le dictionnaire");
        mission2.addSubmission(new Submission("indice 1","Il faut créer un dictionnaire des mots à tester pour éviter de tester toutes les combinaisons possibles."));
        mission2.addSubmission(new Submission("indice 2","le mot comporte 6 lettre, et vit au nord"));
        
        mp.addMission(mission2);
        
        Mission mission3 = new Mission("mission 3","L'attaque");
        mission3.addSubmission(new Submission("indice","Le but est de lancer l'attaque, et de récupérer le mot de passe"));
        mp.addMission(mission3);
        
        missionPlacePanel.add(mp.getPannelFrame(), javax.swing.JLayeredPane.DEFAULT_LAYER);
    }
    
    public void initDictList(){
        System.out.println("## VIEW : initDictList ##");
        for(String s : controller.getModel().getDictList()){
            m2ListDic.addItem(s);
        }
    }
    
    
    private void entryPanelButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_entryPanelButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("## VIEW : commencer > pressed ##");
        entryPanel.setVisible(false);
        initMission();
        initDictList();
        missionLayeredPanel.setVisible(true);
        mission2Panel.setVisible(false);
        mission3Panel.setVisible(false);
        mission1Panel.setVisible(true);
    }//GEN-LAST:event_entryPanelButtonActionPerformed
    
    @SuppressWarnings("empty-statement")
    private void m1FilebuttonMouseClicked(MouseEvent evt) {//GEN-FIRST:event_m1FilebuttonMouseClicked
        
        FileReader fr;
        BufferedReader br ;
        String newLine;
        
        System.out.println("## VIEW : m1FileButton > pressed ##");
        try{
            fr = new FileReader(controller.getModel().getPasswordFile());
            br = new BufferedReader(fr);
            
            System.out.println("## view : m1FileButton ... file initialized ##");
            
            infoView.insertString(infoView.getLength(),"<== Regardez comment les hackers font \n",infoStyle);
            hackerView.insertString(hackerView.getLength(),"hacker01~$ cat .password\n\n",cmdStyle);
            while((newLine = br.readLine()) != null){
                System.out.println("## view : m1FileButton ... reading line ##");
                hackerView.insertString(hackerView.getLength(),newLine+"\n",attackStyle);
            }
            
        }catch(FileNotFoundException e){
            System.err.println(e);
        }catch(BadLocationException exc){
            System.err.println(exc);
        }catch(IOException ex) {
            System.err.println(ex);
        }
        
    }//GEN-LAST:event_m1FilebuttonMouseClicked
    
    private void m1HashButtonMouseClicked(MouseEvent evt) {//GEN-FIRST:event_m1HashButtonMouseClicked
        // TODO add your handling code here:
        try{
            System.out.println("## VIEW : m1HashButton > pressed ##");
            if (controller.getModel().getPasswordManager().testHashUser(m1HashField.getText())){
                System.out.println("## VIEW : m1FileButton ... good hash ##");
                infoView.insertString(infoView.getLength(),"Bon hash\n",succeedStyle);
                infoView.insertString(infoView.getLength(),"Lisez la prochaine mission ==> \n",infoStyle);
                mission1Panel.setVisible(false);
                mission2Panel.setVisible(true);
                hackerPane.setText("");
            }else{
                System.out.println("## VIEW : m1FileButton ... bad hash ##");
                infoView.insertString(infoView.getLength(),"Mauvais hash\n",errorStyle);
            }
        }catch(BadLocationException error){
            System.out.println(error);
        }
    }//GEN-LAST:event_m1HashButtonMouseClicked
    
    private void m2AddWordButtonMouseClicked(MouseEvent evt) {//GEN-FIRST:event_m2AddWordButtonMouseClicked
        // TODO add your handling code here:
        System.out.println("## VIEW : m2AddWordButton > pressed ##");
        controller.performAddWordToDict(m2TextField.getText(),(String) m2ListDic.getSelectedItem());
        try {
            infoView.insertString(infoView.getLength(),"Le mot " + m2TextField.getText()+ " ajouté au dictionnaire " +(String) m2ListDic.getSelectedItem() + " \n",infoStyle);
            hackerView.insertString(hackerView.getLength(),"Les hackers ne font que du remplissage automatique avec des outils\n\n",cmdStyle);
        } catch (BadLocationException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_m2AddWordButtonMouseClicked
    
    private void m2Mission3ButtonMouseClicked(MouseEvent evt) {//GEN-FIRST:event_m2Mission3ButtonMouseClicked
        // TODO add your handling code here:
        System.out.println("## VIEW : m2Mission3Button > pressed ##");
        try {
            if(firstVisit == true){
                infoPane.setText("");
                infoView.insertString(infoView.getLength(),"Lisez la prochaine mission ==> \n",infoStyle);
                firstVisit = false;
            }
            dictionnary = (String) m2ListDic.getSelectedItem();
        } catch (BadLocationException ex) {
            System.err.println(ex);
        }
        mission2Panel.setVisible(false);
        mission3Panel.setVisible(true);      
        hackerPane.setText("");
    }//GEN-LAST:event_m2Mission3ButtonMouseClicked
    
    private void m2AutoButtonMouseClicked(MouseEvent evt) {//GEN-FIRST:event_m2AutoButtonMouseClicked
        // TODO add your handling code here:
        try {
            infoView.insertString(infoView.getLength(),"<== Regarder comment les hackers font pour utiliser l'outil CRUNCH \n",infoStyle);
            hackerView.insertString(hackerView.getLength(),"hacker01~$ ./crunch 6 6 -f charset.lst lalpha -d 1@ >> " + (String) m2ListDic.getSelectedItem() + " \n",cmdStyle);
            hackerView.insertString(hackerView.getLength(),"Explication commande : \n"
                    + "1er chiffre : longueur minimale des mots \n"
                    + "2eme chiffre : longueur maximale des mots \n"
                    + "-f charset.lst lalpha : utilisation d'un certain nombre de lettre possible (alphabet en minuscule) \n"
                    + "-d 1@ : pas deux fois la même lettre côte à côte\n\n",cmdStyle);
            
           
            
            new Thread(new Runnable() {
                public void run() {
                    controller.launchAutoGenerator((String) m2ListDic.getSelectedItem());
                }
            }).start();
            
            
        } catch (BadLocationException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_m2AutoButtonMouseClicked
    
    private void m3FillDicoButtonMouseClicked(MouseEvent evt) {//GEN-FIRST:event_m3FillDicoButtonMouseClicked
        // TODO add your handling code here:
        System.out.println("## VIEW : m3FillDicoButton > pressed ##");
        try {
            infoView.insertString(infoView.getLength(),"Entrez de nouveaux mots dans le dictionnaire \n",infoStyle);
        } catch (BadLocationException ex) {
            System.err.println(ex);
        }
        mission3Panel.setVisible(false);
        mission2Panel.setVisible(true);
        hackerPane.setText("");
    }//GEN-LAST:event_m3FillDicoButtonMouseClicked
    
    private void m3AttackButtonMouseClicked(MouseEvent evt) {//GEN-FIRST:event_m3AttackButtonMouseClicked
        // TODO add your handling code here:
        System.out.println("## VIEW : m3AttackButton > pressed ##");
        try{
            infoView.insertString(infoView.getLength(),"<== Regarder comment les hackers font pour utiliser l'outil JOHN THE RIPPER \n",infoStyle);
            infoView.insertString(infoView.getLength(),"D'abord mettre le hash trouvé dans un fichier : hash.txt \n",infoStyle);
            infoView.insertString(infoView.getLength(),"Ensuite lancer la commande... \n",infoStyle);
            hackerView.insertString(hackerView.getLength(),"hacker01~$ echo " + controller.getModel().getPasswordManager().getHashStored() + " >> hash.txt \n",cmdStyle);
            hackerView.insertString(hackerView.getLength(),"hacker01~$ john --format=md5 --wordlist="+(String) m2ListDic.getSelectedItem()+" hash.txt \n",cmdStyle);
            hackerView.insertString(hackerView.getLength(),"Explication commande : \n"
                    + "--format : algorithme de hashage utilisé \n"
                    + "--wordlist : dictionnaire utilisé \n",cmdStyle);
                    
            new Thread(new Runnable() {
                public void run() {
                    controller.performAttack(dictionnary);
                }
            }).start();
           
        }catch (BadLocationException ex) {
            System.err.println(ex);
        }
    }//GEN-LAST:event_m3AttackButtonMouseClicked
    
    private void m3ConfirmButtonMouseClicked(MouseEvent evt) {//GEN-FIRST:event_m3ConfirmButtonMouseClicked
        // TODO add your handling code here:
        System.out.println("## VIEW : m3ConfirmButton > pressed ##");
        System.out.println("## VIEW : __ passfield = "+m3PassField.getText()+" __ passwordFound = "+controller.getModel().getPasswordManager().getPasswordFound()+" > pressed ##");
        if(m3PassField.getText().equals(controller.getModel().getPasswordManager().getPasswordFound())){
            try {
                infoView.insertString(infoView.getLength(),"Bon password\n",succeedStyle);
                infoView.insertString(infoView.getLength(),"** FIN **\n",infoStyle);
            } catch (BadLocationException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_m3ConfirmButtonMouseClicked
       
    private void m3FinButtonMouseClicked(MouseEvent evt) {//GEN-FIRST:event_m3FinButtonMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_m3FinButtonMouseClicked

    /* TEXT FIELD EVENT */
    private void m1HashFieldMouseClicked(MouseEvent evt) {//GEN-FIRST:event_m1HashFieldMouseClicked
        // TODO add your handling code here:
         m1HashField.setText("");
    }//GEN-LAST:event_m1HashFieldMouseClicked

    private void m2TextFieldMouseClicked(MouseEvent evt) {//GEN-FIRST:event_m2TextFieldMouseClicked
        // TODO add your handling code here:
         m2TextField.setText("");
    }//GEN-LAST:event_m2TextFieldMouseClicked

    private void m3PassFieldMouseClicked(MouseEvent evt) {//GEN-FIRST:event_m3PassFieldMouseClicked
        // TODO add your handling code here:
         m3PassField.setText("");
    }//GEN-LAST:event_m3PassFieldMouseClicked
    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel controlPanel;
    private javax.swing.JPanel entryPanel;
    private javax.swing.JButton entryPanelButton;
    private javax.swing.JScrollPane entryPanelScrollPanel;
    private javax.swing.JTextArea entryPanelText;
    private javax.swing.JLabel entryPanelTitle;
    private javax.swing.JPanel fullPanel;
    private javax.swing.JLabel hackerLabel;
    private javax.swing.JTextPane hackerPane;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JTextPane infoPane;
    private javax.swing.JLayeredPane layoutPanel;
    private javax.swing.JButton m1Filebutton;
    private javax.swing.JButton m1HashButton;
    private javax.swing.JTextField m1HashField;
    private javax.swing.JButton m2AddWordButton;
    private javax.swing.JButton m2AutoButton;
    private javax.swing.JLabel m2ChoisirDic;
    private javax.swing.JComboBox<String> m2ListDic;
    private javax.swing.JButton m2Mission3Button;
    private javax.swing.JTextField m2TextField;
    private javax.swing.JButton m3AttackButton;
    private javax.swing.JButton m3ConfirmButton;
    private javax.swing.JButton m3FillDicoButton;
    private javax.swing.JToggleButton m3FinButton;
    private javax.swing.JTextField m3PassField;
    private javax.swing.JPanel mission1Panel;
    private javax.swing.JPanel mission2Panel;
    private javax.swing.JPanel mission3Panel;
    private javax.swing.JLayeredPane missionLayeredPanel;
    private javax.swing.JLayeredPane missionPlacePanel;
    private javax.swing.JScrollPane scrollHackPane;
    private javax.swing.JScrollPane scrollInfoPane;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
    
    
    @Override
    public void setController(Controller c) {
        this.controller=c;
    }
    
    @Override
    public Controller getController() {
        return controller;
    }
    
    @Override
    public void printMessage(String message,String style){
        try {
            switch(style){
                case "errorStyle" :
                    infoView.insertString(infoView.getLength(),message,errorStyle);
                    break;
                case "succeedStyle" :
                    infoView.insertString(infoView.getLength(),message,succeedStyle);
                    break;
                default :
                    infoView.insertString(infoView.getLength(),message,infoStyle);
                    break;
            }
            
        } catch (BadLocationException ex) {
            System.err.println(ex);
        }
    }
    /*
    @Override
    public void setAppletDescriptionText(String s) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void setMissionDescriptionText(String s) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
}
