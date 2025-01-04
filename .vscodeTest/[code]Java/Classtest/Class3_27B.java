import java.util.*;
public class Class3_27B {

	public static void main(String[] args) {
		//output the days of every year between 2000 and 2020 then change line every five years
		int count=0;
		Scanner input=new Scanner(System.in);
		for(int i=2000;i<=2020;i++) {
			System.out.print(i+":"+Class3_27A.isYear(i)+"  ");
			count++;
			if(count%5==0) {
				System.out.println();
			}
		}

	}

}
