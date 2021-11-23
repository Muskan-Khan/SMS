import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class tbl extends Frame implements ActionListener
{
  	String m,n,o,p;
	JButton bclose=new JButton("Close");
	JButton bsearch=new JButton("Search");
	JTable table2;
	String[] col={"Flat no","Address","Floor","Project name"};
	JScrollPane sp;
	Object[] [] data={{m,n,o,p}};
	//DefaultTableModel model=new DefaultTableModel(col,0);
	
        public tbl()
 	 {
     		setLayout(null);
		setSize(500,500);
		setVisible(true);
		table2=new JTable(data,col);
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		sp=new JScrollPane(table2);
		table2.setModel(model);
     		setBackground(new Color(234,255,229));
     		bsearch.setBounds(800,500,80,40);
		bclose.setBounds(800,670,80,40);
		add(sp);
		table2.setBounds(100,100,300,200);
		sp.setBounds(100,100,300,200); 	
		table2.setFillsViewportHeight(true);
    		add(bsearch);
		add(bclose); 
    		bsearch.addActionListener(this);
		bclose.addActionListener(this);
}
	public void actionPerformed(ActionEvent ee)
	{
		if(ee.getSource()==bsearch)
		{
			try
			{
				Connection con;
				ResultSet res;
				con=DriverManager.getConnection("jdbc:odbc:sms");
				Statement st=con.createStatement();
				res=st.executeQuery("Select * from flat_info");
				while(res.next())
				{
					Vector v=new Vector();
					v.add(res.getString(1));
					v.add(res.getString(3));
					v.add(res.getString(7));
					v.add(res.getString(8));
					model.addRow(v);		
				}
			}
			catch(Exception ex)
			{	
			}
	}
			if(ee.getSource()==bclose)
			{
				this.dispose();
			}
	}
			public static void main(String argv[])throws IOException
			{
				tbl obj=new tbl();
			}
	}
	