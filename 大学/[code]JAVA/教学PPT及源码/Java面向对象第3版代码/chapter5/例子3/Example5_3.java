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
      stu.x=98; //合法，子类对象的x是int型
      System.out.println("对象stu的x的值是:"+stu.getX());
      //stu.x=98.98; //非法，因为子类对象的x已经不是int型
      stu.setX(98.98); //子类对象调用继承的方法操作隐藏的double型变量x
      double m=stu.getDoubleX();//子类对象调用继承的方法操作隐藏的double型变量x
      System.out.println("对象stu隐藏的x的值是:"+m);
  }  
}
