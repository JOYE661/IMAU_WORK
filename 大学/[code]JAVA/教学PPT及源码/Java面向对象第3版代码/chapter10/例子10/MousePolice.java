import java.awt.event.*;
import javax.swing.*;
public class MousePolice implements MouseListener {
    WindowMouse view;
    public void setView(WindowMouse view) {
       this.view = view;
    }
    public void mousePressed(MouseEvent e) {
       if(e.getSource() == view.button&&e.getButton() == MouseEvent.BUTTON1) {
           view.area.append("�ڰ�ť�ϰ���������:\n");
           view.area.append(e.getX()+","+e.getY()+"\n");
       }
       else if(e.getSource() == view&&e.getButton() == MouseEvent.BUTTON1) {
           view.area.append("�ڴ����а���������:\n");
           view.area.append(e.getX()+","+e.getY()+"\n");
       }
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e)  {
       if(e.getSource() instanceof JButton)
           view.area.append("\n�����밴Ŧ,λ��:"+e.getX()+","+e.getY()+"\n");
       if(e.getSource() instanceof JFrame)
           view.area.append("\n�����봰��,λ��:"+e.getX()+","+e.getY()+"\n"); 
    }
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {
       if(e.getClickCount()>=2)
           view.area.setText("�������\n");
   }
}
