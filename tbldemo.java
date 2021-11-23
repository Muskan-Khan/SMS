import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class tbldemo extends Frame implements ActionListener
{
  JButton bclose=new JButton("Close");
  public tbldemo()
  {
     setLayout(null);
     setBackground(new Color(234,255,229));
     bclose.setBounds(800,670,80,40);
     add(bclose); 
     try
     {
       Connection con;
       con=DriverManager.getConnection("jdbc:odbc:sms");
       Statement st=con.createStatement();
       String SQL="select * from flat_info";
       ResultSet res;
       res=st.executeQuery(SQL);
       String[] col={"Flat","Status"}; 
       String m="",n="",o="";
       JTable table1 =new JTable();
       JScrollPane sp;  
       DefaultTableModel model=new DefaultTableModel(col,0); 
       while(res.next())
       {
         Vector v=new Vector();
         m=res.getString(1);
         n=res.getString(2);
         Object [][]data={{m,n}};         
         table1=new JTable(data,col);        
         table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         sp=new JScrollPane(table1);
         table1.setFillsViewportHeight(true);
         v.add(m);   
         v.add(n);
         table1.setModel(model);
         sp.setBounds(500,320,200,400); 
         table1.setBounds(500,320,500,500);               
         add(sp);
         model.addRow(v);
       }
     }
     catch(Exception ee)
     {
          System.out.println(""+ee);
     }
     setSize(1500,1000);
     setVisible(true); 
     
     bclose.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
  if(e.getSource()==bclose)
  {
     this.dispose();
  }
}
public static void main(String args[])
throws IOException
{
     tbldemo obj=new tbldemo();
}
}
