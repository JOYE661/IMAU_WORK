package U11_15;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Task_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame();
		frame.setLayout(new BorderLayout(5,5));
		frame.setFont(new Font("Helvetica",Font.PLAIN,14));
		frame.getContentPane().add("North",new JButton(BorderLayout.NORTH));
		frame.getContentPane().add("South",new JButton(BorderLayout.SOUTH));
		frame.getContentPane().add("East",new JButton(BorderLayout.EAST));
		frame.getContentPane().add("West",new JButton(BorderLayout.WEST));
		frame.getContentPane().add("Center",new JButton(BorderLayout.CENTER));
		frame.setSize(300,260);
		frame.setVisible(true);
	}

}
