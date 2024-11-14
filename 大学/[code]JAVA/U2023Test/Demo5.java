package U2023Test;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String>stu=new ArrayList<>();
		stu.add("jo1");
		stu.add("jo2");
		stu.add("jo3");
		
		Iterator<String>i=stu.iterator();
		while (i.hasNext()) {
			String s=i.next();
			System.out.println(s);
			
		}
	}

}
