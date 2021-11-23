import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.util.*;
import java.sql.*;
public class login extends Frame implements ActionListener
{
  
   JButton btnLogin=new JButton("Login");
   JButton btnCancel=new JButton("Cancel");
   
   JLabel lblusername=new JLabel("User Name:");
   JLabel lblpassword=new JLabel("Password:");   
	TextField txtUsername=new TextField(30);
   JPasswordField passwordField=new JPasswordField(20);
   
   char[] password;
   
public login()
{
  setLayout(null);
  setTitle("Login...");
  setVisible(true);
  Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
  int height=screenSize.height;
  int width=screenSize.width;
  setSize((width/2)-225,(height/2)-50);
  setLocationRelativeTo(null);
 
  lblusername.setBounds(100,144,148,30);
  txtUsername.setBounds(198,144,148,25);
  lblpassword.setBounds(100,175,148,30);
  passwordField.setBounds(198,175,148,25);
  btnLogin.setBounds(146,220,85,25);
  btnCancel.setBounds(244,220,85,25);
   
  add(lblusername);
  add(lblpassword);
  add(txtUsername);
  add(passwordField);
  add(btnLogin);
  add(btnCancel); 
 
  lblusername.setFont(new Font("Arial",Font.BOLD,15));
  txtUsername.setFont(new java.awt.Font("Arial",Font.BOLD,15));
  lblpassword.setFont(new Font("Arial",Font.BOLD,15));
  passwordField.setFont(new java.awt.Font("Arial",Font.BOLD,15));

  txtUsername.setForeground(Color.BLUE);  
  passwordField.setFont(new java.awt.Font("Arial",Font.BOLD,20));
  passwordField.setForeground(Color.BLUE);  
  btnLogin.addActionListener(this);
  btnCancel.addActionListener(this);    
  
}
public void actionPerformed(ActionEvent e)
{

  if(e.getSource()==btnCancel)
  {
    System.exit(0);
  }
  if(e.getSource()==btnLogin)
  {
   try
   {
        Connection con;
	con=DriverManager.getConnection("jdbc:odbc:sms");
	Statement st=con.createStatement();
	ResultSet res;
	res=st.executeQuery("Select * from login" );
        String str="select * from login where username='" + txtUsername.getText()+"' and password='"+passwordField.getText()+"'";
         while(res.next())
         {
	    String val1=res.getString(1);
	    String val2=res.getString(2);
	    if(val1.equals(txtUsername.getText())&&val2.equals(passwordField.getText()))
	    {
			JOptionPane.showMessageDialog(null,"Login Successful");	
			JOptionPane.showMessageDialog(null,"Welcome to Society Management");
			while(res.next())
				{
				JMenud obj=new JMenud();
				//flg=flg+1;
				//this.dispose();
				}
	}
	    else
	    {
		JOptionPane.showMessageDialog(null,"Wrong ID or password");
            }
         }
    }   
     catch(Exception ex)
     {
	System.out.println("Error:"+ex);
     }
}
}
public static void main(String argv[])throws IOException
{
   login obj=new login();
}
}