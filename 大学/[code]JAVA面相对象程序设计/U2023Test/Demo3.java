package U2023Test;

import java.io.*;


//�����ƶ�дд��1����10���ֽں��ٶ���
public class Demo3 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
			//
			FileOutputStream output=new FileOutputStream("Demo3.dat");
			for(int i = 0; i < 10; i++){
				output.write(i);
			}
			output.close();
			//
			FileInputStream input=new FileInputStream("Demo3.dat");
			int value;
			while(input.available()!=0) {
				value=input.read();
				System.out.println(value+"");
			}
			input.close();
	}

}
