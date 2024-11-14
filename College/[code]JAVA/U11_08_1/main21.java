package U11_08_1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class main21 {

	public static void main(String[] args) throws FileNotFoundException {
	FileInputStream f1=new FileInputStream("C:/eclipse-workspace/UPTest/keyword.txt");
	Scanner in=new Scanner(f1);
	HashSet<String> set1=new HashSet<>();
	HashSet<String> set2=new HashSet<>();
	
	while(in.hasNext())
	{
		set1.add(in.next());
	}
	FileInputStream f2=new FileInputStream("c:/eclipse-workspace/UPTest/java1.java");
		Scanner input=new Scanner(f2);
		int sum=0;
		while(input.hasNext())
		{
			String s=input.next();
			if(set1.contains(s)) {
				set2.add(s);
				sum++;
			}
		}
		for (String t : set2) {
			System.out.print(t+" ");
		}		
		System.out.println();
		System.out.println(sum);
	}
}
