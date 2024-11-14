import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyWindow extends JFrame implements ActionListener {
   JTextArea text; 
   JButton button; 
   MyDialog dialog;
   MyWindow() {
      init();
      setBounds(60,60,300,300); 
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   void init() {
      text=new JTextArea(5,22); 
      button=new JButton("打开对话框"); 
      button.addActionListener(this);
      setLayout(new FlowLayout());
      add(button); 
      add(text); 
      dialog=new MyDialog(this,"我是对话框",true);//对话框依赖于MyWindow创建的窗口
   }
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==button) {
        int x=this.getBounds().x+this.getBounds().width;
        int y=this.getBounds().y;
        dialog.setLocation(x,y);
        dialog.setVisible(true); //对话框激活状态时,堵塞下面的语句。
        //对话框消失后下面的语句继续执行：
        if(dialog.getMessage()==MyDialog.YES)   //如果单击了对话框的yes按钮
            text.append("\n你单击了对话框的yes按钮"); 
        else if(dialog.getMessage()==MyDialog.NO) //如果单击了对话框的no按钮
            text.append("\n你单击了对话框的No按钮");
        else if(dialog.getMessage()==-1) 
            text.append("\n你单击了对话框的关闭图标");
      }
   }
}
