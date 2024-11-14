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
       button = new JButton("ȷ��");
       textInput=new JTextField(10);
       textShow=new JTextField(10); 
       textShow.setEditable(false);
       listener=new PoliceListen();
       listener.setView(this);   //����ǰ���ڵ����ô��ݸ�������
       textInput.addActionListener(listener); //textInput���¼�Դ,listener�Ǽ�����
       button.addActionListener(listener); //button���¼�Դ,listener�Ǽ�����
       add(textInput);
       add(button); 
       add(textShow);
   }
}