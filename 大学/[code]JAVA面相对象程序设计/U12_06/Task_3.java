//package U12_06;
//
//import java.awt.BorderLayout;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.Vector;
//
//import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.table.DefaultTableModel;
//
//
//
//public class Task_3 {
//	//static String[][] content= {{"001","ƻ��","3"},{"002","����","6"},{"003","�㽶","9"}};
//	//static String[][] colName= {"���","����","����"};
//	
//	static Vector<String> cName=new Vector<String>();
//	static Vector<Vector<String>> goods=new Vector<Vector<String>>();
//	
//	static ArrayList<Fruit> fruits=new ArrayList<Fruit>();
//	static JPanel panel=new JPanel(new BorderLayout());
//	static JTable table;
//	static DefaultTableModel model;
//	
//	public static void init() {
//		cName.add("���");
//		cName.add("����");
//		cName.add("����");
//		fruits.add(new Fruit("001","ƻ��","6"));
//		fruits.add(new Fruit("001","����","0"));
//		fruits.add(new Fruit("001","�㽶","7"));
//	}
//	
//	
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		init();
//		JFrame frame=new JFrame();
//		show(frame);
//		//frame.add(new JScrollPane(table));
//		frame.setSize(300,200);
//		frame.setVisible(true);
//		
//		
//	}
//	public static void show(JFrame frame) {
//		
//		//JPanel panel=new JPanel(new BorderLayout());
//		JPanel fPanel=new JPanel();
//		JButton querybtButton=new JButton("��ѯ");
//		querybtButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				//��ѯ
//				for(Fruit f: fruits) {
//					Vector<String> fru=new Vector<String>();
//					fru.add(f.getIdString());
//					fru.add(f.getNameString());
//					fru.add(f.getPriceString());
//					goods.add(fru);
//				}
//				model=new DefaultTableModel(goods, cName);
//				table=new JTable(model);
//				panel.updateUI();
//				panel.add(BorderLayout.CENTER,new JScrollPane(table));
//			}
//		});
//		
//		JButton addBtButton=new JButton("���");
//		addBtButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				JDialog dialog=new JDialog();
//				
//				JPanel gPanel=new JPanel(new GridLayout(4,2));
//				JLabel idJLabel=new JLabel("���");
//				JTextField idField=new JTextField();
//				JLabel nameJLabel=new JLabel("����");
//				JTextField nameField=new JTextField();
//				JLabel pJLabel=new JLabel("�۸�");
//				JTextField pField=new JTextField();
//				
//				JButton okButton=new JButton("ȷ�����");
//				okButton.addActionListener(new ActionListener() {
//					
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						// TODO Auto-generated method stub
//						Vector<String> fru=new Vector<String>();
//						fru.add(idField.getText());
//						fru.add(nameField.getText());
//						fru.add(pField.getText());
//						model.addRow(fru);
//						
//					}
//				});
//				JButton canButton=new JButton("ȡ�����");
//				gPanel.add(idJLabel);
//				gPanel.add(idField);
//				gPanel.add(nameJLabel);
//				gPanel.add(nameField);
//				gPanel.add(pJLabel);
//				gPanel.add(pField);
//				gPanel.add(okButton);
//				gPanel.add(canButton);
//				dialog.add(gPanel);
//				
//				
//				dialog.setSize(200,200);
//				dialog.setVisible(true);
//				
//			}
//		});
//		
//		JButton delButton=new JButton("ɾ��");
//		delete(delButton);
//		
//		JButton editButton=new JButton("�޸�");
//		edit(editButton);
//		
//		fPanel.add(querybtButton);
//		fPanel.add(addBtButton);
//		fPanel.add(delButton);
//		fPanel.add(editButton);
//		panel.add(BorderLayout.NORTH,fPanel);
//		
//		frame.add(panel);
//		
//		
//	}
//	public static void edit(JButton editButton) {
//		editButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				JDialog dialog=new JDialog();
//				
//				JPanel gPanel=new JPanel(new GridLayout(4,2));
//				
//				int row=table.getSelectedRow();
//				
//				JLabel idJLabel=new JLabel("���");
//				JTextField idField=new JTextField();
//				
//				idField.setText((String)table.getValueAt(row, 0));
//				
//				JLabel nameJLabel=new JLabel("����");
//				JTextField nameField=new JTextField();
//				
//				nameField.setText((String)table.getValueAt(row, 1));
//				
//				JLabel pJLabel=new JLabel("�۸�");
//				JTextField pField=new JTextField();
//				
//				pField.setText((String)table.getValueAt(row, 2));
//				
//				JButton okButton=new JButton("ȷ���޸�");
//
//				
//				okButton.addActionListener(new ActionListener() {
//					
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						// TODO Auto-generated method stub
//						Vector<String> fru=new Vector<String>();
//						fru.add(idField.getText());
//						fru.add(nameField.getText());
//						fru.add(pField.getText());
//						model.removeRow(row);
//						model.insertRow(row, fru);
//						
//					}
//				});
//				JButton canButton=new JButton("ȡ���޸�");
//				gPanel.add(idJLabel);
//				gPanel.add(idField);
//				gPanel.add(nameJLabel);
//				gPanel.add(nameField);
//				gPanel.add(pJLabel);
//				gPanel.add(pField);
//				gPanel.add(okButton);
//				gPanel.add(canButton);
//				dialog.add(gPanel);
//				
//				
//				dialog.setSize(200,200);
//				dialog.setVisible(true);
//			}
//		});
//		
//	}
//	public static void delete(JButton delButton) {
//		delButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				int row=table.getSelectedRow();
//				model.removeRow(row);
//			}
//		});
//	}
//}
