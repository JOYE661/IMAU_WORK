package U11_15;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class Task1115 {
/*
  完成swing 设计一个登录界面 
     用户名  输入框    
     密码     密码框   
     确定和 取消按钮
要求用到  面板   布局等类
  
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//标题
		JFrame frame =new JFrame("农产品交易平台");
		/*
		//背景颜色
		Container con =frame.getContentPane();
		con.setBackground(Color.GREEN);
		*/
		//添加画板
		JPanel panel=new JPanel(new FlowLayout(FlowLayout.LEFT,10,300));
		panel.add(new JButton("OK"));
		panel.add(new JButton("Cancle"));
		panel.add(new JButton("Hello World"));
		//画板布局2
		
		JPanel panel2=new JPanel();
		panel2.setLayout(new BorderLayout());
		JButton button=null;
		for(int i=0;i<9;i++) {
			button=new JButton("按钮"+i);
			panel2.add(button);
		}
		
		
		/*
		//菜单相关
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
		*/
		//
		frame.add(panel);
		//frame.add(panel2);
		//frame.setJMenuBar(menuBar);
		frame.setVisible(true);
		frame.setSize(600,400);
		
		
	}
}
