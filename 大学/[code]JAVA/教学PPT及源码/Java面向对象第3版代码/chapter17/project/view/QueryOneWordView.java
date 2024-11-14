package project.view;
import javax.swing.*;
import java.awt.*;
public class QueryOneWordView extends JPanel {
   JTextField inputWord;   //输入要查询的单词
   JButton submit;        //提交按钮    
   JTextArea showWord;  //显示查询结果
   HandleQueryOneWord  handleQueryOneWord; //负责处理查询单词
   QueryOneWordView(){
      initView();
      registerListener() ;
   }
   private void initView() {
      setLayout(new BorderLayout());
      JPanel pNorth = new JPanel();
      inputWord = new JTextField(12);
      submit = new JButton("查询单词");
      showWord = new JTextArea();
      showWord.setFont(new Font("宋体",Font.BOLD,20));
      pNorth.add(new JLabel("输入要查询的单词:"));
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
