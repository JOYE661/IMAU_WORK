
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time time1=new Time();
		
		Time time2=new Time(555550000);
		
		System.out.println(time1.getHour()+":"+time1.getMinute()+":"+time1.getSecond());
		System.out.println(time2.getHour()+":"+time2.getMinute()+":"+time2.getSecond());
	}

}
