import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class WindowFile extends JFrame implements ActionListener {
   JFileChooser fileDialog ; //文件对话框
   JMenuBar menubar;
   JMenu menu;
   JMenuItem itemSave,itemOpen;
   JTextArea text;
   WindowFile() {
      init();
      setSize(300,400);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   void init() {
      text=new JTextArea(10,10);
      add(new JScrollPane(text),BorderLayout.CENTER);
      menubar=new JMenuBar();      menu=new JMenu("文件"); 
      itemSave=new JMenuItem("保存文件"); 
      itemOpen=new JMenuItem("打开文件"); 
      itemSave.addActionListener(this); 
      itemOpen.addActionListener(this);
      menu.add(itemSave); 
      menu.add(itemOpen); 
      menubar.add(menu);
      setJMenuBar(menubar);
      fileDialog=new JFileChooser();   }
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==itemSave) {
          int state=fileDialog.showSaveDialog(this);
          if(state==JFileChooser.APPROVE_OPTION) {
              text.append("\n单击了对话框上的\''确定\''按钮");
              text.append("\n保存的文件名字："+fileDialog.getSelectedFile());
          }      
          else {
              text.append("\n单击了对话框上的\"取消\''按钮或关闭图标");
          }
      }
      else if(e.getSource()==itemOpen) {
          int state=fileDialog.showOpenDialog(this);
          if(state==JFileChooser.APPROVE_OPTION) {
              text.append("\n单击了对话框上的\''确定\''按钮");
              text.append("\n打开的文件名字："+fileDialog.getSelectedFile());
          }      
          else {
             text.append("\n单击了对话框上的\"取消\''按钮或关闭图标");
          }
      }
   }
}
