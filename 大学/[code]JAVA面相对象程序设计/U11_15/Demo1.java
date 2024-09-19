package U11_15;

import java.awt.BorderLayout;
import javax.swing.*;

public class Demo1 extends JFrame{

	public static void main(String[] args){
		// TODO Auto-generated method stub
		JFrame frame =new JFrame();
		JPanel panel=new JPanel(new BorderLayout());
		//
		JPanel panel1 =new JPanel();
		JPanel panel2 =new JPanel();
		JPanel panel3 =new JPanel();
		//
		JLabel label=new JLabel("用户名:");
		JLabel label1=new JLabel("密码：");
		JTextField field=new JTextField(10);
		JTextField passwordField=new JPasswordField(10);
		JButton b1=new JButton("确定");
		JButton b2=new JButton("取消");
		
		panel1.add(label);
		panel1.add(field); 
		panel2.add(label1);
		panel2.add(passwordField);
		panel3.add(b1); 
		panel3.add(b2);
		
		panel.add(panel1, BorderLayout.NORTH);
		panel.add(panel2);
		panel.add(panel3, BorderLayout.SOUTH);
		frame.add(panel);
		frame.setSize (500,500);
		frame.setVisible(true);
		
	}

}
