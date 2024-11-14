import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class WindowFile extends JFrame implements ActionListener {
   JFileChooser fileDialog ; //�ļ��Ի���
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
      menubar=new JMenuBar();      menu=new JMenu("�ļ�"); 
      itemSave=new JMenuItem("�����ļ�"); 
      itemOpen=new JMenuItem("���ļ�"); 
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
              text.append("\n�����˶Ի����ϵ�\''ȷ��\''��ť");
              text.append("\n������ļ����֣�"+fileDialog.getSelectedFile());
          }      
          else {
              text.append("\n�����˶Ի����ϵ�\"ȡ��\''��ť��ر�ͼ��");
          }
      }
      else if(e.getSource()==itemOpen) {
          int state=fileDialog.showOpenDialog(this);
          if(state==JFileChooser.APPROVE_OPTION) {
              text.append("\n�����˶Ի����ϵ�\''ȷ��\''��ť");
              text.append("\n�򿪵��ļ����֣�"+fileDialog.getSelectedFile());
          }      
          else {
             text.append("\n�����˶Ի����ϵ�\"ȡ��\''��ť��ر�ͼ��");
          }
      }
   }
}
