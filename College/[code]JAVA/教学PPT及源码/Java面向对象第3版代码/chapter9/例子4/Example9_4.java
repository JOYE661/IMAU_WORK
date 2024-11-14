public class Example9_4 {
   public static void main(String args[]) {
      String path="c:\\book\\javabook\\xml.doc";
      int index=path.indexOf("\\");
      index=path.indexOf("\\",index); 
      String sub=path.substring(index);
      System.out.println(sub);     //输出结果是：\book\javabook\xml.doc
      index=path.lastIndexOf("\\");
      sub=path.substring(index+1);
      System.out.println(sub);     //输出结果是：xml.doc
   }
}
