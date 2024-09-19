public class Move implements Runnable {
   public void run() {      
      String name=Thread.currentThread().getName();    //局部变量name
      StringBuffer str=new StringBuffer();            //局部变量str
      for(int i=1;i<=3;i++) {                         //局部变量i
         if(name.equals("张三")) {
            str.append(name);
            System.out.println(name+"线程的局部变量i="+i+",str="+str);
         } 
         else if(name.equals("李四")) {
            str.append(name);
            System.out.println(name+"线程的局部变量i="+i+",str="+str);
         } 
         try{  Thread.sleep(800);
         }
         catch(InterruptedException e){}
     }
   }
}
