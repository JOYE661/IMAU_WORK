import java.awt.*;
import javax.swing.*;
public class WindowTextView extends JFrame { 
   public JTextArea textInput;  //�û������ı�
   public JTextArea textShow;   //������ʾ�û�������ı��еĵ���
   HandleWord  handleWord; //��������ļ�����
   WindowTextView() { 
      init();
      setBounds(120,100,260,270);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
   }
   void init() {
      textInput = new JTextArea(3,15);
      textShow = new JTextArea(3,15);
      setLayout(new FlowLayout());
      add(new JScrollPane(textInput));
      add(new JScrollPane(textShow));
      textInput.setLineWrap(true);
      textShow.setLineWrap(true); 
      textShow.setEditable(false);
      handleWord = new HandleWord();
      handleWord.setView(this);
      (textInput.getDocument()).addDocumentListener(handleWord); //���ĵ�ע�������
   }
}