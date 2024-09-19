public class Example4_17 {
   public static void main(String args[]) {
      Student zhang=new Student(); 
      Student geng=new Student();  
      zhang.setAge(23); 
      System.out.println("zhang的年龄："+zhang.getAge()); 
      geng.setAge(25);
      //zhang.age=23;或geng.age=25都是非法的，因为zhang和geng已经不在Student类中 
      System.out.println("geng的年龄："+geng.getAge());  
    }
}

