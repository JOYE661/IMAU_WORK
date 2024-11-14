import java.util.*;
public class Example9_11 {
   public static void main(String args[]) {
      String s="we are stud,ents";
      StringTokenizer fenxi=new StringTokenizer(s," ,"); //用空格和逗号的任意组合作为分隔标记
      int number=fenxi.countTokens();
      while(fenxi.hasMoreTokens()) {
          String str=fenxi.nextToken();
          System.out.println(str);
          System.out.println("还剩"+fenxi.countTokens()+"个单词");
      }
      System.out.println("s共有单词："+number+"个");
    } 
}
