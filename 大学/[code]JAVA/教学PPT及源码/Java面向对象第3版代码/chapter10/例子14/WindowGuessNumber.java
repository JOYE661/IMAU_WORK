import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class WindowGuessNumber extends JFrame implements ActionListener {
    int number;
    JLabel hintLabel;
    JTextField inputGuess;
    JButton buttonGetNumber,buttonEnter;
    WindowGuessNumber() {
       setLayout(new FlowLayout());
       buttonGetNumber = new JButton("�õ�һ�������");
       add(buttonGetNumber);
       hintLabel = new JLabel("������Ĳ²⣺",JLabel.CENTER);
       hintLabel.setBackground(Color.cyan);
       inputGuess = new JTextField("0",10); 
       add(hintLabel);
       add(inputGuess);
       buttonEnter = new JButton("ȷ��"); 
       add(buttonEnter); 
       buttonGetNumber.addActionListener((ActionEvent e)->{
                                            number = (int)(Math.random()*100)+1;
                                            hintLabel.setText("������Ĳ²⣺");
                                        });  //�������ʵ������������ʹ����Lambda���ʽ
       buttonEnter.addActionListener(this);  //������������
       setBounds(100,100,560,120);
       setVisible(true);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
       validate();
    }
    public void actionPerformed(ActionEvent e) {
        int guess = 0;
        try {  guess=Integer.parseInt(inputGuess.getText());
               if(guess==number) {
                   hintLabel.setText("�¶��ˣ�");
               }
               else if(guess>number) {
                   hintLabel.setText("�´��ˣ�");
                   inputGuess.setText(null); 
               }
               else if(guess<number) {
                   hintLabel.setText("��С�ˣ�");
                   inputGuess.setText(null); 
               }
        }
        catch(NumberFormatException event) {
               hintLabel.setText("�����������ַ�");
        } 
   } 
}
