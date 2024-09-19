public class Example9_16 {
   public static void main(String args[]) {
      StringBuffer str=
      new StringBuffer("he like Java");
      str.setCharAt(0 ,'w'); 
      str.setCharAt(1 ,'e');
      System.out.println(str); 
      str.insert(2, " all");
      System.out.println(str);
      int index=str.indexOf("Java");
      str.replace(index,str.length(),"apple");
      System.out.println(str);
   }
}
