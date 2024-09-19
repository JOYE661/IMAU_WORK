import java.net.*;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
public class Receive extends JFrame implements Runnable,ActionListener {
   int port;                                        //组播的端口
   InetAddress group=null;                          //组播组的地址
   MulticastSocket socket=null;                     //多点广播套接字 
   JButton 开始接收,停止接收;   
   JTextArea 正在接收内容,已接收的内容;  
   Thread thread;                                   //负责接收信息的线程
   boolean 停止=false;
   public Receive() {
      setTitle("定时接收信息");
      thread=new Thread(this);
      开始接收=new JButton("开始接收");
      停止接收=new JButton("停止接收");
      停止接收.addActionListener(this); 
      开始接收.addActionListener(this); 
      正在接收内容=new JTextArea(10,10);
      已接收的内容=new JTextArea(10,10);
      JPanel north=new JPanel();
      north.add(开始接收);
      north.add(停止接收);
      add(north,BorderLayout.NORTH);
      JPanel center=new JPanel();
      center.setLayout(new GridLayout(1,2)); 
      center.add(new JScrollPane(正在接收内容));
      center.add(new JScrollPane(已接收的内容));
      add(center,BorderLayout.CENTER);
      port=5858;                                 //设置组播组的监听端口
      try{
         group=InetAddress.getByName("239.255.8.0");//设置广播组的地址为239.255.8.0
         socket=new MulticastSocket(port);    //多点广播套接字将在port端口广播
         socket.joinGroup(group); //加入group
      }                          
      catch(Exception e){} 
      setBounds(100,50,360,380);   
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==开始接收) {
        if(!(thread.isAlive()))
           thread=new Thread(this);
        try{  thread.start(); 
              停止=false;        
        }
        catch(Exception ee) {}
      }
      if(e.getSource()==停止接收)
        停止=true; 
   }
   public void run() {
      while(true) {   
        byte data[]=new byte[8192];
        DatagramPacket packet=null;
        packet=new DatagramPacket(data,data.length,group,port); //待接收的数据包
        try { socket.receive(packet);
             String message=new String(packet.getData(),0,packet.getLength());
             正在接收内容.setText("正在接收的内容:\n"+message);
             已接收的内容.append(message+"\n");
        }
        catch(Exception e) {}
        if(停止==true)
           break;
      } 
   }
   public static void main(String args[]) {
      new Receive();
   }
}
