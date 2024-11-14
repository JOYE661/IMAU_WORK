package U12_06;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Task_2 {

	static String[][] content= {{"001","苹果","3"},{"002","橙子","6"},{"003","香蕉","9"}};
	static String[] colName= {"编号","名称","单价"};
	
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
