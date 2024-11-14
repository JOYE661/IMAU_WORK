import java.io.IOException;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			House h1=new House(1,2);
			House h2=(House)(h1.clone());
			System.out.println(h2.getid());
			
		}catch(CloneNotSupportedException e) {
			System.out.println("cuole");
			
		}
	}

}
