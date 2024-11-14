
import java.awt.event.*;
public class PoliceListen implements ActionListener { 
   public void actionPerformed(ActionEvent e) {
      int n=0,m=0;
      String str=e.getActionCommand();
      try{  n=Integer.parseInt(str);
           m=n*n;
           System.out.println(n+"的平方是:"+m);
      }
      catch(Exception ee) {
          System.out.println(ee.toString());
      }
    }
}