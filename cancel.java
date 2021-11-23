import java.awt.*; //abstarct windowing toolkit
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class cancel extends Frame implements ActionListener
{
		JLabel lblTitle=new JLabel("CANCEL DETAILS");
	JLabel lblbkid=new JLabel("Enter Booking Id:-");
    JLabel lbldt=new JLabel("Enter Date:-");
	JLabel lblcid=new JLabel("Enter Customer Id:-");
	JLabel lblcname=new JLabel("Enter Customer Name:-");
	JLabel lblfdno=new JLabel("Enter Flat No /Duplex No :-");
	JLabel lblcnpdamt=new JLabel("Enter Cancel Paid Amt:-");
	JLabel lblrefndbal=new JLabel("Enter Refund Balance:-");
	JLabel lblppdamt=new JLabel("Enter Previous Amount Paid:-");
	JLabel lbltac=new JLabel("Enter Terms And Conditions:-");
	        Label lblbookid=new Label("             ");
		JTextField txtdt=new JTextField(30);
		JTextField txtcid=new JTextField(30);
	JTextField txtcname=new JTextField(30);
	JTextField txtfdno=new JTextField(30);
	JTextField txtcnpdamt=new JTextField(30);
	JTextField txtrefndbal=new JTextField(30);
	JTextField txtppdamt=new JTextField(30);
	JTextField txttac=new JTextField(30);
		 	 JButton REFRESH=new JButton("REFRESH",new ImageIcon("Images/restore.png"));
			 JButton CALCULATE=new JButton("CALCULATE",new ImageIcon("Images/calc.png"));
			 JButton EXIT=new JButton("EXIT",new ImageIcon("Images/exit.png"));

	       public cancel()
	{
	   setLayout(null);
			setBackground(new Color(255,255,255));
		setVisible(true);
						Dimension Screen=Toolkit.getDefaultToolkit().getScreenSize();
				setSize(Screen.width,Screen.height);
		lblTitle.setBounds(600,50,450,50);
lblTitle.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,40));
lblTitle.setForeground(Color.GRAY);   
				 lblTitle.setBounds(500,50,450,35);
		lblbkid.setBounds(200,150,160,35);
	 	lblbookid.setBounds(430,150,200,35);
		lbldt.setBounds(750,150,160,35);
		txtdt.setBounds(970,150,200,35);
		lblcid.setBounds(200,200,200,35);
		txtcid.setBounds(430,200,200,35);
        lblcname.setBounds(750,200,200,35);
		txtcname.setBounds(970,200,200,35);
        lblfdno.setBounds(200,250,240,35);
		txtfdno.setBounds(430,250,200,35);
        lblcnpdamt.setBounds(750,250,300,35);
		txtcnpdamt.setBounds(970,250,200,35);
		 lblrefndbal.setBounds(200,300,360,35);
		txtrefndbal.setBounds(430,300,200,35);
				 lblppdamt.setBounds(750,300,400,35);
		txtppdamt.setBounds(970,300,200,35);
						 lbltac.setBounds(200,360,400,35);
		txttac.setBounds(430,360,650,35);
						REFRESH.setBounds(500,460,120,40);
						CALCULATE.setBounds(660,460,130,40);
						EXIT.setBounds(830,460,100,40);
		
		
		
		lblbkid.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
		lblbookid.setBackground(new Color(212,212,212)); 
		lbldt.setFont(new Font ("Monotype Corsiva",Font.ITALIC,20)); 
		lblcid.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
		lblcname.setFont(new Font ("Monotype Corsiva",Font.ITALIC,20));
		lblfdno.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
		lblcnpdamt.setFont(new Font	("Monotype Corsiva",Font.ITALIC,20));
		lblrefndbal.setFont(new Font ("Monotype Corsiva",Font.ITALIC,20));
		lblppdamt.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
        lbltac.setFont(new Font		("Monotype Corsiva",Font.ITALIC,20));
			
	    lblbookid.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
		txtdt.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
		txtcid.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
		txtcname.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
		txtfdno.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
		txtcnpdamt.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
		txtrefndbal.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
		txttac.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
				txtppdamt.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
				
         add(lblTitle);
		add(lblbkid);
		add(lblbookid);
        add(lbldt);
		add(txtdt);
		add(lblcid);
		add(txtcid);
		add(lblcname);
				add(REFRESH);
				add(CALCULATE);
				add(EXIT);
		add(txtcname);
		add(lblfdno);
		add(txtfdno);
		add(lblcnpdamt);
		add(txtcnpdamt);
		add(lblrefndbal);
		add(txtrefndbal);
		add(lblppdamt);
		add(txtppdamt);
		add(lbltac);
		add(txttac);
		 REFRESH.addActionListener(this);   
		CALCULATE.addActionListener(this);   
		EXIT.addActionListener(this);   
		
		
}
///////////////////////////////////////////////////
public void actionPerformed(ActionEvent e)
{

if(e.getSource()==REFRESH)
{
Calendar cal=Calendar.getInstance();
txtdt.setText(""+(cal.get(Calendar.DATE))+"/"+(cal.get(Calendar.MONTH)+1)+"/"+(cal.get(Calendar.YEAR))+""); 
try
{
    Connection con;
    con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
    ResultSet res;
    Statement st=st=con.createStatement();
    String tbookid=JOptionPane.showInputDialog("Enter BOOKING ID:");
    res=st.executeQuery("select * from booktbl where TransID='"+(tbookid+"'"));
    while(res.next())
    {
		 lblbookid.setText(res.getString(1));
         txtfdno.setText(res.getString(5));
     txtcid.setText(res.getString(6));
	txtcname.setText(res.getString(7));
    }
	}
catch(Exception X)
{
	System.out.println("Exception:"+X);
}
}
////////////////////////////////////////////////////
if(e.getSource()==CALCULATE)
{
	 txtcnpdamt.setText(""+(0.3*Double.parseDouble(txtppdamt.getText())));
	 Double v=Double.parseDouble(txtppdamt.getText())-Double.parseDouble(txtcnpdamt.getText());
	 txtrefndbal.setText(""+v);
}	
//////////////////////////////////////////////////
if(e.getSource()==EXIT)
{
System.exit(0);
}
}	
////////////////////////////////////////////////////
public static void main(String argv[])throws IOException
{
cancel c=new cancel();
}
}		