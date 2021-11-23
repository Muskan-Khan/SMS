 import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.font.*;
public class duplex_info extends Frame implements ActionListener
{
	JButton bnew=new JButton("New",new ImageIcon("images/new.gif"));
	JButton bsave=new JButton("Save",new ImageIcon("images/save.gif"));
	JButton bsearch=new JButton("Search",new ImageIcon("images/search.png"));
	JButton bedit=new JButton("Edit",new ImageIcon("images/edit.png"));
	JButton bcancel=new JButton("Cancel",new ImageIcon("images/exit.png"));
	
	JTextField txduplexno=new JTextField(10);
	JTextField txduplexname=new JTextField(10);
	JTextField txaddress=new JTextField(10);
	JTextField txbuiltuparea=new JTextField(10);
	JTextField txsuperbuiltuparea=new JTextField(20);
	JTextField txcarpetarea=new JTextField(10);
	JTextField txcharge=new JTextField(10);
	JTextField txprojectname=new JTextField(10);
	
	JLabel lbl=new JLabel("Duplex Information");
	JLabel lblduplexno=new JLabel("Duplex No: ");
	JLabel lblduplexname=new JLabel("Duplex Name:");
	JLabel lbladdress=new JLabel("Address: ");
	JLabel lblbuiltuparea=new JLabel("Builtup Area: ");
	JLabel lblsuperbuiltuparea=new JLabel("Superbuiltup Area: ");
	JLabel lblcarpetarea=new JLabel("Carpet Area: ");
	JLabel lblcharge=new JLabel("Charge: ");
	JLabel lblprojectname=new JLabel("Project Name: ");
	JLabel lblfstatus=new JLabel("Status: ");
	JLabel lbl1=new JLabel("Empty");

	public duplex_info()
	{
                
		setLayout(null);
                setSize(2100,1500);
                setTitle("DUPLEX INFO:::-");
                setVisible(true);
		lbl.setFont(new Font("Comic Sans MS",Font.BOLD,50));
		lbl.setForeground(Color.red);
		lbl.setBounds(400,80,500,80);
                lblduplexno.setBackground(new Color(250,150,80));
                lblduplexno.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                lblduplexno.setBounds(300,200,200,40);
		txduplexno.setBounds(600,200,300,40);
		lblduplexname.setBackground(new Color(250,150,80));
                lblduplexname.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                lblduplexname.setBounds(300,260,300,40);
		txduplexname.setBounds(600,260,300,40);
		lbladdress.setBackground(new Color(250,150,80));
                lbladdress.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                lbladdress.setBounds(300,320,300,40);
		txaddress.setBounds(600,320,300,40);
		lblbuiltuparea.setBackground(new Color(250,150,80));
                lblbuiltuparea.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                lblbuiltuparea.setBounds(300,380,300,40);
		txbuiltuparea.setBounds(600,380,300,40);
		lblcarpetarea.setBackground(new Color(250,150,80));
                lblcarpetarea.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                lblcarpetarea.setBounds(300,440,250,40);
		txcarpetarea.setBounds(600,440,300,40);
		lblsuperbuiltuparea.setBackground(new Color(250,150,80));
                lblsuperbuiltuparea.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                lblsuperbuiltuparea.setBounds(300,500,400,40);
		txsuperbuiltuparea.setBounds(600,500,300,40);
		lblcharge.setBackground(new Color(250,150,80));
                lblcharge.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                lblcharge.setBounds(300,560,200,40);
		txcharge.setBounds(600,560,300,40);
		lblprojectname.setBackground(new Color(250,150,80));
                lblprojectname.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                lblprojectname.setBounds(300,620,350,40);
		txprojectname.setBounds(600,620,300,40);
		lblfstatus.setBackground(new Color(250,150,80));
                lblfstatus.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                lblfstatus.setBounds(300,680,300,40);
		lbl1.setBackground(new Color(250,200,100));
                lbl1.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
                lbl1.setBounds(600,680,250,30);
				
		bnew.setBounds(300,800,100,40);
		bsave.setBounds(400,800,100,40);
		bsearch.setBounds(500,800,100,40);
		bedit.setBounds(600,800,100,40);
		bcancel.setBounds(700,800,100,40);
		
		add(lbl);
		add(lblduplexno);
		add(lblduplexname);
		add(lbladdress);
		add(lblbuiltuparea);
		add(lblcarpetarea);
		add(lblsuperbuiltuparea);
		add(lblcharge);
		add(lblprojectname);
		add(lbl1);

		add(txduplexno);
		add(txduplexname);
		add(txaddress);
		add(txbuiltuparea);
		add(txcarpetarea);
		add(txsuperbuiltuparea);
		add(txcharge);
		add(txprojectname);
		add(lblfstatus);

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
		repaint();
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bnew)
		{
		         txduplexno.setText("");
			 txaddress.setText("");
			 txduplexname.setText("");
			 txbuiltuparea.setText("");
			 txcarpetarea.setText("");
 			 txsuperbuiltuparea.setText("");
			 txcharge.setText("");
			 txprojectname.setText("");
			 lbl1.setText("Empty");
		  try
                   {
                   Connection con;
		   con=DriverManager.getConnection("jdbc:odbc:sms");
                   Statement st=con.createStatement();
                   ResultSet res=st.executeQuery("Select * from keytbl");
                   while(res.next())
                   {
                       int x=Integer.parseInt(res.getString(4));
                       txduplexno.setText("D_"+String.format("%04d",x));   
                   }
                   }
                   catch(Exception ex)
                   {}
			
		
	}
                if(e.getSource()==bsave)
                {
                  try
                  {
                   Connection con;
		   con=DriverManager.getConnection("jdbc:odbc:sms");
                   Statement st=con.createStatement();
                   String str="insert into duplex_info(duplex_no,duplex_name,address,builtuparea,carpetarea,superbuiltuparea,projectname,fstatus,charge)values(?,?,?,?,?,?,?,?,?)";
		   PreparedStatement ps=con.prepareStatement(str);
		   ps.setString(1,txduplexno.getText());
		   ps.setString(2,txduplexname.getText());
		   ps.setString(3,txaddress.getText());
		   ps.setString(4,txbuiltuparea.getText());
                          ps.setString(5,txcarpetarea.getText());
		   ps.setString(6,txsuperbuiltuparea.getText());
		   ps.setString(7,txcharge.getText());
		   ps.setString(8,txprojectname.getText());
		   ps.setString(9,lbl1.getText());		   
		   ps.executeUpdate();
		   JOptionPane.showMessageDialog(null,"Saved Successfully");
		   ResultSet res=st.executeQuery("update keytbl set duplex_no=duplex_no+1");
		            txduplexno.setText("");
			 txaddress.setText("");
			 txduplexname.setText("");
			 txbuiltuparea.setText("");
			 txcarpetarea.setText("");
 			 txsuperbuiltuparea.setText("");
			 txcharge.setText("");
			 txprojectname.setText("");
			 lbl1.setText("Empty");
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
				JOptionPane.showInputDialog(null,"Enter Duplex ID:");
				res=st.executeQuery("Select * from duplex_info where duplex_no='"+txduplexno.getText()+"'");
				while(res.next())
				{
				txduplexno.setText(""+res.getString(1));
				txduplexname.setText(""+res.getString(2));
				txaddress.setText(""+res.getString(3));
				txbuiltuparea.setText(""+res.getString(4));
				txcarpetarea.setText(""+res.getString(5));
				txsuperbuiltuparea.setText(""+res.getString(6));
				txprojectname.setText(""+res.getString(7));
				lbl1.setText(""+res.getString(8));
				txcharge.setText(""+res.getString(9));
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
		res=st.executeQuery("Select * from duplex_info");
		String str="update duplex_info set duplex_no='"+txduplexno.getText()+"',duplex_name='"+txduplexname.getText()+"',address='"+txaddress.getText()+"',builtuparea='"+txbuiltuparea.getText()+"',carpetarea='"+txcarpetarea.getText()+"',superbuiltuparea='"+txsuperbuiltuparea.getText()+"',projectname='"+txprojectname.getText()+"',charge='"+txcharge.getText()+"' where duplex_no='"+txduplexno.getText()+"'";
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
             duplex_info obj=new duplex_info();
        }
}