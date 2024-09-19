package test8_time;

public class stopWatch {
	private long startTime;
	private long endTime;
	
	public stopWatch() {
		long t=System.currentTimeMillis();
		//long S=t/1000;
		//long M=S/60;
		//long H=M/60;
		//long s=S%60;
		//long m=M%60;
		//long h=H%60;
		this.startTime=t;
	}
	public long getstartTime() {
		return this.startTime;
	}
	public long getendTime() {
		return this.endTime;
	}
	
	public void start() {
		long t=System.currentTimeMillis();
		this.startTime=t;
	}
	public void stop() {
		long t=System.currentTimeMillis();
		this.endTime=t;
	}
	public long getElapsedTime() {
		return this.endTime-this.startTime;
	}
	
}
