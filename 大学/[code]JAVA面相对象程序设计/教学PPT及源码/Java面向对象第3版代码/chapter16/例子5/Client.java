import java.io.*;
import java.net.*;
public class Client {
   public static void main(String args[]) {
      Socket mysocket;
      DataInputStream in=null;
      DataOutputStream out=null;
      try{  mysocket=new Socket("127.0.0.1",4331);
            in=new DataInputStream(mysocket.getInputStream());
            out=new DataOutputStream(mysocket.getOutputStream()); 
            char c='a';
            while(true) {
              if(c>'z')
                 c='a';
              out.writeChar(c);
              char s=in.readChar(); //in读取信息，堵塞状态
              System.out.println("客户收到:"+s);
              c++;
              Thread.sleep(500);
            } 
       }
       catch(Exception e) {
            System.out.println("服务器已断开"+e);
       }
   } 
}
