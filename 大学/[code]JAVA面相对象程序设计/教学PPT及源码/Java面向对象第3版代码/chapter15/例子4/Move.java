public class Move implements Runnable {
   public void run() {      
      String name=Thread.currentThread().getName();    //�ֲ�����name
      StringBuffer str=new StringBuffer();            //�ֲ�����str
      for(int i=1;i<=3;i++) {                         //�ֲ�����i
         if(name.equals("����")) {
            str.append(name);
            System.out.println(name+"�̵߳ľֲ�����i="+i+",str="+str);
         } 
         else if(name.equals("����")) {
            str.append(name);
            System.out.println(name+"�̵߳ľֲ�����i="+i+",str="+str);
         } 
         try{  Thread.sleep(800);
         }
         catch(InterruptedException e){}
     }
   }
}
