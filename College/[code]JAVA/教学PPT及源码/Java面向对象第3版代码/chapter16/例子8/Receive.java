import java.net.*;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
public class Receive extends JFrame implements Runnable,ActionListener {
   int port;                                        //�鲥�Ķ˿�
   InetAddress group=null;                          //�鲥��ĵ�ַ
   MulticastSocket socket=null;                     //���㲥�׽��� 
   JButton ��ʼ����,ֹͣ����;   
   JTextArea ���ڽ�������,�ѽ��յ�����;  
   Thread thread;                                   //���������Ϣ���߳�
   boolean ֹͣ=false;
   public Receive() {
      setTitle("��ʱ������Ϣ");
      thread=new Thread(this);
      ��ʼ����=new JButton("��ʼ����");
      ֹͣ����=new JButton("ֹͣ����");
      ֹͣ����.addActionListener(this); 
      ��ʼ����.addActionListener(this); 
      ���ڽ�������=new JTextArea(10,10);
      �ѽ��յ�����=new JTextArea(10,10);
      JPanel north=new JPanel();
      north.add(��ʼ����);
      north.add(ֹͣ����);
      add(north,BorderLayout.NORTH);
      JPanel center=new JPanel();
      center.setLayout(new GridLayout(1,2)); 
      center.add(new JScrollPane(���ڽ�������));
      center.add(new JScrollPane(�ѽ��յ�����));
      add(center,BorderLayout.CENTER);
      port=5858;                                 //�����鲥��ļ����˿�
      try{
         group=InetAddress.getByName("239.255.8.0");//���ù㲥��ĵ�ַΪ239.255.8.0
         socket=new MulticastSocket(port);    //���㲥�׽��ֽ���port�˿ڹ㲥
         socket.joinGroup(group); //����group
      }                          
      catch(Exception e){} 
      setBounds(100,50,360,380);   
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==��ʼ����) {
        if(!(thread.isAlive()))
           thread=new Thread(this);
        try{  thread.start(); 
              ֹͣ=false;        
        }
        catch(Exception ee) {}
      }
      if(e.getSource()==ֹͣ����)
        ֹͣ=true; 
   }
   public void run() {
      while(true) {   
        byte data[]=new byte[8192];
        DatagramPacket packet=null;
        packet=new DatagramPacket(data,data.length,group,port); //�����յ����ݰ�
        try { socket.receive(packet);
             String message=new String(packet.getData(),0,packet.getLength());
             ���ڽ�������.setText("���ڽ��յ�����:\n"+message);
             �ѽ��յ�����.append(message+"\n");
        }
        catch(Exception e) {}
        if(ֹͣ==true)
           break;
      } 
   }
   public static void main(String args[]) {
      new Receive();
   }
}
