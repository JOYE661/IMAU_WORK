import java.util.*;
public class Class3_27B {

	public static void main(String[] args) {
		//输出2000到2020之间每年的天数，每五年换一行
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
