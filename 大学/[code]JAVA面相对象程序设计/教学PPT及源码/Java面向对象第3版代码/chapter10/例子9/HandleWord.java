import javax.swing.event.*;
import java.util.Arrays;
public class HandleWord implements DocumentListener { 
    WindowTextView view;
    public void setView(WindowTextView view){
        this.view = view;
    }
    public void changedUpdate(DocumentEvent e) { //�ӿڷ���
        String str=view.textInput.getText(); 
       //�ո����ֺͷ���(!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~)��ɵ�������ʽ:
        String regex ="[\\s\\d\\p{Punct}]+"; 
        String words[]=str.split(regex); 
        Arrays.sort(words);       //���ֵ����С��������
        view.textShow.setText(null); 
        for(String s:words)
           view.textShow.append(s+",");
   }
   public void removeUpdate(DocumentEvent e) { //�ӿڷ���
       changedUpdate(e);
   }
   public void insertUpdate(DocumentEvent e) { //�ӿڷ���
       changedUpdate(e);
   }
}
