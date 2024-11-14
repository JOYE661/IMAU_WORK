package U10_25;
//1、自定义一个Student类,私有化类的成员，包括姓名、学号和专业，实现Serializable接口；
//
//2、创建两个对象，通过ObjectOutputStream写入文件中
//
//3、通过ObjectInputStream从文件中读出两个对象，并将对象内容输出


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
