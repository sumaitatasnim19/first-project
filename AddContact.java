package Frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entities.*;


public class AddContact extends JFrame
implements MouseListener,ActionListener
{
	JLabel namelbl,phnlbl,emaillbl,addresslbl,hdrlbl;
	JTextField namefld,phnfld,emailfld,addressfld;
	JButton savebtn,lgnbtn,backbtn,addbtn;
    Color mycolor,lblcolor,hvrcolor;
	Font myfont;
	JPanel panel;
	
	public AddContact()
	{
		super("Add Contact");
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		mycolor=new Color(255,255,255);
		lblcolor=new Color(255,239,168);
		hvrcolor=new Color(102,195,212);
		
		myfont=new Font("Calibri",Font.PLAIN,20);
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(mycolor);
		
	
	    namelbl=new JLabel("Name:");
		namelbl.setBounds(100,50,85,40);
		namelbl.setBackground(lblcolor);
		namelbl.setOpaque(true);
		namelbl.setForeground(Color.BLACK);
		namelbl.setFont(myfont);
		panel.add(namelbl);
		
		namefld=new JTextField();
		namefld.setBounds(200,50,250,40);
		panel.add(namefld);
		
		phnlbl=new JLabel("Phone:");
		phnlbl.setBounds(100,100,85,40);
		phnlbl.setBackground(lblcolor);
		phnlbl.setOpaque(true);
		phnlbl.setForeground(Color.BLACK);
		phnlbl.setFont(myfont);
		panel.add(phnlbl);
		
		phnfld = new JTextField();
		phnfld.setBounds(200,100,250,40);
		panel.add(phnfld);
		
		emaillbl = new JLabel("Email:");
		emaillbl.setBounds(100,150,85,40);
		emaillbl.setBackground(lblcolor);
		emaillbl.setOpaque(true);
		emaillbl.setForeground(Color.BLACK);
		emaillbl.setFont(myfont);
		panel.add(emaillbl);
		
		emailfld = new JTextField();
		emailfld.setBounds(200,150,250,40);
		panel.add(emailfld);
		
		addresslbl = new JLabel("Address:");
		addresslbl.setBounds(100,200,85,40);
		addresslbl.setBackground(lblcolor);
		addresslbl.setOpaque(true);
		addresslbl.setForeground(Color.BLACK);
		addresslbl.setFont(myfont);
		panel.add(addresslbl);
		
		addressfld = new JTextField();
		addressfld.setBounds(200,200,250,40);
		panel.add(addressfld);
		
		addbtn = new JButton("Save Contact");
        addbtn.setBounds(350,280,130,40);
        addbtn.setBackground(lblcolor);
        addbtn.addMouseListener(this);
        addbtn.addActionListener(this);
        panel.add(addbtn);
		
		backbtn = new JButton("Back");
		backbtn.setBounds(100,280,150,40);
		backbtn.setBackground(lblcolor);
		backbtn.addMouseListener(this);
		backbtn.addActionListener(this);
		panel.add(backbtn);
		
		
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
		else if (me.getSource()==addbtn)
		{
			addbtn.setBackground(hvrcolor);
			addbtn.setForeground(Color.BLACK);
		}
			
		
	}
	@Override
	public void mouseExited(MouseEvent me)
	{
	  if(me.getSource()==backbtn)
		{
			backbtn.setBackground(lblcolor);
			backbtn.setForeground(Color.BLACK);
		}
	  if (me.getSource()==addbtn)
	    {
		 addbtn.setBackground(lblcolor);
		 addbtn.setForeground(Color.BLACK);
	    }

	}
	@Override public void mouseClicked(MouseEvent me) {}
    @Override public void mousePressed(MouseEvent me) {}
    @Override public void mouseReleased(MouseEvent me) {}
	
	    @Override
	    public void actionPerformed(ActionEvent ae)
	{
		   String s1=namefld.getText();
		   String s2=phnfld.getText();
		   String s3=emailfld.getText();
		   String s4=addressfld.getText();
		   
		   
		if (ae.getSource()==addbtn)
		{
			if (s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please fill up all fields!");
			}
			else if(!s2.matches("\\d+"))
			{
			    JOptionPane.showMessageDialog(null, "Phone number must contain only digits!");
			}
			else if(!s2.matches("\\d{11}"))
				{
					JOptionPane.showMessageDialog(null, "Invalid Phone Number!");
				}
			else if(!s3.contains("@")||!s3.endsWith(".com"))
			{
				JOptionPane.showMessageDialog(null, "Invalid Email!");
			}
				
            else 
			{
               ContactAccount ca=new ContactAccount();
               boolean saved=ca.saveContact(s1, s2, s3, s4);

                 if (saved)
				 {
                     JOptionPane.showMessageDialog(null,"Contact Added Successfully!");
                      namefld.setText("");
                      phnfld.setText("");
                      emailfld.setText("");
                      addressfld.setText("");
				 }
				 else
				 {
					 JOptionPane.showMessageDialog(null, "Failed to save contact.");
				 }
			}
		}
		else if (ae.getSource()==backbtn)
		{
			this.setVisible(false);
		    Homepage h1=new Homepage();
	        h1.setVisible(true);
		}
	}
}
	
		
		
	
                    
						
				
		
		
				 
                    
					
						
					 
                     
		
		

              
	


	
