package com.contacs.welcome;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.birthdaycalculator.golap.main.Main;


public class WelcomeClass extends JPanel implements Runnable 
{
	JDialog welcomeDialog;

	Thread thread;
    /**
     * Creates new form WelcomeDialog
     */
    public WelcomeClass() {
        
    	
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception ex)
        {
            
        }
        
        thread = new Thread((Runnable) this);
        
        //System.out.println("step 1");
        
        titleLabel = new JLabel("Welcome to AgeCalculator");
        add(titleLabel);
        developerLabel = new JLabel("");
        add(developerLabel);
        welcomeProgressBar = new javax.swing.JProgressBar(0, 200);
        add(welcomeProgressBar);

        titleLabel.setFont(new java.awt.Font("Segoe Script", 0, 36)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 0, 0));
        //titleLabel.setText("Welcome to Contacts");

        developerLabel.setText("Developed by Engr. Md. Kamrul Hasan Golap");
        developerLabel.setForeground(Color.GREEN);
        
        thread.start();
        
        //System.out.println("step 2");
        
        
        setBackground(new Color(0, 0, 0));
        welcomeDialog = new JDialog();
        welcomeDialog.setSize(520, 100);
        welcomeDialog.add(this);
    	welcomeDialog.setUndecorated(true);
    	welcomeDialog.setLocationRelativeTo(null);
    	welcomeDialog.setVisible(true);
    }
    
    protected void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
    	
    	
    }

   
    private Main mainClass;
    
    // Variables declaration - do not modify                     
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel developerLabel;
    private javax.swing.JProgressBar welcomeProgressBar;
    // End of variables declaration                   
    
    @Override
    public void run() {
        int i=0;
        try {
            thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(WelcomeClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        int c1=0, c2=0, c3=0;
        while(i<2000)
        {
            try
            {
                setBackground(new Color(c1, c2, c3));
                welcomeProgressBar.setValue(i);
                welcomeProgressBar.setBackground(new Color(250, 250, i));
                thread.sleep(10);
                if(c1 != 250) c1++;
                if(c2 != 250) c2++;
                if(c3 != 250) c3++;
            }catch(Exception e)
            {

            }
            
            i++;
        }
        
        welcomeDialog.dispose();
        mainClass = new Main();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new WelcomeClass();
	}

}
