package U11_29_1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class kucun {
	static ArrayList<users> user=new ArrayList<>();
	static String [] label= {"编号","产品","单价"};
    static String [][] content= {{"001","土豆","1.5"},{"002","番茄","3"}};
	static DefaultTableModel model=new DefaultTableModel(content,label);
	static JButton queryBt=new JButton("查询产品");
	static JButton addBt=new JButton("增加产品");
	static JButton exitBt=new JButton("修改产品");
	static JButton deleteBt=new JButton("删除产品");
	public static void main(String[] args) {
		
		JFrame frame=new JFrame();
		user.add(new users("admin","123"));
		user.add(new users("123","123"));
		login(frame);
		setframe(frame);

	}
	public static void setframe(JFrame frame) {
		frame.setSize(500,380);
		frame.setVisible(true);
	}
	public static void login(JFrame frame) {		
		JPanel panel=new JPanel(new BorderLayout());
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		JPanel panel3=new JPanel();
		
		JLabel label=new JLabel("用户名:");
		JLabel label1=new JLabel("密    码:");
		JTextField field=new JTextField(10);
		JPasswordField passwordField=new JPasswordField(10);
		JButton b1=new JButton("登录");
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//验证是否登陆成功
				String na=field.getText();
				String pw=passwordField.getText();
				users inputuser=new users(na, pw);
				boolean flag=true;
				for(users u:user) {
					if(u.info().equals(inputuser.info())) {
						//成功，跳转home界面。
						flag=false;
						panel.removeAll();
						panel.updateUI();
						frame.remove(panel);
						home(frame);
					}	
				}
				if(flag) {
					JOptionPane.showConfirmDialog(frame,"用户名或密码错误","tip",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		JButton b2=new JButton("取消");	
		panel1.add(label);
		panel1.add(field);
		panel2.add(label1);
		panel2.add(passwordField);
		panel3.add(b1);
		panel3.add(b2);
		panel.add(panel1,BorderLayout.NORTH);
		panel.add(panel2);
		panel.add(panel3,BorderLayout.SOUTH);
		frame.add(panel);
	}
	public static void home(JFrame frame) {
		JPanel panel=new JPanel(new BorderLayout(5,5));
		panel.add(BorderLayout.NORTH,new Label("库存管理系统"));
		panel.add(BorderLayout.WEST,menu());
		queryBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JTable table=new JTable(model);
				panel.updateUI();
				panel.add(BorderLayout.CENTER, new JScrollPane(table));
				
			}
		});
		frame.add(panel);
	}
	public static Box menu() {
		Box box=Box.createVerticalBox();
		
		box.add(queryBt);
		box.add(addBt);
		box.add(exitBt);
		box.add(deleteBt);
		return box;		
	}
		
}


