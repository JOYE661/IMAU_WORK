public class Average extends Sum {
   double n;           //子类继承的int型变量n被隐藏
   public double f() {
      double c;
      super.n=(int)n; //子类double型变量n进行int转换运算的结果赋值给隐藏的int型变量n
      c=super.f();
      return c+n;
   }
   public double g() { 
      double c;
      c=super.f();
      return c-n;
   }
}
