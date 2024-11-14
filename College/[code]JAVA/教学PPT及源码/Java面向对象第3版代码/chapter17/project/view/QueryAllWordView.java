package project.view;
import java.awt.*;
import javax.swing.*;
public class QueryAllWordView extends JPanel {
   JButton submit;       //��ѯ��ť 
   JTextArea showWord;  //��ʾ��ѯ���
   HandleQueryAllWord handleQueryAllWord;//�������ѯȫ������
   QueryAllWordView() {
      initView();
      registerListener() ;
   }
   public void initView() {
      setLayout(new BorderLayout());
      submit = new JButton("��ѯȫ������"); 
      add(submit,BorderLayout.NORTH);
      showWord = new JTextArea();
      showWord.setFont(new Font("����",Font.BOLD,20));
      add(new JScrollPane(showWord),BorderLayout.CENTER);
   } 
   private void registerListener() {
      handleQueryAllWord = new HandleQueryAllWord();
      handleQueryAllWord.setView(this);
      submit.addActionListener(handleQueryAllWord);
   }
}
