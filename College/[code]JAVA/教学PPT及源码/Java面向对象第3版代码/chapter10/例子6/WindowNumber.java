
import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.*;
public class WindowNumber extends JFrame { 
   JTextField text;
   PoliceListen listener;
   public WindowNumber() {
      init();
      setBounds(100,100,150,150);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   void init() {
      setLayout(new FlowLayout());
      text=new JTextField(10);          
      listener=new PoliceListen();
      text.addActionListener(listener); //text是事件源,listener是监视器
      add(text);
   }
}