
public class currentTime {

	public static void main(String[] args) {
		long t=System.currentTimeMillis();
		// TODO Auto-generated method stub
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
		
		
		System.out.println(h+":"+m+":"+s);
	}

}
