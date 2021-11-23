import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
public class myapps extends Frame implements ActionListener
{
	JButton b1=new JButton("Click");
	JTextField tx=new JTextField(10);
	JLabel l1=new JLabel("Enter your name:");
	Label l2=new Label("Output");
	public myapps()
	{
                
		setLayout(null);
                setSize(800,400);
                setTitle("DEMO");
                setVisible(true);
                setBackground(new Color(200,150,80));
                l2.setBackground(new Color(250,150,80));
                l1.setFont(new Font("Monotype Corsiva",Font.BOLD,30));
                l1.setBounds(100,100,250,50);
                tx.setBounds(370,100,200,10);
                b1.setBounds(370,160,300,10);
                l2.setBounds(100,210,370,40);
		add(l1);
		add(tx);
		add(b1);
		add(l2);
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			l2.setText("Hello  "+tx.getText());
		}
	}
        public static void main(String argv[])throws IOException
        {
             myapps obj=new myapps();
        }
}