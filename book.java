import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.Calendar;
public class booking extends Frame implements ActionListener
{
	String[] plan={"flexi","CLP","Subvantion"};
	JComboBox planlist=new JComboBox(plan);
	String[] pn={"Astha Township","Madhusudan Vihar","Ashok Vatika","Green City","Devnagri Palace"};
	JComboBox projectname=new JComboBox(pn);
	JLabel lblbookid=new JLabel("Booking ID:");
	JLabel lblbookdate=new JLabel("Booking Date:");
	JLabel lblcustomerid=new JLabel("Customer ID:");
	JLabel lblcustomername=new JLabel("Owner Name:");
	JLabel lblflatid=new JLabel("Flat ID/Duplex ID:");
	JLabel lbln=new JLabel("Name:");
	JLabel lbladdress=new JLabel("Address:");
	JLabel lblcarpetarea=new JLabel("Carpet Area:");
	JLabel lblsuperbuiltuparea=new JLabel("Superbuiltup Area:");
	JLabel lblpn=new JLabel("Project Name:");
	JLabel lblcharge=new JLabel("Charge(per sq.ft):");
	JLabel lbltotalamount=new JLabel("Total Amount:");
	JLabel lbldiscount=new JLabel("Discount:");
	JLabel lbldprice=new JLabel("Price(After discount):");
	JLabel lbldownpayment=new JLabel("Downpayment:");
	JLabel lblnextpayment=new JLabel("Due Date:");
	JLabel lblamt=new JLabel("Amount remaining:");
	JLabel lblinterval=new JLabel("Intervals:");
	JLabel lblbankname=new JLabel("Funded by:");
	JLabel lblloanno=new JLabel("Loan No:");
	
	JLabel lbl=new JLabel("Booking Details");
	JLabel lblplan=new JLabel("Plan:");

	JTextField txbookid=new JTextField(10);
	JTextField txbookdate=new JTextField(10);
	JTextField txcustomerid=new JTextField(10);
	JTextField txcustomername=new JTextField(10);
	JTextField txflatid=new JTextField(10);
	JTextField txcharge=new JTextField(10);
	JTextField txtotalamount=new JTextField(10);
	JTextField txdiscount=new JTextField(10);
	JTextField txdprice=new JTextField(10);
	JTextField txdownpayment=new JTextField(10);
	JTextField txnextpayment=new JTextField(10);
	JTextField txamt=new JTextField(10);
	JTextField txinterval =new JTextField(10);
	JTextField txbankname=new JTextField(10);
	JTextField txloanno=new JTextField(10);
	JTextField txn=new JTextField(10);
	JTextField txaddress=new JTextField(10);
	JTextField txsuperbuiltuparea=new JTextField(10);
	JTextField txcarpetarea=new JTextField(10);
	//JTextField txinstallment=new JTextField(10);
		
	JButton bnew=new JButton("New");
	JButton bbook=new JButton("Book");
	JButton bcancel=new JButton("Cancel");

	public booking()
	{
	setLayout(null);
	setVisible(true);
	setTitle("Booking:::");
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	pack();
	setSize(2100,1200);
	
	lbl.setForeground(Color.red);
	lbl.setFont(new Font("Comic Sans MS",Font.BOLD,60));
	lbl.setBounds(500,80,500,80);
	
	lblbookid.setBackground(new Color(250,150,80));
	lblbookid.setFont(new Font("Comic Sans MS",Font.BOLD,30));
		
	lblbookdate.setBackground(new Color(250,150,80));
	lblbookdate.setFont(new Font("Comic Sans MS",Font.BOLD,30));

	lblcustomerid.setBackground(new Color(250,150,80));
	lblcustomerid.setFont(new Font("Comic Sans MS",Font.BOLD,30));

	lblcustomername.setBackground(new Color(250,150,80));
	lblcustomername.setFont(new Font("Comic Sans MS",Font.BOLD,30));

	lblflatid.setBackground(new Color(250,150,80));
	lblflatid.setFont(new Font("Comic Sans MS",Font.BOLD,30));
		
	lblpn.setBackground(new Color(250,150,80));
	lblpn.setFont(new Font("Comic Sans MS",Font.BOLD,30));
	
	lblplan.setBackground(new Color(250,150,80));
	lblplan.setFont(new Font("Comic Sans MS",Font.BOLD,30));	

	lblbankname.setBackground(new Color(250,150,80));
	lblbankname.setFont(new Font("Comic Sans MS",Font.BOLD,30));

	lblloanno.setBackground(new Color(250,150,80));
	lblloanno.setFont(new Font("Comic Sans MS",Font.BOLD,30));

	lblcharge.setBackground(new Color(250,150,80));
	lblcharge.setFont(new Font("Comic Sans MS",Font.BOLD,20));
	
	lblamt.setBackground(new Color(250,150,80));
	lblamt.setFont(new Font("Comic Sans MS",Font.BOLD,20));

	lbldiscount.setBackground(new Color(250,150,80));
	lbldiscount.setFont(new Font("Comic Sans MS",Font.BOLD,20));

	lbltotalamount.setBackground(new Color(250,150,80));
	lbltotalamount.setFont(new Font("Comic Sans MS",Font.BOLD,20));	

	lbldprice.setBackground(new Color(250,150,80));
	lbldprice.setFont(new Font("Comic Sans MS",Font.BOLD,20));	
		
	lbldownpayment.setBackground(new Color(250,150,80));
	lbldownpayment.setFont(new Font("Comic Sans MS",Font.BOLD,20));	
	
	lblnextpayment.setBackground(new Color(250,150,80));
	lblnextpayment.setFont(new Font("Comic Sans MS",Font.BOLD,20));	
	
	lblamt.setBackground(new Color(250,150,80));
	lblamt.setFont(new Font("Comic Sans MS",Font.BOLD,20));	
	
	lblinterval.setBackground(new Color(250,150,80));
	lblinterval.setFont(new Font("Comic Sans MS",Font.BOLD,20));	
	
	lbln.setBackground(new Color(250,150,80));
	lbln.setFont(new Font("Comic Sans MS",Font.BOLD,20));
	
	lbladdress.setBackground(new Color(250,150,80));
	lbladdress.setFont(new Font("Comic Sans MS",Font.BOLD,20));

	lblcarpetarea.setBackground(new Color(250,150,80));
	lblcarpetarea.setFont(new Font("Comic Sans MS",Font.BOLD,20));

	lblsuperbuiltuparea.setBackground(new Color(250,150,80));
	lblsuperbuiltuparea.setFont(new Font("Comic Sans MS",Font.BOLD,20));
	
	planlist.setBackground(new Color(250,150,80));
	planlist.setFont(new Font("Comic Sans MS",Font.BOLD,20));	

	lblbookid.setBounds(400,200,200,40);
	txbookid.setBounds(620,200,250,40);

	lblbookdate.setBounds(1000,200,300,40);
	txbookdate.setBounds(1300,200,250,40);

	lblcustomerid.setBounds(380,270,200,40);
	txcustomerid.setBounds(620,270,250,40);

	lblcustomername.setBounds(1000,270,300,40);
	txcustomername.setBounds(1300,270,250,40);	

	lblflatid.setBounds(300,340,300,40);
	txflatid.setBounds(620,340,250,40);
	
	lblpn.setBounds(1000,340,300,40);
	projectname.setBounds(1300,340,250,40);

	lbln.setBounds(500,400,200,40);
	txn.setBounds(710,400,200,40);
	
	lblcarpetarea.setBounds(500,450,200,40);
	txcarpetarea.setBounds(710,450,200,40);

	lblcharge.setBounds(500,500,200,40);
	txcharge.setBounds(710,500,200,40);

	lbldiscount.setBounds(500,550,200,40);
	txdiscount.setBounds(710,550,200,40);

	lbladdress.setBounds(980,400,200,40);
	txaddress.setBounds(1200,400,200,40);
	
	lblsuperbuiltuparea.setBounds(980,450,200,40);
	txsuperbuiltuparea.setBounds(1200,450,200,40);

	lbltotalamount.setBounds(980,500,200,40);
	txtotalamount.setBounds(1200,500,200,40);
	
	lbldprice.setBounds(980,550,300,40);
	txdprice.setBounds(1200,550,200,40);

	//lblbankname.setBounds(1000,590,250,40);
	//txbankname.setBounds(1300,590,250,40);
	
	lblplan.setBounds(400,620,250,40);
	planlist.setBounds(670,620,200,40);
	
	lbldownpayment.setBounds(500,680,200,40);
	txdownpayment.setBounds(710,680,200,40);
	
	lblinterval.setBounds(980,680,200,40);
	txinterval.setBounds(1200,680,200,40);
	
	lblnextpayment.setBounds(500,730,200,40);
	txnextpayment.setBounds(710,730,200,40);
	
	lblamt.setBounds(980,730,200,40);
	txamt.setBounds(1200,730,200,40);

	lblbankname.setBounds(400,800,200,40);
	txbankname.setBounds(620,800,200,40);

	lblloanno.setBounds(1000,800,250,40);
	txloanno.setBounds(1300,800,250,40);	

	bnew.setBounds(500,900,100,50);
	bbook.setBounds(600,900,100,50);
	bcancel.setBounds(700,900,100,50);

	add(lblbookid);
	add(txbookid);
	add(lblbookdate);
	add(txbookdate);
	add(lblcustomerid);
	add(txcustomerid);
	add(lblcustomername);
	add(txcustomername);
	add(lblflatid);
	add(txflatid);
	add(lbln);
	add(txn);
	add(lbladdress);
	add(txaddress);
	add(lblcarpetarea);
	add(txcarpetarea);
	add(lblsuperbuiltuparea);
	add(txsuperbuiltuparea);
	add(projectname);
	add(lblpn);
	add(lblcharge);
	add(txcharge);
	add(lbltotalamount);
	add(txtotalamount);
	add(lbldiscount);
	add(txdiscount);
	add(lbldprice);
	add(txdprice);
	add(lblplan);
	add(planlist);
	add(lbldownpayment);
	add(txdownpayment);
	add(lblnextpayment);
	add(txnextpayment);
	add(lblamt);
	add(txamt);
	add(lblinterval);
	add(txinterval);
	add(lblbankname);
	add(txbankname);
	add(lblloanno);
	add(txloanno);

	add(lbl);
	add(bnew);
	add(bbook);
	add(bcancel);
	
	bnew.addActionListener(this);
	bbook.addActionListener(this);
	bcancel.addActionListener(this);
}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bnew)
		{
                 	try
			{
			
                         	 Calendar cal=Calendar.getInstance();
                                   txbookdate.setText(""+cal.get(Calendar.DATE)+" / "+((cal.get(Calendar.MONTH))+1)+" / "+cal.get(Calendar.YEAR));
			 txbankname.setText("");
			 txloanno.setText("");
			// txinstallment.setText("");
			 txdiscount.setText("");
			 txtotalamount.setText("");
                  	 Connection con;
		   	 con=DriverManager.getConnection("jdbc:odbc:sms");
                   	 Statement st=con.createStatement();
                   	 ResultSet res=st.executeQuery("Select * from keytbl");
                   	 while(res.next())
                   	 {
                       		int x=Integer.parseInt(res.getString(5));
                      	        txbookid.setText("BOOK_"+String.format("%04d",x));   
                   	} 
			/*if((txpn.getText().length())==0)
			{
				JOptionPane.showMessageDialog(null,"Project name not provided");
			}*/
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
				res=st.executeQuery("Select * from booking where flat_id='"+txflatid.getText()+"'");
				while(res.next())
				{
					flg=1;

				}

				if(flg==1)
				{
					JOptionPane.showMessageDialog(null,"flat has been booked");
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
				res=st.executeQuery("Select * from booking where flat_id='"+txflatid.getText()+"'");
				while(res.next())
				{
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
				int flg=0,tflg=0;
				ResultSet res;
				ResultSet res1;
				ResultSet res2;
				Double totalcharge;
				String str=txflatid.getText();
				int k=str.length();
				int i=0;
				if(str.charAt(i)=='F')
				{	
				res=st.executeQuery("Select * from flat_info where flat_no='"+txflatid.getText()+"'");
				while(res.next())
				{
					txn.setText(""+res.getString(2));
					txaddress.setText(""+res.getString(3));
					txcarpetarea.setText(""+res.getString(5));
					txsuperbuiltuparea.setText(""+res.getString(6));
					txcharge.setText(""+res.getString(10));
					Double charge=Double.parseDouble(res.getString(10));
					Double ar=Double.parseDouble(res.getString(6));
					totalcharge=charge*ar;
					txtotalamount.setText(""+totalcharge);
				           Double discount=Double.parseDouble(txdiscount.getText());
					Double discountcharge=(discount/100)*totalcharge;
					Double finalcharge=totalcharge-discountcharge;
					txdprice.setText(""+finalcharge);
					flg=1;
				}
				res1=st.executeQuery("Select * from booking where flat_id='"+txflatid.getText()+"'");
				while(res1.next())
				{
						tflg=1;

				}
				if(tflg==1)
				{
					JOptionPane.showMessageDialog(null,"flat has been booked");
				}
				res2=st.executeQuery("Select * from booking where projectname='"+projectname.getSelectedItem()+"'");
				while(res2.next())
				{
						tflg=2;

				}
				if(tflg==2)
				{
					JOptionPane.showMessageDialog(null,"flat has been booked");
				}
				}
				if(str.charAt(i)=='D')
				{
				tflg=0;
				res=st.executeQuery("Select * from duplex_info where duplex_no='"+txflatid.getText()+"'");
				while(res.next())
				{
					txn.setText(""+res.getString(2));
					txaddress.setText(""+res.getString(3));
					txcarpetarea.setText(""+res.getString(5));
					//txpn.setText(""+res.getString(8));
					flg=1;
				}
				res1=st.executeQuery("Select * from booking where flat_id='"+txflatid.getText()+"'");
				while(res1.next())
				{	

					tflg=1;

				}
				if(tflg==1)
				{
					JOptionPane.showMessageDialog(null,"Duplex has been booked");
			
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
		    		res=st.executeQuery("Select * from owner_info where owner_id='"+txcustomerid.getText()+"'");
				while(res.next())
				{
					txcustomername.setText(""+res.getString(3));
					flg=1;
				}
				if(flg==0)
				JOptionPane.showMessageDialog(null,"Wrong id");
			}
                        catch(Exception ex)
			{
				System.out.println("ERROR:"+ex);
			}
		}
		if(e.getSource()==bbook)
		{
			try
			{
		  	 Connection con;
		   	 con=DriverManager.getConnection("jdbc:odbc:sms");
                   	 Statement st=con.createStatement();
                   
                   	   String str="insert into booking(book_id,book_date,customer_id,flat_id,plan,bank_name,loan_no,installment,discount,total_amount)values(?,?,?,?,?,?,?,?,?,?)";
		   	   PreparedStatement ps=con.prepareStatement(str);
			   ps.setString(1,txbookid.getText());
			   ps.setString(2,txbookdate.getText());
			   ps.setString(3,txcustomerid.getText());
			   ps.setString(4,txflatid.getText());
			   ps.setString(5,(String)planlist.getSelectedItem());
       	                   ps.setString(6,txbankname.getText());
			   ps.setString(7,txloanno.getText());
		  	//   ps.setString(8,txinstallment.getText());
		   	   ps.setString(9,txdiscount.getText());
		   	   ps.setString(10,txtotalamount.getText());
		   	   ps.executeUpdate();
		   	   JOptionPane.showMessageDialog(null,"Booking Successfull!!!");
			   str="update keytbl set book_id=book_id+1";
                  	   ps=con.prepareStatement(str);
                   	   ps.executeUpdate();
			 txbookid.setText("");
			 txbookdate.setText("");
			 txcustomerid.setText("");
			 txcustomername.setText("");
			 txflatid.setText("");
			// txpn.setText("");
			 txn.setText("");
			 txcarpetarea.setText("");
			 txaddress.setText("");
			 txbankname.setText("");
			 txloanno.setText("");
			// txinstallment.setText("");
			 txdiscount.setText("");
			 txtotalamount.setText("");
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
				String str1=txflatid.getText();
				int k=str1.length();
				int i=0;
				if(str1.charAt(i)=='F')
				{
                                   	
				String str="update flat_info set fstatus='occupied'"+" where flat_no='"+txflatid.getText()+"'";
				PreparedStatement ps=con.prepareStatement(str);
				ps.executeUpdate();
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
				String str1=txflatid.getText();
				int k=str1.length();
				int i=0;
				if(str1.charAt(i)=='D')
				{
                                   	
				String str="update duplex_info set fstatus='occupied'"+" where duplex_no='"+txflatid.getText()+"'";
				PreparedStatement ps=con.prepareStatement(str);
				ps.executeUpdate();
				}
			      }
                  catch(Exception ex)
                  {
                      System.out.println("ERROR:"+ex);
                  }
	}
		if(e.getSource()==bcancel)
		{
			this.dispose();
		}
	}
	public static void main(String argv[])throws IOException
	{
		booking obj=new booking();
}
}
		 