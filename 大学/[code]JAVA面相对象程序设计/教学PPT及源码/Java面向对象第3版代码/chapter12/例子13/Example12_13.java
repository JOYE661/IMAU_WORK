import javax.swing.*;
import java.io.*;
import java.awt.*;
public class Example12_13 {
   public static void main(String args[]) {
      byte b[]=new byte[30];
      JTextArea text=new JTextArea(20,20);
      JFrame jframe=new JFrame();
      jframe.setSize(280,300);
      jframe.setVisible(true);
      jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jframe.add(new JScrollPane(text),BorderLayout.CENTER);
      jframe.validate();
      try{ 
         FileInputStream input=new FileInputStream("Example12_13.java");
         ProgressMonitorInputStream input_progress=
         new ProgressMonitorInputStream(null,"��ȡjava�ļ�",input);
         ProgressMonitor p=input_progress.getProgressMonitor();//��ý�����
         int m = -1;
         while( (m=input_progress.read(b))!=-1) {
           String s=new String(b,0,m);
           text.append(s);
           Thread.sleep(200);//�����ļ���С��Ϊ�˿�����������������ӻ�0.2��
         }
      }
      catch(Exception e){}
   }
}
