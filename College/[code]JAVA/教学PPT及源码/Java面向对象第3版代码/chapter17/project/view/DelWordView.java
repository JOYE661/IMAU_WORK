package project.view;
import javax.swing.*;
public class DelWordView extends JPanel {
   JTextField inputWord;  //����Ҫɾ���ĵ���
   JButton submit;        //�ύ��ť    
   JTextField hintMess;
   HandleDelWord  handleDelWord;  //������ɾ������
   DelWordView(){
      initView();
      registerListener() ;
   }
   private void initView() {
      inputWord = new JTextField(12);
      submit = new JButton("ɾ������");
      hintMess = new JTextField(20);
      hintMess.setEditable(false);
      add(new JLabel("����Ҫɾ���ĵ���:"));
      add(inputWord);
      add(submit);
      add(new JLabel("��ʾ:"));
      add(hintMess);
   }
   private void registerListener() {
      handleDelWord = new HandleDelWord();
      handleDelWord.setView(this);
      submit.addActionListener(handleDelWord);
   }
}
