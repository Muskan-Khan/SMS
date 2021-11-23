import java.awt.event.*;
import java.awt.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class report extends Frame implements ActionListener
{
    JTable table2;
	Button b1=new Button("SEARCH");
		JLabel lblcan=new JLabel("REPORT  DETAILS");
		Label lbldate=new Label("              ");
		JScrollPane sp;
	String[] col={"Bookingid","F/D no","Cid","Cname","Amt"};
	Object[] [] data={{"Bookingid","F/D no","Cid","Cname","Amt"}};
	DefaultTableModel model=new DefaultTableModel(col,0);
	public report()
	{
	setLayout(null);
	setSize(1500,1500);
	setBackground(new Color(247,228,213));
	setVisible(true);
	table2=new JTable(data,col);
//	table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	sp=new JScrollPane(table2);
	table2.setModel(model);
	b1.setBounds(1000,50,80,40);
	add(b1);
	sp.setBounds(400,200,600,200);
	add(sp);
	lblcan.setBounds(500,50,350,40);
	lbldate.setBounds(320,100,160,40);
	add(lblcan);
	add(lbldate);
			lbldate.setBackground(new Color(255,255,255));
	lblcan.setBackground(new Color(255,255,255));
	lblcan.setFont(new Font("algerian",Font.BOLD,30));
	lbldate.setFont(new Font("algerian",Font.ITALIC,14));
	table2.setFillsViewportHeight(true);
	b1.addActionListener(this);
}
	public void actionPerformed(ActionEvent ee)
{
	if(ee.getSource()==b1)
{
	try
		{
		Connection con;
		ResultSet res;
		con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
		Statement st=con.createStatement();
	String tdate=JOptionPane.showInputDialog("Enter Date:");
		model.setRowCount(0);
		res=st.executeQuery("select * from booktbl where bookdt='"+(tdate+"'"));
			while(res.next())
		{
		         lbldate.setText(res.getString(2));
			Vector v=new Vector();
			v.add(res.getString(1));
			v.add(res.getString(5));
			v.add(res.getString(6));
			v.add(res.getString(7));
			v.add(res.getString(16));
			
			
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
report obj=new report();
}
}
		





