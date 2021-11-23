import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.Calendar;
import java.util.*;
import javax.swing.table.DefaultTableModel;
public class daily extends JFrame implements ActionListener
{
	
	JTable table1 =new JTable();
	JScrollPane sp;

	JButton bsearch=new JButton("Search");	
	JButton bclose=new JButton("Close");
	JButton bprint=new JButton("Print");

	JLabel lblddate=new JLabel("Date:");
	JTextField txddate=new JTextField(10);

	
	String m,n,o,p,q;
	JTable table2;
	String[] col={"Bookid","Ownerid","Customer Name","Flat No/Duplex No","Amount"};
	Object[] [] data={{m,n,o,p,q}};
	DefaultTableModel model=new DefaultTableModel(col,0);	
	public daily()
	{
		setLayout(null);
		setSize(1200,1500);
		setVisible(true);
		table2=new JTable(data,col);
		sp=new JScrollPane(table2);
		table2.setModel(model);
     		setBackground(new Color(234,255,229));
     		bsearch.setBounds(800,500,80,40);
		bclose.setBounds(800,670,80,40);
		add(sp);
		table2.setBounds(500,500,500,200);
		sp.setBounds(500,500,500,200); 	
		table2.setFillsViewportHeight(true);
    		add(bsearch);
		add(bclose); 
    		bsearch.addActionListener(this);
		bclose.addActionListener(this);
		bprint.addActionListener(this);

		lblddate.setBackground(new Color(250,150,80));
		lblddate.setFont(new Font("Comic Sans MS",Font.BOLD,30));

		lblddate.setBounds(300,300,200,40);
		txddate.setBounds(550,300,200,40);
		bsearch.setBounds(1050,300,100,50);
		bclose.setBounds(1200,300,100,50);

		add(bclose);
		add(lblddate);
		add(txddate);
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
                                      		  	Connection con;
						ResultSet res;
						String[] col={"BookID","OwnerID","Flat/Duplex No","Amount"};
						DefaultTableModel model=new DefaultTableModel(col,0);
						table2.setModel(model);
						String ddate=txddate.getText().toString();
						con=DriverManager.getConnection("jdbc:odbc:sms");
						Statement st=con.createStatement();
						res=st.executeQuery("Select * from booking where book_date='"+ddate+"'");
						while(res.next())
						{
							Vector v=new Vector();
							v.add(res.getString(1));
							v.add(res.getString(3));
							v.add(res.getString(4));
							v.add(res.getString(6));
							model.addRow(v);		
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
      PrintWriter obj=new PrintWriter("Daily");
      obj.println("\t\t\t\t\tReport on Booking     ");
      obj.println("");
      obj.println(" ________________________________________________________________________________________________");
      obj.println("|S.No. |    Batch No.   |    Total no. of class |\tReg No. |\tPresent |\tAbsent  |");
      obj.println("|_______________________________________________________________________________________________|");
      int ctr1=1,s1=0,z=0; String reg="";
      Connection con;
      con=DriverManager.getConnection("jdbc:odbc:sms"); 
      ResultSet res;
      Statement st=con.createStatement();
      String str="select * from from booking where book_date='"+txddate.getText()+"'";
      res=st.executeQuery(str);
      
      String SQL1;
      ResultSet res1;
      Statement st1=con.createStatement();
     while(res.next())
     {
      reg="";
      reg=res.getString(1);
      obj.print("| "+ctr1+"    |\t"+txtbatchno.getText()+" \t|\t\t "+a+" \t|\t "+reg);
      
      
         
         SQL1="select edate from attentbl where reg_no="+reg+"AND batch_no='"+txtbatchno.getText()+"'AND month='"+txtmonth.getText()+"'";
         res1=st1.executeQuery(SQL1);
         s1=0;
         z=0;
         while(res1.next())//s1 = no of present of a student & z= no of absent of a student & reg for student's regno
         {
           s1=s1+1;
         }
         z=a-s1;
         ctr1=ctr1+1;
         obj.println("\t|\t "+s1+" \t|\t "+z+"\t|\n");
         obj.println("_________________________________________________________________________________________________");
      }
       obj.close();
       Runtime r=Runtime.getRuntime();
      r.exec("notepad c:\\amritaj\\project1\\Attendance");     
    }
    catch(Exception ee)
    {
      System.out.println("Exception :"+ee);
    }
  }

			
		}
		if(e.getSource()==bclose)
  		{
		     this.dispose();
  		}
		}
		public static void main(String argv[])throws IOException
		{
		daily obj=new daily();
		}
	}
                 
		
	
		
