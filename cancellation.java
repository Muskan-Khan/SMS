import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.font.*;
import java.util.Calendar;
public class cancellation extends Frame implements ActionListener
{
	JButton bnew=new JButton("New",new ImageIcon("images/new.gif"));
	JButton bsubmit=new JButton("Submit",new ImageIcon("images/restore.gif"));
	JButton bexit=new JButton("Exit",new ImageIcon("images/exit.png"));
	
	JTextField txbookid=new JTextField(10);
	JTextField txdate=new JTextField(10);
	JTextField txownerid=new JTextField(10);
	JTextField txflatid=new JTextField(10);
	JTextField txpaymentrcv=new JTextField(20);
	JTextField txdueamount=new JTextField(10);
	JTextField txdeductionmade=new JTextField(10);
	JTextField txamtrefund=new JTextField(10);
	JTextField txreason=new JTextField(10);
	
	JLabel lbl=new JLabel("CANCELLATION");
	JLabel lblbookid=new JLabel("Enter Booking ID: ");
	JLabel lbldate=new JLabel("Cancellation Date: ");
	JLabel lblownerid=new JLabel("Owner ID: ");
	JLabel lblflatid=new JLabel("Flat/Duplex ID: ");
	JLabel lblpaymentrcv=new JLabel("Payment received: ");
	JLabel lbldueamount=new JLabel("Due Amount: ");
	JLabel lbldeductionmade=new JLabel("Deduction made: ");
	JLabel lblamtrefund=new JLabel("Amount refunded(if any): ");
	JLabel lblreason=new JLabel("Reason for cancellation: ");

	public cancellation()
	{
		setLayout(null);
                	setSize(2100,1500);
                	setTitle("FLAT INFO:::-");
                	setVisible(true);
		lbl.setFont(new Font("Comic Sans MS",Font.BOLD,50));
		lbl.setForeground(Color.red);
		lbl.setBounds(500,80,500,80);
                	lblbookid.setBackground(new Color(250,150,80));
                	lblbookid.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                	
		lblbookid.setBounds(300,200,400,40);
		txbookid.setBounds(700,200,300,40);
		
		lbldate.setBackground(new Color(250,150,80));
                	lbldate.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                	
		lbldate.setBounds(300,260,400,40);
		txdate.setBounds(700,260,300,40);
		
		lblownerid.setBackground(new Color(250,150,80));
                	lblownerid.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                	
		lblownerid.setBounds(300,320,400,40);
		txownerid.setBounds(700,320,300,40);
		
		lblflatid.setBackground(new Color(250,150,80));
                	lblflatid.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                	
		lblflatid.setBounds(300,380,400,40);
		txflatid.setBounds(700,380,300,40);
		
		lblpaymentrcv.setBackground(new Color(250,150,80));
                	lblpaymentrcv.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                	
		lblpaymentrcv.setBounds(300,440,400,40);
		txpaymentrcv.setBounds(700,440,300,40);
		
		lbldueamount.setBackground(new Color(250,150,80));
                	lbldueamount.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                	
		lbldueamount.setBounds(300,500,400,40);
		txdueamount.setBounds(700,500,300,40);
		
		lbldeductionmade.setBackground(new Color(250,150,80));
                       lbldeductionmade.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                	
		lbldeductionmade.setBounds(300,560,400,40);
		txdeductionmade.setBounds(700,560,300,40);
		
		lblamtrefund.setBackground(new Color(250,150,80));
                	lblamtrefund.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                	
		lblamtrefund.setBounds(300,620,400,40);
		txamtrefund.setBounds(700,620,300,40);		

		lblreason.setBackground(new Color(250,150,80));
                	lblreason.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                	
		lblreason.setBounds(300,680,400,40);
		txreason.setBounds(700,680,300,40);		
		bnew.setBounds(400,800,150,40);		
		bsubmit.setBounds(550,800,150,40);
		bexit.setBounds(700,800,150,40);
		
		add(lbl);
		add(lblbookid);
		add(lbldate);
		add(lblownerid);
		add(lblflatid);
		add(lblpaymentrcv);
		add(lbldueamount);
		add(lbldeductionmade);
		add(lblamtrefund);
		add(lblreason);

		add(txbookid);
		add(txdate);
		add(txownerid);
		add(txflatid);
		add(txpaymentrcv);
		add(txdueamount);
		add(txdeductionmade);
		add(txamtrefund);
		add(txreason);

		add(bnew);
		add(bsubmit);
		add(bexit);
		
		bnew.addActionListener(this);
		bsubmit.addActionListener(this);
		bexit.addActionListener(this);	
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bnew)
		{
		      	try
			 {
			 Calendar cal=Calendar.getInstance();
                                   txdate.setText(""+cal.get(Calendar.DATE)+" / "+((cal.get(Calendar.MONTH))+1)+" / "+cal.get(Calendar.YEAR));
			 txdeductionmade.setText("");
			 txamtrefund.setText("");
			 txreason.setText("");
			 
			 	Connection con;
				con=DriverManager.getConnection("jdbc:odbc:sms");
				Statement st=con.createStatement();
				int flg=0;
				ResultSet res;
				res=st.executeQuery("Select * from booking where book_id='"+txbookid.getText()+"'");
				while(res.next())
				{
					flg=1;
					txownerid.setText(""+res.getString(3));
					txflatid.setText(""+res.getString(4));
					txpaymentrcv.setText(""+res.getString(6));
					txdueamount.setText(""+res.getString(7));
				
				}
				if(flg==0)
				{
					JOptionPane.showMessageDialog(null,"Booking ID not found");
				}
				}
				catch(Exception ex)
				{
					System.out.println("Error:"+ex);
                			}
	    		}
                if(e.getSource()==bsubmit)
                {
                  try
                  {
                          Connection con;
		   con=DriverManager.getConnection("jdbc:odbc:sms");
                  	   Statement st=con.createStatement();
                   	   String str="insert into cancellation(book_id,book_date,owner_id,flat_id,deduction,amtrefund,reason)values(?,?,?,?,?,?,?)";
		   PreparedStatement ps=con.prepareStatement(str);
		   ps.setString(1,txbookid.getText());
		   ps.setString(2,txdate.getText());
		   ps.setString(3,txownerid.getText());
		   ps.setString(4,txflatid.getText());
                  	   ps.setString(5,txdeductionmade.getText());
		   ps.setString(6,txamtrefund.getText());
		   ps.setString(7,txreason.getText());
		   ps.executeUpdate();
		   JOptionPane.showMessageDialog(null,"Cancellation Successfull");
		   Connection con1;
		con1=DriverManager.getConnection("jdbc:odbc:sms");
		ResultSet res;
		Statement st1=con.createStatement();
		res=st1.executeQuery("Select * from booking");
		String s="Cancelled";
		String str1="update booking set status='"+s+"'";
		PreparedStatement ps1=con.prepareStatement(str1);
		ps1.executeUpdate();
		 }
                  catch(Exception ex)
                  {
                      System.out.println("ERROR:"+ex);
                  }
			try
			{
			   txbookid.setText("");
			   txdate.setText("");
			   txownerid.setText("");
			   txflatid.setText("");
			   txpaymentrcv.setText("");
			   txdeductionmade.setText("");
			   txreason.setText("");
			   
     			}
			catch(Exception ex)
			{
				System.out.println("Exception:::"+ex);
			}
		try
		{
		Connection con;
		con=DriverManager.getConnection("jdbc:odbc:sms");
		ResultSet res;
		Statement st=con.createStatement();
		String id=txflatid.getText();
		if(id.charAt(0)=='F')
		{
		String str="update flat_info set fstatus='empty'";
		PreparedStatement ps=con.prepareStatement(str);
		ps.executeUpdate();
		}
		else if(id.charAt(0)=='D')
		{
			String str="update duplex_info set fstatus='empty'";
			PreparedStatement ps=con.prepareStatement(str);
			ps.executeUpdate();
		}
	}
	catch(Exception ex)
	{
	System.out.println("Error:"+ex);
	}
 }
	    if(e.getSource()==bexit)
                {
                       this.dispose();
                }
}
	public static void main(String argv[])throws IOException
            {
     	        cancellation obj=new cancellation();
        	 }
}