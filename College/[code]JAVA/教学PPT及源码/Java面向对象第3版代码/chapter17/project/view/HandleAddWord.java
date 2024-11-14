package project.view;
import java.awt.event.*;
import project.data.*;
public class HandleAddWord implements ActionListener {
   AddWordView view ;
   public void actionPerformed(ActionEvent e) {
      String englishWord = view.inputWord.getText();
      String meaning = view.inputMeaning.getText();
      if(englishWord.length()==0||meaning.length()==0) 
         return;
      Word word = new Word();
      AddWord addWord = new AddWord(); //负责添加单词的对象
      word.setEnglishWord(englishWord);
      word.setMeaning(meaning);
      int isOK = addWord.insertWord(word);//向数据库中的表添加单词
      if(isOK!=0)
         view.hintMess.setText("添加单词成功");
      else
         view.hintMess.setText("添加单词失败，也许单词已经在表里了"); 
   }
   public void setView(AddWordView view) {
      this.view = view;
   }
}
