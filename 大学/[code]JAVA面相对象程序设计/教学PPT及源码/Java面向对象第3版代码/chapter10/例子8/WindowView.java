import java.awt.*;
import javax.swing.*;
public class WindowView extends JFrame {
   public JTextField inputNumberOne,inputNumberTwo; 
   public JComboBox<String> choiceFuhao;
   public JTextArea textShow;
   public JButton button;
   public OperatorListener operator;    //����ItemEvent�¼��ļ�����
   public ComputerListener computer;   //����ActionEvent�¼��ļ�����
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
      button = new JButton("����"); 
      choiceFuhao.addItem("ѡ���������:");
      String [] a = {"+","-","*","/"};
      for(int i=0;i<a.length;i++) {
          choiceFuhao.addItem(a[i]);
      }
      textShow = new JTextArea(9,30);
      operator = new OperatorListener();
      computer = new ComputerListener();
      operator.setView(this);   //����ǰ���ڵ����ô��ݸ�������
      computer.setView(this);  //����ǰ���ڵ����ô��ݸ�������
      choiceFuhao.addItemListener(operator);   //choiceFuhao���¼�Դ,operator�Ǽ�����
      button.addActionListener(computer);      //button���¼�Դ,computer�Ǽ�����
      add(inputNumberOne);
      add(choiceFuhao);
      add(inputNumberTwo);
      add(button);
      add(new JScrollPane(textShow));
   }
}
