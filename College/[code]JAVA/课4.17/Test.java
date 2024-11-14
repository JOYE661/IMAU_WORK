
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MI mi=new MI(5);
		if(mi.isP()) {
			System.out.println("yes");
		}
		else{
			System.out.println("No");
		}
		int count=0;
		for(int i=0;i<=100;i++) {
			if(MI.isP(i)) {
				System.out.print(i+" ");
				count++;
			}
			if(count%5==0) {
				System.out.println();
			}
		}
	}

}
