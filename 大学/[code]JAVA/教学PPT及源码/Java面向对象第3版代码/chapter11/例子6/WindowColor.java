import java.awt.event.*; 
import java.awt.*;
import javax.swing.*;
public class WindowColor extends JFrame implements ActionListener {
   JButton button;
   WindowColor() {
      button=new JButton("打开颜色对话框"); 
      button.addActionListener(this);
      setLayout(new FlowLayout());
      add(button);
      setBounds(60,60,300,300);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public void actionPerformed(ActionEvent e) {
      Color newColor=JColorChooser.showDialog(this,"调色板",button.getBackground());
      if(newColor!=null) {
         button.setBackground(newColor); 
      }    
   }
}
