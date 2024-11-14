package U12_06_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class kucun {
	static ArrayList<users> user=new ArrayList<>();
    static Vector<String> cName=new Vector<>();
    static Vector<Vector<String>> goods=new Vector<Vector<String>>();
    static ArrayList<Product> pro=new ArrayList<>();
	static DefaultTableModel model=new DefaultTableModel(goods,cName);
	static JButton queryBt=new JButton("��ѯ��Ʒ");
	static JButton addBt=new JButton("���Ӳ�Ʒ");
	static JButton exitBt=new JButton("�޸Ĳ�Ʒ");
	static JButton deleteBt=new JButton("ɾ����Ʒ");
	static JTable table;
	public static void main(String[] args) {
		init();
		JFrame frame=new JFrame();
		user.add(new users("admin","123"));
		user.add(new users("1","1"));
		for(Product p : pro) {
			Vector<String> fru=new Vector<>();
			fru.add(p.getId());
			fru.add(p.getName());
			fru.add(p.getPrice());
			goods.add(fru);
		}
		login(frame);
		setframe(frame);

	}
	public static void init() {
		cName.add("���");
		cName.add("����");
		cName.add("����");
		pro.add(new Product("001","����","1.5"));
		pro.add(new Product("002","����","3"));
		pro.add(new Product("003","���","2"));
		
	}
	public static void setframe(JFrame frame) {
		frame.setSize(500,380);
		frame.setLocation(280, 100);
		frame.setVisible(true);
	}
	public static void login(JFrame frame) {		
		JPanel panel=new JPanel(new BorderLayout());
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		JPanel panel3=new JPanel();
		
		JLabel label=new JLabel("�û���:");
		JLabel label1=new JLabel("��    ��:");
		JTextField field=new JTextField(10);
		JPasswordField passwordField=new JPasswordField(10);
		JButton b1=new JButton("��¼");
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//��֤�Ƿ��½�ɹ�
				String na=field.getText();
				String pw=passwordField.getText();
				users inputuser=new users(na, pw);
				boolean flag=true;
				for(users u:user) {
					if(u.info().equals(inputuser.info())) {
						//�ɹ�����תhome���档
						flag=false;
						panel.removeAll();
						panel.updateUI();
						frame.remove(panel);
						home(frame);
					}	
				}
				if(flag) {
					JOptionPane.showConfirmDialog(frame,"�û������������","tip",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		JButton b2=new JButton("ȡ��");	
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
		panel.add(BorderLayout.NORTH,new Label("������ϵͳ"));
		panel.add(BorderLayout.WEST,menu());
		query(panel);
		add();
		delete();
		edit();
		frame.add(panel);
	}
	public static void query(JPanel panel) {
		queryBt.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				table=new JTable(model);
				panel.updateUI();
				panel.add(BorderLayout.CENTER, new JScrollPane(table));
				
			}
		});
		
	}
	public static void add() {
		addBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JDialog dialog=new JDialog();
				JPanel gPanel=new JPanel();
				JLabel idJLabel=new JLabel("���");
				JTextField idfield=new JTextField(10);
				JLabel nameJLabel=new JLabel("����");
				JTextField namefield=new JTextField(10);
				JLabel pJLabel=new JLabel("�۸�");
				JTextField pfield=new JTextField(10);
				JButton okButton=new JButton("ȷ�����");
				JButton canButton=new JButton("ȡ�����");
				okButton.addActionListener(new ActionListener() {		
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Vector<String> fru=new Vector<>();
						fru.add(idfield.getText());
						fru.add(namefield.getText());
						fru.add(pfield.getText());
						model.addRow(fru);
						
					}
				});
				gPanel.add(idJLabel);
				gPanel.add(idfield);
				gPanel.add(nameJLabel);
				gPanel.add(namefield);
				gPanel.add(pJLabel);
				gPanel.add(pfield);
				gPanel.add(okButton);
				gPanel.add(canButton);
				dialog.add(gPanel);
				dialog.setSize(180,200);
				dialog.setVisible(true);
			}
		});
	}
	public static void delete() {
		deleteBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int row=table.getSelectedRow();
				model.removeRow(row);
			}
		});
	}
	public static void edit() {
		exitBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JDialog dialog=new JDialog();
				JPanel gPanel=new JPanel();
				int row=table.getSelectedRow();
				JLabel idJLabel=new JLabel("���");
				JTextField idfield=new JTextField(10);
				idfield.setText((String)table.getValueAt(row, 0));
				JLabel nameJLabel=new JLabel("����");
				JTextField namefield=new JTextField(10);
				namefield.setText((String)table.getValueAt(row, 1));
				JLabel pJLabel=new JLabel("�۸�");
				JTextField pfield=new JTextField(10);
				pfield.setText((String)table.getValueAt(row, 2));
				JButton okButton=new JButton("ȷ���޸�");
				JButton canButton=new JButton("ȡ���޸�");
				okButton.addActionListener(new ActionListener() {		
					@Override
					public void actionPerformed(ActionEvent arg0) {
						Vector<String> fru=new Vector<>();
						fru.add(idfield.getText());
						fru.add(namefield.getText());
						fru.add(pfield.getText());
						model.removeRow(row);
						model.insertRow(row, fru);					
					}
				});
				gPanel.add(idJLabel);
				gPanel.add(idfield);
				gPanel.add(nameJLabel);
				gPanel.add(namefield);
				gPanel.add(pJLabel);
				gPanel.add(pfield);
				gPanel.add(okButton);
				gPanel.add(canButton);
				dialog.add(gPanel);
				dialog.setSize(200,200);
				dialog.setVisible(true);
			}
		});
			
		
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


