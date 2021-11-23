import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.awt.font.*;
public class flat_info extends Frame implements ActionListener
{
	JButton bnew=new JButton("New",new ImageIcon("images/new.gif"));
	JButton bsave=new JButton("Save",new ImageIcon("images/save.gif"));
	JButton bsearch=new JButton("Search",new ImageIcon("images/search.png"));
	JButton bedit=new JButton("Edit",new ImageIcon("images/edit.png"));
	JButton bcancel=new JButton("Cancel",new ImageIcon("images/exit.png"));
	
	JTextField txflatno=new JTextField(10);
	JTextField txbuildname=new JTextField(10);
	JTextField txaddress=new JTextField(10);
	JTextField txbuiltuparea=new JTextField(10);
	JTextField txsuperbuiltuparea=new JTextField(20);
	JTextField txcarpetarea=new JTextField(10);
	JTextField txfloor=new JTextField(10);
	JTextField txcharge=new JTextField(10);

	String[] pn={"Astha Township","Madhusudan Vihar","Ashok Vatika","Green City","Devnagri Palace"};
	JComboBox projectname=new JComboBox(pn);
	
	JLabel lbl=new JLabel("Flat Information");
	JLabel lblflatno=new JLabel("Flat No: ");
	JLabel lblbuildname=new JLabel("Building Name: ");
	JLabel lbladdress=new JLabel("Address: ");
	JLabel lblbuiltuparea=new JLabel("Builtup Area: ");
	JLabel lblsuperbuiltuparea=new JLabel("Superbuiltup Area: ");
	JLabel lblcarpetarea=new JLabel("Carpet Area: ");
	JLabel lblfloor=new JLabel("Floor: ");
	JLabel lblprojectname=new JLabel("Project Name: ");
	JLabel lblfstatus=new JLabel("Status: ");
	JLabel lblcharge=new JLabel("Charge(per Sq.ft):");
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
		lblbuildname.setBackground(new Color(250,150,80));
                lblbuildname.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                lblbuildname.setBounds(300,260,300,40);
		txbuildname.setBounds(600,260,300,40);
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
		txfloor.setBounds(600,560,300,40);
		lblprojectname.setBackground(new Color(250,150,80));
                lblprojectname.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                lblprojectname.setBounds(300,620,350,40);
		projectname.setBounds(600,620,300,40);
		lblfstatus.setBackground(new Color(250,150,80));
                lblfstatus.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                lblfstatus.setBounds(300,680,300,40);
		lblcharge.setBackground(new Color(250,150,80));
                lblcharge.setFont(new Font("Comic Sans MS",Font.BOLD,30));
                lblcharge.setBounds(300,740,300,40);
		txcharge.setBounds(600,740,300,40);
		

		lbl1.setBackground(new Color(250,200,100));
                lbl1.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
                lbl1.setBounds(600,680,250,30);
				
		bnew.setBounds(300,800,150,40);
		bsave.setBounds(450,800,150,40);
		bsearch.setBounds(600,800,150,40);
		bedit.setBounds(750,800,150,40);
		bcancel.setBounds(900,800,150,40);
		
		add(lbl);
		add(lblflatno);
		add(lblbuildname);
		add(lbladdress);
		add(lblbuiltuparea);
		add(lblcarpetarea);
		add(lblsuperbuiltuparea);
		add(lblfloor);
		add(lblprojectname);
		add(lblcharge);
		add(lbl1);

		add(txflatno);
		add(txbuildname);
		add(txaddress);
		add(txbuiltuparea);
		add(txcarpetarea);
		add(txsuperbuiltuparea);
		add(txfloor);
		add(projectname);
		add(txcharge);
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
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bnew)
		{
		            txflatno.setText("");
			 txaddress.setText("");
			 txbuildname.setText("");
			 txbuiltuparea.setText("");
			 txcarpetarea.setText("");
 			 txsuperbuiltuparea.setText("");
			 txfloor.setText("");
			 lbl1.setText("Empty");
	
		   try
                   {
                   Connection con;
		   con=DriverManager.getConnection("jdbc:odbc:sms");
                   Statement st=con.createStatement();
                   ResultSet res=st.executeQuery("Select * from keytbl");
                   while(res.next())
                   {
                       int x=Integer.parseInt(res.getString(3));
                       txflatno.setText("F_"+String.format("%04d",x));   
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
                   String str1=projectname.getSelectedItem().toString();
                   String str="insert into flat_info(flat_no,build_name,address,builtuparea,carpetarea,superbuiltuparea,floor,projectname,fstatus)values(?,?,?,?,?,?,?,?,?)";
		   PreparedStatement ps=con.prepareStatement(str);
		   ps.setString(1,txflatno.getText());
		   ps.setString(2,txbuildname.getText());
		   ps.setString(3,txaddress.getText());
		   ps.setString(4,txbuiltuparea.getText());
                  	   ps.setString(5,txcarpetarea.getText());
		   ps.setString(6,txsuperbuiltuparea.getText());
		   ps.setString(7,txfloor.getText());
		   ps.setString(8,str1);
		   ps.setString(9,lbl1.getText());		   
		   ps.executeUpdate();
		   JOptionPane.showMessageDialog(null,"Saved Successfully");
		   str="update keytbl set flat_no=flat_no+1";
                   ps=con.prepareStatement(str);
                   ps.executeUpdate();
			 txflatno.setText("");
			 txaddress.setText("");
			 txbuildname.setText("");
			 txbuiltuparea.setText("");
			 txcarpetarea.setText("");
 			 txsuperbuiltuparea.setText("");
			 txfloor.setText("");
			 txcharge.setText("");
	
	
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
				String id=JOptionPane.showInputDialog(null,"Enter Flat ID:");
				int flg=0;
				ResultSet res;
				res=st.executeQuery("Select * from flat_info where flat_no='"+id+"'");
				while(res.next())
				{
				txflatno.setText(""+id);
				txbuildname.setText(""+res.getString(2));
				txaddress.setText(""+res.getString(3));
				txbuiltuparea.setText(""+res.getString(4));
				txcarpetarea.setText(""+res.getString(5));
				txsuperbuiltuparea.setText(""+res.getString(6));
				txfloor.setText(""+res.getString(7));
				projectname.setSelectedItem(""+res.getString(8));
				lbl1.setText(""+res.getString(9));
				txcharge.setText(""+res.getString(10));
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
		String pn=projectname.getSelectedItem().toString();
		ResultSet res;
		Statement st=con.createStatement();
		res=st.executeQuery("Select * from flat_info");
		String str="update flat_info set flat_no='"+txflatno.getText()+"',build_name='"+txbuildname.getText()+"',address='"+txaddress.getText()+"',builtuparea='"+txbuiltuparea.getText()+"',carpetarea='"+txcarpetarea.getText()+"',superbuiltuparea='"+txsuperbuiltuparea.getText()+"',floor='"+txfloor.getText()+"',projectname='"+pn+"',fstatus='"+lblfstatus.getText()+"',charge='"+txcharge.getText()+"' where flat_no='"+txflatno.getText()+"'";
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
             flat_info obj=new flat_info();
        }
}