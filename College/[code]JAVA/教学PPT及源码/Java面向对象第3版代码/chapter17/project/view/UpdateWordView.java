package project.view;
import javax.swing.*;
public class UpdateWordView extends JPanel {
   JTextField inputWord;        //����Ҫ���µĵ���
   JTextField inputNewMeaning;  //���뵥�ʵ��½���
   JButton lookWord;            //�ύ�鿴
   JButton submit;              //�ύ���°�ť 
   JTextField hintMess;    
   HandleUpdateWord  handleUpdateWord;  //��������µ���
   UpdateWordView() {
      initView();
      registerListener() ;
   }
   private void initView() {
      Box boxH;                 //��ʽ��
      Box boxVOne,boxVTwo;      //��ʽ�� 
      boxH =Box.createHorizontalBox();
      boxVOne=Box.createVerticalBox();
      boxVTwo=Box.createVerticalBox();
      inputWord = new JTextField(30);
      inputNewMeaning = new JTextField(30);
      submit = new JButton("�ύ�µĽ���");
      lookWord = new JButton("�鿴ԭ�н���");
      hintMess = new JTextField(20);
      hintMess.setEditable(false);
      boxVOne.add(new JLabel("���뵥��:"));
      boxVOne.add(new JLabel("�鿴�ɵĽ���:"));
      boxVOne.add(new JLabel("�����µĽ���:"));
      boxVOne.add(new JLabel("�ύ�µĽ���:"));
      boxVOne.add(new JLabel("��ʾ��Ϣ:"));
      boxVTwo.add(inputWord);
      boxVTwo.add(lookWord);
      boxVTwo.add(inputNewMeaning);
      boxVTwo.add(submit);
      boxVTwo.add(hintMess);
      boxH.add(boxVOne);
      boxH.add(Box.createHorizontalStrut(10));
      boxH.add(boxVTwo);
      add(boxH); 
   }
   private void registerListener() {
      handleUpdateWord = new HandleUpdateWord();
      handleUpdateWord.setView(this);
      submit.addActionListener(handleUpdateWord);
      lookWord.addActionListener(handleUpdateWord);
   }
}
