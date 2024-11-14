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
      content = findRecord.getRecord(); //返回二维数组，即查询的全部记录
      tableHead=findRecord.getColumnName();//返回全部字段（列）名
      table = new JTable(content,tableHead); 
      win.add(new JScrollPane(table));
      win.setBounds(12,100,400,200);
      win.setVisible(true); 
      win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }
}
