package U11_15;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class Task1115 {
/*
  ���swing ���һ����¼���� 
     �û���  �����    
     ����     �����   
     ȷ���� ȡ����ť
Ҫ���õ�  ���   ���ֵ���
  
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����
		JFrame frame =new JFrame("ũ��Ʒ����ƽ̨");
		/*
		//������ɫ
		Container con =frame.getContentPane();
		con.setBackground(Color.GREEN);
		*/
		//��ӻ���
		JPanel panel=new JPanel(new FlowLayout(FlowLayout.LEFT,10,300));
		panel.add(new JButton("OK"));
		panel.add(new JButton("Cancle"));
		panel.add(new JButton("Hello World"));
		//���岼��2
		
		JPanel panel2=new JPanel();
		panel2.setLayout(new BorderLayout());
		JButton button=null;
		for(int i=0;i<9;i++) {
			button=new JButton("��ť"+i);
			panel2.add(button);
		}
		
		
		/*
		//�˵����
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
		*/
		//
		frame.add(panel);
		//frame.add(panel2);
		//frame.setJMenuBar(menuBar);
		frame.setVisible(true);
		frame.setSize(600,400);
		
		
	}
}
