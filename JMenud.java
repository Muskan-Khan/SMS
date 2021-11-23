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
JMenuItem mnuflat=new JMenuItem("Flat");
JMenuItem mnuduplex=new JMenuItem("Duplex");
JMenuItem mnuowner=new JMenuItem("Owner");
JMenuItem mnustaff=new JMenuItem("Staff");
JMenuItem mnuex=new JMenuItem("Ok");
JMenuItem mnubooking=new JMenuItem("Booking");
JMenuItem mnucancellation=new JMenuItem("Cancellation");
JMenuItem mnupayment=new JMenuItem("Payment");
JMenuItem mnuavailability=new JMenuItem("Available flats/duplex");
JMenuItem mnubbook=new JMenuItem("Total Booking");
JMenuItem mnudpayment=new JMenuItem("Total Payments");
JLabel lbltitle=new JLabel("<html><u>SOCIETY</u></html>");
JLabel lbltitle1=new JLabel("<html><u>MANAGEMENT</u></html>");
JLabel lbltitle2=new JLabel("<html><u>SYSTEM</u></html>");
  JLabel lblpic=new JLabel();
public JMenud()
{
 //********************TO OPEN THE FRAME IN THE CENTER**************

setLayout(null);
Dimension Screen=Toolkit.getDefaultToolkit().getScreenSize();
setSize(Screen.width,Screen.height);
setVisible(true);
setTitle("Society Management");
//setLocationRelativeTo(null);
 //****************************************************************
  lblpic.setIcon(new ImageIcon("images/flat.jpg"));
 
  lblpic.setBounds(500,300,2000,600);  

mb.setFont(new Font("arial",Font.PLAIN,20));
lbltitle1.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,45));
lbltitle1.setForeground(Color.blue);
lbltitle.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,45));
lbltitle.setForeground(Color.blue);
lbltitle2.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,45));
lbltitle2.setForeground(Color.blue);
lbltitle.setBounds(580,100,400,40);
lbltitle1.setBounds(750,150,400,40);
lbltitle2.setBounds(1070,200,400,40);
mnumaster.add(mnuflat);
mnumaster.add(mnuduplex);
mnumaster.add(mnuowner);
mnumaster.add(mnustaff);
mnutransaction.add(mnubooking);
mnutransaction.add(mnupayment);
mnutransaction.add(mnucancellation);
mnureport.add(mnuavailability);
mnureport.add(mnubbook);
mnureport.add(mnudpayment);
mnuexit.add(mnuex);

mb.add(mnumaster);
mb.add(mnutransaction);
mb.add(mnureport);
mb.add(mnuexit);
add(lbltitle);
add(lbltitle1);
add(lbltitle2);
add(lblpic);

mnuflat.addActionListener(this);
mnuduplex.addActionListener(this);
mnuowner.addActionListener(this);
mnustaff.addActionListener(this);
mnubooking.addActionListener(this);
mnucancellation.addActionListener(this);
mnupayment.addActionListener(this);
mnuavailability.addActionListener(this);
mnubbook.addActionListener(this);
mnudpayment.addActionListener(this);
mnuex.addActionListener(this);
this.setJMenuBar(mb);
repaint();
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
      staffc obj=new staffc();
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
	if(e.getSource()==mnupayment)
   {
	payment obj=new payment();
   }
 if(e.getSource()==mnuavailability)
   {
	availability obj=new availability();
   }
 if(e.getSource()==mnubbook)
   {
	bbook obj=new bbook();
   }
 if(e.getSource()==mnudpayment)
   {
	dpayment obj=new dpayment();
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





