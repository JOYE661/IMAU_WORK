import javax.swing.*;
public class Example14_6 {
   public static void main(String args[]) {
      String [] tableHead;
      String [][] content; 
      JTable table ;
      JFrame win= new JFrame();
      Query findRecord = new  Query();
      findRecord.setDatabaseName("Book");
      findRecord.setSQL("select * from bookList");
      content = findRecord.getRecord(); //���ض�ά���飬����ѯ��ȫ����¼
      tableHead=findRecord.getColumnName();//����ȫ���ֶΣ��У���
      table = new JTable(content,tableHead); 
      win.add(new JScrollPane(table));
      win.setBounds(12,100,400,200);
      win.setVisible(true); 
      win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }
}
