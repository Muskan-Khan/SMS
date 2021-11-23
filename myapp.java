import java.awt.*;////abstract windowing toolkit
import java.awt.event.*;
import java.applet.*;
public class myapp extends Applet implements ActionListener
{
   Button b1=new Button("add");
   Label l1=new Label("number1");
   Label l2=new Label("number2");
   Label l3=new Label("result");
   TextField tx1=new TextField(15);
   TextField tx2=new TextField(15);
   TextField tx3=new TextField(15);
public void init()
 { 
add(l1);
add(tx1);
add(l2);
add(tx2);
add(l3);
add(tx3);
add(b1);
b1.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
  if(e.getSource()==b1)
  {
int x=Integer.parseInt(tx1.getText());
int y=Integer.parseInt(tx2.getText());
int z=x+y;
tx3.setText(""+z);
l3.setText("add"+tx3.getText());
 }
}
}
