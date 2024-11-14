public class Application {
    public static void main(String args[]) {
         Com com;
         com=new ComImp();   //com变量存放ComImp类的对象的引用
         int m=com.sub(8,2); //com回调ComImp类实现的接口方法
         System.out.println(m);  //输出结果为6
    }
}



