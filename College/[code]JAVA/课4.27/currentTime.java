
public class currentTime {

	public static void main(String[] args) {
		long t=System.currentTimeMillis();
		// TODO Auto-generated method stub
		long S=t/1000;
		//总秒
		
		long M=S/60;
		//总分钟
		long s=S%60;
		//当前秒
		long H=M/60;
		//总小时
		long m=M%60;
		//当前分
		long h=H%24;
		//当前时
		
		
		System.out.println(h+":"+m+":"+s);
	}

}
