import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.font.*;
public class flat_info extends Frame implements ActionListener
{
	JButton bnew=new JButton("New");
	JButton bsave=new JButton("Save");
	JButton bsearch=new JButton("Search");
	JButton bedit=new JButton("Edit");
	JButton bcancel=new JButton("Cancel");
	
	JTextField txduplexno=new JTextField(10);
	JTextField txduplexname=new JTextField(10);
	JTextField txaddress=new JTextField(10);
	JTextField txbuiltuparea=new JTextField(10);
	JTextField txsuperbuiltuparea=new JTextField(20);
	JTextField txcarpetarea=new JTextField(10);
	JTextField txfloor=new JTextField(10);
	JTextField txprojectname=new JTextField(10);
	
	JLabel lbl=new JLabel("Flat Information");
	JLabel lblduplexno=new JLabel("Duplex No: ");
	JLabel lblduplexname=new JLabel("Duplex Name:");
	JLabel lbladdress=new JLabel("Address: ");
	JLabel lblbuiltuparea=new JLabel("Builtup Area: ");
	JLabel lblsuperbuiltuparea=new JLabel("Superbuiltup Area: ");
	JLabel lblcarpetarea=new JLabel("Carpet Area: ");
	JLabel lblfloor=new JLabel("Floor: ");
	JLabel lblprojectname=new JLabel("Project Name: ");
	JLabel lblstatus=new JLabel("Status: ");
	JLabel lbl1=new JLabel("Empty");

	public flat_info()
	{
                
		setLayout(null);
                setSize(2100,1500);
                setTitle("FLAT INFO:::-");
                setVisible(true);
		lbl.setFont(new Font("Comic Sans MS",Font.BOLD,50));
		lbl.setForeground(Color.red);
		lbl.setBounds(400,80,500,80);
                lblflatno.setBackground(new Color(250,150,80));
                lblflatno.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                lblflatno.setBounds(300,200,200,40);
		txflatno.setBounds(600,200,300,40);
		lblflatno.setBackground(new Color(250,150,80));
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
		lblfloor.setBackground(new Color(250,150,80));
                lblfloor.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                lblfloor.setBounds(300,560,200,40);
		txcharge.setBounds(600,560,300,40);
		lblprojectname.setBackground(new Color(250,150,80));
                lblprojectname.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                lblprojectname.setBounds(300,620,350,40);
		txprojectname.setBounds(600,620,300,40);
		lblstatus.setBackground(new Color(250,150,80));
                lblstatus.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                lblstatus.setBounds(300,680,300,40);
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
		add(lblfloor);
		add(lblprojectname);
		add(lbl1);

		add(txflatno);
		add(txduplexname);
		add(txaddress);
		add(txbuiltuparea);
		add(txcarpetarea);
		add(txsuperbuiltuparea);
		add(txfloor);
		add(txprojectname);
		add(lblstatus);

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
		
	}
                if(e.getSource()==bsave)
                {
                  try
                  {
                   Connection con;
		   con=DriverManager.getConnection("jdbc:odbc:sms");
                   Statement st=con.createStatement();
                   
                   String str="insert into duplex_info(duplex_no,duplex_name,address,builtuparea,carpetarea,superbuiltarea,floor,projectname,status)values(?,?,?,?,?,?,?,?,?)";
		   PreparedStatement ps=con.prepareStatement(str);
		   ps.setString(1,txduplexno.getText());
		   ps.setString(2,txduplexname.getText());
		   ps.setString(3,txaddress.getText());
		   ps.setString(4,txbuiltuparea.getText());
                   ps.setString(5,txcarpetarea.getText());
		   ps.setString(6,txsuperbuiltuparea.getText());
		   ps.setString(7,txfloor.getText());
		   ps.setString(8,txprojectname.getText());
		   ps.setString(9,lbl1.getText());		   
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
				res=st.executeQuery("Select * from duplex_info where duplex_no='"+txduplexno.getText()+"'");
				while(res.next())
				{
				txduplexname.setText(""+res.getString(2));
				txaddress.setText(""+res.getString(3));
				txbuiltuparea.setText(""+res.getString(4));
				txcarpetarea.setText(""+res.getString(5));
				txsuperbuiltuparea.setText(""+res.getString(6));
				txfloor.setText(""+res.getString(7));
				txprojectname.setText(""+res.getString(8));
				lbl1.setText(""+res.getString(9));
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
		String str="update duplex_info set duplex_no='"+txduplexno.getText()+"',duplex_name='"+txduplexname.getText()+"',address='"+txaddress.getText()+"',builtuparea='"+txbuiltuparea.getText()+"',carpetarea='"+txcarpetarea.getText()+"',superbuiltuparea='"+txsuperbuiltuparea.getText()+"',projectname='"+txprojectname.getText()+"',charge='"+txcharge.text+"' where flat_no='"+txflatno.getText()+"'";
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