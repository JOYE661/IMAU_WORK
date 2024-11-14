public class MainClass {
   public static void main(String arg[]) {
      Car car =new Car();
      int i=1;
      while(true) {
         try{
           car.show();
           Thread.sleep(2000);  //每隔2000耗秒更换驾驶员
           Class<?> cs=Class.forName("Driver"+i); //有关Class类知识点见6.5
           Person p=(Person)cs.getDeclaredConstructor().newInstance();
           //如果没有第i个驾驶员就触发异常，跳到catch,即无人驾驶或当前驾驶员继续驾驶:
           car.setPerson(p);      //更换驾驶员
           i++; 
         }
         catch(Exception exp){
           i++;
         }
         if(i>10) i=1;          //最多10个驾驶员轮换开车
      }
   }
}
