import java.awt.event.*; 
import java.awt.*;
import javax.swing.*;
public class WindowMess extends JFrame implements ActionListener {
    JTextField inputNumber;
    JTextArea show;
    String regex ;
    WindowMess() {
       regex="-?[0-9][0-9]*[.]?[0-9]*" ;
       inputNumber=new JTextField(22);
       inputNumber.addActionListener(this);
       show=new JTextArea(); 
       add(inputNumber,BorderLayout.NORTH);
       add(show,BorderLayout.CENTER); 
       setBounds(60,60,300,300);       
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public void actionPerformed(ActionEvent e) { 
        String s=inputNumber.getText();
        if(s.length() == 0) return;
        if(!s.matches(regex)) { //���������桱��Ϣ�Ի���
            JOptionPane.showMessageDialog(this,"�������˷Ƿ��ַ�","����Ի���",
                                            JOptionPane.WARNING_MESSAGE);
            inputNumber.setText(null); 
        }  
        else {
            double number=Double.parseDouble(s);
            show.append("\n"+number+"ƽ��:"+(number*number));
        }
   }
}
