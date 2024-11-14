
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person stu=new Student();
		Person e=new employee();
		employee f=new faculty();
		employee sta=new staff();
		
		stu.setname(" stu");
		e.setname(" e");
		f.setname(" f");
		sta.setname(" sta");
		
		System.out.println(stu.toString());
		System.out.println(e.toString());
		System.out.println(f.toString());
		System.out.println(sta.toString());
	}

}
