package U11_08_1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class main2 {

	public static void main(String[] args) throws FileNotFoundException {
	FileInputStream f1=new FileInputStream("C:/eclipse-workspace/UPTest/keyword.txt");
	Scanner in=new Scanner(f1);
	HashSet<String> set1=new HashSet<>();
	while(in.hasNext())
	{
		set1.add(in.next());
	}
	FileInputStream f2=new FileInputStream("c:/eclipse-workspace/UPTest/java1.java");
		Scanner input=new Scanner(f2);
		int sum=0;
		while(input.hasNext())
		{
			if(set1.contains(input.next()))
				sum++;
		}
				System.out.println(sum);
	}

}
