public class MainClass {
   public static void main(String args[]) {
      Rational r1=new Rational(1,5);
      Rational r2=new Rational(3,2);;
      Rational result=r1.add(r2); 
      int a=result.getNumerator();
      int b=result.getDenominator();  
      System.out.println("1/5+3/2 = "+a+"/"+b);
      result=r1.sub(r2);
      a=result.getNumerator();
      b=result.getDenominator();    
      System.out.println("1/5-3/2 = "+a+"/"+b);
      result=r1.muti(r2); 
      a=result.getNumerator();
      b=result.getDenominator();  
      System.out.println("1/5��3/2 = "+a+"/"+b);
      result=r1.div(r2);
       a=result.getNumerator();
      b=result.getDenominator();   
      System.out.println("1/5��3/2 = "+a+"/"+b);
      int n=10,k=1;
      System.out.println("����2/1+3/2+5/3+8/5+13/8����ǰ"+n+"���.");
      Rational sum=new Rational(0,1);
      Rational item=new Rational(2,1);
      while(k<=n) {
         sum=sum.add(item);
         k++;
         int fenzi=item.getNumerator();
         int fenmu=item.getDenominator();
         item.setNumeratorAndDenominator(fenzi+fenmu,fenzi);  
      } 
      a=sum.getNumerator();
      b=sum.getDenominator();
      System.out.println("�÷�����ʾ:");
      System.out.println(a+"/"+b);
      double doubleResult=(a*1.0)/b;
      System.out.println("��С����ʾ:");
      System.out.println(doubleResult); 
   }
}
