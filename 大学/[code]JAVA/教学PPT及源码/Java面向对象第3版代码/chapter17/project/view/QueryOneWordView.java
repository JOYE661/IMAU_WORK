package project.view;
import javax.swing.*;
import java.awt.*;
public class QueryOneWordView extends JPanel {
   JTextField inputWord;   //����Ҫ��ѯ�ĵ���
   JButton submit;        //�ύ��ť    
   JTextArea showWord;  //��ʾ��ѯ���
   HandleQueryOneWord  handleQueryOneWord; //�������ѯ����
   QueryOneWordView(){
      initView();
      registerListener() ;
   }
   private void initView() {
      setLayout(new BorderLayout());
      JPanel pNorth = new JPanel();
      inputWord = new JTextField(12);
      submit = new JButton("��ѯ����");
      showWord = new JTextArea();
      showWord.setFont(new Font("����",Font.BOLD,20));
      pNorth.add(new JLabel("����Ҫ��ѯ�ĵ���:"));
      pNorth.add(inputWord);
      pNorth.add(submit);
      add(pNorth,BorderLayout.NORTH);
      add(new JScrollPane(showWord),BorderLayout.CENTER);
   }
   private void registerListener() {
      handleQueryOneWord = new HandleQueryOneWord();
      handleQueryOneWord.setView(this);
      submit.addActionListener(handleQueryOneWord);
   }
}
