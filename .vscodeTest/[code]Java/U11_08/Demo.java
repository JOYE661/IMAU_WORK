package U11_08;
//ͳ��һ��Ӣ���ı��е��ʳ��ֵĴ���
//
//��1��ʹ��HashMap�洢����
//
//��2����ͬ�ĵ��ʣ�����+1
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Map<String,Integer> dic=new HashMap<String, Integer>();
		
		Scanner in=new Scanner(new File("C:\\eclipse-workspace\\UPTest\\en1.txt"));
		while(in.hasNext()) {
			String line=in.nextLine();
			word(line,dic);
			
			//System.out.println("������ÿ������"+in.nextLine());
		}
		//System.out.println("map�е����ݣ�"+dic);
		for(String word:dic.keySet()) {
			System.out.println(word+"���ִ���Ϊ��"+dic.get(word));
		}
	}
	public static void word(String line,Map<String,Integer> dic) {
		line=line.replaceAll("[:,?.]", "");
		//System.out.println(line);
		String [] words=line.split(" ");
		for(String word:words) {
			if(word.length()!=0)
			//System.out.println(word);
			//�����Ƿ����
			if(dic.containsKey(word)) {
				int count=dic.get(word);
				count++;
				dic.replace(word, count);
			}
			else {
				//����map
				dic.put(word, 1);
			}
		}
		//System.out.println(dic);
	}
}
