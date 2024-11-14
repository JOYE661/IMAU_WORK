package project.view;
import javax.swing.*;
public class AddWordView extends JPanel {
   JTextField inputWord;     //���뵥��
   JTextField inputMeaning;  //���뵥�ʵĽ���
   JButton submit;           //�ύ��ť   
   JTextField hintMess; 
   HandleAddWord  handleAddWord;  //��������ӵ���
   AddWordView() {
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
      inputMeaning = new JTextField(30);
      submit = new JButton("��ӵ���");
      hintMess = new JTextField(20);
      hintMess.setEditable(false);
      boxVOne.add(new JLabel("����:"));
      boxVOne.add(new JLabel("����:"));
      boxVOne.add(new JLabel("�ύ:"));
      boxVOne.add(new JLabel("��ʾ:"));
      boxVTwo.add(inputWord);
      boxVTwo.add(inputMeaning);
      boxVTwo.add(submit);
      boxVTwo.add(hintMess);
      boxH.add(boxVOne);
      boxH.add(Box.createHorizontalStrut(10));
      boxH.add(boxVTwo);
      add(boxH); 
   }
   private void registerListener() {
      handleAddWord = new HandleAddWord();
      handleAddWord.setView(this);
      submit.addActionListener(handleAddWord);
   }
}
