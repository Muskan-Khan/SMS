import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class maintenance extends Frame implements ActionListener
{
	JButton bnew=new JButton("New");
	JButton bsave=new JButton("Save");
	JButton bcancel=new JButton("Cancel");
	
	JTextField txbookid=new JTextField(10);
	JTextField txcustomerid=new JTextField(10);
	JTextField txcustomername=new JTextField(10);
	JTextField txflatid=new JTextField(10);
	JTextField txamt=new JTextField(10);
	JTextField txbankname=new JTextField(10);
	JTextField txbankbranch=new JTextField(10);
	JTextField tx=new JTextField(10);
	JTextField txtotal_amt=new JTextField(10);	


	JLabel lbltransactionid=new JLabel("TRANSACTION ID:");
	JLabel lblflatno=new JLabel("FLAT NO:");
	JLabel lblduplexno=new JLabel("DUPLEX NO:");
	JLabel lbldop=new JLabel("DATE OF PAYMENT:");
	JLabel lblprevread=new JLabel("PREVIOUS READING:");
	JLabel lblcloseread=new JLabel("CLOSING READING:");
	JLabel lblelecharge=new JLabel("ELECTRIC CHARGE:");
	JLabel lblwatercharge=new JLabel("WATER CHARGE:");
	JLabel lblmaintenancecharge=new JLabel("MAINTENANCE CHARGE:");
	JLabel lbltotalamt=new JLabel("TOTAL AMOUNT:");

	
	public maintenance()
	{
                
		setLayout(null);
                setSize(1500,1000);
                setTitle("---MAITENANCE---");
                setVisible(true);
                setBackground(new Color(200,150,80));

                lbltransactionid.setBackground(new Color(250,150,80));
                lbltransactionid.setFont(new Font("Monotype Corsiva",Font.BOLD,15));
                lbltransactionid.setBounds(100,80,400,40);

		lblflatno.setBackground(new Color(250,150,80));
                lblflatno.setFont(new Font("Monotype Corsiva",Font.BOLD,15));
                lblflatno.setBounds(100,135,400,40);

		lblduplexno.setBackground(new Color(250,150,80));
                lblduplexno.setFont(new Font("Monotype Corsiva",Font.BOLD,15));
                lblduplexno.setBounds(100,185,400,40);

		lbldop.setBackground(new Color(250,150,80));
                lbldop.setFont(new Font("Monotype Corsiva",Font.BOLD,15));
                lbldop.setBounds(100,235,400,40);

		lblprevread.setBackground(new Color(250,150,80));
                lblprevread.setFont(new Font("Monotype Corsiva",Font.BOLD,15));
                lblprevread.setBounds(100,285,400,40);

		lblcloseread.setBackground(new Color(250,150,80));
                lblcloseread.setFont(new Font("Monotype Corsiva",Font.BOLD,15));
                lblcloseread.setBounds(100,335,400,40);

		lblelecharge.setBackground(new Color(250,150,80));
                lblelecharge.setFont(new Font("Monotype Corsiva",Font.BOLD,15));
                lblelecharge.setBounds(100,385,400,40);

		lblwatercharge.setBackground(new Color(250,150,80));
                lblwatercharge.setFont(new Font("Monotype Corsiva",Font.BOLD,15));
                lblwatercharge.setBounds(100,435,400,40);

		lblmaintenancecharge.setBackground(new Color(250,150,80));
                lblmaintenancecharge.setFont(new Font("Monotype Corsiva",Font.BOLD,15));
                lblmaintenancecharge.setBounds(100,485,400,40);

		lbltotalamt.setBackground(new Color(250,150,80));
                lbltotalamt.setFont(new Font("Monotype Corsiva",Font.BOLD,15));
                lbltotalamt.setBounds(100,535,400,40);		



                txtransaction_id.setBounds(700,80,500,40);
		txflat_no.setBounds(700,135,500,40);
		txduplex_no.setBounds(700,185,500,40);
		txdop.setBounds(700,235,500,40);
		txprev_read.setBounds(700,285,500,40);
		txclose_read.setBounds(700,335,500,40);
		txele_charge.setBounds(700,385,500,40);
		txwater_charge.setBounds(700,435,500,40);
		txmaintenance_charge.setBounds(700,485,500,40);
		txtotal_amt.setBounds(700,535,500,40);

				
		bnew.setBounds(200,600,100,40);
		bsave.setBounds(320,600,100,40);
		bsearch.setBounds(440,600,100,40);
		bedit.setBounds(560,600,100,40);
		bcancel.setBounds(680,600,100,40);

		
		add(lbltransactionid);
		add(lblflatno);
		add(lblduplexno);
		add(lbldop);
		add(lblprevread);
		add(lblcloseread);
		add(lblelecharge);
		add(lblwatercharge);
		add(lblmaintenancecharge);
		add(lbltotalamt);
		
		add(txtransaction_id);
		add(txflat_no);
		add(txduplex_no);
		add(txdop);
		add(txprev_read);
		add(txclose_read);
		add(txele_charge);
		add(txwater_charge);
		add(txmaintenance_charge);
		add(txtotal_amt);

		add(bnew);
		add(bsave);
		add(bsearch);
		add(bedit);
		add(bcancel);

		

		bnew.addActionListener(this);
		bsave.addActionListener(this);
		bsearch.addActionListener(this);
		bedit.addActionListener(this);
		bcancel.addActionListener(this);
		
		
		

	}
	public void actionPerformed(ActionEvent e)
	{

		
		if(e.getSource()==bnew)
		{
			
		         txtransaction_id.setText("");
			 txflat_no.setText("");
			 txduplex_no.setText("");
			 txdop.setText("");
			 txprev_read.setText("");
 			 txclose_read.setText("");
			 txele_charge.setText("");
			 txwater_charge.setText("");
			 txmaintenance_charge.setText("");
			 txtotal_amt.setText("");
			JOptionPane.showMessageDialog(null,"Clearing Successfully");		
	}
                if(e.getSource()==bsave)
                {
                  try
                  {
                   Connection con;
		   con=DriverManager.getConnection("jdbc:odbc:sms");
                   Statement st=con.createStatement();
                   
                   String str="insert into maintenance(transaction_id,flat_no,duplex_no,dop,prev_read,close_read,ele_charge,water_charge,maintenance_charge,total_amt)values(?,?,?,?,?,?,?,?,?,?)";
		   PreparedStatement ps=con.prepareStatement(str);
		   ps.setString(1,txtransaction_id.getText());
		   ps.setString(2,txflat_no.getText());
		   ps.setString(3,txduplex_no.getText());
		   ps.setString(4,txdop.getText());
                   ps.setString(5,txprev_read.getText());
		   ps.setString(6,txclose_read.getText());
		   ps.setString(7,txele_charge.getText());
		   ps.setString(8,txwater_charge.getText());
		   ps.setString(9,txmaintenance_charge.getText());
		   ps.setString(10,txtotal_amt.getText());
		   
		   ps.executeUpdate();
		   JOptionPane.showMessageDialog(null,"Saved Successfully");
                  }
                  catch(Exception ex)
                  {
                      System.out.println("ERROR:"+ex);
                  }
                }
		if(e.getSource()==bsearch)
		{
			try
			{
				Connection con;
				con=DriverManager.getConnection("jdbc:odbc:sms");
				Statement st=con.createStatement();
				int flg=0;
				ResultSet res;
				res=st.executeQuery("Select * from maintenance where transaction_id='"+txtransaction_id.getText()+"'");
				while(res.next())
				{
				txflat_no.setText(""+res.getString(2));
				txduplex_no.setText(""+res.getString(3));
				txdop.setText(""+res.getString(4));
				txprev_read.setText(""+res.getString(5));
				txclose_read.setText(""+res.getString(6));
				txele_charge.setText(""+res.getString(7));
				txwater_charge.setText(""+res.getString(8));
				txmaintenance_charge.setText(""+res.getString(9));
				txtotal_amt.setText(""+res.getString(9));
				flg=1;
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
		}
			if(e.getSource()==bedit)
		{
		try
		{
		Connection con;
		con=DriverManager.getConnection("jdbc:odbc:sms");
		ResultSet res;
		Statement st=con.createStatement();
		res=st.executeQuery("Select * from maintenance");
		String str="update maintenance set transaction_id='"+txtransaction_id.getText()+"',flat_no='"+txflat_no.getText()+"',duplex_no='"+txduplex_no.getText()+"',dop='"+txdop.getText()+"',prev_read='"+txprev_read.getText()+"',close_read='"+txclose_read.getText()+"',ele_charge='"+txele_charge.getText()+"',water_charge='"+txwater_charge.getText()+"',maintenance_charge='"+txmaintenance_charge.getText()+"',total_amt='"+txtotal_amt.getText()+"' where transaction_id='"+txtransaction_id.getText()+"'";
		PreparedStatement ps=con.prepareStatement(str);
		ps.executeUpdate();
	JOptionPane.showMessageDialog(null,"Updated successfully");
	}
	catch(Exception ex)
	{
	System.out.println("Error:"+ex);
	}
	}	
            if(e.getSource()==bcancel)

                {
                       System.exit(0);
                }

	}

		        public static void main(String argv[])throws IOException
        		{
            		 maintenance obj=new maintenance();
        		}
		}