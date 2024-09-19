package project.view;
import java.awt.*;
import javax.swing.*;
public class RandomQueryView extends JPanel {
   JTextField inputQueryNumber;//����Ҫ��ѯ�ĵ�����Ŀ
   JButton submit;            //��ѯ��ť 
   JTextArea showWord;       //��ʾ��ѯ���
   HandleRandomQueryWord  handleRandomQueryWord;  //�����������ѯ����
   RandomQueryView() {
      initView();
      registerListener() ;
   }
   public void initView() {
      setLayout(new BorderLayout());
      JPanel pNorth = new JPanel();
      inputQueryNumber = new JTextField(4);
      showWord = new JTextArea(); 
      showWord.setFont(new Font("����",Font.BOLD,20));
      submit = new JButton("��ѯ");
      pNorth.add(new JLabel("���������ѯ����Ŀ:"));
      pNorth.add(inputQueryNumber);
      pNorth.add(submit);
      add(pNorth,BorderLayout.NORTH);
      add(new JScrollPane(showWord),BorderLayout.CENTER);
   }
   private void registerListener() {
      handleRandomQueryWord = new HandleRandomQueryWord();
      handleRandomQueryWord.setView(this);
      submit.addActionListener(handleRandomQueryWord);
   }
}
