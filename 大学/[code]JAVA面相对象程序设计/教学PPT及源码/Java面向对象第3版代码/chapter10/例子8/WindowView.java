import java.awt.*;
import javax.swing.*;
public class WindowView extends JFrame {
   public JTextField inputNumberOne,inputNumberTwo; 
   public JComboBox<String> choiceFuhao;
   public JTextArea textShow;
   public JButton button;
   public OperatorListener operator;    //监视ItemEvent事件的监视器
   public ComputerListener computer;   //监视ActionEvent事件的监视器
   public WindowView() {
      init();
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   void init() {
      setLayout(new FlowLayout());
      inputNumberOne = new JTextField(5);
      inputNumberTwo = new JTextField(5);
      choiceFuhao = new JComboBox<String>();
      button = new JButton("计算"); 
      choiceFuhao.addItem("选择运算符号:");
      String [] a = {"+","-","*","/"};
      for(int i=0;i<a.length;i++) {
          choiceFuhao.addItem(a[i]);
      }
      textShow = new JTextArea(9,30);
      operator = new OperatorListener();
      computer = new ComputerListener();
      operator.setView(this);   //将当前窗口的引用传递给监视器
      computer.setView(this);  //将当前窗口的引用传递给监视器
      choiceFuhao.addItemListener(operator);   //choiceFuhao是事件源,operator是监视器
      button.addActionListener(computer);      //button是事件源,computer是监视器
      add(inputNumberOne);
      add(choiceFuhao);
      add(inputNumberTwo);
      add(button);
      add(new JScrollPane(textShow));
   }
}
