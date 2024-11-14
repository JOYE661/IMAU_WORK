import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import static javax.swing.JFrame.*;
public class WindowMenu extends JFrame {  
   JMenuBar menubar;
    JMenu menu,subMenu;
    JMenuItem  item1,item2;
    public WindowMenu(){} 
    public WindowMenu(String s,int x,int y,int w,int h) {
       init(s);
       setLocation(x,y);
       setSize(w,h);
       setVisible(true);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
    }
    void init(String s){
       setTitle(s);        
       menubar=new JMenuBar(); 
       menu=new JMenu("菜单"); 
       subMenu=new JMenu("子菜单");  
       item1=new JMenuItem("菜单项1",new ImageIcon("a.gif"));
       item2=new JMenuItem("菜单项2",new ImageIcon("b.gif"));
       item1.setAccelerator(KeyStroke.getKeyStroke('A')); 
       item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));         
       menu.add(item1);      
       menu.addSeparator();
       menu.add(item2);           
       menu.add(subMenu);  
       subMenu.add(new JMenuItem("子菜单里的菜单项",new ImageIcon("c.gif")));  
       menubar.add(menu);         
       setJMenuBar(menubar);
    } 
}
