package U2023Test;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Demo6 {

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		Hashtable<String, Integer>map=new Hashtable<>();
		//
		File file=new File("C:\\eclipse-workspace\\UPTest\\en1.txt");
		Scanner input=new Scanner(file);
		//
		while (input.hasNext()) {
			String s=input.next();
			s=s.toLowerCase();
			//»¯ÎªÐ¡Ð´
			if(map.containsKey(s)) {
				int value=map.get(s);
				value++;
				map.put(s, value);
			}
			else {
				map.put(s, 1);
			}
		}
		/*
		Set<Entry<String,Integer>>set=map.entrySet();
		for(Entry<String,Integer> x:set) {
			System.out.println(x.getKey()+""+x.getValue());
		}
		*/
		for(String words:map.keySet()) {
			System.out.println(words+" "+map.get(words));
		}
		
	}

}
