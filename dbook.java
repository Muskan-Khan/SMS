import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.Calendar;
import java.util.*;
import javax.swing.table.DefaultTableModel;
public class bbook extends Frame implements ActionListener
{
	JTable table1 =new JTable();
	JScrollPane sp;

	JButton bsearch=new JButton("Search");	
	JButton bprint=new JButton("Print");
	JButton bclose=new JButton("Close");

	JLabel lbldate=new JLabel("Enter Date(Eg:01/01/2017):");
	JTextField txdate=new JTextField(10);
	String m,n,o,p,q;
	JTable table2;
	String[] col={"Flat no","Address","Floor","Carpet Area","Charge(per Sq.ft)"};
	Object[] [] data={{m,n,o,p,q}};
	DefaultTableModel model=new DefaultTableModel(col,0);	
	public availability()
	{
		setLayout(null);
		setSize(1200,1500);
		setVisible(true);
		table2=new JTable(data,col);
		sp=new JScrollPane(table2);
		table2.setModel(model);
     		setBackground(new Color(234,255,229));
		lbldate.setBackground(new Color(250,150,80));
               	lbldate.setFont(new Font("Comic Sans MS",Font.BOLD,30));
		
     		lbldate.setBounds(400,200,200,60);
                	txdate.setBounds(700,200,140,60);
		table2.setBounds(800,800,800,200);
		sp.setBounds(800,800,800,200); 	
		table2.setFillsViewportHeight(true);
		add(sp);
    		add(lbldate);
		add(txdate);
		add(bsearch);
		add(bprint);
		add(bclose); 
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
		}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==bsearch)
			{
				 model.setRowCount(0);
				 try
    				 {
                                      		  	char d1=txdob.getText().charAt(0);
						char d2=txdob.getText().charAt(1);
						char d3=txdob.getText().charAt(2);
						char d4=txdob.getText().charAt(3);
				                      char d5=txdob.getText().charAt(4);
						 char d6=txdob.getText().charAt(5);
						char d7=txdob.getText().charAt(6);
						 char d8=txdob.getText().charAt(7);
				                      char d9=txdob.getText().charAt(8);
						 char d10=txdob.getText().charAt(9);
                     					if((d1>='0' && d1<='9')&&(d2>='0' && d2<='9')&&(d4>='0' && d4<='9')&&(d5>='0' && d5<='9')&&(d7>='0' && d7<='9')&&(d8>='0' && d8<='9')&&(d9>='0' && d9<='9')&&(d10>='0' && d10<='9')&&d3=='/' && d6=='/')
                   					////////////////////////////////////////
                   					{
						Connection con;
						ResultSet res;
						String[] col={"Booking ID","Customer ID","Flat/Duplex No"};
						DefaultTableModel model=new DefaultTableModel(col,0);
						table2.setModel(model);
						String bdate=txdate.getText();
						con=DriverManager.getConnection("jdbc:odbc:sms");
						Statement st=con.createStatement();
						res=st.executeQuery("Select * from booking where book_date='"+bdate+"'");
						while(res.next())
						{
							Vector v=new Vector();
							v.add(res.getString(1));
							v.add(res.getString(3));
							v.add(res.getString(4));
							model.addRow(v);		
						}
					}
					else
						JOptionPane.showMessageDialog(null,"Invalid Date!!!!");
						
				}
				catch(Exception ex)
					{
						System.out.println("Error:"+ex);
					}
		}
		if(e.getSource()==bprint)
		{
			try
			{
				PrintWriter objpr=new PrintWriter("avail.txt");
				objpr.println("Booking ID" \t "Customer ID" \t "Flat/Duplex No");
				objpr.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				Connection con;
				ResultSet res;
				con=DriverManager.getConnection("jdbc:odbc:sms");
				Statement st=con.createStatement();
					res=st.executeQuery("Select * from booking where bdate='"+txdate.getText()+"'");
					while(res.next())
					{
						objpr.println(res.getString(1)+"\t \t"+res.getString(3)+"\t \t"+res.getString(4));
					}
				objpr.close();
				Runtime robj=Runtime.getRuntime();
				Process pr=robj.exec("notepad.exe d:\\new\\bbook.txt");
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
		bbook obj=new bbook();
		}
	}
                 
		
	
		
