package U12_06;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import U12_06_1.users;



public class Task_1 {
	//static String[][] content= {{"001","苹果","3"},{"002","橙子","6"},{"003","香蕉","9"}};
	//static String[][] colName= {"编号","名称","单价"};
	static ArrayList<users> user=new ArrayList<>();
	static Vector<String> cName=new Vector<String>();
	static Vector<Vector<String>> goods=new Vector<Vector<String>>();
	
	static ArrayList<Fruit> fruits=new ArrayList<Fruit>();
	static JPanel panel=new JPanel(new BorderLayout());
	static JTable table;
	static DefaultTableModel model;
	
	public static void init() {
		cName.add("编号");
		cName.add("名称");
		cName.add("单价");
		fruits.add(new Fruit("001","苹果","6"));
		fruits.add(new Fruit("001","橙子","0"));
		fruits.add(new Fruit("001","香蕉","7"));
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		user.add(new users("admin","123"));
		user.add(new users("1","1"));
		
		init();
		JFrame frame=new JFrame();
		login(frame);
		//show(frame);
		//frame.add(new JScrollPane(table));
		
		frame.setSize(300,200);
		frame.setVisible(true);
		//frame.setSize(500,380);
		//frame.setLocation(280, 100);
		//frame.setVisible(true);
		
		
	}
	public static void show(JFrame frame) {
		
		//JPanel panel=new JPanel(new BorderLayout());
		JPanel fPanel=new JPanel();
		JButton querybtButton=new JButton("查询");
		querybtButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//查询
				for(Fruit f: fruits) {
					Vector<String> fru=new Vector<String>();
					fru.add(f.getIdString());
					fru.add(f.getNameString());
					fru.add(f.getPriceString());
					goods.add(fru);
				}
				model=new DefaultTableModel(goods, cName);
				table=new JTable(model);
				panel.updateUI();
				panel.add(BorderLayout.CENTER,new JScrollPane(table));
			}
		});
		
		JButton addBtButton=new JButton("添加");
		addBtButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialog dialog=new JDialog();
				
				JPanel gPanel=new JPanel(new GridLayout(4,2));
				JLabel idJLabel=new JLabel("编号");
				JTextField idField=new JTextField();
				JLabel nameJLabel=new JLabel("名称");
				JTextField nameField=new JTextField();
				JLabel pJLabel=new JLabel("价格");
				JTextField pField=new JTextField();
				
				JButton okButton=new JButton("确定添加");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Vector<String> fru=new Vector<String>();
						fru.add(idField.getText());
						fru.add(nameField.getText());
						fru.add(pField.getText());
						model.addRow(fru);
						
					}
				});
				JButton canButton=new JButton("取消添加");
				gPanel.add(idJLabel);
				gPanel.add(idField);
				gPanel.add(nameJLabel);
				gPanel.add(nameField);
				gPanel.add(pJLabel);
				gPanel.add(pField);
				gPanel.add(okButton);
				gPanel.add(canButton);
				dialog.add(gPanel);
				
				
				dialog.setSize(200,200);
				dialog.setVisible(true);
				
			}
		});
		
		JButton delButton=new JButton("删除");
		delete(delButton);
		
		JButton editButton=new JButton("修改");
		edit(editButton);
		
		fPanel.add(querybtButton);
		fPanel.add(addBtButton);
		fPanel.add(delButton);
		fPanel.add(editButton);
		panel.add(BorderLayout.NORTH,fPanel);
		
		frame.add(panel);
		
		
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
						show(frame);
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
	public static void edit(JButton editButton) {
		editButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialog dialog=new JDialog();
				
				JPanel gPanel=new JPanel(new GridLayout(4,2));
				
				int row=table.getSelectedRow();
				
				JLabel idJLabel=new JLabel("编号");
				JTextField idField=new JTextField();
				
				idField.setText((String)table.getValueAt(row, 0));
				
				JLabel nameJLabel=new JLabel("名称");
				JTextField nameField=new JTextField();
				
				nameField.setText((String)table.getValueAt(row, 1));
				
				JLabel pJLabel=new JLabel("价格");
				JTextField pField=new JTextField();
				
				pField.setText((String)table.getValueAt(row, 2));
				
				JButton okButton=new JButton("确定修改");

				
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Vector<String> fru=new Vector<String>();
						fru.add(idField.getText());
						fru.add(nameField.getText());
						fru.add(pField.getText());
						model.removeRow(row);
						model.insertRow(row, fru);
						
					}
				});
				JButton canButton=new JButton("取消修改");
				gPanel.add(idJLabel);
				gPanel.add(idField);
				gPanel.add(nameJLabel);
				gPanel.add(nameField);
				gPanel.add(pJLabel);
				gPanel.add(pField);
				gPanel.add(okButton);
				gPanel.add(canButton);
				dialog.add(gPanel);
				
				
				dialog.setSize(200,200);
				dialog.setVisible(true);
			}
		});
		
	}
	public static void delete(JButton delButton) {
		delButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=table.getSelectedRow();
				model.removeRow(row);
			}
		});
	}
}
