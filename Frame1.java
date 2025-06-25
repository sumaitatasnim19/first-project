package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entities.*;


public class Frame1 extends JFrame implements MouseListener, ActionListener
{
	JLabel namelbl,passlbl,imglbl,hdrlbl,titlelbl;
	JTextField namefld;
	JPasswordField passfld;
	JButton lgnbtn,rgstrbtn,backbtn;
	Color mycolor,lblcolor,hvrcolor;
	Font myfont,btnfont,hdrfont,titlefont;
	ImageIcon img;
	JPanel panel;
	
	public Frame1()
	{
		super("Login Page");
		this.setSize(950,550);
		this.setLocationRelativeTo(null);
		
		mycolor=new Color(255,255,255);
		lblcolor=new Color(12,50,95);
		hvrcolor= new Color(255, 157, 1); 
		myfont=new Font("Calibri",Font.PLAIN,25);
		btnfont=new Font("Calibri",Font.PLAIN,20);
		hdrfont=new Font("Calibri",Font.PLAIN,30);
		titlefont=new Font("Calibri",Font.PLAIN,35);
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(mycolor);

		
		hdrlbl=new JLabel("LOGIN");
		hdrlbl.setBounds(630,100,200,50);
		hdrlbl.setBackground(lblcolor);
		hdrlbl.setOpaque(false);
		hdrlbl.setForeground(Color.BLACK);
		hdrlbl.setFont(hdrfont);
		panel.add(hdrlbl);
		
		titlelbl=new JLabel("Welcome To Contact Book");
		titlelbl.setBounds(500,50,400,50);
		titlelbl.setBackground(lblcolor);
		titlelbl.setOpaque(false);
		titlelbl.setForeground(Color.BLACK);
		titlelbl.setFont(titlefont);
		panel.add(titlelbl);
		
		namelbl=new JLabel("Username:");
		namelbl.setBounds(500,200,150,30);
		namelbl.setBackground(lblcolor);
		namelbl.setOpaque(false);
		namelbl.setForeground(Color.BLACK);
		namelbl.setFont(myfont);
		panel.add(namelbl);
		
		namefld=new JTextField();
		namefld.setBounds(650,200,200,30);
		panel.add(namefld);
		
		passlbl=new JLabel("Password:");
		passlbl.setBounds(500,240,150,30);
		passlbl.setBackground(lblcolor);
		passlbl.setOpaque(false);
		passlbl.setFont(myfont);
		passlbl.setForeground(Color.BLACK);
		panel.add(passlbl);
		
		passfld=new JPasswordField();
		passfld.setBounds(650,240,200,30);
		passfld.setEchoChar('*');
		panel.add(passfld);
		
		lgnbtn=new JButton("Log In");
		lgnbtn.setBounds(750,430,120,40);
		lgnbtn.setBackground(lblcolor);
		lgnbtn.setForeground(Color.WHITE);
		lgnbtn.setFont(btnfont);
		lgnbtn.addMouseListener(this);
		lgnbtn.addActionListener(this);
		panel.add(lgnbtn);
		
		rgstrbtn=new JButton("Register");
		rgstrbtn.setBounds(550,430,120,40);
		rgstrbtn.setBackground(lblcolor);
		rgstrbtn.setForeground(Color.WHITE);
		rgstrbtn.setFont(btnfont);
		rgstrbtn.addMouseListener(this);
		rgstrbtn.addActionListener(this);
		panel.add(rgstrbtn);
		
		
		img=new ImageIcon("F://Java Project//Contact Management System//Images//background.jpg");
		imglbl=new JLabel(img);
		imglbl.setBounds(0,0,475,580);
		panel.add(imglbl);
		
		
		
		
		this.add(panel);
	}
	public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==lgnbtn)
		{
			lgnbtn.setBackground(hvrcolor);
			lgnbtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()==rgstrbtn)
		{
			rgstrbtn.setBackground(hvrcolor);
			rgstrbtn.setForeground(Color.BLACK);
		}
		
	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==lgnbtn)
		{
			lgnbtn.setBackground(lblcolor);
			lgnbtn.setForeground(Color.WHITE);
		}
		else if(me.getSource()==rgstrbtn)
		{
			rgstrbtn.setBackground(lblcolor);
			rgstrbtn.setForeground(Color.WHITE);
		}
	}
		
		public void actionPerformed(ActionEvent ae)
	{
		String s1=namefld.getText();
		String s2=passfld.getText();
		if(ae.getSource()==rgstrbtn)
		{
			this.setVisible(false);
			Frame2 f2=new Frame2();
			f2.setVisible(true);
		}
		else if(ae.getSource()==lgnbtn)
		{
			Account a1=new Account();
			if(a1.getAccount(s1,s2)==true)
			{
				JOptionPane.showMessageDialog(null,"Valid");
			this.setVisible(false);
			Homepage h1=new Homepage();
			h1.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Username and Password does not match!","Warning",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	
}
	
	
