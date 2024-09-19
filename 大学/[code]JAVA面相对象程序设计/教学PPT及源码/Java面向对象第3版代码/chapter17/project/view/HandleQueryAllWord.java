package project.view;
import java.awt.event.*;
import project.data.*;
public class HandleQueryAllWord implements ActionListener {
   QueryAllWordView view ;
   public void actionPerformed(ActionEvent e) {
      view.showWord.setText("");
      QueryAllWord query = new QueryAllWord();//查询对象
      Word [] result =query.queryAllWord();     //执行查询
      for(int i=0;i<result.length;i++){
         int m = i+1;
         view.showWord.append(m+"."+result[i].getEnglishWord());
         view.showWord.append("   "+result[i].getMeaning());
         view.showWord.append("\n");   
      }
   }
   public void setView(QueryAllWordView view) {
      this.view = view;
   }
}
