import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
public class staff extends Frame implements ActionListener
{
		JLabel l1=new JLabel("STAFF ID:-");
		JLabel l2=new JLabel("FIRST NAME:-");
		JLabel l3=new JLabel("LAST NAME:-");	        
		JLabel l4=new JLabel("AGE:-");
		JLabel l5=new JLabel("ADDRESS:-");
		JLabel l6=new JLabel("CITY:-");
		JLabel l7=new JLabel("STATE:-");
		JLabel l8=new JLabel("EMAIL-ID:-");
		JLabel l9=new JLabel("PHONE:-");
		JLabel l10=new JLabel("GENDER:-");
		JLabel l11=new JLabel("DESIGNATION:-");
		JLabel l12=new JLabel("POST OFFICE:-");
		JLabel l13=new JLabel("PIN-CODE:-");

	        JTextField txstaff_id=new JTextField (5);
		JTextField txfirst_name=new JTextField (15);		
		JTextField txlast_name=new JTextField (15);
		JTextField txage=new JTextField (3);
		JTextField txaddress=new JTextField (30);
		JTextField txcity=new JTextField (15);
		JTextField txstate=new JTextField (15);
		JTextField txe_mail=new JTextField (25);
		JTextField txphone_no=new JTextField (10);
		JTextField txdesignation=new JTextField (5);
		JTextField txpost_office=new JTextField (15);
		JTextField txpin_code=new JTextField (15);
			
		ButtonGroup cg=new ButtonGroup();

	        
		JButton bsave=new JButton("SAVE");
		JButton bnew=new JButton("NEW");
		JButton bcancel=new JButton("CANCEL");
		JRadioButton b3=new JRadioButton("MALE");
		JRadioButton b4=new JRadioButton("FEMALE");
		

       public staff()
       {
                setLayout(null);
		setSize(1000,1000);
		setTitle("STAFF DETAILS:--");
		setVisible(true);
		setBackground(new Color(150,190,80));
		l1.setBackground(new Color(200,40,124));
		l1.setFont(new Font("Monotype Corsiva",Font.BOLD,30));
		l2.setBackground(new Color(200,40,124));
		l2.setFont(new Font("Monotype Corsiva",Font.BOLD,30));
		l3.setBackground(new Color(200,40,124));
		l3.setFont(new Font("Monotype Corsiva",Font.BOLD,30));
		l4.setBackground(new Color(200,40,124));
		l4.setFont(new Font("Monotype Corsiva",Font.BOLD,30));
		l5.setBackground(new Color(200,40,124));
		l5.setFont(new Font("Monotype Corsiva",Font.BOLD,30));
		l6.setBackground(new Color(200,40,124));
		l6.setFont(new Font("Monotype Corsiva",Font.BOLD,30));
		l7.setBackground(new Color(200,40,124));
		l7.setFont(new Font("Monotype Corsiva",Font.BOLD,30));
		l8.setBackground(new Color(200,40,124));
		l8.setFont(new Font("Monotype Corsiva",Font.BOLD,30));
		l9.setBackground(new Color(200,40,124));
		l9.setFont(new Font("Monotype Corsiva",Font.BOLD,30));
		l10.setBackground(new Color(200,40,124));
		l10.setFont(new Font("Monotype Corsiva",Font.BOLD,30));
		l11.setBackground(new Color(200,40,124));
		l11.setFont(new Font("Monotype Corsiva",Font.BOLD,30));
		l12.setBackground(new Color(200,40,124));
		l12.setFont(new Font("Monotype Corsiva",Font.BOLD,30));
		l13.setBackground(new Color(200,40,124));
		l13.setFont(new Font("Monotype Corsiva",Font.BOLD,30));

		b3.setBackground(new Color(150,190,80));
		b3.setFont(new Font("Monotype Corsiva",Font.BOLD,30));
		b4.setBackground(new Color(150,190,80));
		b4.setFont(new Font("Monotype Corsiva",Font.BOLD,30));
		
		l1.setBounds(100,40,250,35);
		l2.setBounds(100,80,250,35);
		l3.setBounds(100,120,250,35);				
		l4.setBounds(100,160,250,35);
		l5.setBounds(100,200,250,35);
                l6.setBounds(100,240,250,35);
		l7.setBounds(100,280,250,35);	
		l8.setBounds(100,320,250,35);
		l9.setBounds(100,360,250,35);
		l10.setBounds(100,400,250,35);
		l11.setBounds(100,440,250,35);
		l12.setBounds(100,480,250,35);
		l13.setBounds(100,520,250,35);

		txstaff_id.setBounds(400,40,250,35);
		txfirst_name.setBounds(400,80,250,35);
		txlast_name.setBounds(400,120,250,35);
		txage.setBounds(400,160,250,35);
		txaddress.setBounds(400,200,250,35);
		txcity.setBounds(400,240,250,35);
		txstate.setBounds(400,280,250,35);
		txe_mail.setBounds(400,320,250,35);
		txphone_no.setBounds(400,360,250,35);
		txdesignation.setBounds(400,440,250,35);
		txpost_office.setBounds(400,480,250,35);
		txpin_code.setBounds(400,520,250,35);
		
		
		bsave.setBounds(150,600,100,30);
		bnew.setBounds(350,600,100,30);
		bcancel.setBounds(550,600,100,30);
		b3.setBounds(400,400,120,30);
		b4.setBounds(580,400,170,30);		

		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		add(l11);
		add(l12);
		add(l13);
                add(txstaff_id);
		add(txfirst_name);
		add(txlast_name);
		add(txage);
		add(txaddress);
		add(txcity);
		add(txstate);
		add(txe_mail);
		add(txphone_no);
		add(txdesignation);
		add(txpost_office);
		add(txpin_code);
		

		add(bsave);
		add(bnew);
		add(bcancel);
		cg.add(b3);
		cg.add(b4);
                add(b3);
                add(b4);
		bsave.addActionListener(this);
		bnew.addActionListener(this);
		bcancel.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		


       }
       public void actionPerformed(ActionEvent e)
       {
              if(e.getSource()==bnew)
              {
			txstaff_id.setText("");
			txfirst_name.setText("");
			txlast_name.setText("");
			txage.setText("");
			txaddress.setText("");
			txcity.setText("");
			txstate.setText("");
			txe_mail.setText("");
			txphone_no.setText("");
			txdesignation.setText("");
			txpost_office.setText("");	
			txpin_code.setText("");
			
		}
		if(e.getSource()==bsave)
		{
		try
		{
		Connection con;
		con=DriverManager.getConnection("jdbc:odbc:sms");
		Statement st=con.createStatement();
		String str="insert into staff(staff_id,first_name,last_name,age,address,city,state,e_mail,phone_no,gender,designation,post_office,pin_code)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(str);
                ps.setString(1,txstaff_id.getText());
		ps.setString(2,txfirst_name.getText());
		ps.setString(3,txlast_name.getText());
		ps.setString(4,txage.getText());
		ps.setString(5,txaddress.getText());
		ps.setString(6,txcity.getText());
		ps.setString(7,txstate.getText());
		ps.setString(8,txe_mail.getText());
		ps.setString(9,txphone_no.getText());
                if(b3.isSelected())
                ps.setString(10,"Male");
                else
		ps.setString(10,"Female");
                ps.setString(11,txdesignation.getText());
		ps.setString(12,txpost_office.getText());	
		ps.setString(13,txpin_code.getText());
		ps.executeUpdate();	
		JOptionPane.showMessageDialog(null,"Saved successfully");
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
		 staff obj=new staff();
		}
	
}

