public class Example9_7 {
   public static void main(String args[]) {
      char [] a,b,c; 
      String s="��������ӻ��ܵ¹������";
      a=new char[2];
      s.getChars(5,7,a,0);
      System.out.println(a);
      b=new char[s.length()];
      s.getChars(7,12,b,0);
      s.getChars(5,7,b,5);
      s.getChars(0,5,b,7);
      System.out.println(b);
      c="��Һã��ܸ�����ʶ���".toCharArray();
      for(char ch:c)
        System.out.print(ch);
   }
}
