import java.awt.*;
import javax.swing.*;
public class WindowTextView extends JFrame { 
   public JTextArea textInput;  //用户输入文本
   public JTextArea textShow;   //排序显示用户输入的文本中的单词
   HandleWord  handleWord; //负责排序的监视器
   WindowTextView() { 
      init();
      setBounds(120,100,260,270);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
   }
   void init() {
      textInput = new JTextArea(3,15);
      textShow = new JTextArea(3,15);
      setLayout(new FlowLayout());
      add(new JScrollPane(textInput));
      add(new JScrollPane(textShow));
      textInput.setLineWrap(true);
      textShow.setLineWrap(true); 
      textShow.setEditable(false);
      handleWord = new HandleWord();
      handleWord.setView(this);
      (textInput.getDocument()).addDocumentListener(handleWord); //向文档注册监视器
   }
}