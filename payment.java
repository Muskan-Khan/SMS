import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.Calendar;
import java.util.*;
public class payment extends Frame implements ActionListener,ItemListener
{
	String[] charge={"Water","Electricity","Maintenance","Installment"};
	JComboBox chargelist=new JComboBox(charge);
	String[] pn={"Astha Township","Madhusudan Vihar","Ashok Vatika","Green City","Devnagri Palace"};
	JComboBox projectname=new JComboBox(pn);
	
	JLabel lblbookid=new JLabel("Booking ID:");
	JLabel lbldate=new JLabel("Date:");
	JLabel lblcustomerid=new JLabel("Customer ID:");
	JLabel lblcustomername=new JLabel("Owner Name:");
	JLabel lblflatid=new JLabel("Flat ID/Duplex ID:");
	JLabel lblpn=new JLabel("Project Name:");
	JLabel lblpayfor=new JLabel("Pay for:");
	JLabel lblreceiptno=new JLabel("Receipt No:");
	JLabel lblprevreading=new JLabel("Previous Reading:");
	JLabel lblclosereading=new JLabel("Close Reading:");
	JLabel lblcharge=new JLabel("Charge(per unit):");
	JLabel lbltcharge=new JLabel("Total Charge:");
	JLabel lblunits=new JLabel("Units consumed:");
	JLabel lblpayment=new JLabel("Amount calculated:");
	JLabel lbldueamt=new JLabel("Dues:");

	JLabel lblpayingin=new JLabel("Paying in:"); 
	JLabel lblamt=new JLabel("Amount:");
	JLabel lblbankname=new JLabel("Bank Name:");
	JLabel lblbankbranch=new JLabel("Bank Branch:");
	JLabel lblchequeno=new JLabel("Cheque No:");
	JLabel lblchequedate=new JLabel("Cheque Date:");

	ButtonGroup cg=new ButtonGroup();
	JRadioButton b1=new JRadioButton("Cash");
	JRadioButton b2=new JRadioButton("Cheque");	

	JLabel lbl=new JLabel("Payment Details");

	JTextField txbookid=new JTextField(10);
	JTextField txdate=new JTextField(10);
	JTextField txcustomerid=new JTextField(10);
	JTextField txcustomername=new JTextField(10);
	JTextField txflatid=new JTextField(10);
	JTextField txreceiptno=new JTextField(10);
	JTextField txprevreading=new JTextField(10);
	JTextField txclosereading=new JTextField(10);
	JTextField txcharge=new JTextField(10);
	JTextField txtcharge=new JTextField(10);	
	JTextField txunits=new JTextField(10);
	JTextField txpayment=new JTextField(10);
	JTextField txremamt=new JTextField(10);
	JTextField txlastpaydate=new JTextField(10);
	JTextField txamt=new JTextField(10);
	JTextField txdueamt=new JTextField(10);
	JTextField txbankname=new JTextField(10);
	JTextField txbankbranch=new JTextField(10);
	JTextField txchequeno=new JTextField(10);
	JTextField txchequedate=new JTextField(10);
		
	JButton bnew=new JButton("New",new ImageIcon("images/new.gif"));
	JButton bsubmit=new JButton("Submit",new ImageIcon("images/restore.gif"));
	JButton bcancel=new JButton("Cancel",new ImageIcon("images/exit.png"));
	JButton brefresh=new JButton("Refresh",new ImageIcon("images/refresh.png"));

	public payment()
	{
	setLayout(null);
	setVisible(true);
	setTitle("Payment:::");
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	pack();
	setSize(2100,1200);
	
	lbl.setForeground(Color.red);
	lbl.setFont(new Font("Comic Sans MS",Font.BOLD,60));
	lbl.setBounds(600,80,500,80);
	
	lblbookid.setBackground(new Color(250,150,80));
	lblbookid.setFont(new Font("Comic Sans MS",Font.BOLD,30));
		
	lbldate.setBackground(new Color(250,150,80));
	lbldate.setFont(new Font("Comic Sans MS",Font.BOLD,30));

	lblcustomerid.setBackground(new Color(250,150,80));
	lblcustomerid.setFont(new Font("Comic Sans MS",Font.BOLD,30));

	lblcustomername.setBackground(new Color(250,150,80));
	lblcustomername.setFont(new Font("Comic Sans MS",Font.BOLD,30));

	lblflatid.setBackground(new Color(250,150,80));
	lblflatid.setFont(new Font("Comic Sans MS",Font.BOLD,30));
		
	lblpn.setBackground(new Color(250,150,80));
	lblpn.setFont(new Font("Comic Sans MS",Font.BOLD,30));
	
	lblcharge.setBackground(new Color(250,150,80));
	lblcharge.setFont(new Font("Comic Sans MS",Font.BOLD,20));	
	
	lbltcharge.setBackground(new Color(250,150,80));
	lbltcharge.setFont(new Font("Comic Sans MS",Font.BOLD,20));	
	
	lblreceiptno.setBackground(new Color(250,150,80));
	lblreceiptno.setFont(new Font("Comic Sans MS",Font.BOLD,20));	
	
	lblprevreading.setBackground(new Color(250,150,80));
	lblprevreading.setFont(new Font("Comic Sans MS",Font.BOLD,20));	
	
	lblclosereading.setBackground(new Color(250,150,80));
	lblclosereading.setFont(new Font("Comic Sans MS",Font.BOLD,20));	
	
	lblamt.setBackground(new Color(250,150,80));
	lblamt.setFont(new Font("Comic Sans MS",Font.BOLD,30));	
	
	lblunits.setBackground(new Color(250,150,80));
	lblunits.setFont(new Font("Comic Sans MS",Font.BOLD,20));	
	
	lblpayment.setBackground(new Color(250,150,80));
	lblpayment.setFont(new Font("Comic Sans MS",Font.BOLD,20));	
			
	lbldueamt.setBackground(new Color(250,150,80));
	lbldueamt.setFont(new Font("Comic Sans MS",Font.BOLD,20));	

	b1.setFont(new Font("Comic Sans MS",Font.BOLD,25));	
	b1.setBackground(new Color(255,255,255));
	
	b2.setFont(new Font("Comic Sans MS",Font.BOLD,25));	
	b2.setBackground(new Color(255,255,255));
	
	lblpayingin.setBackground(new Color(250,150,80));
	lblpayingin.setFont(new Font("Comic Sans MS",Font.BOLD,30));
	
	lblpayfor.setBackground(new Color(250,150,80));
	lblpayfor.setFont(new Font("Comic Sans MS",Font.BOLD,30));	

	lblbankname.setBackground(new Color(250,150,80));
	lblbankname.setFont(new Font("Comic Sans MS",Font.BOLD,20));

	lblbankbranch.setBackground(new Color(250,150,80));
	lblbankbranch.setFont(new Font("Comic Sans MS",Font.BOLD,20));
	
	lblchequeno.setBackground(new Color(250,150,80));
	lblchequeno.setFont(new Font("Comic Sans MS",Font.BOLD,20));
	
	lblchequedate.setBackground(new Color(250,150,80));
	lblchequedate.setFont(new Font("Comic Sans MS",Font.BOLD,20));	

	lblpayment.setBackground(new Color(250,150,80));
	lblpayment.setFont(new Font("Comic Sans MS",Font.BOLD,20));

	chargelist.setFont(new Font("Comic Sans MS",Font.BOLD,20));	
	projectname.setFont(new Font("Comic Sans MS",Font.BOLD,20));	

	lblbookid.setBounds(400,200,200,40);
	txbookid.setBounds(620,200,250,40);

	lbldate.setBounds(1000,200,300,40);
	txdate.setBounds(1300,200,250,40);

	lblcustomerid.setBounds(380,270,200,40);
	txcustomerid.setBounds(620,270,250,40);

	lblcustomername.setBounds(1000,270,300,40);
	txcustomername.setBounds(1300,270,250,40);	

	lblflatid.setBounds(300,340,300,40);
	txflatid.setBounds(620,340,250,40);
	
	lblpn.setBounds(1000,340,300,40);
	projectname.setBounds(1300,340,250,40);

	lblpayfor.setBounds(458,400,600,60);
	chargelist.setBounds(620,400,250,40);
	brefresh.setBounds(890,400,140,40);

	lblreceiptno.setBounds(550,450,200,40);
	txreceiptno.setBounds(780,450,200,40);

	lblcharge.setBounds(1000,450,200,40);
	txcharge.setBounds(1220,450,200,40);

	lblprevreading.setBounds(550,500,250,40);
	txprevreading.setBounds(780,500,200,40);

	lblpayment.setBounds(1000,500,200,40);
	txpayment.setBounds(1220,500,200,40);

	lblclosereading.setBounds(550,550,200,40);
	txclosereading.setBounds(780,550,200,40);

	lbldueamt.setBounds(1000,550,250,40);
	txdueamt.setBounds(1220,550,200,40);

	lblunits.setBounds(550,600,200,40);
	txunits.setBounds(780,600,200,40);
	
	lbltcharge.setBounds(1000,600,200,40);
	txtcharge.setBounds(1220,600,200,40);
	
	lblpayingin.setBounds(400,670,250,45);
	b1.setBounds(670,670,100,50);
	b2.setBounds(800,670,120,50);
	
	lblamt.setBounds(1000,670,300,40);
	txamt.setBounds(1200,670,250,40);

	lblbankname.setBounds(900,730,200,40);
	txbankname.setBounds(1050,730,200,40);
	
	lblbankbranch.setBounds(900,780,200,40);
	txbankbranch.setBounds(1050,780,200,40);
	
	lblchequeno.setBounds(500,730,200,40);
	txchequeno.setBounds(650,730,200,40);
	
	lblchequedate.setBounds(500,780,200,40);
	txchequedate.setBounds(650,780,200,40);
	
	bnew.setBounds(550,850,150,50);
	bsubmit.setBounds(700,850,150,50);
	bcancel.setBounds(850,850,150,50);

	add(lblbookid);
	add(txbookid);
	add(lbldate);
	add(txdate);
	add(lblcustomerid);
	add(txcustomerid);
	add(lblcustomername);
	add(txcustomername);
	add(lblflatid);
	add(txflatid);
	add(lblpn);
	add(lblreceiptno);
	add(txreceiptno);
	add(lblprevreading);
	add(txprevreading);
	add(lblclosereading);
	add(txclosereading);
	add(lbltcharge);
	add(txtcharge);
	add(lblamt);
	add(txamt);
	add(lblcharge);
	add(txcharge);
	add(lblunits);
	add(txunits);
	add(lblpayment);	
	add(txpayment);	
	add(lblpayfor);
	add(lbldueamt);
	add(txdueamt);
	add(projectname);
	add(lblbankname);
	add(txbankname);
	add(lblbankbranch);
	add(txbankbranch);
	add(lblchequeno);
	add(txchequeno);
	add(lblchequedate);
	add(txchequedate);
	add(lblcharge);
	add(chargelist);
	add(lblpayingin);
	
	add(b1);
	add(b2);
	cg.add(b1);
	cg.add(b2);


	add(lbl);
	add(bnew);
	add(bsubmit);
	add(bcancel);
	add(brefresh);

	bnew.addActionListener(this);
	bsubmit.addActionListener(this);
	bcancel.addActionListener(this);
       	b1.addItemListener(this);
 	b2.addItemListener(this);
	brefresh.addActionListener(this);
           chargelist.addItemListener(this);
	repaint();
}
public void itemStateChanged(ItemEvent ie)
{
	if(ie.getSource()==b1)
	{
		txchequeno.setVisible(false);
		txchequedate.setVisible(false);
		lblchequeno.setVisible(false);
		lblchequedate.setVisible(false);
		txbankname.setVisible(false);
		txbankbranch.setVisible(false);
		lblbankname.setVisible(false);
		lblbankbranch.setVisible(false);	

	}
	if(ie.getSource()==b2)
	{
		txchequeno.setVisible(true);
		txchequedate.setVisible(true);
		lblchequeno.setVisible(true);
		lblchequedate.setVisible(true);
		txbankname.setVisible(true);
		txbankbranch.setVisible(true);
		lblbankname.setVisible(true);
		lblbankbranch.setVisible(true);	

	}
	if(ie.getSource()==chargelist)
	{
	if(chargelist.getSelectedItem().equals("Water") || chargelist.getSelectedItem().equals("Electricity") || chargelist.getSelectedItem().equals("Maintenance"))
	{
		try
		{
			Connection con;
		   	con=DriverManager.getConnection("jdbc:odbc:sms");
                   	 	Statement st=con.createStatement(); 
			txamt.setText("");
			txbankname.setText("");
			txbankname.setText("");
			txchequeno.setText("");
			txchequedate.setText("");
		}
		catch(Exception ex)
		{
			System.out.println("Error:"+ex);
		}
	}
		if(chargelist.getSelectedItem().equals("Maintenance"))
		{
			lblcharge.setVisible(false);
			txcharge.setVisible(false);
			lblpayment.setVisible(false);
			txpayment.setVisible(false);
			lbldueamt.setVisible(false);
			txdueamt.setVisible(false);
			txprevreading.setText("");
			lbltcharge.setVisible(false);
			txtcharge.setVisible(false);
			lblprevreading.setVisible(true);
			txprevreading.setVisible(true);
			lblclosereading.setVisible(true);
			txclosereading.setVisible(true);
			lblunits.setVisible(true);
			txunits.setVisible(true);
			lblprevreading.setText("Dues:");
			lblclosereading.setText("For the month of:");
			lblunits.setText("Total charge:");
			try
			{
			   Connection con;
		   	   con=DriverManager.getConnection("jdbc:odbc:sms");
                   		   Statement st=con.createStatement();
                   	   	   ResultSet res=st.executeQuery("Select * from keytbl");
                   	 		while(res.next())
                   	 	 	{
                       			int x=Integer.parseInt(res.getString(8));
                      	           	           		txreceiptno.setText("Rec_"+String.format("%04d",x));   
                   			 }
			}
			catch(Exception ex)
			{
				System.out.println("Error:"+ex);
			}
			try
			{
				int flg=0;
				Connection con;
				con=DriverManager.getConnection("jdbc:odbc:sms");
				Statement st=con.createStatement();
				ResultSet res;
				res=st.executeQuery("Select * from maintenancetbl where bookid='"+txbookid.getText()+"'");
				while(res.next())
				{
					txprevreading.setText(""+res.getString(6));
					flg=1;
				}
				if(flg==0)
				{
					txprevreading.setText("0");
				}
			}
			catch(Exception ex)
			{
				System.out.println("Exception:"+ex);
			}
		}	
          		if(chargelist.getSelectedItem().equals("Electricity"))
		{
			lblprevreading.setVisible(true);
			txprevreading.setVisible(true);
			lblclosereading.setVisible(true);
			txclosereading.setVisible(true);
			lblunits.setVisible(true);
			txunits.setVisible(true);
			lblcharge.setVisible(true);
			txcharge.setVisible(true);
			lblpayment.setVisible(true);
			txpayment.setVisible(true);
			lbldueamt.setVisible(true);
			txdueamt.setVisible(true);
			lbltcharge.setVisible(true);
			txtcharge.setVisible(true);
			lblprevreading.setText("Previous Reading:");
			lblclosereading.setText("Close Reading:");
			txreceiptno.setText("");
			txprevreading.setText("");
			txclosereading.setText("");
			txunits.setText("");
			txpayment.setText("");
			txdueamt.setText("");
			lblunits.setText("Units:");
			try
			{
				Connection con;
		   	   	con=DriverManager.getConnection("jdbc:odbc:sms");
                   		   	Statement st=con.createStatement();
				ResultSet res=st.executeQuery("Select * from keytbl");
                   	 		while(res.next())
                   	 	 	{
                       			int x=Integer.parseInt(res.getString(6));
                      	           	           		txreceiptno.setText("Rec_"+String.format("%04d",x));   
                   			 }
			}
			catch(Exception ex)
			{
				System.out.println("Error:"+ex);
			}
			try
			{
				int flg=0;
				Connection con;
				con=DriverManager.getConnection("jdbc:odbc:sms");
				Statement st=con.createStatement();
				ResultSet res;
				res=st.executeQuery("Select * from electricity where bookid='"+txbookid.getText()+"'");
				while(res.next())
				{
					txprevreading.setText(""+res.getString(6));
					txdueamt.setText(""+res.getString(9));
					flg=1;
				}
				if(flg==0)
				{
					txprevreading.setText("0");
					txdueamt.setText("0");
				}
			}
			catch(Exception ex)
			{
				System.out.println("Exception:"+ex);
			}
		}
		if(chargelist.getSelectedItem().equals("Water"))
		{
			lblcharge.setVisible(false);
			txcharge.setVisible(false);
			lblpayment.setVisible(false);
			txpayment.setVisible(false);
			lbldueamt.setVisible(false);
			txdueamt.setVisible(false);
			txprevreading.setText("");
			lbltcharge.setVisible(false);
			txtcharge.setVisible(false);
			lblprevreading.setVisible(true);
			txprevreading.setVisible(true);
			lblclosereading.setVisible(true);
			txclosereading.setVisible(true);
			lblunits.setVisible(true);
			txunits.setVisible(true);
			lblprevreading.setText("Dues:");
			lblclosereading.setText("For the month of:");
			txclosereading.setText("");
			txunits.setText("");
			lblunits.setText("Total charge:");
			try
			{
				Connection con;
		   	   	con=DriverManager.getConnection("jdbc:odbc:sms");
                   		   	Statement st=con.createStatement();
				ResultSet res=st.executeQuery("Select * from keytbl");
                   	 		while(res.next())
                   	 	 	{
                       			int x=Integer.parseInt(res.getString(7));
                      	           	           		txreceiptno.setText("Rec_"+String.format("%04d",x));   
                   			 }
			}
			catch(Exception ex)
			{
				System.out.println("Error:"+ex);
			}
			try
			{
				int flg=0;
				Connection con;
				con=DriverManager.getConnection("jdbc:odbc:sms");
				Statement st=con.createStatement();
				ResultSet res;
				res=st.executeQuery("Select * from water where bookid='"+txbookid.getText()+"'");
				while(res.next())
				{
					txprevreading.setText(""+res.getString(6));
					flg=1;
				}
				if(flg==0)
				{
					txprevreading.setText("0");
				}
			}
			catch(Exception ex)
			{
				System.out.println("Exception:"+ex);
			}

		}
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bnew)
		{
			 Calendar cal=Calendar.getInstance();
                                   txdate.setText(""+cal.get(Calendar.DATE)+" / "+((cal.get(Calendar.MONTH))+1)+" / "+cal.get(Calendar.YEAR));
			txreceiptno.setText("");
			txclosereading.setText("");
			txprevreading.setText("");
			txunits.setText("");
			txcharge.setText("");
			txpayment.setText("");
			txdueamt.setText("");
			txamt.setText("");
			txbankname.setText("");
			txbankbranch.setText("");
			txchequedate.setText("");
			txchequeno.setText("");
			try
			{
				Connection con;
				con=DriverManager.getConnection("jdbc:odbc:sms");
				Statement st=con.createStatement();
				int flg=0;
				ResultSet res;
				res=st.executeQuery("Select * from booking where book_id='"+txbookid.getText()+"'");
				while(res.next())
				{
					flg=1;
					txcustomerid.setText(""+res.getString(3));
					txflatid.setText(""+res.getString(4));
				}
					if(flg==0)
					{
					JOptionPane.showMessageDialog(null,"Invalid Booking ID");
					}
			}
			   catch(Exception ex)
			   {
				System.out.println("Error:"+ex);
                	              }
			try
			{
		 	           Connection con;
				con=DriverManager.getConnection("jdbc:odbc:sms");
				Statement st=con.createStatement();
				int flg=0;
				ResultSet res;
				String str=txflatid.getText();
				int k=str.length();
				int i=0;
					if(str.charAt(i)=='F')
					{	
					res=st.executeQuery("Select * from flat_info where flat_no='"+txflatid.getText()+"'");
					while(res.next())
					     {
						projectname.setSelectedItem(""+res.getString(8));
						flg=1;
					     }
					}
				if(str.charAt(i)=='D')
				{
				flg=1;
				res=st.executeQuery("Select * from duplex_info where duplex_no='"+txflatid.getText()+"'");
				while(res.next())
				{
					projectname.setSelectedItem(""+res.getString(7));
					flg=1;
				}
				if(flg==0)
				{
					JOptionPane.showMessageDialog(null,"No such record");
				}
			}
			}
			catch(Exception ex)
			{
				System.out.println("ERROR:"+ex);
			}
		           try
			{
				Connection con;
				con=DriverManager.getConnection("jdbc:odbc:sms");
				Statement st=con.createStatement();
				int flg=0;
				ResultSet res;
		    		res=st.executeQuery("Select * from owner_info where flat_no='"+txflatid.getText()+"'");
				while(res.next())
				{
					txcustomername.setText(""+res.getString(3));
				}
			}
                        	catch(Exception ex)
			{
				System.out.println("ERROR:"+ex);
			}
			}
			if(e.getSource()==brefresh)
			{
				if(chargelist.getSelectedItem().equals("Electricity"))
				{
				try
				{	
					Double prev=Double.parseDouble(txprevreading.getText());
					Double close=Double.parseDouble(txclosereading.getText());
					Double units=close-prev;
					txunits.setText(""+units);
					if(txcharge.getText()=="0")
					JOptionPane.showMessageDialog(null,"Charge per unit required!!!");
					Double charge=Double.parseDouble(txcharge.getText());
					Double totalcharge=charge*units;
					txpayment.setText(""+totalcharge);
					Double dues=Double.parseDouble(txdueamt.getText());
					txtcharge.setText(""+(dues+totalcharge));			
				}
				catch(Exception ex)
				{
					System.out.println("Error:"+ex);
				}
				}
				if(chargelist.getSelectedItem().equals("Water"))
				{
						   int i=0,ctr=1;
						   Double tcharge;
						   String month=txclosereading.getText();
			   			   while(i<=month.length()) 
						   {	
							String a=(Character.toString(month.charAt(i)));
			 				 if(a.equals(","))
			  				{
								ctr++;
			 				 }
						    }
						tcharge=ctr*500.00;
						txunits.setText(""+Double.toString(tcharge));
				}
			}

			if(e.getSource()==bsubmit)
			{
			if(chargelist.getSelectedItem().equals("Electricity"))
			{
			try
			{
			   Connection con;
		   	   con=DriverManager.getConnection("jdbc:odbc:sms");
                   		   Statement st=con.createStatement();
                   	   	   String str="insert into electricity(ereceiptno,bookid,paymentdate,flatid,prevreading,closereading,units,charge,amt,dueamt)values(?,?,?,?,?,?,?,?,?,?)";
		   	   PreparedStatement ps=con.prepareStatement(str);
			   ps.setString(1,txreceiptno.getText());
			   ps.setString(2,txbookid.getText());
			   ps.setString(3,txdate.getText());
			   ps.setString(4,txflatid.getText());
			   ps.setString(5,txprevreading.getText());
			   ps.setString(6,txclosereading.getText());
       	             	   ps.setString(7,txunits.getText());
		  	   ps.setString(8,txcharge.getText());
		   	   Double charge=Double.parseDouble(txcharge.getText());
			   Double units=Double.parseDouble(txunits.getText());
			   Double totalcharge=charge*units;
			   txpayment.setText(""+totalcharge);
			   Double tcharge=Double.parseDouble(txtcharge.getText());
			   Double amt=Double.parseDouble(txamt.getText());
			   Double dues=tcharge-amt;
			   ps.setString(9,txamt.getText());
		   	   ps.setString(10,Double.toString(dues));
		   	   ps.executeUpdate();
			   JOptionPane.showMessageDialog(null,"Payment Successfull..");
			   str="update keytbl set ereceiptno=ereceiptno+1";
                  	   	   ps=con.prepareStatement(str);
                   	               ps.executeUpdate();
			   JOptionPane.showMessageDialog(null,"Remaining Amount:"+dues);
			 }
			catch(Exception ex)
			{
				System.out.println("Error:"+ex);
			}
			}
			if(chargelist.getSelectedItem().equals("Water"))
			{
		              try
			   {
			   Connection con;
		   	   con=DriverManager.getConnection("jdbc:odbc:sms");
                   		   Statement st=con.createStatement();
                   	   	   String str="insert into water(wreceiptno,bookid,paymentdate,wmonth,amt,dueamt)values(?,?,?,?,?,?)";
		   	   PreparedStatement ps=con.prepareStatement(str);
			   ps.setString(1,txreceiptno.getText());
			   ps.setString(2,txbookid.getText());
			   ps.setString(3,txdate.getText());
			   ps.setString(4,txclosereading.getText());
			   ps.setString(5,txamt.getText());
			   Double tcharge=Double.parseDouble(txunits.getText());
			   Double amt=Double.parseDouble(txamt.getText());
			   Double dues=tcharge-amt;
			   ps.setString(6,Double.toString(dues));
			   ps.executeUpdate();
			   JOptionPane.showMessageDialog(null,"Payment Successfull..");
			   str="update keytbl set wreceiptno=wreceiptno+1";
                  	   	   ps=con.prepareStatement(str);
                   	               ps.executeUpdate();
			}
			catch(Exception ex)
			{
			 	System.out.println("Error:"+ex);
			}
			}
			if(chargelist.getSelectedItem().equals("Maintenance"))
			{
		              try
			   {
			   Connection con;
		   	   con=DriverManager.getConnection("jdbc:odbc:sms");
                   		   Statement st=con.createStatement();
                   	   	   String str="insert into maintenancetbl(mreceiptno,bookid,paymentdate,wmonth,amt,dueamt)values(?,?,?,?,?,?)";
		   	   PreparedStatement ps=con.prepareStatement(str);
			   ps.setString(1,txreceiptno.getText());
			   ps.setString(2,txbookid.getText());
			   ps.setString(3,txdate.getText());
			   ps.setString(4,txclosereading.getText());
			   ps.setString(5,txamt.getText());
			   Double tcharge=Double.parseDouble(txunits.getText());
			   Double amt=Double.parseDouble(txamt.getText());
			   Double dues=tcharge-amt;
			   ps.setString(6,Double.toString(dues));
			   ps.executeUpdate();
			   JOptionPane.showMessageDialog(null,"Payment Successfull..");
			   str="update keytbl set mreceiptno=mreceiptno+1";
                  	   	   ps=con.prepareStatement(str);
                   	               ps.executeUpdate();
			}
			catch(Exception ex)
			{
			 	System.out.println("Error:"+ex);
			}
			}
			if(chargelist.getSelectedItem().equals("Installment"))
			{
		              try
			   {
			    Connection con;
		   	   con=DriverManager.getConnection("jdbc:odbc:sms");
                   		   Statement st=con.createStatement();
                   	   	   String str="insert into water(ireceiptno,bookid,paymentdate,wmonth,amt,dueamt)values(?,?,?,?,?,?)";
		   	   PreparedStatement ps=con.prepareStatement(str);
			   ps.setString(1,txreceiptno.getText());
			   ps.setString(2,txbookid.getText());
			   ps.setString(3,txdate.getText());
			   ps.setString(4,txclosereading.getText());
			   ps.setString(5,txamt.getText());
			   Double tcharge=Double.parseDouble(txunits.getText());
			   Double amt=Double.parseDouble(txamt.getText());
			   Double dues=tcharge-amt;
			   ps.setString(6,Double.toString(dues));
			   ps.executeUpdate();
			   JOptionPane.showMessageDialog(null,"Payment Successfull..");
			   str="update keytbl set wreceiptno=wreceiptno+1";
                  	   	   ps=con.prepareStatement(str);
                   	               ps.executeUpdate();
			}
			catch(Exception ex)
			{
			 	System.out.println("Error:"+ex);
			}
			}
			}
			if(e.getSource()==bcancel)
			{
				this.dispose();
			}
	}
	public static void main(String argv[])throws IOException
	{
		payment obj=new payment();
	}
}		 