package pollingsystem1;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class PollingSystem1 extends Applet
{
 public int count1;
 public int count2;
 public int totalvotes;
 public Button vote;
 TextField A;
 TextField B;
 @Override
 public void init()
 {
  count1 = 0;
  count2 = 0;
 totalvotes=0;
  this.setBackground(Color.yellow);
  setLayout(new BorderLayout());
     Panel p1 =new Panel();
	 p1.setBackground(Color.lightGray);
         p1.setLayout(new GridLayout(8,2,3,2));
	 Checkbox ch1 =new Checkbox("After 5PM");     
         Checkbox ch2 =new Checkbox("Before 5PM");     
        
        A = new TextField("A:"  + String.valueOf(count1));
	A.setEditable(false);
        B = new TextField("B:" + String.valueOf(count2));
	B.setEditable(false);
       
        handlenp npp = new handlenp();
	p1.add(ch1);
	ch1.addItemListener(npp);
        p1.add(B);
        handleanc ancc = new handleanc();
	p1.add(ch2);
        ch2.addItemListener(ancc);
        p1.add(A);
     
        add("North",p1);
	Label l =new Label("What should be the timing for tomorrow");
	Font f = new Font("Helvetica",Font.BOLD,48);
	l.setFont(f);
        add("Center",l);
        SingleAction sa = new SingleAction();
	vote =new Button("Count number of votes");
	vote.addActionListener(sa);
	add("South",vote);
}
class  handleanc implements ItemListener
{
@Override
public void itemStateChanged(ItemEvent ie)
{
  if(ie.getStateChange()==ItemEvent.SELECTED)
  count1++;
}
}
class  handlenp implements ItemListener
{
  @Override
  public void itemStateChanged(ItemEvent ie)
{
  if(ie.getStateChange()==ItemEvent.SELECTED)
  ++count2;
}
}
class SingleAction implements ActionListener
{
        @Override
	public void actionPerformed(ActionEvent e)
	{
               	A.setText("A :" + (100*count1)/(count1+count2)+"%");
		B.setText("B :" + (100*count2)/(count1+count2)+"%"); 
		
	}
}
}