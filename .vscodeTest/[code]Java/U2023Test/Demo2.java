package U2023Test;
//PrintWrite¡∑œ∞
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file=new File("Demo2.txt");
		if(file.exists()) {
			System.out.println("File already exists");
			System.exit(0);
		}
		//
		PrintWriter output=new PrintWriter(file);
			output.print("joye jo1 ");
			output.println(100);
			output.print("joye jo2 ");
			output.println(100);
			
			
			output.close();
			
		Scanner input=new Scanner(file);
		while(input.hasNext()) {
			String line1=input.next();
			String line2=input.next();
			int line3=input.nextInt();
			
			System.out.print(line1+""+line2+""+line3);
			input.close();
			
		}
	}

}
