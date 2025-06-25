package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entities.*;

public class Homepage extends JFrame implements MouseListener,ActionListener
{
	JLabel titlelbl,imglbl;
    JButton addbtn,viewbtn,searchbtn,backbtn;
	Color mycolor,lblcolor,hvrcolor;
	Font btnfont,titleFont;
	ImageIcon img;
	JPanel panel;
	
	public Homepage()
	{
		super("Contact Management System");
		this.setSize(610,350);
		this.setLocationRelativeTo(null);
		
		mycolor=new Color(255,255,255);
		lblcolor=new Color(102,195,212);
		hvrcolor=new Color(255,239,168);
		btnfont=new Font("Calibri",Font.PLAIN,20);
		titleFont=new Font("Calibri",Font.PLAIN,30);
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(mycolor);
		
	
	    titlelbl = new JLabel("Contact Book");
		titlelbl.setBounds(210,20,400,40);
		titlelbl.setFont(titleFont);
		titlelbl.setForeground(Color.BLACK);
		titlelbl.setOpaque(false);
		panel.add(titlelbl);
		
		
		addbtn=new JButton("Add Contact");
		addbtn.setBounds(210,80,170,40);
		addbtn.setBackground(lblcolor);
		addbtn.setForeground(Color.WHITE);
		addbtn.setFont(btnfont);
		addbtn.addMouseListener(this);
		addbtn.addActionListener(this);
		panel.add(addbtn);
		
		viewbtn=new JButton("View Contact");
		viewbtn.setBounds(210,140,170,40);
		viewbtn.setBackground(lblcolor);
		viewbtn.setForeground(Color.BLACK);
		viewbtn.setFont(btnfont);
		viewbtn.addMouseListener(this);
		viewbtn.addActionListener(this);
		panel.add(viewbtn);
		
		
		backbtn=new JButton("Back");
		backbtn.setBounds(80,210,120,40);
		backbtn.setBackground(lblcolor);
		backbtn.setForeground(Color.BLACK);
		backbtn.addMouseListener(this);
		backbtn.addActionListener(this);
		backbtn.setFont(btnfont);
		backbtn.addMouseListener(this);
		panel.add(backbtn);
		
		img=new ImageIcon("F://Java Project//Contact Management System//Images//background3.jpg");
		imglbl=new JLabel(img);
		imglbl.setBounds(0,0,610,350);
		panel.add(imglbl);
		
		this.add(panel);
		
	}
		
	@Override
	public void mouseEntered(MouseEvent me)
	{
		
	  if(me.getSource()==addbtn)
		{
			addbtn.setBackground(hvrcolor);
			addbtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()==viewbtn)
		{
			viewbtn.setBackground(hvrcolor);
			viewbtn.setForeground(Color.BLACK);
		}
		
		else if(me.getSource()==backbtn)
		{
			backbtn.setBackground(hvrcolor);
			backbtn.setForeground(Color.BLACK);
		}
		
	}
	@Override
	public void mouseExited(MouseEvent me)
	{
		if (me.getSource()==addbtn)
		{
			addbtn.setBackground(lblcolor);
			addbtn.setForeground(Color.WHITE);
		}
		if (me.getSource()==viewbtn)
		{
			viewbtn.setBackground(lblcolor);
			viewbtn.setForeground(Color.WHITE);
		}
		
		if(me.getSource()==backbtn)
		{
			backbtn.setBackground(lblcolor);
			backbtn.setForeground(Color.WHITE);
		}
	}
	@Override public void mouseClicked(MouseEvent me) {}
    @Override public void mousePressed(MouseEvent me) {}
    @Override public void mouseReleased(MouseEvent me) {}
	
	    @Override
	    public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==addbtn)
		{
			this.setVisible(false);
			AddContact a1= new AddContact();
			a1.setVisible(true);
		}
		if (ae.getSource()==viewbtn)
		{
			this.setVisible(false);
			ViewContact v1=new ViewContact();
			v1.setVisible(true);
		}
		
		if (ae.getSource()==backbtn)
		{
			this.setVisible(false);
			Frame1 f1=new Frame1();
			f1.setVisible(true);
		}
		
		
	}
	
	

		
		
	
}