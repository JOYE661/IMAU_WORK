import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
public class DatagramPacketWindow extends JFrame {
    JTextField sendMessage=new JTextField(16);
    JTextArea receiveMessage=new JTextArea(); 
    JButton sendButton=new JButton("发送");
    SendDataPacket sendDataPacket;   //负责发送数据包
    ReceiveDatagramPacket receiveDatagramPacket;//负责接受数据包
    DatagramPacketWindow() {
       sendDataPacket = new SendDataPacket();
       receiveDatagramPacket = new ReceiveDatagramPacket();
       receiveDatagramPacket.setJTextArea(receiveMessage);
       setSize(400,200);
       setVisible(true);
       JPanel pSouth=new JPanel();
       pSouth.add(sendMessage);
       pSouth.add(sendButton); 
       add(pSouth,"South");
       add(new JScrollPane(receiveMessage),"Center");
       validate();
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       sendButton.addActionListener((ActionEvent event)->{
                  byte buffer[] = sendMessage.getText().trim().getBytes();
                  sendDataPacket.setMessBySend(buffer); 
                  sendDataPacket.sendMess();});
   }
}
