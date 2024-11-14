package U2023Test;

import java.util.*;


public class Demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<Integer, String>sMap=new Hashtable<>();
		//
		sMap.put(2021, "jo1");
		sMap.put(2022, "jo2");
		sMap.put(2024, "jo3");
		sMap.put(2023, "jo4");
		//
		Set<Integer>sKey=sMap.keySet();
		for(Integer x:sKey) {
			System.out.println(x+" "+sMap.get(x));
		}
	}

}
