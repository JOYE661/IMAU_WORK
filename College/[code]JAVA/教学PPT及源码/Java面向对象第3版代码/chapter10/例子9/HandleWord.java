import javax.swing.event.*;
import java.util.Arrays;
public class HandleWord implements DocumentListener { 
    WindowTextView view;
    public void setView(WindowTextView view){
        this.view = view;
    }
    public void changedUpdate(DocumentEvent e) { //接口方法
        String str=view.textInput.getText(); 
       //空格、数字和符号(!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~)组成的正则表达式:
        String regex ="[\\s\\d\\p{Punct}]+"; 
        String words[]=str.split(regex); 
        Arrays.sort(words);       //按字典序从小到大排序
        view.textShow.setText(null); 
        for(String s:words)
           view.textShow.append(s+",");
   }
   public void removeUpdate(DocumentEvent e) { //接口方法
       changedUpdate(e);
   }
   public void insertUpdate(DocumentEvent e) { //接口方法
       changedUpdate(e);
   }
}
