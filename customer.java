import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class customer extends Frame implements ActionListener
{
JLabel lblTitle=new JLabel("CUSTOMER DETAILS");
 JLabel lblCustID= new JLabel("Enter your Customer ID:");
 JLabel lblCustName= new JLabel("Enter your Customer Name:");
 JLabel lblCustAddress= new JLabel("Enter your Address:");
 JLabel lblAadharNo= new JLabel("Enter your Aadhar No:");
 JLabel lblDOB= new JLabel("Enter your DOB:");
 JLabel lblGender= new JLabel("Enter your Gender:");
 JLabel lblBankName= new JLabel("Enter your Bank Name:");
 JLabel lblBankAC= new JLabel("Enter your Bank A/C No:");
 JLabel lblType= new JLabel("Enter your Preference:");
 JLabel lblContactNo= new JLabel("Enter your Contact No:");
 Label lblCID=new Label("              ");
 JTextField txCustName=new JTextField(15);
 JTextField txCustAddress=new JTextField(15);
 JTextField txAadharNo=new JTextField(15); 
 JTextField txDOB=new JTextField(15);
 JTextField txBankName=new JTextField(15);
 JTextField txBankAC=new JTextField(15);
 JTextField txGender=new JTextField(15);
 JTextField txContactNo=new JTextField(15);
 JButton btnNew=new JButton("NEW",new ImageIcon("images/NEW.gif"));
 JButton btnSave=new JButton("SAVE",new ImageIcon("images/SAVE.gif"));
 JButton btnSearch=new JButton("SEARCH",new ImageIcon("images/search.png"));
 JButton btnEdit=new JButton("EDIT",new ImageIcon("images/edit.png"));
 JButton btnCancel=new JButton("CANCEL",new ImageIcon("images/exit.png"));
 JRadioButton rbmale=new JRadioButton("MALE");
 JRadioButton rbfemale=new JRadioButton("FEMALE");
   ButtonGroup bg=new ButtonGroup(); 
 public customer()
 {
   setLayout(null);
   setVisible(true);
   setSize(1100,700);
   lblTitle.setBounds(550,100,450,50);
   lblTitle.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,40));
   lblTitle.setForeground(Color.GRAY);
   setBackground(new Color(255,255,255));
   lblCustID.setBounds(150,200,250,35);
   lblCID.setBackground(new Color(255,255,255));
   lblCustID.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   lblCID.setBackground(new Color(212,212,212));
   lblCID.setBounds(360,200,200,35);
   lblCustName.setBounds(650,200,250,35);
   lblCustName.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txCustName.setBounds(870,200,200,35);
   lblCustAddress.setBounds(150,250,250,35);
   lblCustAddress.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txCustAddress.setBounds(350,250,200,35);
   lblAadharNo.setBounds(650,250,200,35);
   lblAadharNo.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txAadharNo.setBounds(870,250,200,35);
   lblDOB.setBounds(150,300,200,35);
   lblDOB.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txDOB.setBounds(350,300,200,35);
   lblBankName.setBounds(650,300,200,35);
   lblBankName.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txBankName.setBounds(870,300,200,35);
   lblBankAC.setBounds(150,350,200,35);
   lblBankAC.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txBankAC.setBounds(350,350,200,35);
   lblContactNo.setBounds(650,350,200,35);
   lblContactNo.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
   txContactNo.setBounds(870,350,200,35);

   lblGender.setBounds(150,400,200,35);
   lblGender.setFont(new Font("Monotype Corsiva",Font.ITALIC,20));
                        //txGender.setBounds(350,400,100,355);
   rbmale.setBounds(350,400,100,35);
   rbfemale.setBounds(450,400,100,35);
   
   btnNew.setBounds(350,500,100,40);
   btnSave.setBounds(500,500,100,40);
   btnSearch.setBounds(650,500,105,40);
   btnEdit.setBounds(800,500,100,40);
   btnCancel.setBounds(950,500,100,40);
 
  add(lblTitle);
  add(lblCustID);
  add(lblCID);
  add(lblCustName);
  add(txCustName);
  add(lblCustAddress);
  add(txCustAddress);
  add(lblAadharNo);
  add(txAadharNo);
  add(lblDOB);
  add(txDOB);
  add(lblBankName);
  add(txBankName);
  add(lblBankAC);
  add(txBankAC);
  add(lblContactNo);
  add(txContactNo);
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
lblCID.setText("");
txCustName.setText("");
txCustAddress.setText("");
txAadharNo.setText("");
txDOB.setText("");
txBankName.setText("");
txBankAC.setText("");
txGender.setText("");
txContactNo.setText("");
try
{
Connection con;
con=DriverManager.getConnection("jdbc:odbc:cmsdsn");
ResultSet res;
Statement st=st=con.createStatement();
res=st.executeQuery("select * from keytable");
while(res.next())
{
lblCID.setText(""+res.getString(2));
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
 res=st.executeQuery("Select * from custtbl");
 String str= "insert into custtbl(CustID,CustName,CustAddress,AadharNo,DOB,BankName,BankAC,Gender,ContactNo)values(?,?,?,?,?,?,?,?,?)";
 PreparedStatement ps=con.prepareStatement(str);
 ps.setString(1,lblCID.getText());
 ps.setString(2,txCustName.getText());
 ps.setString(3,txCustAddress.getText());
 ps.setString(4,txAadharNo.getText());
 ps.setString(5,txDOB.getText());
 ps.setString(6,txBankName.getText());
 ps.setString(7,txBankAC.getText());
 ps.setString(8,txGender.getText());
 ps.setString(9,txContactNo.getText());
 ps.executeUpdate();
 JOptionPane.showMessageDialog(null,"saved succesfully");
 str="update keytable set CustID =CustID+1";
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
String CID=JOptionPane.showInputDialog("Enter CID");
res=st.executeQuery("select * from custtbl where CustID='"+CID+"'");
while(res.next())
{
     lblCID.setText(res.getString(1));
     txCustName.setText(res.getString(2));
	 txCustAddress.setText(res.getString(3));
	 txAadharNo.setText(res.getString(4));
	 txDOB.setText(res.getString(5));
	 txBankName.setText(res.getString(6));
	 txBankAC.setText(res.getString(7));
	 if (res.getString(8).equals("rbmale"))
	 rbmale.setSelected(true);
	 else
	 rbfemale.setSelected(true);
	 txContactNo.setText(res.getString(9));

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
 res=st.executeQuery("select * from custtbl");
 String Gender;
    if (rbmale.isSelected()==true)
        Gender="MALE";
    else
        Gender="FEMALE";
 String str="update custtbl set CustID='"+lblCID.getText()+"',CustName='"+txCustName.getText()+"',CustAddress='"+txCustAddress.getText()+"',AadharNo='"+txAadharNo.getText()+"', DOB='"+txDOB.getText()+"',BankName='"+txBankName.getText()+"',BankAC='"+txBankAC.getText()+"',Gender='"+txGender.getText()+"',ContactNo='"+txContactNo.getText()+"' where CustID='"+lblCID.getText()+"'";
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
customer obj=new customer();
}
}










































