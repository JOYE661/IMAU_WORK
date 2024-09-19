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
      DelWord del = new DelWord();    //����ɾ�����ʵĶ���
      word.setEnglishWord(englishWord); //ɾ������
      int isOK = del.delWord(word);
      if(isOK!=0)
         view.hintMess.setText("ɾ�����ʳɹ�");
      else
         view.hintMess.setText("ɾ��ʧ�ܣ����ʲ��ڱ���");
   }
   public void setView(DelWordView view) {
      this.view = view;
   }
}
