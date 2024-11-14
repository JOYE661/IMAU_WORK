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
      QueryOneWord query = new QueryOneWord();//�����ѯ�Ķ���
      Word result = query.queryOneWord(word);    //ִ�в�ѯ����
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

