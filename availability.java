import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.Calendar;
import java.util.*;
import javax.swing.table.DefaultTableModel;
public class availability extends Frame implements ActionListener
{
	String[] projects={"Astha township","Madhusudan Vihar","Green city","Ashok Vatika","DevNagri Palace"};
	JComboBox projectlist=new JComboBox(projects);

	JTable table1 =new JTable();
	JScrollPane sp;

	JButton bsearch=new JButton("Search");	
	JButton bprint=new JButton("Print");
	JButton bclose=new JButton("Close");

	JLabel lbl=new JLabel("Availability of Flats/Duplex");
	JLabel lblhouse=new JLabel("House Type:");
	JLabel lblprojectname=new JLabel("Project Name:");
	
	ButtonGroup fd=new ButtonGroup();
	JRadioButton b1=new JRadioButton("Flat");
	JRadioButton b2=new JRadioButton("Duplex");
	String m,n,o,p,q;
	JTable table2;
	String[] col={"Flat no","Address","Floor","Carpet Area","Charge(per Sq.ft)"};
	Object[] [] data={{m,n,o,p,q}};
	DefaultTableModel model=new DefaultTableModel(col,0);	
	public availability()
	{
		setLayout(null);
		setVisible(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(2100,1200);
	
		lbl.setForeground(Color.red);
		lbl.setFont(new Font("Comic Sans MS",Font.BOLD,45));
		lbl.setBounds(500,100,650,80);		
		table2=new JTable(data,col);
		sp=new JScrollPane(table2);
		table2.setModel(model);
     		setBackground(new Color(234,255,229));
		add(sp);
		table2.setBounds(450,400,700,350);
		sp.setBounds(450,400,700,350); 	
		table2.setFillsViewportHeight(true);
    		add(bsearch);
		add(bprint);
		add(bclose); 
    		bsearch.addActionListener(this);
		bclose.addActionListener(this);
		bprint.addActionListener(this);			
               	
		projectlist.setFont(new Font("Comic Sans MS",Font.PLAIN,20));

		lblhouse.setBackground(new Color(250,150,80));
		lblhouse.setFont(new Font("Comic Sans MS",Font.BOLD,30));

		b1.setBackground(new Color(255,255,255));
		b2.setBackground(new Color(255,255,255));
	
		b1.setFont(new Font("Comic Sans MS",Font.PLAIN,30));
		b2.setFont(new Font("Comic Sans MS",Font.PLAIN,30));
				
		lblprojectname.setBackground(new Color(255,255,255));
		lblprojectname.setFont(new Font("Comic Sans MS",Font.BOLD,50));
		
		lblprojectname.setBackground(new Color(250,150,80));
		lblprojectname.setFont(new Font("Comic Sans MS",Font.BOLD,30));		

	        	lblhouse.setBounds(400,200,200,60);
                	b1.setBounds(700,200,140,60);
		b2.setBounds(900,200,140,60);

		lblprojectname.setBounds(400,300,350,60);
		projectlist.setBounds(700,300,300,50);
		
		bsearch.setBounds(1050,300,100,50);
		bprint.setBounds(1150,300,100,50);
		bclose.setBounds(1250,300,100,50);

		add(lbl);
		add(bclose); 
		add(lblprojectname);
		add(projectlist);
		add(lblhouse);
		add(b1);
		add(b2);
		fd.add(b1);
		fd.add(b2);
		add(bsearch);
		add(bprint);
		bsearch.addActionListener(this);
		bclose.addActionListener(this);
		bprint.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		repaint();
		}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==bsearch)
			{
				 model.setRowCount(0);
				 try
    				 {
					if(b1.isSelected())
					{
                                      		  	Connection con;
						ResultSet res;
						String[] col={"Flat no","Address","Floor","Carpet Area","Charge(per Sq.ft)"};
						DefaultTableModel model=new DefaultTableModel(col,0);
						table2.setModel(model);
						String pname=projectlist.getSelectedItem().toString();
						con=DriverManager.getConnection("jdbc:odbc:sms");
						Statement st=con.createStatement();
						res=st.executeQuery("Select * from flat_info where projectname='"+pname+"'");
						while(res.next())
						{
							Vector v=new Vector();
							v.add(res.getString(1));
							v.add(res.getString(3));
							v.add(res.getString(7));
							v.add(res.getString(5));
							v.add(res.getString(10));
							model.addRow(v);		
						}
					}
					if(b2.isSelected())
					{
						Connection con;
						ResultSet res;
						String[] col={"Duplex no","Address","Carpet Area","Superbuiltup Area","Charge(per Sq.ft)"};
						DefaultTableModel model=new DefaultTableModel(col,0);
						table2.setModel(model);
						String pname=projectlist.getSelectedItem().toString();
						con=DriverManager.getConnection("jdbc:odbc:sms");
						Statement st=con.createStatement();
						res=st.executeQuery("Select * from duplex_info where projectname='"+pname+"'");
						while(res.next())
						{
							Vector v=new Vector();
							v.add(res.getString(1));
							v.add(res.getString(3));
							v.add(res.getString(6));
							v.add(res.getString(5));
							v.add(res.getString(9));
							model.addRow(v);		
						}
					}	
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
				objpr.println("Flat/Duplex No \t Address \t Area");
				objpr.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				Connection con;
				ResultSet res;
				con=DriverManager.getConnection("jdbc:odbc:sms");
				Statement st=con.createStatement();
				if(b1.isSelected())
				{
					res=st.executeQuery("Select * from flat_info where projectname='"+projectlist.getSelectedItem()+"'");
					while(res.next())
					{
						objpr.println(res.getString(1)+"\t \t"+res.getString(3)+"\t \t"+res.getString(6));
					}
				}
				else
				{
					res=st.executeQuery("Select * from flat_info where projectname='"+projectlist.getSelectedItem()+"'");
					while(res.next())
					{
						objpr.println(res.getString(1)+"\t \t"+res.getString(3)+"\t \t"+res.getString(5));
					}
				}
				objpr.close();
				Runtime robj=Runtime.getRuntime();
				Process pr=robj.exec("notepad.exe d:\\new\\avail.txt");
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
		availability obj=new availability();
		}
	}
                 
		
	
		
