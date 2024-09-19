
public class Time {

	//属性
	private long hour;
	private	long minute;
	private long second;
	//行为
	public void setTime(long t) {
		
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
		this.hour=h;
		this.minute=m;
		this.second=s;
	}
	//构造
	public long getHour() {
		return hour;
	}
	public long getMinute() {
		return minute;
	}
	public long getSecond() {
		return second;
	}
	public Time() {
		long t=System.currentTimeMillis();
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
		this.hour=h;
		this.minute=m;
		this.second=s;
	}
	public Time(long t) {
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
		this.hour=h;
		this.minute=m;
		this.second=s;
	}
	public Time(long hour,long minute,long second) {
		this.hour=hour;
		this.minute=minute;
		this.second=second;
	}
}
