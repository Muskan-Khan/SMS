import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class MenuCMS extends JFrame implements ActionListener
{
JMenuBar menubar=new JMenuBar();
JMenu mnuMaster=new JMenu("Master");
JMenu mnuTransaction=new JMenu("Transaction");
JMenu mnuReport=new JMenu("Report");
JMenu mnuExit=new JMenu("Exit");


JMenuItem mnucust=new JMenuItem("CUSTOMER",new ImageIcon("Icons/customer-icon.gif"));
JMenuItem mnustaff=new JMenuItem("STAFF",new ImageIcon("Icons/staff.gif"));;
JMenuItem mnuflat=new JMenuItem("FLAT",new ImageIcon("Images/f1.gif"));;
JMenuItem mnuland=new JMenuItem("LAND",new ImageIcon("Images/l1.gif"));;
JMenuItem mnuduplex=new JMenuItem("DUPLEX",new ImageIcon("Images/Home.gif"));;
JMenuItem mnubook=new JMenuItem("BOOKING",new ImageIcon("Icons/b2.gif"));;
JMenuItem mnupayment=new JMenuItem("PAYMENT",new ImageIcon("Images/payments.png"));;
	JMenuItem mnucancel=new JMenuItem("CANCEL",new ImageIcon("Images/delete.png"));;
		JMenuItem mnureport=new JMenuItem("REPORT",new ImageIcon("Icons/b1.gif"));;
			JMenuItem mnuexit=new JMenuItem("EXIT",new ImageIcon("Images/exit.png"));;
				

public MenuCMS()
{  
setLayout(null);
setSize(600,600);
Dimension Screen=Toolkit.getDefaultToolkit().getScreenSize();
	    setSize(Screen.width,Screen.height);
setVisible(true);
setTitle("MENU BAR CMS");
setBackground(new Color(223,112,0)); 
menubar.add(mnuMaster);
        menubar.add(mnuTransaction);
        menubar.add(mnuReport);
        menubar.add(mnuExit);
	mnuMaster.add(mnucust);
	mnuMaster.add(mnustaff);
	mnuMaster.add(mnuflat);
	mnuMaster.add(mnuland);
	mnuMaster.add(mnuduplex);
	mnuTransaction.add(mnubook);
		mnuTransaction.add(mnupayment);
			mnuTransaction.add(mnucancel);
				mnuReport.add(mnureport);
				mnuExit.add(mnuexit);
    mnustaff.addActionListener(this);
mnucust.addActionListener(this);
mnuduplex.addActionListener(this);
mnuflat.addActionListener(this);
mnuland.addActionListener(this);
mnubook.addActionListener(this);
mnupayment.addActionListener(this);
mnucancel.addActionListener(this);
mnureport.addActionListener(this);
mnuexit.addActionListener(this);

this.setJMenuBar(menubar);
}
public void actionPerformed(ActionEvent e )
{
if (e.getSource()==mnustaff)
     {
	    staff obj=new staff();
	 }
	 
		if (e.getSource()==mnucust)
     {
	    customer obj=new customer();
     }
	 
	    if (e.getSource()==mnuduplex)
     {
	    duplex obj=new duplex();
	}
if (e.getSource()==mnuflat)
     {
	    flat obj=new flat();
	}
	if (e.getSource()==mnuland)
     {
	    land obj=new land();
	}
	if (e.getSource()==mnupayment)
     {
	    payment obj=new payment();
	}
	if (e.getSource()==mnubook)
     {
	    book obj=new book();
	}
	if (e.getSource()==mnucancel)
     {
	    cancel obj=new cancel();
	}
	if (e.getSource()==mnuexit)
     {
	   System.exit(0);
	}
	if (e.getSource()==mnureport)
     {
	    report obj=new report();
	}

}	
    	
public static void main(String args[])throws IOException
{
MenuCMS obj=new MenuCMS();
}
}






















