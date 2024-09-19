package project.view;
import javax.swing.*;
public class DelWordView extends JPanel {
   JTextField inputWord;  //输入要删除的单词
   JButton submit;        //提交按钮    
   JTextField hintMess;
   HandleDelWord  handleDelWord;  //负责处理删除单词
   DelWordView(){
      initView();
      registerListener() ;
   }
   private void initView() {
      inputWord = new JTextField(12);
      submit = new JButton("删除单词");
      hintMess = new JTextField(20);
      hintMess.setEditable(false);
      add(new JLabel("输入要删除的单词:"));
      add(inputWord);
      add(submit);
      add(new JLabel("提示:"));
      add(hintMess);
   }
   private void registerListener() {
      handleDelWord = new HandleDelWord();
      handleDelWord.setView(this);
      submit.addActionListener(handleDelWord);
   }
}
