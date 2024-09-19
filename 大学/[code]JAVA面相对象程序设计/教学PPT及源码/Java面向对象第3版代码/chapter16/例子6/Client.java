import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
public class Client {
   public static void main(String args[]) {
     new WindowClient();
   }
}
class  WindowClient extends JFrame implements Runnable,ActionListener {
   JButton connection,send;
   JTextField inputText;
   JTextArea showResult;
   Socket socket=null;
   DataInputStream in=null;
   DataOutputStream out=null;
   Thread thread; 
   WindowClient() {
      socket=new Socket();
      connection=new JButton("连接服务器");
      send=new JButton("发送");
      send.setEnabled(false);
      inputText=new JTextField(6);
      showResult=new JTextArea();
      add(connection,BorderLayout.NORTH);
      JPanel pSouth=new JPanel();
      pSouth.add(new JLabel("输入圆的半径:"));
      pSouth.add(inputText);
      pSouth.add(send);
      add(new JScrollPane(showResult),BorderLayout.CENTER);
      add(pSouth,BorderLayout.SOUTH);
      connection.addActionListener(this);
      send.addActionListener(this);
      thread=new Thread(this); 
      setBounds(10,30,460,400);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==connection) {
        try { //请求和服务器建立套接字连接：
           if(socket.isConnected()){}
           else{
              InetAddress  address=InetAddress.getByName("127.0.0.1");
              InetSocketAddress socketAddress=new InetSocketAddress(address,4331);
              socket.connect(socketAddress); 
              in =new DataInputStream(socket.getInputStream());
              out = new DataOutputStream(socket.getOutputStream());
              send.setEnabled(true);
              if(!(thread.isAlive()))
                 thread=new Thread(this);
              thread.start();
           }
        } 
        catch (IOException ee) {
           System.out.println(ee);
           socket=new Socket();
        }
      }
      if(e.getSource()==send) {
         String s=inputText.getText();
         double r=Double.parseDouble(s);
         try { out.writeDouble(r);
         }
         catch(IOException e1){} 
      }
   }
   public void run() {
      String s=null;
      double result=0;
      while(true) {
        try{ s=in.readUTF();
             showResult.append("\n"+s);
        }
        catch(IOException e) { 
             showResult.setText("与服务器已断开"+e);
             socket=new Socket();
             break;
        }   
      }
   }
}
