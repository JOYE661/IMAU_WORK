package U12_06;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Task_2 {

	static String[][] content= {{"001","ƻ��","3"},{"002","����","6"},{"003","�㽶","9"}};
	static String[] colName= {"���","����","����"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame();
		
		DefaultTableModel model=new DefaultTableModel(content,colName);
		JTable table=new JTable(model);
		frame .add(table);
		frame.setSize(300,200);
		frame.setVisible(true);
	}

}
