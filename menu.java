import java.awt.event.ActionEvent;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.*;
public class MenuCMS extends Frame
implements ActionListener
{
MenuBar mnuBar=new MenuBar();
Menu mnuMaster=new Menu("Master");
Menu mnuTransaction=new Menu("Transaction");
Menu mnuReport=new Menu("Report");
Menu mnuExit=new Menu("Exit");

MenuItem mnuStaff=new MenuItem("Staff");
MenuItem mnuCustomer=new MenuItem("Customer");
MenuItem mnuDuplex=new MenuItem("Duplex");
MenuItem mnuFlat=new MenuItem("Flat");
MenuItem mnuLand=new MenuItem("Land");

public MenuCMS()
{
setLayout(null);
setSize(600,600);
setTitle("MENU BAR CMS");
setBackground=new color(255,0,255); mnuStaff.add(mnuStaff);
mnuCustomer.add(mnuCustomer);
mnuDuplex.add(mnuDuplex);
mnuFlat.add(mnuFlat);
mnuLand.add(mnuLand);
mnuMaster.add(mnuMaster);
mnuTransaction.add(mnuTransaction);
mnuReport.add(mnuReport);
mnuExit.add(mnuExit);
mnuStaff.addActionListener(this);
mnuCustomer.addActionListener(this);
mnuDuplex.addActionListener(this);
mnuFlat.addActionListener(this);
mnuLand.addActionListener(this);

this.SetMenuBar(mnuBar);
}
public void actionPerformed(ActionEvent e )
{
if (e.getSource()==mnuStaff)
     {
	    Staff obj=new Staff();
	 }
	 
		if (e.getSource()==mnuCustomer)
     {
	    customer obj=new customer();
     }
	 
	    if (e.getSource()==mnuDuplex)
     {
	    Duplex obj=new Duplex();
	}
if (e.getSource()==mnuFlat)
     {
	    Flat obj=new Flat();
	}
	if (e.getSource()==mnuLand)
     {
	    Land obj=new Land();
	}

}	
    	
public static void main(String args[])throws IOException
{
MenuCMS obj=new MenuCMS();
}
}






















