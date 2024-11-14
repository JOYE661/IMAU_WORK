package U11_15;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Demo extends JFrame{

	private static void createGUI() {
		JFrame frame =new JFrame();
		JPanel panel=new JPanel();
		JLabel label=new JLabel();
		JTextField tuser=new JTextField();
		JTextField tpassword=new JTextField();
		panel.setLayout(null);
		//
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Helloworld");
		frame.setSize(600,600);
		frame.setLocation(300,200);
		//frame.setVisible(true);
		//
		//
		
		//
		JButton OK=new JButton("OK");
		JButton cancel=new JButton("cancel");
		JLabel user=new JLabel("user");
		JLabel password=new JLabel("password");
		JTextField tu=new JTextField(10);
		JTextField tp=new JTextField(10);

		//
		user.setBounds(10,20,90,30);
		password.setBounds(10,50,90,30);
		OK.setBounds(10,80,90,30);
		cancel.setBounds(100,80,90,30);
		
		
		panel.add(OK);
		panel.add(cancel);
		panel.add(user);
		panel.add(tu);
		panel.add(password);
		panel.add(tp);
		
		frame.add(panel);
		frame.setVisible(true);
		//frame.setSize(600,600);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(Demo::createGUI);
		//createGUI();
	}

}
