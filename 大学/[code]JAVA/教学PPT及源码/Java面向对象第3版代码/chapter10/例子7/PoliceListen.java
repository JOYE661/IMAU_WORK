import java.awt.event.*;
public class PoliceListen implements ActionListener { 
    WindowNumber view;
    public void setView(WindowNumber view) {
       this.view = view;
    }
    public void actionPerformed(ActionEvent e) {
       int n = 0,m = 0;
       String str=view.textInput.getText();
       if(!str.isEmpty()) {
          try{  
               n=Integer.parseInt(str);
               m=n*n;
               view.textShow.setText(""+m);
          }
          catch(Exception exp) {
               view.textInput.setText("«Î ‰»Î ˝◊÷");
          }
       }
    }
}
