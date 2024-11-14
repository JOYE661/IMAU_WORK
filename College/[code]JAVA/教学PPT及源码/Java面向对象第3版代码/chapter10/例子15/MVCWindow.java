import java.awt.*;
import javax.swing.*;
public class MVCWindow extends JFrame  {
    TriangeModel model;             //ģ��
    JTextField textA,textB,textC;  //��ͼ
    JTextArea showArea;            //��ͼ
    JButton button;
    Controller controller;        //���������������䵱�ý�ɫ��
    MVCWindow() {
       init();
       setVisible(true);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    void init() {
       model = new TriangeModel();
       textA = new JTextField(5);   
       textB = new JTextField(5);
       textC = new JTextField(5);
       button = new JButton("�������");
       showArea = new JTextArea(); 
       JPanel pNorth=new JPanel();
       pNorth.add(new JLabel("��A:"));
       pNorth.add(textA);
       pNorth.add(new JLabel("��B:"));
       pNorth.add(textB);
       pNorth.add(new JLabel("��C"));
       pNorth.add(textC); 
       pNorth.add(button); 
       add(pNorth,BorderLayout.NORTH);
       add(new JScrollPane(showArea),BorderLayout.CENTER);
       controller = new Controller(); 
       button.addActionListener(controller);
       controller.setMVCWindow(this);
       validate();
    }
}
