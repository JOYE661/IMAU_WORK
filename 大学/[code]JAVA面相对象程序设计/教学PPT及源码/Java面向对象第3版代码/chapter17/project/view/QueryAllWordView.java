package project.view;
import java.awt.*;
import javax.swing.*;
public class QueryAllWordView extends JPanel {
   JButton submit;       //查询按钮 
   JTextArea showWord;  //显示查询结果
   HandleQueryAllWord handleQueryAllWord;//负责处理查询全部单词
   QueryAllWordView() {
      initView();
      registerListener() ;
   }
   public void initView() {
      setLayout(new BorderLayout());
      submit = new JButton("查询全部单词"); 
      add(submit,BorderLayout.NORTH);
      showWord = new JTextArea();
      showWord.setFont(new Font("宋体",Font.BOLD,20));
      add(new JScrollPane(showWord),BorderLayout.CENTER);
   } 
   private void registerListener() {
      handleQueryAllWord = new HandleQueryAllWord();
      handleQueryAllWord.setView(this);
      submit.addActionListener(handleQueryAllWord);
   }
}
