import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.*;
public class WindowNumber extends JFrame { 
    public JTextField textInput,textShow;
    public JButton button;
    PoliceListen listener;
    public WindowNumber() {
       init();
       setBounds(100,100,320,100);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   void init() {
       setLayout(new FlowLayout());
       button = new JButton("确定");
       textInput=new JTextField(10);
       textShow=new JTextField(10); 
       textShow.setEditable(false);
       listener=new PoliceListen();
       listener.setView(this);   //将当前窗口的引用传递给监视器
       textInput.addActionListener(listener); //textInput是事件源,listener是监视器
       button.addActionListener(listener); //button是事件源,listener是监视器
       add(textInput);
       add(button); 
       add(textShow);
   }
}