package U10_25;
//1���Զ���һ��Student��,˽�л���ĳ�Ա������������ѧ�ź�רҵ��ʵ��Serializable�ӿڣ�
//
//2��������������ͨ��ObjectOutputStreamд���ļ���
//
//3��ͨ��ObjectInputStream���ļ��ж����������󣬲��������������


import java.io.*;

public class Class10_25test {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
		Student t1=new Student("zhouye",100,"cs");
		Student t2=new Student("lizhenghao",0,"cs");
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("t1.dat"));
		out.writeObject(t1);
		out.writeObject(t2);
		out.close();
		
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("t1.dat"));
		
		Student s3=(Student)(in.readObject());
		Student s4=(Student)(in.readObject());
		System.out.println(s3);
		System.out.println(s4);
		in.close();
		
	}

}
