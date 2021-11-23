import java.import java.awt.*;
import java.applet.*;
import java.applet.*;
public class sumof2no extends Applet
{
  label l1=new label("Enter your name:");
	button b1=new button("Click");
	TextField tx=new TextField(10);
public void init()
{
 	setLayout(new FlowLayout());
	add(l1);
	add(tx);
	add(b1);
	b1.actionListener(this);
}
public void actionPerformed(ActionEvent e)
{
	if(e.getsource()==b1)
	{
		l2.settext(l1.text);
	}
}
}