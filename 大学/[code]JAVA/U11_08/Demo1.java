package U11_08;

import java.util.HashMap;
import java.util.Map;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> dic=new HashMap<String, Integer>();
		String line="One of the�� most well, Hamlet help ? and deeds.";
		//����һ�仰
		line=line.replaceAll("[:,?.]", "");
		System.out.println(line);
		String [] words=line.split(" ");
		for(String word:words) {
			if(word.length()!=0)
			System.out.println(word);
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
		System.out.println(dic);
	}

}
