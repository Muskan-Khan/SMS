import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
public class booking2 extends Frame implements ActionListener
{
    int cost;
	String trmt_id,trmt_name;
	JTable table2;
	Button b1=new Button("OK");
	JScrollPane sp;
	String[]col={"Treatment ID","Treatment Name","Amount"};
	Object[][]data={{trmt_id,trmt_name,cost}};
	DefaultTableModel model=new DefaultTableModel(col,0);
	public booking()
	{
	setLayout(null);
	setSize(500,500);
	setVisible(true);
	table2=new JTable(data,col);
	table2.setAutoResizeMode(JTable.AUTO_RESIZE.OFF);
	sp=new JScrollPane(table2);
	table2.setModel(model);
	b1.setBounds(100,50,80,40);
	add(b1);
	sp.setBounds(100,100,300,200);
	table2.setBounds(100,100,300,200);
	add(sp);
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
             con=DriverManager.getConnection("jdbc:odbc:spadsn");
             Statement st=con.createStatement();
             res=st.executeQuery("select*from treat");
			 while(res.next())
			 {
			       Vector v=new Vector();
				   v.add(res.getString(1));
                   v.add(res.getString(2));
                   v.add(res.getString(3));
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
booking obj=new booking();
}
}					
 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
	