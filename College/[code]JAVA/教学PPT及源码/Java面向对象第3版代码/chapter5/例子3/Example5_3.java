class People {
    public double x;
    public void setX(double x) {
       this.x=x;
    }
    public double getDoubleX() {
       return x;
    }
}
class Student extends People {
    int x;
    public int getX() {
       return x;
    }
}
public class Example5_3 {
  public static void main(String args[]) {
      Student stu=new Student();
      stu.x=98; //�Ϸ�����������x��int��
      System.out.println("����stu��x��ֵ��:"+stu.getX());
      //stu.x=98.98; //�Ƿ�����Ϊ��������x�Ѿ�����int��
      stu.setX(98.98); //���������ü̳еķ����������ص�double�ͱ���x
      double m=stu.getDoubleX();//���������ü̳еķ����������ص�double�ͱ���x
      System.out.println("����stu���ص�x��ֵ��:"+m);
  }  
}
