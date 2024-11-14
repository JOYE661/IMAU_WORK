package U11_01;
//��1������ũ��Ʒ�࣬��������������Ϣ��
//
//��2���������ݴ洢��product.txt�ļ��У����㽫���ȡ����������������10��ũ��Ʒ����
//
//��3���ڣ�2���Ļ����Ͻ�ũ��Ʒ����洢��HashSet��
//
//��4������HashSet����Ԫ�أ�����ͨ��ObjectOutputStream�洢�ڶ������ļ���
//
//��5����ȡ�������ļ��д洢�Ķ��󣬱Ƚ϶������ļ��д洢�Ķ����Դ�ļ��д洢����ĸ����Ƿ�һ�£�Ϊʲô��


import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, IOException{
		// TODO Auto-generated method stub
		File file=new File("pro.txt");
		Scanner in=new Scanner(file);
		Set<Product> set=new HashSet<>();
		
		if(!file.exists()) {
			System.out.println("�ļ�������");
			System.exit(0);
		}
		Product pro=new Product();
		while(in.hasNext()) {
			String line=in.nextLine();
			System.out.println(line);
			String[] items=line.split("\t");
			String re="\\D*";
			String pir=items[1].replaceAll(re,"").trim();
			//String pir=items[1].replace("kg","").replace("$","");
			pro=new Product(items[0],Double.parseDouble(pir),items[2],items[3]);
			set.add(pro);
			
			//for(String item:items) {
			//	System.out.println(item);
			//}
		}
		in.close();
		System.out.println("�����е�����");
		for(Product p:set) {
			System.out.println(p);
		}
		//+++++++++++++++++++++++++++++++++++++++++++++

		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("out.dat"));
		for(Product p:set) {
			out.writeObject(p);
		}
		out.close();
		
		//+++++++++++++++++++++++++++++++++++++++++++++
//			ObjectInputStream inn=new ObjectInputStream(new FileInputStream("out.dat"));
//			Object obj=inn.readObject();
//			while(obj!=null) {
//				System.out.println(obj);
//				obj=inn.readObject();
//			}
//			inn.close();
//		 
	}

}
