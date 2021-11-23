import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class owner extends Frame implements ActionListener
{
JLabel lblTitle=new JLabel("OWNER  DETAILS ");
    JLabel lblFlatNo=new JLabel(" Enter your Flat No: ");
	JLabel lblOwnerID=new JLabel("Enter your Owner ID: ");
	JLabel lblOwnerName=new JLabel("Enter your Name : ");
	JLabel lblDOB=new JLabel("Enter your DOB:: ");
	JLabel lblAddress=new JLabel("Enter your Address: ");
	JLabel lblContactNo=new JLabel("Enter your Contact No: ");
	JLabel lblDOP=new JLabel("Enter your Date of Purchase: ");
    JLabel lblGender=new JLabel("Gender: ");
    Label lblFNo=new Label("                ");
	JTextField txOwnerID=new JTextField(10);
	JTextField txOwnerName=new JTextField(10);
	JTextField txDOB=new JTextField(10);
	JTextField txAddress=new JTextField(10);
	JTextField txContactNo=new JTextField(10);
	JTextField txDOP=new JTextField(10);
	JTextField txGender=new JTextField(10);
	
	 JButton btnNew=new JButton("NEW",new ImageIcon("images/NEW.gif"));
 JButton btnSave=new JButton("SAVE",new ImageIcon("images/SAVE.gif"));
 JButton btnSearch=new JButton("SEARCH",new ImageIcon("images/search.png"));
 JButton btnEdit=new JButton("EDIT",new ImageIcon("images/edit.png"));
 JButton btnCancel=new JButton("CANCEL",new ImageIcon("images/exit.png"));

    JRadioButton rbmale=new JRadioButton("MALE");
    JRadioButton rbfemale=new JRadioButton("FEMALE");
    ButtonGroup bg=new ButtonGroup();  

 public owner()
 {
setLayout(null);
setVisible(true);
setSize(1100,700);
setBackground(new Color(255,255,255));
lblTitle.setBounds(550,100,450,50);
lblTitle.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,40));
lblTitle.setForeground(Color.GRAY);   
   lblFlatNo.setBounds(200,200,250,35);
   lblFNo.setBackground(new Color(212,212,212));
   lblFlatNo.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   lblFNo.setBounds(450,200,200,35);
   lblOwnerID.setBounds(750,200,250,35);
   lblOwnerID.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txOwnerID.setBounds(970,200,200,35);
   lblOwnerName.setBounds(200,250,250,35);
   lblOwnerName.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txOwnerName.setBounds(450,250,200,35);
   lblDOB.setBounds(750,250,200,35);
   lblDOB.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txDOB.setBounds(970,250,200,35);
   lblAddress.setBounds(200,300,200,35);
   lblAddress.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txAddress.setBounds(450,300,200,35);
   lblContactNo.setBounds(750,300,200,35);
   lblContactNo.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txContactNo.setBounds(970,300,200,35);
   lblDOP.setBounds(200,350,250,35);
   lblDOP.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txDOP.setBounds(450,350,200,35);
   lblGender.setBounds(750,350,200,35);
   lblGender.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
                        //txGender.setBounds(400,470,250,35);
   rbmale.setBounds(970,350,100,35);
   rbfemale.setBounds(1070,350,100,35);

    btnNew.setBounds(350,500,100,40);
   btnSave.setBounds(500,500,100,40);
   btnSearch.setBounds(650,500,105,40);
   btnEdit.setBounds(800,500,100,40);
   btnCancel.setBounds(950,500,100,40);

    add(lblTitle);
    add(lblFlatNo);
  add(lblFNo);
  add(lblOwnerID);
  add(txOwnerID);
  add(lblOwnerName);
  add(txOwnerName);
  add(lblDOB);
  add(txDOB);
  add(lblAddress);
  add(txAddress);
  add(lblContactNo);
  add(txContactNo);
  add(lblDOP);
  add(txDOP);
  add(lblGender);
  //add(txGender);
bg.add(rbmale);
bg.add(rbfemale);  
add(rbmale);
add(rbfemale);  
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
lblFNo.setText("");
txOwnerID.setText("");
txOwnerName.setText("");
txDOB.setText("");
txAddress.setText("");
txContactNo.setText("");
txDOP.setText("");
txGender.setText("");
try
{
Connection con;
con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
ResultSet res;
Statement st=st=con.createStatement();
res=st.executeQuery("select * from keytable");
while(res.next())
{lblFNo.setText(""+res.getString(1));
}
}
catch(Exception ex)
{
System.out.println(ex);
}

}
//////////////////////////////////////////////////
if(e.getSource()==btnSave)
{
try
{
 Connection con;
 con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
 ResultSet res;
 Statement st=con.createStatement();
 res=st.executeQuery("Select * from ownertbl");
 String str= "insert into ownertbl(FlatNo,OwnerID,OwnerName,DOB,Address,ContactNo,DOP,Gender)values(?,?,?,?,?,?,?,?)";
 PreparedStatement ps=con.prepareStatement(str);
 ps.setString(1,lblFNo.getText());
 ps.setString(2,txOwnerID.getText());
 ps.setString(3,txOwnerName.getText());
 ps.setString(4,txDOB.getText());
 ps.setString(5,txAddress.getText());
 ps.setString(6,txContactNo.getText());
 ps.setString(7,txDOP.getText());
 ps.setString(8,txGender.getText());
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
////////////////////////////////////////////////////
if(e.getSource()==btnSearch)
{
try
{
Connection con;
con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
ResultSet res;
Statement st=st=con.createStatement();
String FID=JOptionPane.showInputDialog("Enter FlatNo");
res=st.executeQuery("select * from ownertbl where FlatNo='"+lblFNo+"'");
while(res.next())
{
     lblFNo.setText(res.getString(1));
     txOwnerID.setText(res.getString(2));
	 txOwnerName.setText(res.getString(3));
	 txDOB.setText(res.getString(4));
	 txAddress.setText(res.getString(5));
	 txContactNo.setText(res.getString(6));
	 txDOP.setText(res.getString(7));
	if (res.getString(8).equals("rbmale"))
	 rbmale.setSelected(true);
	 else
	 rbfemale.setSelected(true);
}
System.out.println("HELLO");
}
catch(Exception y)
{
System.out.println(y);
}
}
///////////////////////////////////////////////////////
if(e.getSource()==btnEdit)
{
try
{
 Connection con;
 con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
 ResultSet res;
 Statement st=st=con.createStatement();
 res=st.executeQuery("select * from ownertbl");
 String Gender;
    if (rbmale.isSelected()==true)
        Gender="MALE";
    else
        Gender="FEMALE";
 String str="update ownertbl set FlatNo='"+lblFNo.getText()+"',OwnerID='"+txOwnerID.getText()+"',OwnerName='"+txOwnerName.getText()+"',DOB='"+txDOB.getText()+"',Address='"+txAddress.getText()+"',ContactNo='"+txContactNo.getText()+"',DOP='"+txDOP.getText()+"',Gender='"+Gender+"' where FlatNo='"+lblFNo.getText()+"'";                                 
 PreparedStatement ps=con.prepareStatement(str);
 ps.executeUpdate();
 JOptionPane.showMessageDialog(null,"Update Successfully");
 
 }
  catch(Exception z)
{ 
System.out.println("Exception:"+z);
}
}
/////////////////////////////////////////////////////	
if(e.getSource()==btnCancel)
{
this.dispose();
}


}
public static void main(String argv[])throws IOException
{
owner obj=new owner();
}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	