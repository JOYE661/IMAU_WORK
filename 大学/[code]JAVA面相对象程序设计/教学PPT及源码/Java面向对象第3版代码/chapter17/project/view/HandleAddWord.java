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
      AddWord addWord = new AddWord(); //������ӵ��ʵĶ���
      word.setEnglishWord(englishWord);
      word.setMeaning(meaning);
      int isOK = addWord.insertWord(word);//�����ݿ��еı���ӵ���
      if(isOK!=0)
         view.hintMess.setText("��ӵ��ʳɹ�");
      else
         view.hintMess.setText("��ӵ���ʧ�ܣ�Ҳ�����Ѿ��ڱ�����"); 
   }
   public void setView(AddWordView view) {
      this.view = view;
   }
}
