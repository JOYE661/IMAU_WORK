
public class Time {

	//����
	private long hour;
	private	long minute;
	private long second;
	//��Ϊ
	public void setTime(long t) {
		
		long S=t/1000;
		//����
		
		long M=S/60;
		//�ܷ���
		long s=S%60;
		//��ǰ��
		long H=M/60;
		//��Сʱ
		long m=M%60;
		//��ǰ��
		long h=H%24;
		//��ǰʱ
		this.hour=h;
		this.minute=m;
		this.second=s;
	}
	//����
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
		//����
		
		long M=S/60;
		//�ܷ���
		long s=S%60;
		//��ǰ��
		long H=M/60;
		//��Сʱ
		long m=M%60;
		//��ǰ��
		long h=H%24;
		//��ǰʱ
		this.hour=h;
		this.minute=m;
		this.second=s;
	}
	public Time(long t) {
		long S=t/1000;
		//����
		
		long M=S/60;
		//�ܷ���
		long s=S%60;
		//��ǰ��
		long H=M/60;
		//��Сʱ
		long m=M%60;
		//��ǰ��
		long h=H%24;
		//��ǰʱ
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
