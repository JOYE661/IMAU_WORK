public class Example15_1 { 
   public  static void main(String args[]) { //主线程
       Tiger  tiger;
       Cat cat;  
       tiger = new Tiger() ;  //创建线程
       cat = new Cat();      //创建线程
       System.out.println("tiger的状态:"+tiger.getState());
       System.out.println("cat状态:"+cat.getState());
       tiger.start();            //启动线程 
       cat.start();             //启动线程
       for(int i=1;i <= 6;i++) {
          System.out.printf("\n%s","tiger状态:"+tiger.getState());
          System.out.printf("\n%s","cat状态:"+cat.getState());
          System.out.printf("\n%s","主人"+i);
       }  
       System.out.printf("\n%s","|tiger的状态:"+tiger.getState());
       System.out.printf("\n%s","|cat状态:"+cat.getState());
   }
}
