public class Application {
    public static void main(String args[]) {
         A a;
         a=new B();   //a是B类对象的上转型对象
         int m=a.add(3,2); //a调用子类B重写的add()方法
         System.out.println(m);  //输出结果为5
    }
}
