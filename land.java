import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class land extends Frame implements ActionListener
{
JLabel lblTitle= new JLabel("LAND  DETAILS");
 JLabel lblLandID= new JLabel("Enter ID:");
 JLabel lblOwnerName= new JLabel("Enter Owner Name:");
 JLabel lblOwnerID= new JLabel("Enter Owner ID:");
 JLabel lblAadharNo= new JLabel("Enter Aadhar No:");
 JLabel lblContactNo= new JLabel("Enter Contact No.:");
 JLabel lblLandLocation= new JLabel("Enter Land Location:");
 JLabel lblGender= new JLabel("Enter Gender:");
 Label lblLID=new Label("                     ");
 JTextField txOwnerName=new JTextField(15);
 JTextField txOwnerID=new JTextField(15);
 JTextField txAadharNo=new JTextField(15); 
 JTextField txContactNo=new JTextField(15);
 JTextField txLandLocation=new JTextField(15);
 JTextField txGender=new JTextField(15);
 
  JButton btnNew=new JButton("NEW",new ImageIcon("images/NEW.gif"));
 JButton btnSave=new JButton("SAVE",new ImageIcon("images/SAVE.gif"));
 JButton btnSearch=new JButton("SEARCH",new ImageIcon("images/search.png"));
 JButton btnEdit=new JButton("EDIT",new ImageIcon("images/edit.png"));
 JButton btnCancel=new JButton("CANCEL",new ImageIcon("images/exit.png"));

 JRadioButton rbmale=new JRadioButton("MALE");
 JRadioButton rbfemale=new JRadioButton("FEMALE");
   ButtonGroup bg=new ButtonGroup(); 
public land()
 {
 setLayout(null);
 setVisible(true);
 setSize(1100,700);
 setBackground(new Color(255,255,255));
 lblTitle.setBounds(550,100,450,50);
 lblTitle.setFont(new Font("Times New Roman",Font.BOLD,40));
 lblTitle.setForeground(Color.GRAY);
   lblLandID.setBounds(200,200,250,35);
   lblLID.setBackground(new Color(212,212,212));
   lblLandID.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   lblLID.setBounds(360,200,200,35);
   lblOwnerName.setBounds(700,260,250,35);
   lblOwnerName.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txOwnerName.setBounds(850,260,200,35);
   lblOwnerID.setBounds(700,200,250,35);
   lblOwnerID.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txOwnerID.setBounds(850,320,200,35);
   lblAadharNo.setBounds(200,260,250,35);
   lblAadharNo.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txAadharNo.setBounds(360,260,200,35);
   lblContactNo.setBounds(700,320,250,35);                                  
   lblContactNo.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txContactNo.setBounds(850,200,200,35);                                        
   lblLandLocation.setBounds(200,320,250,35);
   lblLandLocation.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txLandLocation.setBounds(360,320,200,35);
   lblGender.setBounds(200,380,250,35);
   lblGender.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
                        //txGender.setBounds(400,400,250,35);
   rbmale.setBounds(360,380,100,35);
   rbfemale.setBounds(470,380,100,35);
   
   
   btnNew.setBounds(350,500,100,40);
   btnSave.setBounds(500,500,100,40);
   btnSearch.setBounds(650,500,105,40);
   btnEdit.setBounds(800,500,100,40);
   btnCancel.setBounds(950,500,100,40);

   add(lblTitle);
  add(lblLandID);
  add(lblLID);
  add(lblOwnerName);
  add(txOwnerName);
  add(lblOwnerID);
  add(txOwnerID);
  add(lblAadharNo);
  add(txAadharNo);
  add(lblContactNo);
  add(txContactNo);
  add(lblLandLocation);
  add(txLandLocation);
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
lblLID.setText("");
txOwnerName.setText("");
txOwnerID.setText("");
txAadharNo.setText("");
txContactNo.setText("");
txLandLocation.setText("");
txGender.setText("");
try
{
Connection con;
con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
ResultSet res;
Statement st=st=con.createStatement();
res=st.executeQuery("select * from keytable");
while(res.next())
{
lblLID.setText(""+res.getString(4));
}
}

catch(Exception ex)
{
System.out.println(ex);
} 
}
if(e.getSource()==btnSave)
{
try
{
 Connection con;
 con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
 ResultSet res;
 Statement st=con.createStatement();
 res=st.executeQuery("Select * from landtbl");
 String str= "insert into landtbl(LandID,OwnerName,OwnerID,AadharNo,ContactNo,LandLocation,Gender)values(?,?,?,?,?,?,?)";
 PreparedStatement ps=con.prepareStatement(str);
 ps.setString(1,lblLID.getText());
 ps.setString(2,txOwnerName.getText());
 ps.setString(3,txOwnerID.getText());
 ps.setString(4,txAadharNo.getText());
 ps.setString(5,txContactNo.getText());
 ps.setString(6,txLandLocation.getText());
 ps.setString(7,txGender.getText());
 ps.executeUpdate();
 JOptionPane.showMessageDialog(null,"saved succesfully");
 str="update keytable set LandID =LandID+1";
 ps=con.prepareStatement(str);
 ps.executeUpdate();
}
catch(Exception x)
{
 System.out.println("Exception:"+x);
 
}
}
if(e.getSource()==btnSearch)
{
try
{
Connection con;
con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
ResultSet res;
Statement st=st=con.createStatement();
String LID=JOptionPane.showInputDialog("Enter LandID");
res=st.executeQuery("select * from landtbl where LandID='"+LID+"'");
while(res.next())
{    lblLID.setText(res.getString(1));
     txOwnerName.setText(res.getString(2));
	 txOwnerID.setText(res.getString(3));
	 txAadharNo.setText(res.getString(4));
	 txContactNo.setText(res.getString(5));
	 txLandLocation.setText(res.getString(6));
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
//////////////////////////////
if(e.getSource()==btnEdit)
{
try
{
 Connection con;
 con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
 ResultSet res;
 Statement st=st=con.createStatement();
 res=st.executeQuery("select * from landtbl");
 String Gender;
    if (rbmale.isSelected()==true)
        Gender="MALE";
    else
        Gender="FEMALE";
 String str="update landtbl set LandID='"+lblLID.getText()+"',OwnerName='"+txOwnerName.getText()+"',OwnerID='"+txOwnerID.getText()+"',AadharNo='"+txAadharNo.getText()+"', ContactNo='"+txContactNo.getText()+"',LandLocation='"+txLandLocation.getText()+"',Gender='"+Gender+"' where LandID='"+lblLID.getText()+"'";                       
 PreparedStatement ps=con.prepareStatement(str);
 ps.executeUpdate();
 JOptionPane.showMessageDialog(null,"Update Successfully");
 }
  catch(Exception z)
{ 
System.out.println("Exception:"+z);
}
}
                  
if(e.getSource()==btnCancel)
{
this.dispose();
}


}
public static void main(String argv[])throws IOException
{
land obj=new land();
}
}














