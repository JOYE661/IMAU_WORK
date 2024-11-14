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
       buttonGetNumber = new JButton("得到一个随机数");
       add(buttonGetNumber);
       hintLabel = new JLabel("输入你的猜测：",JLabel.CENTER);
       hintLabel.setBackground(Color.cyan);
       inputGuess = new JTextField("0",10); 
       add(hintLabel);
       add(inputGuess);
       buttonEnter = new JButton("确定"); 
       add(buttonEnter); 
       buttonGetNumber.addActionListener((ActionEvent e)->{
                                            number = (int)(Math.random()*100)+1;
                                            hintLabel.setText("输入你的猜测：");
                                        });  //匿名类的实例做监视器，使用了Lambda表达式
       buttonEnter.addActionListener(this);  //窗口做监视器
       setBounds(100,100,560,120);
       setVisible(true);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
       validate();
    }
    public void actionPerformed(ActionEvent e) {
        int guess = 0;
        try {  guess=Integer.parseInt(inputGuess.getText());
               if(guess==number) {
                   hintLabel.setText("猜对了！");
               }
               else if(guess>number) {
                   hintLabel.setText("猜大了！");
                   inputGuess.setText(null); 
               }
               else if(guess<number) {
                   hintLabel.setText("猜小了！");
                   inputGuess.setText(null); 
               }
        }
        catch(NumberFormatException event) {
               hintLabel.setText("请输入数字字符");
        } 
   } 
}
