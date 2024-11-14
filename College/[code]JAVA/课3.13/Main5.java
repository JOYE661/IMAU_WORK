import java.util.Scanner;
public class Main5 {

	public static void main(String[] args) {
		Scanner input;
		input=new Scanner(System.in);
		// TODO Auto-generated method stub
		while(input.hasNext()) {
			double weight=input.nextDouble();
			double height=input.nextDouble();
			double BMI=weight/(height*height);
			
			if(BMI<18.5) {
				System.out.println("Æ«ÊÝ");
			}
			else if(BMI<=24&&BMI>=18.5) {
				System.out.println("Õý³£");
			}
			else if(BMI<=27&&BMI>=25) {
				System.out.println("³¬ÖØ");
			}
			else if(BMI>27) {
				System.out.println("·ÊÅÖ");
			}
		}
	}

}
