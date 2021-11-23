import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class allocate extends Frame implements ActionListener
{
JLabel lblTitle=new JLabel("ALLOCATE  DETAILS ");
 JLabel lblDOA= new JLabel("Enter your DOA:");
 JLabel lblSite= new JLabel("Enter your Site:");
 JLabel lblRawID= new JLabel("Enter your RawID:");
 JLabel lblQty= new JLabel("Enter your Qty:");
 JTextField txDOA=new JTextField(15);
 JTextField txSite=new JTextField(15);
 JTextField txRawID=new JTextField(15);
 JTextField txQty=new JTextField(15); 
 
 JButton btnNew=new JButton("NEW",new ImageIcon("images/NEW.gif"));
 JButton btnSave=new JButton("SAVE",new ImageIcon("images/SAVE.gif"));
 JButton btnSearch=new JButton("SEARCH",new ImageIcon("images/search.png"));
 JButton btnEdit=new JButton("EDIT",new ImageIcon("images/edit.png"));
 JButton btnCancel=new JButton("CANCEL",new ImageIcon("images/exit.png"));

public allocate()
 {
   setLayout(null);
   setVisible(true);
   setSize(1100,700);
   setBackground(new Color(255,255,255));
   lblTitle.setBounds(550,100,450,50);
lblTitle.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,40));
lblTitle.setForeground(Color.GRAY);   
   lblDOA.setBounds(200,200,250,35);
   lblDOA.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txDOA.setBounds(400,200,250,35);
   lblSite.setBounds(750,200,250,35);
   lblSite.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txSite.setBounds(930,200,250,35);
   lblRawID.setBounds(200,250,250,35);
   lblRawID.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txRawID.setBounds(400,250,250,35);
   lblQty.setBounds(750,250,250,35);
   lblQty.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txQty.setBounds(930,250,250,35);
   
   
   btnNew.setBounds(350,500,100,40);
   btnSave.setBounds(500,500,100,40);
   btnSearch.setBounds(650,500,105,40);
   btnEdit.setBounds(800,500,100,40);
   btnCancel.setBounds(950,500,100,40);      
  
add(lblTitle);  
  add(lblDOA);
  add(txDOA);
  add(lblSite);
  add(txSite);
  add(lblRawID);
  add(txRawID);
  add(lblQty);
  add(txQty);
  add(btnNew);
  add(btnSave);
  add(btnSearch);
  add(btnEdit);
  add(btnCancel);

  btnNew.addActionListener(this);
  btnSave.addActionListener(this);
  btnSearch.addActionListener(this);
  btnEdit.addActionListener(this);
  btnCancel.addActionListener(this);

}
public void actionPerformed(ActionEvent e)
{
 if(e.getSource()==btnNew)
{
 txDOA.setText("");
txSite.setText("");
txRawID.setText("");
txQty.setText("");
}

////////////////////////////////////////////////////////
if(e.getSource()==btnSave)
{
try
{
 Connection con;
 con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
 System.out.println("hellllllooo");
 ResultSet res;
 Statement st=con.createStatement();
 res=st.executeQuery("Select * from allocatetbl");
 String str= "insert into allocatetbl(DOA,Site,RawID,Qty)values(?,?,?,?)";
 PreparedStatement ps=con.prepareStatement(str);
 ps.setString(1,txDOA.getText());
 ps.setString(2,txSite.getText());
 ps.setString(3,txRawID.getText());
 ps.setString(4,txQty.getText());
 ps.executeUpdate();
 JOptionPane.showMessageDialog(null,"saved succesfully");
}
catch(Exception x)
{
 System.out.println("Exception:"+x);
 
}
}
////////////////////////////////////////////////////////
if(e.getSource()==btnSearch)
{
try
{
Connection con;
con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
ResultSet res;
Statement st=st=con.createStatement();
res=st.executeQuery("select * from allocatetbl where DOA='"+txDOA.getText()+"'");
while(res.next())
{
     txSite.setText(res.getString(2));
     txRawID.setText(res.getString(3));
     txQty.setText(res.getString(4));
}
System.out.println("HELLO");
}
catch(Exception y)
{
System.out.println(y);
}
}
//////////////////////////////
if(e.getSource()==btnEdit)
{
try
{
 Connection con;
 con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
 ResultSet res;
 Statement st=con.createStatement();
 res=st.executeQuery("select * from allocatetbl");
 String str="update allocatetbl set DOA='"+txDOA.getText()+"',Site='"+txSite.getText()+"',RawID="+Integer.parseInt(txRawID.getText())+",Qty="+Integer.parseInt(txQty.getText())+" where DOA='"+txDOA.getText()+"'";                     
 PreparedStatement ps=con.prepareStatement(str);
 ps.executeUpdate();
 JOptionPane.showMessageDialog(null,"Update Successfully");
 }
  catch(Exception z)
{ 
System.out.println("Exception:"+z);
}
}
///////////////////////////////////////////////////////                  
if(e.getSource()==btnCancel)
{
this.dispose();
}
///////////////////////////////////////////////////////


}
public static void main(String argv[])throws IOException
{
allocate obj=new allocate();
}
}





































 