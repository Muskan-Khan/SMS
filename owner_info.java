import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class owner_info extends Frame implements ActionListener
{
	JButton bnew=new JButton("New",new ImageIcon("images/new.gif"));
	JButton bsave=new JButton("Save",new ImageIcon("images/save.gif"));
	JButton bsearch=new JButton("Search",new ImageIcon("images/search.png"));
	JButton bedit=new JButton("Edit",new ImageIcon("images/edit.png"));
	JButton bcancel=new JButton("Cancel",new ImageIcon("images/exit.png"));
	
	JTextField txownerid=new JTextField(10);
	JTextField txflatno=new JTextField(10);
	JTextField txname=new JTextField(10);
	JTextField txdob=new JTextField(10);
	JTextField txaddress=new JTextField(10);
	JTextField txcontactno=new JTextField(10);
	JTextField txemail=new JTextField(10);
	JTextField txdop=new JTextField(10);
	
	JLabel lblownerid=new JLabel("Owner ID: ");
        JLabel lbl=new JLabel("Owner Information ");
	JLabel lblname=new JLabel("Owner name ");
	JLabel lblgender=new JLabel("Gender: ");
	JLabel lbldob=new JLabel("D.O.B: ");
	JLabel lbladdress=new JLabel("Permanent Address: ");
	JLabel lblcontactno=new JLabel("Contact No: ");
	JLabel lblemail=new JLabel("Email: ");
	JLabel lbldop=new JLabel("Date of purchase: ");

	ButtonGroup cg=new ButtonGroup();
	JRadioButton b3=new JRadioButton("Male");
	JRadioButton b4=new JRadioButton("Female");	

	public owner_info()
	{
                
		setLayout(null);
                setSize(2100,1200);
                setTitle("OWNER INFO:::-");
                setVisible(true);
                //setBackground(new Color(200,150,80));
                
                lblownerid.setBackground(new Color(250,150,80));
                lblownerid.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                
		lblname.setBackground(new Color(250,150,80));
                lblname.setFont(new Font("Comic Sans MS",Font.BOLD,30));
               
		lblgender.setBackground(new Color(250,150,80));
                lblgender.setFont(new Font("Comic Sans MS",Font.BOLD,30));
               
		lbldob.setBackground(new Color(250,150,80));
                lbldob.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                
		lbladdress.setBackground(new Color(250,150,80));
                lbladdress.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                
		lblcontactno.setBackground(new Color(250,150,80));
                lblcontactno.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                
		lblemail.setBackground(new Color(250,150,80));
                lblemail.setFont(new Font("Comic Sans MS",Font.BOLD,30));
		b3.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
		b4.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
               
		lbldop.setBackground(new Color(250,150,80));
                lbldop.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                lbl.setBackground(Color.red);		
                lbl.setFont(new Font("Comic Sans MS",Font.BOLD,60));
                lbl.setBounds(500,60,600,80);
		lbl.setForeground(Color.red);
                lblownerid.setBounds(400,200,200,40);
                txownerid.setBounds(700,200,400,40);
                lblname.setBounds(400,260,200,40);
		txname.setBounds(700,260,400,40);
                lblgender.setBounds(400,320,200,40);
                b3.setBounds(700,320,140,40);
		b4.setBounds(900,320,140,40);
                lbldob.setBounds(400,380,200,40);
		txdob.setBounds(700,380,400,40);
                lbladdress.setBounds(400,440,400,40);
		txaddress.setBounds(700,440,400,40);
                lblcontactno.setBounds(400,500,200,40);
		txcontactno.setBounds(700,500,400,40);
                lblemail.setBounds(400,560,200,40);
		txemail.setBounds(700,560,400,40);
                lbldop.setBounds(400,620,300,40);
		txdop.setBounds(700,620,400,40);
				
		bnew.setBounds(500,750,100,40);
		bsave.setBounds(600,750,100,40);
		bsearch.setBounds(700,750,100,40);
		bedit.setBounds(800,750,100,40);
		bcancel.setBounds(900,750,100,40);
		
	        add(lbl);
		add(lblownerid);
		add(lblname);
		add(lblgender);
		add(lbldob);
		add(lbladdress);
		add(lblcontactno);
		add(lblemail);
		add(lbldop);

		add(txownerid);
		add(txname);
		add(txdob);
		add(txaddress);
		add(txcontactno);
		add(txemail);
		add(txdop);

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
			 txownerid.setText("");
			 txname.setText("");
			 cg.clearSelection();
			 b4.setSelected(false);
			 txdob.setText("");
 			 txaddress.setText("");
			 txcontactno.setText("");
			 txemail.setText("");
			 txdop.setText("");
                   try
                   {
                   Connection con;
		   con=DriverManager.getConnection("jdbc:odbc:sms");
                   Statement st=con.createStatement();
                   ResultSet res=st.executeQuery("Select * from keytbl");
                   while(res.next())
                   {
                       int x=Integer.parseInt(res.getString(1));
                       txownerid.setText("OWN_"+String.format("%04d",x));   
                   }
                   }
                   catch(Exception ex)
                   {
			System.out.println("Error:"+ex);
		   }
		
	}
                if(e.getSource()==bsave)
                {
                  try
                  {
                     
		 Connection con;
		   con=DriverManager.getConnection("jdbc:odbc:sms");
                         Statement st=con.createStatement();
                   ////////////////////////////////////////
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
                        String str="insert into owner_info(owner_id,oname,gender,dob,address,contact,email,dop)values(?,?,?,?,?,?,?,?)";
		   PreparedStatement ps=con.prepareStatement(str);
		   ps.setString(1,txownerid.getText());
		   ps.setString(2,txname.getText());
                   if(b3.isSelected())
			ps.setString(3,"male");
		   else
			ps.setString(3,"female");
   		   ps.setString(4,txdob.getText());
		   ps.setString(5,txaddress.getText());
		   ps.setString(6,txcontactno.getText());
		   ps.setString(7,txemail.getText());
		   ps.setString(8,txdop.getText());
		   ps.executeUpdate();
		   JOptionPane.showMessageDialog(null,"Saved Successfully");
                   ResultSet res=st.executeQuery("update keytbl set owner_id=owner_id+1");
                  }
	else
	{
		 JOptionPane.showMessageDialog(null,"Date Invalid!!!");
	}
		
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
				res=st.executeQuery("Select * from owner_info where owner_id='"+txownerid.getText()+"'");
				while(res.next())
				{
				txname.setText(""+res.getString(2));
				if(res.getString(3).equals("male"))
				{
				b3.setSelected(true);
				}
				else
				{
				b4.setSelected(true);
				}
				txdob.setText(""+res.getString(4));
				txaddress.setText(""+res.getString(5));
				txcontactno.setText(""+res.getString(6));
				txemail.setText(""+res.getString(7));
				txdop.setText(""+res.getString(8));
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
		res=st.executeQuery("Select * from owner_info");
		String gen;
		if(b3.isSelected())
			gen="male";
		else
			gen="female";
		String str="update owner_info set oname='"+txname.getText()+"',gender='"+gen+"',dob='"+txdob.getText()+"',address='"+txaddress.getText()+"',contact='"+txcontactno.getText()+"',email='"+txemail.getText()+"',dop='"+txdop.getText()+"' where owner_id='"+txownerid.getText()+"'";
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