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
		//����
		JFrame frame =new JFrame("ũ��Ʒ����ƽ̨");
		//������ɫ
		Container con =frame.getContentPane();
		con.setBackground(Color.GREEN);//�˵����
		JMenuBar menuBar=new JMenuBar();
		
		JMenu fJMenu=new JMenu("ˮ���˵�");
		JMenuItem banaItem=new JMenuItem("�㽶");
		JMenuItem peaItem=new JMenuItem("����");
		fJMenu.add(banaItem);
		fJMenu.add(peaItem);
		menuBar.add(fJMenu);
		//�ټ�һ��ƻ�������˵�
		JMenu appleMenu=new JMenu("ƻ��");
		JMenuItem redItem=new JMenuItem("��ƻ��");
		JMenuItem greenItem=new JMenuItem("��ƻ��");
		appleMenu.add(redItem);
		appleMenu.add(greenItem);
		fJMenu.add(appleMenu);		
		//�ټ�һ��һ���߲˲˵�
		JMenu vJMenu=new JMenu("�߲˲˵�");
		JMenuItem tomItem=new JMenuItem("����");
		JMenuItem ptolItem=new JMenuItem("������");
		vJMenu.add(tomItem);
		vJMenu.add(ptolItem);
		menuBar.add(vJMenu);
		//
		
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
		frame.setSize(600,400);
	}

}
