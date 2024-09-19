import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
public class DatagramPacketWindow extends JFrame {
    JTextField sendMessage=new JTextField(16);
    JTextArea receiveMessage=new JTextArea(); 
    JButton sendButton=new JButton("����");
    SendDataPacket sendDataPacket;   //���������ݰ�
    ReceiveDatagramPacket receiveDatagramPacket;//����������ݰ�
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
