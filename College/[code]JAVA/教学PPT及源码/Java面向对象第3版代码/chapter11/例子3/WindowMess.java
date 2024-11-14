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
        if(!s.matches(regex)) { //弹出“警告”消息对话框。
            JOptionPane.showMessageDialog(this,"您输入了非法字符","警告对话框",
                                            JOptionPane.WARNING_MESSAGE);
            inputNumber.setText(null); 
        }  
        else {
            double number=Double.parseDouble(s);
            show.append("\n"+number+"平方:"+(number*number));
        }
   }
}
