import java.net.*;
public class BroadCast extends Thread { 
   String s="����Ԥ��,����¶�32��,����¶�25��"; 
   int port=5858;                                    //�鲥�Ķ˿� 
   InetAddress group=null;                          //�鲥��ĵ�ַ
   MulticastSocket socket=null;                     //���㲥�׽���  
   BroadCast() { 
      try { 
         group=InetAddress.getByName("239.255.8.0");//���ù㲥��ĵ�ַΪ239.255.8.0
         socket=new MulticastSocket(port);         //���㲥�׽��ֽ���port�˿ڹ㲥
         socket.setTimeToLive(1); //���㲥�׽��ַ������ݱ���ΧΪ��������
         socket.joinGroup(group); //����group��,socket���͵����ݱ���group�еĳ�Ա���յ�
      }                                 
      catch(Exception e) {
         System.out.println("Error: "+ e);          
      }
   }
   public void run() {
      while(true) {
        try{  DatagramPacket packet=null;        //���㲥�����ݰ�
               byte data[]=s.getBytes(); 
               packet=new DatagramPacket(data,data.length,group,port); 
               System.out.println(new String(data)); 
               socket.send(packet);             //�㲥���ݰ�
               sleep(2000);
        }
        catch(Exception e) {
               System.out.println("Error: "+ e);          
        }
      }
   }
   public static void main(String args[]) {
      new BroadCast().start();
   }
}
