package U11_08_1;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class WAIMAI {

	public static void main(String[] args) {
		//HashSet容器------String
		HashSet<String> set1=new HashSet<>();
		//add()
		//可重复数据：x和y-------1-x.equals(y)----2-x.hashcode()-----y.hashcode()
		set1.add("java");
		set1.add("c++");
		set1.add("python");
		set1.add(new String("java"));
		System.out.println(set1.size());
		for (String string : set1) {
			System.out.print(string+" ");
		}
		System.out.println();
		//contains
		if(set1.contains("c++"))
		{
			System.out.println(true);
		}
		else
		{
			System.out.println(false);
		}
		//LinkHashSet
		LinkedHashSet<String> set2=new LinkedHashSet<>();
		set2.add("java");
		set2.add("c++");
		set2.add("python");
		set2.add(new String("java"));
		System.out.println(set2.size());
		for (String string : set2) {
			System.out.print(string+" ");
		}
		System.out.println();
		//TreeSet
		TreeSet<String> set3=new TreeSet<>();
		set3.add("java");
		set3.add("c++");
		set3.add("python");
		set3.add(new String("java"));
		for (String string : set3) {
			System.out.print(string+" ");
		}
		System.out.println();
		//lower()//higher-------floor()/ceiling()
		String t1=set3.lower("python");
		String t2=set3.floor("python");
		System.out.println(t1+" "+t2);
		//list----(1,2,3,1)----去除重复元素---set:set1
		ArrayList<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(1);
		System.out.println("list:"+list.size());
		//set类型容器---set4
		HashSet<Integer> set4=new HashSet<>(list);
		System.out.println("set4:"+set4.size());
	}

}
