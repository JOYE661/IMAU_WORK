public class People extends Thread {
   StringBuffer str;
   People(String s,StringBuffer str) { 
      setName(s); //调用从Thread类继承的setName方法为线程起名字
      this.str=str;
   }
   public void run() {
      for(int i=1;i<=3;i++) {
         str.append(getName()+",");   //将当前线程的名字尾加到str
         System.out.println("我是"+getName()+",字符串为:"+str);
         try {  sleep(1000);      
         }
         catch(InterruptedException e){}
      }
   } 
}


