 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BindButtonWindow extends JFrame {
    JButton button; 
    Police listener;
    BindButtonWindow(){
       setLayout(new FlowLayout());
       listener=new Police();
       button = new JButton("单击我或按'A'键移动我");
       add(button);
       button.addActionListener(listener);// listener以注册方式成为监视器，监视鼠标单击按钮
       InputMap inputmap = button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
       inputmap.put(KeyStroke.getKeyStroke("A"),"dog");
       ActionMap actionmap=button.getActionMap();
       actionmap.put("dog",listener);    // 指定listener是按钮键盘操作的监视器
       setVisible(true);
       setBounds(100,100,800,500);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }
    class Police extends AbstractAction { //Police是内部类
       public void actionPerformed(ActionEvent e) {
          JButton b=(JButton)e.getSource();
          int x=b.getBounds().x; //获取按钮的位置 
          int y=b.getBounds().y;
          b.setLocation(x+10,y+10); //移动按钮 
       }
    }
}
