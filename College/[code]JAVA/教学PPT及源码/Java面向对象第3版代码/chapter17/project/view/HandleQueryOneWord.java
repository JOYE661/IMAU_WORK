package project.view;
import java.awt.event.*;
import project.data.*;
public class HandleQueryOneWord implements ActionListener {
   QueryOneWordView view ;
   public void actionPerformed(ActionEvent e) {
      String englishWord = view.inputWord.getText();
      if(englishWord.length()==0) 
         return;
      Word word = new Word();
      word.setEnglishWord(englishWord);
      QueryOneWord query = new QueryOneWord();//负责查询的对象
      Word result = query.queryOneWord(word);    //执行查询操作
      if(result == null) 
          return;
      view.showWord.append(" "+result.getEnglishWord());
      view.showWord.append("   "+result.getMeaning());
      view.showWord.append("\n");   
   }
   public void setView(QueryOneWordView view) {
      this.view = view;
   }
}

