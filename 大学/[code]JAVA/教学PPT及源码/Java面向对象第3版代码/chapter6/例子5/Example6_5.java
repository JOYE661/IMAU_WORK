public class Example6_5 {
   public static void main(String args[ ]) {
      int n=0,m=0,t=6666;
      try{  m=Integer.parseInt("8888");
            n=Integer.parseInt("ab85"); //�����쳣,ת��catch
            t=9999;  //tû�л��ḳֵ
      }
      catch(NumberFormatException e) {
            System.out.println("�����쳣:"+e.getMessage());
            n=123;
      }
      System.out.println("n="+n+",m="+m+",t="+t);
    }
}

