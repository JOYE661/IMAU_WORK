import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.time.LocalTime;
public class WindowTime extends JFrame implements ActionListener {
   JTextField text;
   JButton bStart,bStop,bContinue;
   Timer time;
   int n=0,start=1;
   WindowTime() {
      time=new Timer(1000,this); //WindowTime对象做计时器的监视器
      text=new JTextField(10); 
      bStart=new JButton("开始");
      bStop=new JButton("暂停");
      bContinue=new JButton("继续");
      bStart.addActionListener(this);
      bStop.addActionListener(this);
      bContinue.addActionListener(this);
      setLayout(new FlowLayout());
      add(bStart);
      add(bStop);
      add(bContinue);
      add(text);
      setSize(500,500);
      validate();
      setVisible(true);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }
   public void actionPerformed(ActionEvent e) { 
      if(e.getSource()==time) {
           LocalTime dateTime = LocalTime.now();  
           String timeStr =
           dateTime.getHour()+":"+dateTime.getMinute()+":"+dateTime.getSecond();
           text.setText(timeStr);
      } 
      else if(e.getSource()==bStart)
           time.start();    
      else if(e.getSource()==bStop)
           time.stop();    
      else if(e.getSource()==bContinue)
           time.restart();    
   }
}
