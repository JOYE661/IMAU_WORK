public class Average extends Sum {
   double n;           //����̳е�int�ͱ���n������
   public double f() {
      double c;
      super.n=(int)n; //����double�ͱ���n����intת������Ľ����ֵ�����ص�int�ͱ���n
      c=super.f();
      return c+n;
   }
   public double g() { 
      double c;
      c=super.f();
      return c-n;
   }
}
