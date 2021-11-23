import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class staffc extends Frame implements ActionListener
{
	JButton bnew=new JButton("New",new ImageIcon("images/new.gif"));
	JButton bsave=new JButton("Save",new ImageIcon("images/save.gif"));
	JButton bsearch=new JButton("Search",new ImageIcon("images/search.png"));
	JButton bedit=new JButton("Edit",new ImageIcon("images/edit.png"));
	JButton bcancel=new JButton("Cancel",new ImageIcon("images/exit.png"));
	
	JTextField txstaffid=new JTextField(10);
	JTextField txname=new JTextField(10);
	JTextField txage=new JTextField(10);
	JTextField txaddress=new JTextField(10);
	JTextField txcontactno=new JTextField(10);
	JTextField txemail=new JTextField(10);
	JTextField txdesignation=new JTextField(10);
	
	JLabel lblstaffid=new JLabel("Staff ID: ");
           JLabel lbl=new JLabel("Staff Information ");
	JLabel lblname=new JLabel("Staff name ");
	JLabel lblgender=new JLabel("Gender: ");
	JLabel lblage=new JLabel("Age: ");
	JLabel lbladdress=new JLabel("Permanent Address: ");
	JLabel lblcontactno=new JLabel("Contact No: ");
	JLabel lblemail=new JLabel("Email: ");
	JLabel lbldesignation=new JLabel("Designation: ");

	ButtonGroup cg=new ButtonGroup();
	JRadioButton b3=new JRadioButton("Male");
	JRadioButton b4=new JRadioButton("Female");	

	public staffc()
	{
                
		setLayout(null);
                setSize(2100,1200);
                setTitle("OWNER INFO:::-");
                setVisible(true);
                
                lblstaffid.setBackground(new Color(250,150,80));
                lblstaffid.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                
		lbladdress.setBackground(new Color(250,150,80));
                lbladdress.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                
		lblname.setBackground(new Color(250,150,80));
                lblname.setFont(new Font("Comic Sans MS",Font.BOLD,30));
               
		lblgender.setBackground(new Color(250,150,80));
                lblgender.setFont(new Font("Comic Sans MS",Font.BOLD,30));
               
		lblage.setBackground(new Color(250,150,80));
                lblage.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                
	      lblcontactno.setBackground(new Color(250,150,80));
                lblcontactno.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                
	      lblemail.setBackground(new Color(250,150,80));
                lblemail.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                
		lbldesignation.setBackground(new Color(250,150,80));
                     lbldesignation.setFont(new Font("Comic Sans MS",Font.BOLD,30));
		
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
                lbladdress.setBounds(400,320,350,40);
		txaddress.setBounds(700,320,400,40);
                lblgender.setBounds(400,380,200,40);
                b3.setBounds(700,380,140,40);
	      b4.setBounds(900,380,140,40);
                lblage.setBounds(400,440,200,40);
	     txage.setBounds(700,440,400,40);
                lblcontactno.setBounds(400,500,400,40);
	     txcontactno.setBounds(700,500,400,40);
                lblemail.setBounds(400,560,200,40);
	     txemail.setBounds(700,560,400,40);
                lbldesignation.setBounds(400,620,200,40);
	     txdesignation.setBounds(700,620,400,40);
				
		bnew.setBounds(500,700,100,40);
		bsave.setBounds(600,700,100,40);
		bsearch.setBounds(700,700,100,40);
		bedit.setBounds(800,700,100,40);
		bcancel.setBounds(900,700,100,40);
		
	           add(lbl);
		add(lblstaffid);
		add(lblname);
		add(lblgender);
		add(lbladdress);
		add(lblage);
		add(lblcontactno);
		add(lblemail);
		add(lbldesignation);

		add(txstaffid);
		add(txname);
		add(txdesignation);
		add(txaddress);
		add(txcontactno);
		add(txemail);
		add(txage);

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
			 txaddress.setText("");
			 cg.clearSelection();
			 b4.setSelected(false);
			 txage.setText("");
			 txcontactno.setText("");
			 txemail.setText("");
			 txdesignation.setText("");
                   try
                   {
                   Connection con;
		   con=DriverManager.getConnection("jdbc:odbc:sms");
                   Statement st=con.createStatement();
                   ResultSet res=st.executeQuery("Select * from keytbl");
                   while(res.next())
                   {
                       int x=Integer.parseInt(res.getString(2));
                       txstaffid.setText("S_"+String.format("%04d",x));   
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
                         String str="insert into staff(staff_id,name,address,gender,age,contactno,e_mail,designation)values(?,?,?,?,?,?,?,?)";
		   PreparedStatement ps=con.prepareStatement(str);
		   ps.setString(1,txstaffid.getText());
		   ps.setString(2,txname.getText());
		   ps.setString(3,txaddress.getText());
                   	   if(b3.isSelected())
			ps.setString(4,"male");
		   else
			ps.setString(4,"female");
   		   ps.setString(5,txage.getText());
		   ps.setString(6,txcontactno.getText());
		   ps.setString(7,txemail.getText());
		   ps.setString(8,txdesignation.getText());
		   ps.executeUpdate();
		   JOptionPane.showMessageDialog(null,"Saved Successfully");
                   ResultSet res=st.executeQuery("update keytbl set staff_id=staff_id+1");
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
				JOptionPane.showMessageDialog(null,"Please provide the staff_id!!!");
				Connection con;
				con=DriverManager.getConnection("jdbc:odbc:sms");
				Statement st=con.createStatement();
				int flg=0;
				ResultSet res;
				res=st.executeQuery("Select * from staff where staff_id='"+txstaffid.getText()+"'");
				while(res.next())
				{
				txname.setText(""+res.getString(2));
				txaddress.setText(""+res.getString(3));
				if(res.getString(4).equals("male"))
				{
				b3.setSelected(true);
				}
				else
				{
				b4.setSelected(true);
				}
				txage.setText(""+res.getString(5));
				txcontactno.setText(""+res.getString(6));
				txemail.setText(""+res.getString(7));
				txdesignation.setText(""+res.getString(8));
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
		String str="update staff set name='"+txname.getText()+"',address='"+txaddress.getText()+"',gender='"+gen+"',age='"+txage.getText()+"',contactno='"+txcontactno.getText()+"',e_mail='"+txemail.getText()+"',designation='"+txdesignation.getText()+"' where staff_id='"+txstaffid.getText()+"'";
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
             staffc obj=new staffc();
        }
}