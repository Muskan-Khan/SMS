import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
public class flat extends Frame implements ActionListener
{
JLabel lblTitle= new JLabel("FLAT  DETAILS");
 JLabel lblFlatNo= new JLabel("Enter Flat No:");
 JLabel lblBuildName= new JLabel("Enter Building Name :");
 JLabel lblAddress= new JLabel("Enter Address :");
 JLabel lblBuiltupArea= new JLabel("Enter Builtup Area :");
 JLabel lblSuperbuiltup= new JLabel("Enter Superbuiltup Area :");
 JLabel lblCarpetArea= new JLabel("Enter Carpet Area ");
 JLabel lblFloor= new JLabel("Enter Floor No :");
 JLabel lblProjectName= new JLabel("Enter Project Name :");
 JLabel lblStatus= new JLabel("Status :");
 Label lblFNo=new Label("           ");
 JTextField txBuildName=new JTextField(15);
 JTextField txAddress=new JTextField(15);
 JTextField txBuiltupArea=new JTextField(15);
 JTextField txSuperbuiltup=new JTextField(15); 
 JTextField txCarpetArea=new JTextField(15);
 JTextField txFloor=new JTextField(15);
 Label lblProName=new Label("                        ");
 JTextField txStatus=new JTextField(15);
 
  JButton btnNew=new JButton("NEW",new ImageIcon("images/NEW.gif"));
 JButton btnSave=new JButton("SAVE",new ImageIcon("images/SAVE.gif"));
 JButton btnSearch=new JButton("SEARCH",new ImageIcon("images/search.png"));
 JButton btnEdit=new JButton("EDIT",new ImageIcon("images/edit.png"));
 JButton btnCancel=new JButton("CANCEL",new ImageIcon("images/exit.png"));

 public flat()
{
 setLayout(null);
 setVisible(true);
 setSize(1100,700);
 setBackground(new Color(255,255,255));
 lblTitle.setBounds(550,100,450,50);
 lblTitle.setFont(new Font("Times New Roman",Font.BOLD,40));
 lblTitle.setForeground(Color.GRAY);
   lblFlatNo.setBounds(100,200,250,35);
   lblFNo.setBackground(new Color(212,212,212));
   lblFlatNo.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   lblFNo.setBounds(260,200,200,35);
   lblBuildName.setBounds(530,200,250,35);
   lblBuildName.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txBuildName.setBounds(730,200,200,35);
   lblAddress.setBounds(530,320,250,35);
   lblAddress.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txAddress.setBounds(730,320,200,35);
   lblBuiltupArea.setBounds(100,260,250,35);                                            
   lblBuiltupArea.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txBuiltupArea.setBounds(260,260,200,35);
   lblSuperbuiltup.setBounds(530,260,250,35);
   lblSuperbuiltup.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txSuperbuiltup.setBounds(730,260,200,35);
   lblCarpetArea.setBounds(1000,260,250,35);
   lblCarpetArea.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txCarpetArea.setBounds(1150,260,200,35);
   lblFloor.setBounds(1000,200,200,35);                                  
   lblFloor.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txFloor.setBounds( 1150,200,200,35);                                     
   lblProjectName.setBounds(100,320,250,35);
   lblProjectName.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   lblProName.setBounds(260,320,200,35);
   lblProName.setBackground(new Color(212,212,212));
   lblStatus.setBounds(1000,320,250,35);
   lblStatus.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txStatus.setBounds(1150,320,200,35);
   
   btnNew.setBounds(350,500,100,40);
   btnSave.setBounds(500,500,100,40);
   btnSearch.setBounds(650,500,105,40);
   btnEdit.setBounds(800,500,100,40);
   btnCancel.setBounds(950,500,100,40);

  add(lblTitle);
  add(lblFlatNo);
  add(lblFNo);
  add(lblBuildName);
  add(txBuildName);
  add(lblAddress);
  add(txAddress);
  add(lblBuiltupArea);
  add(txBuiltupArea);
  add(lblSuperbuiltup);
  add(txSuperbuiltup);
  add(lblCarpetArea);
  add(txCarpetArea);
  add(lblFloor);
  add(txFloor);
  add(lblProjectName);
  add(lblProName);
  add(lblStatus);
  add(txStatus);
  add(btnSave);
    add(btnNew);
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
lblFNo.setText("");
txBuildName.setText("");
txAddress.setText("");
txBuiltupArea.setText("");
txSuperbuiltup.setText("");
txCarpetArea.setText("");
txFloor.setText("");
lblProName.setText("");
txStatus.setText("");
try
{
Connection con;
con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
ResultSet res;
Statement st=st=con.createStatement();
res=st.executeQuery("select * from keytable");
while(res.next())
{
lblFNo.setText(""+res.getString(1));
}
}

catch(Exception ex)
{
System.out.println(ex);
} 
}
///////////////////////////////////////////////////
if(e.getSource()==btnSave)
{
try
{
 Connection con;
 con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
 ResultSet res;
 Statement st=con.createStatement();
 res=st.executeQuery("Select * from flattbl");
 String str= "insert into flattbl(FlatNo,BuildName,Address,BuiltupArea,Superbuiltup,CarpetArea,Floor,ProjectName,Status)values(?,?,?,?,?,?,?,?,?)";
 PreparedStatement ps=con.prepareStatement(str);
 ps.setString(1,lblFNo.getText());
 ps.setString(2,txBuildName.getText());
 ps.setString(3,txAddress.getText());
 ps.setString(4,txBuiltupArea.getText());
 ps.setString(5,txSuperbuiltup.getText());
 ps.setString(6,txCarpetArea.getText());
 ps.setString(7,txFloor.getText());
 ps.setString(8,lblProName.getText());
 ps.setString(9,txStatus.getText());
 ps.executeUpdate();
 JOptionPane.showMessageDialog(null,"saved succesfully");
  str="update keytable set FlatNo =FlatNo+1";
 ps=con.prepareStatement(str);
 ps.executeUpdate();
}
catch(Exception x)
{
 System.out.println("Exception:"+x);
 
}
}
///////////////////////////////////////
if(e.getSource()==btnSearch)
{
try
{
Connection con;
con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
ResultSet res;
Statement st=st=con.createStatement();
String FNo=JOptionPane.showInputDialog("Enter FNo");
res=st.executeQuery("select * from flattbl where FlatNo='"+FNo+"'");
while(res.next())
{  
    lblFNo.setText(res.getString(1));
     txBuildName.setText(res.getString(2));
	 txAddress.setText(res.getString(3));
	 txBuiltupArea.setText(res.getString(4));
	 txSuperbuiltup.setText(res.getString(5));
	 txCarpetArea.setText(res.getString(6));
	 txFloor.setText(res.getString(7));
	 lblProName.setText(res.getString(8));
	 txStatus.setText(res.getString(9));
	 
	 
}
System.out.println("HELLO");
}
catch(Exception y)
{
System.out.println(y);
}
}
//////////////////////////////////////
if(e.getSource()==btnEdit)
{
try
{
 Connection con;
 con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
 ResultSet res;
 Statement st=st=con.createStatement();
 res=st.executeQuery("select * from flattbl");
 String str="update flattbl set FlatNo='"+lblFNo.getText()+"',BuildName='"+txBuildName.getText()+"',Address='"+txAddress.getText()+"',BuiltupArea='"+txBuiltupArea.getText()+"', Superbuiltup='"+txSuperbuiltup.getText()+"',CarpetArea='"+txCarpetArea.getText()+"',Floor='"+txFloor.getText()+"',ProName='"+lblProName.getText()+"',Status='"+txStatus.getText()+"' where FlatNo='"+lblFNo.getText()+"'";
 PreparedStatement ps=con.prepareStatement(str);
 ps.executeUpdate();
 JOptionPane.showMessageDialog(null,"Update Successfully");
 }
  catch(Exception z)
{ 
System.out.println("Exception:"+z);
}
}
//////////////////////////////////////

if(e.getSource()==btnCancel)
{
this.dispose();
}


}
public static void main(String argv[])throws IOException
{
flat obj=new flat();
}
}

































