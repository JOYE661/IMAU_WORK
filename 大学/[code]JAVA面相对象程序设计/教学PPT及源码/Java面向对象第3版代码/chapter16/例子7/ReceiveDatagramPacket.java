import java.net.*;
public class ReceiveDatagramPacket implements Runnable {
    javax.swing.JTextArea receiveMess;           //存放收到的信息
    Thread thread;
    public int port;               //接受信息的端口
    public ReceiveDatagramPacket(){
        thread = new Thread(this);
    }
    public void setJTextArea(javax.swing.JTextArea text){
        receiveMess = text;
    }
    public void setPort(int port){
       this.port = port;
    }
    public void receiveMess(){
        thread.start();
    }
    public void run() {
        DatagramPacket pack=null;
        DatagramSocket datagramSocket=null;
        byte  data[]=new byte[8192];
        try{  pack=new DatagramPacket(data,data.length);
              datagramSocket=new DatagramSocket(port);
        }
        catch(Exception e){} 
        if(datagramSocket==null) return;
        while(true) {  
           try{ datagramSocket.receive(pack); 
                String message=new String(pack.getData(),0,pack.getLength());
                receiveMess.append("\n"+message);
                System.out.println(message);
           }
           catch(Exception e){}
        } 
    }
}
