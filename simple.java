import java.io.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class simple extends frame implements ActionListener
{
   Label lbl=new Label("Enter name:");
   TextField txname=new TextField(10);
    Button bttn=new Button("Click");
    public simple()
   {
    setLayout(null);
    setSize(2100,1800);
	lbl.setBackground(new Color(250,150,80));
	txname.setFont(new Font("Monotype Corsiva",20));
	add(lbl);
	add(txname);
	add(bttn);
	bttn.addActionListener(this);
	public void actionPerformed(ActionEvent ex)
	{
		if(e.getSource()==bttn)
		{
			try
			{
			System.out.println(txname.text);
			}
			catch
			{
			System.out.println("Exception:"+ex)
		}
	}
	}
public static void main(String argv[])throws IOException
{
	simple obj=new simpple();
}
}