import java.util.Scanner;
public class Class3_13Main5 {

	public static void main(String[] args) {
		Scanner input;
		input=new Scanner(System.in);
		// ��֧�����BMI
		while(input.hasNext()) {
			double weight=input.nextDouble();
			double height=input.nextDouble();
			double BMI=weight/(height*height);
			
			if(BMI<18.5) {
				System.out.println("ƫ��");
			}
			else if(BMI<=24&&BMI>=18.5) {
				System.out.println("����");
			}
			else if(BMI<=27&&BMI>=25) {
				System.out.println("����");
			}
			else if(BMI>27) {
				System.out.println("����");
			}
		}
	}

}
