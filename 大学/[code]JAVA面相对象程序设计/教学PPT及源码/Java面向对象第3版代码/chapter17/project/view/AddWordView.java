package project.view;
import javax.swing.*;
public class AddWordView extends JPanel {
   JTextField inputWord;     //输入单词
   JTextField inputMeaning;  //输入单词的解释
   JButton submit;           //提交按钮   
   JTextField hintMess; 
   HandleAddWord  handleAddWord;  //负责处理添加单词
   AddWordView() {
      initView();
      registerListener() ;
   }
   private void initView() {
      Box boxH;                 //行式盒
      Box boxVOne,boxVTwo;      //列式盒 
      boxH =Box.createHorizontalBox();
      boxVOne=Box.createVerticalBox();
      boxVTwo=Box.createVerticalBox();
      inputWord = new JTextField(30);
      inputMeaning = new JTextField(30);
      submit = new JButton("添加单词");
      hintMess = new JTextField(20);
      hintMess.setEditable(false);
      boxVOne.add(new JLabel("单词:"));
      boxVOne.add(new JLabel("解释:"));
      boxVOne.add(new JLabel("提交:"));
      boxVOne.add(new JLabel("提示:"));
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
