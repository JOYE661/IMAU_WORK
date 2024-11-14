package project.view;
import java.awt.*;
import javax.swing.*;
public class RandomQueryView extends JPanel {
   JTextField inputQueryNumber;//输入要查询的单词数目
   JButton submit;            //查询按钮 
   JTextArea showWord;       //显示查询结果
   HandleRandomQueryWord  handleRandomQueryWord;  //负责处理随机查询单词
   RandomQueryView() {
      initView();
      registerListener() ;
   }
   public void initView() {
      setLayout(new BorderLayout());
      JPanel pNorth = new JPanel();
      inputQueryNumber = new JTextField(4);
      showWord = new JTextArea(); 
      showWord.setFont(new Font("宋体",Font.BOLD,20));
      submit = new JButton("查询");
      pNorth.add(new JLabel("输入随机查询的数目:"));
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
