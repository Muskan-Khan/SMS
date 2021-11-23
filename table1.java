import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
public class table1 extends Frame implements ActionListener
{
    
			 
			 
			 
			 JTable table2;
	Button b1=new Button("OK");
	JLabel lblProjectName=new JLabel("Enter Project Name:-");
	JLabel lblFlatNo=new JLabel("Flat No / Duplex No:-");
	
	        JRadioButton flatrb=new JRadioButton("flatnumber");
        JRadioButton duplexrb=new JRadioButton("duplexnumber");
         ButtonGroup gb=new ButtonGroup();
		 Choice chProjectName=new Choice();
		         JTextField txProjectName=new JTextField(30);
	JScrollPane sp;
	String[] col={"F/D number","F/D cparea","status"};
	Object[] [] data={{"F/D number","F/D cparea","status"}};
	DefaultTableModel model=new DefaultTableModel(col,0);
	public table1()
	{
	setLayout(null);
	setSize(1500,1500);
	setVisible(true);
	table2=new JTable(data,col);
	table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	sp=new JScrollPane(table2);
	table2.setModel(model);
	b1.setBounds(1000,50,80,40);
	add(b1);
	sp.setBounds(400,150,300,200);
	add(sp);
	table2.setBounds(400,150,300,200);
	flatrb.setBounds(600,100,200,40);
	duplexrb.setBounds(700,100,200,40);
	add(lblFlatNo);
	add(flatrb);
	add(duplexrb);
	lblFlatNo.setBounds(130,50,200,40);
	lblProjectName.setBounds(550,50,200,40);
	chProjectName.setBounds(750,50,200,80);
	add(lblProjectName);
	chProjectName.add("Astha Town");
	chProjectName.add("Vatika Green");
	chProjectName.add("Green Garden");
	chProjectName.add("Syndicate Colony");
	chProjectName.add("Green Enclave");
	chProjectName.add("Eden Garden");
	add(chProjectName);
	
	flatrb.setBounds(250,50,120,40);
	duplexrb.setBounds(350,50,120,40);
			gb.add(flatrb);
                gb.add(duplexrb);
                add(flatrb);
                add(duplexrb);
				lblProjectName.setForeground(Color.BLUE);
						lblProjectName.setFont(new Font("algerian",Font.BOLD,15));
						chProjectName.setFont(new Font("algerian",Font.BOLD,15));
	table2.setFillsViewportHeight(true);
	b1.addActionListener(this);
}
public void actionPerformed(ActionEvent ee)
{
	if(ee.getSource()==b1)
{
System.out.println("2222222222222222");
	try
		{
		Connection con;
		ResultSet res;
		con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
		Statement st=con.createStatement();
		System.out.println("33333333333333333");
		System.out.println(flatrb.isSelected());
		 if(flatrb.isSelected())
		 {
             res=st.executeQuery("select * from flattbl where ProjectName='"+chProjectName.getSelectedItem()+"' and Status='Available'");
             System.out.println("44444444444444");
         }			 
			else
         res=st.executeQuery("select * from duplextbl where ProjectName='"+chProjectName.getSelectedItem()+"' and duplex_status='no'");
	System.out.println("111111111");
		while(res.next())
		{
			Vector v=new Vector();
			v.add(res.getString(1));
			v.add(res.getString(6));
					if(flatrb.isSelected())
		v.add(res.getString(9));
		
		else
				v.add(res.getString(10));
			
			
			model.addRow(v);
		}
		}
		catch(Exception e)
		{
		}
}
}
public static void main(String argv[])throws IOException
{
table1 obj=new table1();
}
}

			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
	