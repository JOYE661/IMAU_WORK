package U11_15;

import java.awt.BorderLayout;

import javax.swing.*;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f=new JFrame("Login");
		JPanel p=new JPanel(new BorderLayout());
		//
		JPanel p1=new JPanel();
		JLabel name=new JLabel("Username:");
		JTextField nameText=new JTextField(10);
		p1.add(name);
		p1.add(nameText);
		//
		JPanel p2=new JPanel();
		JLabel pw=new JLabel("Password:");
		JPasswordField pwText=new JPasswordField(10);
		p2.add(pw);
		p2.add(pwText);
		//
		JPanel p3=new JPanel();
		JButton button1=new JButton("Yes");
		JButton button2=new JButton("Cancel");
		p3.add(button1);
		p3.add(button2);
		//
		p.add(BorderLayout.NORTH,p1);
		p.add(p2);
		p.add(BorderLayout.SOUTH,p3);
		//
		f.add(p);
		f.setSize(300,200);
		f.setVisible(true);
	}

}
