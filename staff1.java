import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class staff_info extends Frame implements ActionListener
{
	JButton bnew=new JButton("New");
	JButton bsave=new JButton("Save");
	JButton bsearch=new JButton("Search");
	JButton bedit=new JButton("Edit");
	JButton bcancel=new JButton("Cancel");
	
	JTextField txstaffid=new JTextField(10);
	JTextField txname=new JTextField(10);
	JTextField txdob=new JTextField(10);
	JTextField txaddress=new JTextField(10);
	JTextField txcity=new JTextField(10);
	JTextField txstate=new JTextField(10);
	JTextField txcontactno=new JTextField(10);
	JTextField txpostoffice=new JTextField(10);
	JTextField txpincode=new JTextField(10);
	JTextField txdesignation=new JTextField(10);
	JTextField txdop=new JTextField(10);
	
	JLabel lblstaffid=new JLabel("Staff ID: ");
        JLabel lbl=new JLabel("Staff Information ");
	JLabel lblname=new JLabel("Name: ");
	JLabel lblcity=new JLabel("City: ");
	JLabel lblgender=new JLabel("Gender: ");
	JLabel lbldob=new JLabel("D.O.B: ");
	JLabel lbladdress=new JLabel("Permanent Address: ");
	JLabel lblcontactno=new JLabel("Contact No: ");
	JLabel lblemail=new JLabel("Email: ");
	JLabel lbldoj=new JLabel("Date of joining: ");
	JLabel lblstate=new JLabel("State: ");
	JLabel lbldesignation=new JLabel("Designation: ");
	JLabel lblpincode=new JLabel("Pin Code: ");
	

	ButtonGroup cg=new ButtonGroup();
	JRadioButton b3=new JRadioButton("Male");
	JRadioButton b4=new JRadioButton("Female");	

	public staff_info()
	{
                
		setLayout(null);
                setSize(2100,1200);
                setTitle("STAFF INFO:::-");
                setVisible(true);
                //setBackground(new Color(200,150,80));
                
                lblstaffid.setBackground(new Color(250,150,80));
                lblstaffid.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                
		lblname.setBackground(new Color(250,150,80));
                lblname.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                
		lbldob.setBackground(new Color(250,150,80));
                lbldob.setFont(new Font("Comic Sans MS",Font.BOLD,30));
               
		lblgender.setBackground(new Color(250,150,80));
                lblgender.setFont(new Font("Comic Sans MS",Font.BOLD,30));
               
		lbladdress.setBackground(new Color(250,150,80));
                lbladdress.setFont(new Font("Comic Sans MS",Font.BOLD,30));
               
		lblcity.setBackground(new Color(250,150,80));
                lblcity.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                
		lblstate.setBackground(new Color(250,150,80));
                lblstate.setFont(new Font("Comic Sans MS",Font.BOLD,30));
	
		lblpostoffice.setBackground(new Color(250,150,80));
		lblpostoffice.setFont(new Font("Comic Sans MS",Font.BOLD,30));

		lblpincode.setBackground(new Color(250,150,80));
		lblpincode.setFont(new Font("Comic Sans MS",Font.BOLD,30));
		
                lblcontactno.setBackground(new Color(250,150,80));
                lblcontactno.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                
		lblemail.setBackground(new Color(250,150,80));
                lblemail.setFont(new Font("Comic Sans MS",Font.BOLD,30));

		lbldesignation.setBackground(new Color(250,150,80));
		lbldesignation.setFont(new Font("Comic Sans MS",Font.BOLD,30));

		lbldoj.setBackground(new Color(250,150,80));
		lbldoj.setFont(new Font("Comic Sans MS",Font.BOLD,30));

		b3.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
		b4.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
               
		lbl.setBackground(Color.red);		
                lbl.setFont(new Font("Comic Sans MS",Font.BOLD,60));
                lbl.setBounds(500,60,600,80);
		lbl.setForeground(Color.red);
                lblstaffid.setBounds(400,200,200,40);
                txstaffid.setBounds(700,200,400,40);
                lblname.setBounds(400,260,200,40);
		txname.setBounds(700,260,400,40);
                lbldob.setBounds(400,320,300,40);
		txdob.setBounds(700,320,400,40);
                lblgender.setBounds(400,380,200,40);
                b3.setBounds(700,380,140,40);
		b4.setBounds(900,380,140,40);
                lbladdress.setBounds(400,440,200,40);
		txaddress.setBounds(700,440,400,40);
                lblcity.setBounds(400,500,400,40);
		txcity.setBounds(700,500,400,40);
		lblstate.setBounds(400,560,200,40);
		txstate.setBounds(700,560,400,40);
                lblcontactno.setBounds(400,560,200,40);
		txcontactno.setBounds(700,560,400,40);
                lblemail.setBounds(400,620,200,40);
		txemail.setBounds(700,620,400,40);
                lblpostoffice.setBounds(400,680,200,40);
		txpostoffice.setBounds(700,680,400,40);
                lblpincode.setBounds(400,740,200,40);
		txpincode.setBounds(700,740,400,40);
                lbldesignation.setBounds(400,800,200,40);
		txdesignation.setBounds(700,800,400,40);
                lbldoj.setBounds(400,860,200,40);
		txdoj.setBounds(700,860,400,40);
				
		bnew.setBounds(500,880,100,40);
		bsave.setBounds(600,880,100,40);
		bsearch.setBounds(700,880,100,40);
		bedit.setBounds(800,880,100,40);
		bcancel.setBounds(900,880,100,40);
		
	        add(lbl);
		add(lblstaffid);
		add(lblname);
		add(lblgender);
		add(lbldob);
		add(lbladdress);
		add(lblcontactno);
		add(lblemail);
		add(lbldoj);
		add(lblcity);
		add(lblstate);
		add(lblpostoffice);
		add(lblpincode);
		add(lbldesignation);
		add(doj);

		add(staffid);
		add(txname);
		add(txdob);
		add(txaddress);
		add(txcity);
		add(txstate);
		add(txpostoffice);
		add(txcontactno);
		add(txemail);
		add(txdoj);
		add(txpincode);
		add(designation);

		add(bnew);
		add(bsave);
		add(bsearch);
		add(bedit);
		add(bcancel);

		add(b3);
		add(b4);
		cg.add(b3);
		cg.add(b4);

		bnew.addActionListener(this);
		bsave.addActionListener(this);
		bsearch.addActionListener(this);
		bedit.addActionListener(this);
		bcancel.addActionListener(this);
		
		b3.addActionListener(this);
		b4.addActionListener(this);
		repaint();

	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bnew)
		{
		        
			 txstaffid.setText("");
			 txname.setText("");
			 cg.clearSelection();
			 b4.setSelected(false);
			 txdob.setText("");
 			 txaddress.setText("");
			 txcontactno.setText("");
			 txemail.setText("");
			 txdoj.setText("");
			 txcity.setText("");
			 txstate.setText("");
			 txpostoffice.setText("");
			 txpincode.setText("");
	}
                if(e.getSource()==bsave)
                {
                  try
                  {
                   Connection con;
		   con=DriverManager.getConnection("jdbc:odbc:sms");
                   Statement st=con.createStatement();
                   
                   String str="insert into owner_info(flat_no,owner_id,oname,gender,dob,address,contact,email,dop)values(?,?,?,?,?,?,?,?,?)";
		   PreparedStatement ps=con.prepareStatement(str);
		   ps.setString(1,txflatno.getText());
		   ps.setString(2,txownerid.getText());
		   ps.setString(3,txname.getText());
                   if(b3.isSelected())
			ps.setString(4,"male");
		   else
			ps.setString(4,"female");
   		   ps.setString(5,txdob.getText());
		   ps.setString(6,txaddress.getText());
		   ps.setString(7,txcontactno.getText());
		   ps.setString(8,txemail.getText());
		   ps.setString(9,txdop.getText());
		   
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
				res=st.executeQuery("Select * from staff where staff_id='"+txstaffid.getText()+"'");
				while(res.next())
				{
				txflatno.setText(""+res.getString(2));
				txname.setText(""+res.getString(3));
				if(res.getString(4).equals("male"))
				{
				b3.setSelected(true);
				}
				else
				{
				b4.setSelected(true);
				}
				txdob.setText(""+res.getString(5));
				txaddress.setText(""+res.getString(6));
				txcontactno.setText(""+res.getString(7));
				txemail.setText(""+res.getString(8));
				txdop.setText(""+res.getString(9));
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
		res=st.executeQuery("Select * from staff");
		String gen;
		if(b3.isSelected())
			gen="male";
		else
			gen="female";
		String str="update staff set name='"+txname.getText()+"',dob='"+txdob.getText()+"',gender='"+gen+"',address='"+txaddress.getText()+"',city='"+txcity.getText()+"',state='"+txstate.getText()+"',post_office='"+txpostoffice.getText()+"',pin_code='"+txpincode.getText()+"',contact_no='"+txcontactno.getText()+"',designation='"+txdesignation.getText()+"',doj='"+txdoj.getText()+"' where staff_id='"+txstaffid.getText()+"'";
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
                       this.dispose();
                }

	}

		        public static void main(String argv[])throws IOException
        {
             owner_info obj=new owner_info();
        }
}