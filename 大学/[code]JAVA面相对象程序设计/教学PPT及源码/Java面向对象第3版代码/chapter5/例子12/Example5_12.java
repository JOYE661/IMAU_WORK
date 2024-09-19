abstract class 机动车 {
   abstract void 启动();
   abstract void 加速();
   abstract void 刹车();
}
class 手动档轿车 extends 机动车 {
   void 启动() {
      System.out.println("踏下离合器，换到一挡");
      System.out.println("然后慢慢抬起离合器");
   }
   void 加速() {
      System.out.println("踩油门");
   }
   void 刹车() {
      System.out.println("踏下离合器，踏下刹车板");
      System.out.println("然后将挡位换到一挡");
   }
}
class 自动档轿车 extends 机动车 { 
   void 启动() {
      System.out.println("使用前进挡");
      System.out.println("然后轻踩油门");
   }
   void 加速() {
      System.out.println("踩油门");
   }
   void 刹车() {
      System.out.println("踏下刹车板");
   }
}
public class Example5_12 {
   public static void main(String args[]) {
      机动车 car=new 手动档轿车();
      System.out.println("手动档轿车的操作：");
      car.启动();
      car.加速();
      car.刹车();
      car=new 自动档轿车();
      System.out.println("自动档轿车轿车的操作：");
      car.启动();
      car.加速();
      car.刹车();
   }
}
