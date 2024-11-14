import java.awt.event.*;
import javax.swing.*;
public class MousePolice implements MouseListener {
    WindowMouse view;
    public void setView(WindowMouse view) {
       this.view = view;
    }
    public void mousePressed(MouseEvent e) {
       if(e.getSource() == view.button&&e.getButton() == MouseEvent.BUTTON1) {
           view.area.append("在按钮上按下鼠标左键:\n");
           view.area.append(e.getX()+","+e.getY()+"\n");
       }
       else if(e.getSource() == view&&e.getButton() == MouseEvent.BUTTON1) {
           view.area.append("在窗体中按下鼠标左键:\n");
           view.area.append(e.getX()+","+e.getY()+"\n");
       }
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e)  {
       if(e.getSource() instanceof JButton)
           view.area.append("\n鼠标进入按纽,位置:"+e.getX()+","+e.getY()+"\n");
       if(e.getSource() instanceof JFrame)
           view.area.append("\n鼠标进入窗口,位置:"+e.getX()+","+e.getY()+"\n"); 
    }
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {
       if(e.getClickCount()>=2)
           view.area.setText("鼠标连击\n");
   }
}
