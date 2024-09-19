import java.awt.*;
import javax.swing.*;
public class MVCWindow extends JFrame  {
    TriangeModel model;             //模型
    JTextField textA,textB,textC;  //视图
    JTextArea showArea;            //视图
    JButton button;
    Controller controller;        //控制器（监视器充当该角色）
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
       button = new JButton("计算面积");
       showArea = new JTextArea(); 
       JPanel pNorth=new JPanel();
       pNorth.add(new JLabel("边A:"));
       pNorth.add(textA);
       pNorth.add(new JLabel("边B:"));
       pNorth.add(textB);
       pNorth.add(new JLabel("边C"));
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
