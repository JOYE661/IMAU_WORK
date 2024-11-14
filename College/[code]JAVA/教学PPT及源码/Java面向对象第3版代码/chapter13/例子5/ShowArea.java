import java.io.*; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class ShowArea extends JPanel {
    JTable table;
    Object tableElement[][],name[]={"Ãû³Æ","¿â´æ","µ¥¼Û"};
    public ShowArea(){
        setLayout(new BorderLayout());
        table = new JTable();
        add(table);
    }
    public void show(LinkedList<Goods> goodsList) {
        remove(table);
        int length=goodsList.size();
        tableElement = new Object[length][3];
        table=new JTable(tableElement,name); 
        add(table);
        Iterator<Goods> iter=goodsList.iterator();
        int i=0;
        while(iter.hasNext()) {
           Goods  goods =iter.next();
           tableElement[i][0]= goods.getName();
           tableElement[i][1]=goods.getMount();
           tableElement[i][2]=goods.getPrice();
           i++;
        }
       table.repaint();
   }
}