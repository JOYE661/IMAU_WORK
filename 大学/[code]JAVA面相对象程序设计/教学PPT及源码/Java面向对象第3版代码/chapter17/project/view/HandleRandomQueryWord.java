package project.view;
import java.awt.event.*;
import project.data.*;
public class HandleRandomQueryWord implements ActionListener {
   RandomQueryView view ;
   public void actionPerformed(ActionEvent e) {
      view.showWord.setText("");
      String n =view.inputQueryNumber.getText().trim();
      if(n.length()==0)
        return;
      int count = 0;
      try{
         count = Integer.parseInt(n);
      }
      catch(NumberFormatException exp){
         view.showWord.setText("������������");
      }
      RandomQueryWord random = new RandomQueryWord();//��ѯ����
      random.setCount(count); //�����ȡcount������
      Word [] result = random.randomQueryWord();         //ִ�в�ѯ
      for(int i=0;i<result.length;i++){
         int m = i+1;
         view.showWord.append(m+"."+result[i].getEnglishWord());
         view.showWord.append("   "+result[i].getMeaning());
         view.showWord.append("\n");   
      }
   }
   public void setView(RandomQueryView view) {
      this.view = view;
   }
}

