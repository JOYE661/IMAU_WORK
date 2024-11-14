import java.awt.event.*;   
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
public class WordPolice implements ActionListener {
   WindowWord view;
   HashMap<String,String> hashtable;
   File file=new File("word.txt");
   Scanner sc=null;
   WordPolice() {
     hashtable=new HashMap<String,String>();
     try{ sc=new Scanner(file);
          while(sc.hasNext()){
             String englishWord=sc.next();
             String chineseWord=sc.next(); 
             hashtable.put(englishWord,chineseWord); 
          }
     }
     catch(Exception e){}  
   }
   public void setView(WindowWord view) {
       this.view = view;
   }
   public void actionPerformed(ActionEvent e) {
      String englishWord=view.inputText.getText();
      if(hashtable.containsKey(englishWord)) {
         String chineseWord=hashtable.get(englishWord);
         view.showText.setText(chineseWord);
      }
      else {
         view.showText.setText("没有此单词");
      }  
   }
}
