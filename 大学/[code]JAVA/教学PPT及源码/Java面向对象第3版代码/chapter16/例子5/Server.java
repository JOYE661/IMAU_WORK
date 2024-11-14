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
      try{ System.out.println("等待客户呼叫");
           you=server.accept(); //堵塞状态，除非有客户呼叫
           out=new DataOutputStream(you.getOutputStream());
           in=new DataInputStream(you.getInputStream());
           while(true) {
              char c=in.readChar(); // in读取信息，堵塞状态
              System.out.println("服务器收到:"+c);
              out.writeChar((char)(c-32));
              Thread.sleep(500);
           }
      }
      catch(Exception e) {
          System.out.println("客户已断开"+e);
      }
   }
}
