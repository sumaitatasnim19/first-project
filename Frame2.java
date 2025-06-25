package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entities.*;


public class Frame2 extends JFrame implements MouseListener,ActionListener
{
	JLabel namelbl,passlbl,rtpasslbl,imglbl,hdrlbl,emailbl,captchalbl;
	JTextField namefld,emailfld,captchafld;
	JPasswordField passfld;
	JPasswordField rtpassfld;
	JButton rgstrbtn,backbtn;
	Color mycolor,lblcolor,hvrcolor;
	Font myfont,btnfont,hdrfont;
	ImageIcon img;
	JPanel panel;
	
	public Frame2()
	{
		super("Sign in Page");
		this.setSize(950,550);
		this.setLocationRelativeTo(null);
		
		mycolor=new Color(255,255,255);
		lblcolor=new Color(12,50,95);
		hvrcolor= new Color(255, 157, 1); 
		myfont=new Font("Calibri",Font.PLAIN,18);
		btnfont=new Font("Calibri",Font.PLAIN,20);
		hdrfont=new Font("Calibri",Font.PLAIN,30);
		
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(mycolor);
	
		hdrlbl=new JLabel("SIGN UP");
		hdrlbl.setBounds(180,80,200,50);
		hdrlbl.setBackground(lblcolor);
		hdrlbl.setOpaque(false);
		hdrlbl.setForeground(Color.BLACK);
		hdrlbl.setFont(hdrfont);
		panel.add(hdrlbl);
		
		
		namelbl=new JLabel("Username:");
		namelbl.setBounds(80,150,150,30);
		namelbl.setBackground(lblcolor);
		namelbl.setOpaque(false);
		namelbl.setForeground(Color.BLACK);
		namelbl.setFont(myfont);
		panel.add(namelbl);
		
		namefld=new JTextField();
		namefld.setBounds(210,150,200,30);
		panel.add(namefld);
		
		emailbl=new JLabel("Email:");
		emailbl.setBounds(80,190,150,30);
		emailbl.setBackground(lblcolor);
		emailbl.setOpaque(false);
		emailbl.setForeground(Color.BLACK);
		emailbl.setFont(myfont);
		panel.add(emailbl);
		
		emailfld=new JTextField();
		emailfld.setBounds(210,190,200,30);
		panel.add(emailfld);
		
		passlbl=new JLabel("Password:");
		passlbl.setBounds(80,230,150,30);
		passlbl.setBackground(lblcolor);
		passlbl.setOpaque(false);
		passlbl.setFont(myfont);
		passlbl.setForeground(Color.BLACK);
		panel.add(passlbl);
		
		passfld=new JPasswordField();
		passfld.setBounds(210,230,200,30);
		passfld.setEchoChar('*');
		panel.add(passfld);
		
		rtpasslbl=new JLabel("Retype Password:");
		rtpasslbl.setBounds(80,270,250,30);
		rtpasslbl.setBackground(lblcolor);
		rtpasslbl.setOpaque(false);
		rtpasslbl.setForeground(Color.BLACK);
		rtpasslbl.setFont(myfont);
		panel.add(rtpasslbl);
		
		rtpassfld=new JPasswordField();
		rtpassfld.setBounds(210,270,200,30);
		rtpassfld.setEchoChar('*');
		panel.add(rtpassfld);
		
		captchalbl=new JLabel("20+15");
		captchalbl.setBounds(80,310,250,30);
		captchalbl.setBackground(lblcolor);
		captchalbl.setForeground(Color.BLACK);
		captchalbl.setFont(myfont);
		panel.add(captchalbl);
		
		captchafld=new JTextField();
		captchafld.setBounds(210,310,100,30);
		panel.add(captchafld);
		
		
		
		rgstrbtn=new JButton("Register");
		rgstrbtn.setBounds(290,430,100,40);
		rgstrbtn.setBackground(lblcolor);
		rgstrbtn.setForeground(Color.WHITE);
		rgstrbtn.setFont(btnfont);
		rgstrbtn.addMouseListener(this);
		rgstrbtn.addActionListener(this);
		panel.add(rgstrbtn);
		
		
		backbtn=new JButton("Back");
		backbtn.setBounds(100,430,100,40);
		backbtn.setBackground(lblcolor);
		backbtn.setForeground(Color.WHITE);
		backbtn.setFont(btnfont);
		backbtn.addActionListener(this);
		backbtn.addMouseListener(this);
		panel.add(backbtn);
		
		img=new ImageIcon("F://Java Project//Contact Management System//Images//background2.jpg");
		imglbl=new JLabel(img);
		imglbl.setBounds(475,0,475,580);
		panel.add(imglbl);
		
		
		this.add(panel);
	}
	
	
	@Override
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource()==backbtn)
		{
			backbtn.setBackground(hvrcolor);
			backbtn.setForeground(Color.BLACK);
		}
		else if(me.getSource()==rgstrbtn)
		{
			rgstrbtn.setBackground(hvrcolor);
			rgstrbtn.setForeground(Color.BLACK);
		}
		
	}
	@Override
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource()==backbtn)
		{
			backbtn.setBackground(lblcolor);
			backbtn.setForeground(Color.WHITE);
		}
		else if(me.getSource()==rgstrbtn)
		{
			rgstrbtn.setBackground(lblcolor);
			rgstrbtn.setForeground(Color.WHITE);
		}
	} 
	@Override public void mouseClicked(MouseEvent me) {}
    @Override public void mousePressed(MouseEvent me) {}
    @Override public void mouseReleased(MouseEvent me) {}
	
		@Override
		public void actionPerformed(ActionEvent ae)
	{
		String s1=namefld.getText();
		String s2=passfld.getText();
		String s3=rtpassfld.getText();
		String s4=emailfld.getText();
		String s5=captchafld.getText();
		
		if (ae.getSource()==backbtn)
		{
            this.setVisible(false);
			Frame1 f1=new Frame1();
			f1.setVisible(true);
			return;
		}
		
		if (s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty())//if all fields r empty
		{
			JOptionPane.showMessageDialog(null, "Please fill up all fields");
		}
		else if (!s2.equals(s3))
			{
               JOptionPane.showMessageDialog(null, "Passwords do not match!","Warning",JOptionPane.ERROR_MESSAGE);
			}
		else if (!s5.equals("35"))
		{
			JOptionPane.showMessageDialog(null,"Incorrect Captcha");
		}
		else 
		{
                Account acc=new Account();
                boolean created = acc.createAccount(s1,s2,s4); 
                if (created)
				{
                    JOptionPane.showMessageDialog(null, "Account created successfully.");
				}
          
                 else
				 {
                    JOptionPane.showMessageDialog(null, "Account could not be created. Please try a different username.");
				 }
                
            
        }

	}
		
				

	
}

	