import java.awt.event.*; 
import java.awt.*;
import javax.swing.*;
public class WindowInput extends JFrame implements ActionListener {
   int m;
   JButton openInput;
   WindowInput() {
       openInput=new JButton("弹出输入对话框");
       add(openInput,BorderLayout.NORTH);
       openInput.addActionListener(this); 
       setBounds(60,60,300,300);        
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public void actionPerformed(ActionEvent e) { 
      String str=JOptionPane.showInputDialog(this,"输入正整数","输入对话框",
                                              JOptionPane.PLAIN_MESSAGE);
      if(str!=null) {
        try {
              m=Integer.parseInt(str);
              setSize(m,m);
         }
         catch(Exception exp){} 
      }
     
   }
}
