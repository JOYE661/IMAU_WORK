package project.view;
import java.awt.event.*;
import project.data.*;
public class HandleDelWord implements ActionListener {
   DelWordView view ;
   public void actionPerformed(ActionEvent e) {
      String englishWord = view.inputWord.getText();
      if(englishWord.length()==0) 
         return;
      Word word = new Word();
      DelWord del = new DelWord();    //负责删除单词的对象
      word.setEnglishWord(englishWord); //删除单词
      int isOK = del.delWord(word);
      if(isOK!=0)
         view.hintMess.setText("删除单词成功");
      else
         view.hintMess.setText("删除失败，单词不在表里");
   }
   public void setView(DelWordView view) {
      this.view = view;
   }
}
