public class Shanghai extends DatagramPacketWindow {
    Shanghai() {
       setTitle("�����Ϻ�");
       sendDataPacket.setIP("127.0.0.1");
       sendDataPacket.setPort(888); 
       receiveDatagramPacket.setPort(666);
       receiveDatagramPacket.receiveMess();  
    }
    public static void main(String args[]) {
       Shanghai shanghai=new Shanghai();
    }
}
