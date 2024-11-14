public class Beijing extends DatagramPacketWindow {
    Beijing() {
       setTitle("我是北京");
       sendDataPacket.setIP("127.0.0.1");
       sendDataPacket.setPort(666); 
       receiveDatagramPacket.setPort(888);
       receiveDatagramPacket.receiveMess();
    }
    public static void main(String args[]) {
       Beijing beijing=new Beijing();
    }
}