import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import java.sql.*;
public class JMenud extends JFrame implements ActionListener
{
int flag;
JMenuBar mb=new JMenuBar();
JMenu mnumaster=new JMenu("Master");
JMenu mnureport=new JMenu("Report");
JMenu mnutransaction=new JMenu("Transaction");
JMenu mnuexit=new JMenu("Logout");
JMenuItem mnuflat=new JMenuItem("Flat",new ImageIcon("images/flat1.jpg"));
JMenuItem mnuduplex=new JMenuItem("Duplex");
JMenuItem mnuowner=new JMenuItem("Owner");
JMenuItem mnustaff=new JMenuItem("Staff");
JMenuItem mnuex=new JMenuItem("Ok");
JMenuItem mnubooking=new JMenuItem("Booking");
JMenuItem mnucancellation=new JMenuItem("Cancellation");
JMenuItem mnuspayment=new JMenuItem("Sales Payment");
JMenuItem mnumaintenance=new JMenuItem("Maintenance");
JLabel lbltitle=new JLabel("SOCIETY");
JLabel lbltitle1=new JLabel("MAINTENANCE");      
public JMenud()
{
setLayout(null);
Dimension Screen=Toolkit.getDefaultToolkit().getScreenSize();
setSize(Screen.width,Screen.height);
setVisible(true);
setTitle("Society Management");
mb.setFont(new Font("arial",Font.PLAIN,20));
lbltitle1.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,35));
lbltitle1.setForeground(Color.cyan);
lbltitle.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,35));
lbltitle.setForeground(Color.cyan);
lbltitle.setBounds(450,100,400,40);
lbltitle1.setBounds(540,150,400,40);
mnumaster.add(mnuflat);
mnumaster.add(mnuduplex);
mnumaster.add(mnuowner);
mnumaster.add(mnustaff);
mnutransaction.add(mnubooking);
mnutransaction.add(mnucancellation);
mnutransaction.add(mnuspayment);
mnutransaction.add(mnumaintenance);
mnuexit.add(mnuex);

mb.add(mnumaster);
mb.add(mnutransaction);
mb.add(mnureport);
mb.add(mnuexit);
add(lbltitle);
add(lbltitle1);
mnuflat.addActionListener(this);
mnuduplex.addActionListener(this);
mnuowner.addActionListener(this);
mnustaff.addActionListener(this);
mnubooking.addActionListener(this);
mnucancellation.addActionListener(this);
mnuspayment.addActionListener(this);
mnumaintenance.addActionListener(this);
this.setJMenuBar(mb);
}
public void actionPerformed(ActionEvent e)
{
  if(e.getSource()==mnuflat)
   {
      flat_info obj=new flat_info();
   }
  if(e.getSource()==mnuduplex)
   {
	duplex_info obj=new duplex_info();
   }
   if(e.getSource()==mnustaff)
   {
      staff obj=new staff();
   }
    if(e.getSource()==mnuowner)
   {
      owner_info obj=new owner_info();
   }
   if(e.getSource()==mnucancellation)
   {
      cancellation obj=new cancellation();
   }
   if(e.getSource()==mnubooking)
   {
	booking obj=new booking();
   }
    if(e.getSource()==mnuex)
   {
   System.exit(0);
   }
}
public static void main(String args[])
{
JMenud obj=new JMenud();
}
}





