import java.io.*;
import java.net.*;
public class Server {
   public static void main(String args[]) {
      ServerSocket server=null;
      Socket you=null;
      DataOutputStream out=null;
      DataInputStream  in=null;
      try { server=new ServerSocket(4331);
      }
      catch(IOException e1) {
            System.out.println(e1);
      } 
      try{ System.out.println("�ȴ��ͻ�����");
           you=server.accept(); //����״̬�������пͻ�����
           out=new DataOutputStream(you.getOutputStream());
           in=new DataInputStream(you.getInputStream());
           while(true) {
              char c=in.readChar(); // in��ȡ��Ϣ������״̬
              System.out.println("�������յ�:"+c);
              out.writeChar((char)(c-32));
              Thread.sleep(500);
           }
      }
      catch(Exception e) {
          System.out.println("�ͻ��ѶϿ�"+e);
      }
   }
}
