public class Example4_19 {
   public  static void main(String args[]) {
      Integer x=100,y=12;//װ��:Integer x=new Integer(100),y=new Integer(12);
      Integer m=x+y;  //�Ȳ�����װ��:Integer m=new Integer(x.intValue()+y.intValue());
      int ok=m;       //����:int ok=m.intValue();
      System.out.println(ok);   
  }
}
