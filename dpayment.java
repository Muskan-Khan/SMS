import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.Calendar;
import java.util.*;
import javax.swing.table.DefaultTableModel;
public class dpayment extends Frame implements ActionListener
{
	JTable table1 =new JTable();
	JScrollPane sp;

	JButton bsearch=new JButton("Search");	
	JButton bprint=new JButton("Print");
	JButton bclose=new JButton("Close");
	JLabel lbl=new JLabel("Report on Daily Payments");
	JLabel lbldate=new JLabel("Enter Date(Eg:01/01/2017):");
	JTextField txdate=new JTextField(10);
	String m,n,o,p;
	JTable table2;
	String[] col={"Receipt No","Booking ID","Amount paid"};
	Object[] [] data={{m,n,o}};
	DefaultTableModel model=new DefaultTableModel(col,0);	
	public dpayment()
	{
		setLayout(null);
		setVisible(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(2100,1200);
	
		lbl.setForeground(Color.red);
		lbl.setFont(new Font("Comic Sans MS",Font.BOLD,40));
		lbl.setBounds(600,150,600,80);
	
		table2=new JTable(data,col);
		sp=new JScrollPane(table2);
		table2.setModel(model);
     		setBackground(new Color(234,255,229));
		lbldate.setBackground(new Color(250,150,80));
               	lbldate.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		
     		lbldate.setBounds(500,300,450,60);
                	txdate.setBounds(810,300,140,60);
		table2.setBounds(500,400,800,500);
		sp.setBounds(500,400,800,500); 	
		table2.setFillsViewportHeight(true);
		add(sp);
    		add(lbldate);
		add(txdate);
		add(lbl);
    		bsearch.addActionListener(this);
		bclose.addActionListener(this);
		bprint.addActionListener(this);			
               	
		bsearch.setBounds(1050,300,100,50);
		bprint.setBounds(1150,300,100,50);
		bclose.setBounds(1250,300,100,50);

		add(bclose); 
		add(bsearch);
		add(bprint);
		bsearch.addActionListener(this);
		bclose.addActionListener(this);
		bprint.addActionListener(this);
		repaint();
		}
		public void actionPerformed(ActionEvent e)
		{
			table2.setModel(model);
			if(e.getSource()==bsearch)
			{
				int flg=0; 
				model.setRowCount(0);
                                      		  	char d1=txdate.getText().charAt(0);
						char d2=txdate.getText().charAt(1);
						char d3=txdate.getText().charAt(2);
						char d4=txdate.getText().charAt(3);
				                      char d5=txdate.getText().charAt(4);
						 char d6=txdate.getText().charAt(5);
						char d7=txdate.getText().charAt(6);
						 char d8=txdate.getText().charAt(7);
				                      char d9=txdate.getText().charAt(8);
						 char d10=txdate.getText().charAt(9);
                     					if((d1>='0' && d1<='9')&&(d2>='0' && d2<='9')&&(d4>='0' && d4<='9')&&(d5>='0' && d5<='9')&&(d7>='0' && d7<='9')&&(d8>='0' && d8<='9')&&(d9>='0' && d9<='9')&&(d10>='0' && d10<='9')&&d3=='/' && d6=='/')
                   					////////////////////////////////////////
                   					{
						try
						{
						Connection con;
						ResultSet res;
						String[] col={"Receipt No","Booking ID","Amount Paid"};
						String bdate=txdate.getText();
						con=DriverManager.getConnection("jdbc:odbc:sms");
						Statement st=con.createStatement();
						res=st.executeQuery("Select * from electricity where paymentdate='"+bdate+"'");
						while(res.next())
						{
							flg=1;
							Vector v=new Vector();
							v.add(res.getString(1));
							v.add(res.getString(2));
							v.add(res.getString(9));
							model.addRow(v);		
						}
					if(flg==0)
						JOptionPane.showMessageDialog(null,"Date Not Found!!!!");					
				}
				catch(Exception ex)
					{
						System.out.println("Error:"+ex);
					}
					try
					{
						Connection con;
						ResultSet res;
						String bdate=txdate.getText();
						con=DriverManager.getConnection("jdbc:odbc:sms");
						Statement st=con.createStatement();
						res=st.executeQuery("Select * from water where paymentdate='"+bdate+"'");
						while(res.next())
						{
							flg=1;
							Vector v=new Vector();
							v.add(res.getString(1));
							v.add(res.getString(2));
							v.add(res.getString(5));
							model.addRow(v);		
						}
						
					}
					catch(Exception ex)
					{
						System.out.println("Error:"+ex);
					}
				}
				else
						JOptionPane.showMessageDialog(null,"Invalid Date!!!!");
		}
		if(e.getSource()==bprint)
		{
				try
				{
				Connection con;
				ResultSet res;
				PrintWriter objpr=new PrintWriter("dpayment.txt");
				objpr.println("Receipt No \t Booking ID \t Flat/Duplex No");
				objpr.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				
				con=DriverManager.getConnection("jdbc:odbc:sms");
				Statement st=con.createStatement();
					res=st.executeQuery("Select * from electricity where paymentdate='"+txdate.getText()+"'");
					while(res.next())
					{
						objpr.println(res.getString(1)+"\t\t"+res.getString(2)+"\t\t"+res.getString(9));
					}
					/*
				Connection con;
				ResultSet res;
				con=DriverManager.getConnection("jdbc:odbc:sms");
				Statement st=con.createStatement();*/
					res=st.executeQuery("Select * from water where paymentdate='"+txdate.getText()+"'");
					while(res.next())
					{
						objpr.println(res.getString(1)+"\t\t"+res.getString(2)+"\t\t"+res.getString(5));
					}
				objpr.close();
				Runtime robj=Runtime.getRuntime();
				Process pr=robj.exec("notepad.exe d:\\new\\dpayment.txt");
			}
			catch(Exception ex)
			{
				System.out.println("Error:"+ex);
			}
		}
		if(e.getSource()==bclose)
  		{
		     this.dispose();
  		}
		}
		public static void main(String argv[])throws IOException
		{
		dpayment obj=new dpayment();
		}
	}
                 
		
	
		
