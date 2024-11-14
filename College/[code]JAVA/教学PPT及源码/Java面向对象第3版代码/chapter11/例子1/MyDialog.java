import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyDialog extends JDialog implements ActionListener  { //对话框类
   static final int YES=1,NO=0;
   int message=-1; 
   JButton yes,no;
    MyDialog(JFrame f,String s,boolean b) { //构造方法	
       super(f,s,b);
       yes=new JButton("Yes"); 
       yes.addActionListener(this);
       no=new JButton("No");  
       no.addActionListener(this);
       setLayout(new FlowLayout());
       add(yes); 
       add(no);
       setBounds(60,60,100,100);
       addWindowListener(new WindowAdapter(){
                           public void windowClosing(WindowEvent e){
                              message=-1;
                              setVisible(false);
                           }
                         });
    }
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==yes) {
           message=YES;
           setVisible(false);
       }
       else if(e.getSource()==no) {
           message=NO;
           setVisible(false);
       }
    }
    public int getMessage() {
       return message;
    }
}
