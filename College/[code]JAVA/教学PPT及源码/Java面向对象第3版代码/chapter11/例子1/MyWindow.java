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
      button=new JButton("�򿪶Ի���"); 
      button.addActionListener(this);
      setLayout(new FlowLayout());
      add(button); 
      add(text); 
      dialog=new MyDialog(this,"���ǶԻ���",true);//�Ի���������MyWindow�����Ĵ���
   }
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==button) {
        int x=this.getBounds().x+this.getBounds().width;
        int y=this.getBounds().y;
        dialog.setLocation(x,y);
        dialog.setVisible(true); //�Ի��򼤻�״̬ʱ,�����������䡣
        //�Ի�����ʧ�������������ִ�У�
        if(dialog.getMessage()==MyDialog.YES)   //��������˶Ի����yes��ť
            text.append("\n�㵥���˶Ի����yes��ť"); 
        else if(dialog.getMessage()==MyDialog.NO) //��������˶Ի����no��ť
            text.append("\n�㵥���˶Ի����No��ť");
        else if(dialog.getMessage()==-1) 
            text.append("\n�㵥���˶Ի���Ĺر�ͼ��");
      }
   }
}
