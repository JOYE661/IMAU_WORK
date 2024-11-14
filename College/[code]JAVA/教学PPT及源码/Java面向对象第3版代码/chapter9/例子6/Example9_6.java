import java.util.Date; 
public class Example9_6 {
   public static void main(String args[]) {
       Date date=new Date();
       System.out.println(date.toString());
       Student zhang=new Student("Zhang San");
       System.out.println(zhang.toString());  
       System.out.println(new Student("Li Xiao").toString());  
   }
}
