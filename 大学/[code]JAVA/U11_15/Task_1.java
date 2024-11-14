package U11_15;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Task_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//标题
		JFrame frame =new JFrame("农产品交易平台");
		//背景颜色
		Container con =frame.getContentPane();
		con.setBackground(Color.GREEN);//菜单相关
		JMenuBar menuBar=new JMenuBar();
		
		JMenu fJMenu=new JMenu("水果菜单");
		JMenuItem banaItem=new JMenuItem("香蕉");
		JMenuItem peaItem=new JMenuItem("桃子");
		fJMenu.add(banaItem);
		fJMenu.add(peaItem);
		menuBar.add(fJMenu);
		//再加一个苹果二级菜单
		JMenu appleMenu=new JMenu("苹果");
		JMenuItem redItem=new JMenuItem("红苹果");
		JMenuItem greenItem=new JMenuItem("绿苹果");
		appleMenu.add(redItem);
		appleMenu.add(greenItem);
		fJMenu.add(appleMenu);		
		//再加一个一级蔬菜菜单
		JMenu vJMenu=new JMenu("蔬菜菜单");
		JMenuItem tomItem=new JMenuItem("土豆");
		JMenuItem ptolItem=new JMenuItem("西红柿");
		vJMenu.add(tomItem);
		vJMenu.add(ptolItem);
		menuBar.add(vJMenu);
		//
		
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
		frame.setSize(600,400);
	}

}
