package Frames;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import Entities.*;

public class ViewContact extends JFrame implements MouseListener, ActionListener
{
    JLabel titlelbl;
    JTable table;
    JTextField searchfld;
    JButton searchbtn, backbtn;
    Color mycolor, lblcolor,hvrcolor;
    Font myfont;
	JScrollPane scrollPane;
    JPanel panel;
    String[]col={"Name","Phone","Email","Address"};
    String[][] row;
    private boolean isEditing=false;

    public ViewContact()
	{
        super("View Contact");
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
		
        mycolor=new Color(255,255,255);
        lblcolor=new Color(201,219,255);
		hvrcolor=new Color(255,239,168);
        myfont=new Font("Calibri",Font.PLAIN,20);
        panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(mycolor);

        titlelbl=new JLabel("Contact Details");
        titlelbl.setBounds(300,10,300,40);
        titlelbl.setFont(new Font("Calibri",Font.PLAIN,30));
        panel.add(titlelbl);

        searchfld=new JTextField();
        searchfld.setBounds(570,60,150,30);
        panel.add(searchfld);

        searchbtn=new JButton("Search");
        searchbtn.setBounds(450,60,100,30);
        searchbtn.setBackground(lblcolor);
        searchbtn.setFont(myfont);
        searchbtn.addActionListener(this);
        panel.add(searchbtn);

        row=loadData();
        table=new JTable(new DefaultTableModel(row,col)
		{
            @Override
            public boolean isCellEditable(int row,int column)
			{
                return isEditing;
            }
        });
		
        scrollPane=new JScrollPane(table);
        scrollPane.setBounds(30,110,720,230);
        panel.add(scrollPane);

        backbtn=new JButton("Back");
        backbtn.setBounds(30,370,100,30);
        backbtn.setBackground(lblcolor);
        backbtn.setFont(myfont);
        backbtn.addMouseListener(this);
        backbtn.addActionListener(this);
        panel.add(backbtn);

        this.add(panel);
    }

  
    public String[][] loadData()
	{
        String[][] data=new String[10][4];
        int count=0;

        try (BufferedReader br=new BufferedReader(new FileReader("contacts.txt")))
		{
            String line;
            while ((line = br.readLine())!= null)
			{
                String[] parts=line.split(",");
                if (parts.length==4)
				{
                    data[count]=parts;
                    count++;
                }
            }
        } 
		catch (IOException e)
		{
            JOptionPane.showMessageDialog(null, "Error reading contacts.txt");
        }

        String[][] result=new String[count][4];
        for (int i=0; i<count; i++)
		{
            result[i]=data[i];
        }
        return result;
    }

    
    public void refreshTable()
	{
        row = loadData();
        table.setModel(new DefaultTableModel(row, col)
		{
            @Override
            public boolean isCellEditable(int row, int column) {
                return isEditing;
            }
        });
    }


    @Override
    public void mouseEntered(MouseEvent me)
	{
        if (me.getSource()==backbtn)
		{
            backbtn.setBackground(hvrcolor);
        }
    }

    @Override
    public void mouseExited(MouseEvent me)
	{
        if (me.getSource()==backbtn)
		{
            backbtn.setBackground(lblcolor);
        }
    }
	
	@Override public void mouseClicked(MouseEvent me) {}
    @Override public void mousePressed(MouseEvent me) {}
    @Override public void mouseReleased(MouseEvent me) {}
	
           @Override
         public void actionPerformed(ActionEvent ae)
		 {
			 if (ae.getSource()==backbtn)
			 {
				 this.setVisible(false);
                 new Homepage().setVisible(true);
			 }
			 else if (ae.getSource()==searchbtn)
			 {
				 String query=searchfld.getText().toLowerCase();
				 if (query.isEmpty())
				 {
					  refreshTable();
                      return;
				 }
			 }
			 String[][] fullData=loadData();
             DefaultTableModel model=new DefaultTableModel(col, 0);
			 for (String[] row:fullData)
			 {
				 String rowData=String.join(",", row).toLowerCase();
				 if (rowData.contains(query))
				 {
					 model.addRow(row);
				 }
			 }
			 if (model.getRowCount()==0)
			 {
				 JOptionPane.showMessageDialog(null, "No matching contacts found.", "Search Result", JOptionPane.ERROR_MESSAGE);
			 }
			 else
			 {
				 table.setModel(model);
			 }
		 }
}
		 

				 
            
        
			 
				 
                
           
			 
    
	
        
      
        
         
           
        
        
         
            
             
        
         
            
         

