import java.awt.*;
import javax.swing.*;
public class WindowMouse extends JFrame {
    JButton button;
    JTextArea area;
    MousePolice police; 
    WindowMouse() {
       init();
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    void init() {
       setLayout(new FlowLayout());
       area = new JTextArea(10,28);
       police = new MousePolice();
       police.setView(this); 
       button = new JButton("°´Å¥"); 
       button.addMouseListener(police);
       addMouseListener(police);
       add(button);
       add(new JScrollPane(area));
   }
}