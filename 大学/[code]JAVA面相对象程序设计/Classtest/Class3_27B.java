import java.util.*;
public class Class3_27B {

	public static void main(String[] args) {
		//���2000��2020֮��ÿ���������ÿ���껻һ��
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
