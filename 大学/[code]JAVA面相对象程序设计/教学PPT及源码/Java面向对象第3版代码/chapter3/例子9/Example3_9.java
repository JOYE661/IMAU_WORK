enum Color {
  ºì,À¶,ÂÌ,»Æ,ºÚ
}
public class Example3_9 {
   public static void main(String args[]) {
      for(Color a:Color.values()) {
         for(Color b:Color.values()) {
            for(Color c:Color.values()) {
               if(a!=b&&a!=c&&b!=c) {
                  System.out.print(a+","+b+","+c+" |");
               }
            }
         }
      }
    }
}  

