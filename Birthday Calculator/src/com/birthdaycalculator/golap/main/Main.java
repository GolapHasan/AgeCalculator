package com.birthdaycalculator.golap.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.aboutme.golap.InfoFrame;

public class Main extends JPanel 
{
	public Main() 
	{
		setSystemLookandFeel();
		variableDeclaring();
		frameDeclaring();
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int x=10, y=50;
		timeFormatLabel.setLocation(x+150, y-20);
		birthDateLabel.setLocation(x+20, y);
		currentDateLabel.setLocation(x+20, y+30);
		
		birthDayComboBox.setLocation(x+150, y);
		birthMonthComboBox.setLocation(x+200, y);
		birthYearCombobox.setLocation(x+250, y);
		currentDayComboBox.setLocation(x+150, y+30);
		currentMonthComboBox.setLocation(x+200, y+30);
		currentYearCombobox.setLocation(x+250, y+30);
		
		calculateButton.setSize(150, 25);
		calculateButton.setLocation(x+150, y+60);
		
		ageLabel.setLocation(x+10, y+100);
		ageYear.setLocation(x+105, y+100);
		ageMonth.setLocation(x+175, y+100);
		ageDay.setLocation(x+235, y+100);
		
		aboutMe.setSize(150, 25);
		aboutMe.setLocation(x+150, getHeight()-40);
	}

	public static void main(String[] args) 
	{
		new Main();
	}
	
	private class ButtonHandler implements ActionListener
	{

		public void actionPerformed(ActionEvent event) 
		{
			if(event.getSource() == calculateButton)
			{
				//System.out.println("ok");
				calculateAge();
			}
			else if(event.getSource() == aboutMe)
			{
				new InfoFrame();
			}
		}
		
	}
	
	public void calculateAge()
	{
		int birthDay, birthMonth, birtYear, currentDay, currentMonth, currntYear, day, month, year;
		birthDay = Integer.parseInt(birthDayComboBox.getSelectedItem().toString());
		birthMonth = Integer.parseInt(birthMonthComboBox.getSelectedItem().toString());
		birtYear = Integer.parseInt(birthYearCombobox.getSelectedItem().toString());
		
		currentDay = Integer.parseInt(currentDayComboBox.getSelectedItem().toString());
		currentMonth = Integer.parseInt(currentMonthComboBox.getSelectedItem().toString());
		currntYear = Integer.parseInt(currentYearCombobox.getSelectedItem().toString());
		
		if(currentDay < birthDay)
		{
			currentDay += 30;
			birthMonth++;
		}		
		day = currentDay - birthDay;
		
		if(currentMonth < birthMonth)
		{
			currentMonth += 12;
			birtYear++;
		}
		month = currentMonth - birthMonth;
		
		if(currntYear < birtYear)
		{
			ageLabel.setText("আপনি ভুল ইনপুট দিয়েছেন" + "।");
			ageYear.setText("");
			ageMonth.setText("");
			ageDay.setText("");
			return;
		}
		year = currntYear - birtYear;
		
		String y, m, d;
		y = year<100? year<10? "00"+year : "0"+year : "" + year;
		m = month<10? "0"+month : ""+month;
		d = day<10? "0"+day : ""+day;
		ageYear.setText(y + "");
		ageMonth.setText(m + "");
		
		ageDay.setText(d + "");
		ageLabel.setText("আপনার বয়সঃ        বছর       মাস        দিন ");
	}
	
	public void variableDeclaring()
	{
		banglaFont = new Font("Siyam Rupali", Font.PLAIN, 15);
		buttonHandler = new ButtonHandler();
		
		/*Start of comboBox declaring*/
		String[] day = new String[31];
		String[] month = new String[12];
		String[] year = new String[150];
		
		for(int i=0; i<31; i++)
			day[i] = "" + (i+1);		
		for(int i=0; i<12; i++)
			month[i] = "" + (i+1);
		for(int i=0; i<150; i++)
			year[i] = "" + (i+1950);
		
		GregorianCalendar calendar = new GregorianCalendar();
		
		birthDayComboBox = new JComboBox(day);
		birthDayComboBox.setSelectedItem("9");
		add(birthDayComboBox);
		currentDayComboBox = new JComboBox(day);
		currentDayComboBox.setSelectedItem("" + calendar.get(Calendar.DATE));
		add(currentDayComboBox);
		
		birthMonthComboBox = new JComboBox(month);
		birthMonthComboBox.setSelectedItem("6");
		add(birthMonthComboBox);
		currentMonthComboBox = new JComboBox(month);
		currentMonthComboBox.setSelectedItem("" + calendar.get(Calendar.MONTH));
		add(currentMonthComboBox);
		
		birthYearCombobox = new JComboBox(year);
		birthYearCombobox.setSelectedItem("1991");
		add(birthYearCombobox);
		currentYearCombobox = new JComboBox(year);
		currentYearCombobox.setSelectedItem("" + calendar.get(Calendar.YEAR));
		add(currentYearCombobox);
		/*End of comboBox declaring*/
		
		/*Start of Label declaring*/
		birthDateLabel = new JLabel("জন্ম তারিখঃ ");
		birthDateLabel.setFont(banglaFont);
		add(birthDateLabel);
		currentDateLabel = new JLabel("বর্তমান তারিখঃ ");
		currentDateLabel.setFont(banglaFont);
		add(currentDateLabel);
		
		timeFormatLabel = new JLabel("দিন     মাস      বছর");
		timeFormatLabel.setFont(banglaFont);
		add(timeFormatLabel);
		
		ageLabel = new JLabel();
		ageLabel.setFont(banglaFont);
		add(ageLabel);
		
		ageYear = new JLabel();
		ageYear.setFont(new Font("", Font.PLAIN, 20));
		ageYear.setForeground(Color.BLUE);
		add(ageYear);
		ageMonth = new JLabel();
		ageMonth.setFont(new Font("", Font.PLAIN, 20));
		ageMonth.setForeground(Color.RED);
		add(ageMonth);
		ageDay = new JLabel();
		ageDay.setFont(new Font("", Font.PLAIN, 20));
		ageDay.setForeground(Color.MAGENTA);
		add(ageDay);
		/*End of Label declaring*/
		
		/*Start of Button declaring*/
		calculateButton = new JButton("বয়স");
		calculateButton.setFont(banglaFont);
		calculateButton.addActionListener(buttonHandler);
		add(calculateButton);
		
		aboutMe = new JButton("কে আমি?");
		aboutMe.setFont(banglaFont);
		aboutMe.addActionListener(buttonHandler);
		add(aboutMe);
		/*End of Button declaring*/
		
	}
	
	public void frameDeclaring()
	{
		mainFrame = new JFrame("বয়স ক্যালকুলেটর");
		mainFrame.add(this);
		mainFrame.setFont(banglaFont);
		mainFrame.setSize(350, 300);
		mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
	}
	
	public void setSystemLookandFeel()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{}
	}
	
	/* variable declaration */
	private JFrame mainFrame;
	private Font banglaFont;
	private JComboBox birthDayComboBox, birthMonthComboBox, birthYearCombobox, currentDayComboBox, currentMonthComboBox, currentYearCombobox;
	private JLabel birthDateLabel, currentDateLabel, timeFormatLabel, ageLabel, ageYear, ageMonth, ageDay;
	private JButton calculateButton, aboutMe;
	private ButtonHandler buttonHandler;

}
