public interface Printable { 
    public final int MAX = 100;  //�ȼ�д����int MAX=100;
    public abstract void on();   //�ȼ�д����void on();
    public abstract float sum(float x ,float y);
    public default int max(int a,int b) {   //default����
        return a>b?a:b;
    }
    public static void f() {
       System.out.println("ע���Ǵ�Java SE 8��ʼ��");
    }
}