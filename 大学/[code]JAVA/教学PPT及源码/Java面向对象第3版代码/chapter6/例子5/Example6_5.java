public class Example6_5 {
   public static void main(String args[ ]) {
      int n=0,m=0,t=6666;
      try{  m=Integer.parseInt("8888");
            n=Integer.parseInt("ab85"); //发生异常,转向catch
            t=9999;  //t没有机会赋值
      }
      catch(NumberFormatException e) {
            System.out.println("发生异常:"+e.getMessage());
            n=123;
      }
      System.out.println("n="+n+",m="+m+",t="+t);
    }
}

