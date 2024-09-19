import java.util.*;
public class Example13_6 {
   public static void main(String args[]) {
      Stack<Integer> stack=new Stack<Integer>();
      stack.push(1); 
      stack.push(1);
      int k=1;
      while(k<=10) {
        for(int i=1;i<=2;i++) {
          int f1=stack.pop();
          int f2=stack.pop();
          int next = f1+f2;
          System.out.println(""+next); 
          stack.push(next);
          stack.push(f2);
          k++;
        }
      } 
   }
}


