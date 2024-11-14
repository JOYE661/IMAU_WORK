import java.awt.event.*;
public class OperatorListener implements ItemListener {
     WindowView view;
     public void setView(WindowView view) {
         this.view = view;
     }
     public void itemStateChanged(ItemEvent e)  {
         String fuhao = view.choiceFuhao.getSelectedItem().toString();
         view.computer.setFuhao(fuhao);
     }
}