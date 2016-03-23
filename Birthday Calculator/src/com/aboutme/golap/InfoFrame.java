package com.aboutme.golap;
import javax.swing.*;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
public class InfoFrame extends JDialog 
{
	/*
	 * constructor of the class
	 */
	public InfoFrame() 
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "System look and feel error from InfoFrame Class");
		}
		informationPanelDeclaring();
		setFrameInfo();
	}
	
	/*
	 * information panel declaring
	 */
	public void informationPanelDeclaring()
	{
		informationPanel = new InFormationPanel();
		add(informationPanel);
	}

	/*
	 * set frame information
	 */
	public void setFrameInfo()
	{
		banglaFont = new Font("Siyam Rupali", Font.PLAIN, 15);
		setTitle("আমার সম্পর্কে!");
		setFont(banglaFont);
		setSize(295, 400);
		Image icon = Toolkit.getDefaultToolkit().getImage("src/FrameIcon.JPG");
		setIconImage(icon);
		setLocationRelativeTo(null);
		setModal(true);	
		setResizable(false);
		setVisible(true);	
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String args[])
	{
		new InfoFrame();
	}
//	
	/*
	 * declaring part of the class
	 */
	private InFormationPanel informationPanel;
	private Font banglaFont;
}
