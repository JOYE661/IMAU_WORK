public class ComputerSum implements Runnable {
   int i=1,sum=0;             //�̹߳��������
   public void run() {      
      Thread  thread=Thread.currentThread();
      System.out.println(thread.getName()+"��ʼ����");
      while(i<=10) {
        sum=sum+i;
        System.out.print(" "+sum);
        if(i==5) {
           System.out.println(thread.getName()+"��������ˣ�i="+i);
           Thread threadTwo=new Thread(this);//threadTwo�� threadOne��Ŀ�������ͬ
           threadTwo.setName("����");
           threadTwo.start();  //����threadTwo
           i++;      //����֮ǰ��i���6
           return;   //threadOne����  
        }
        i++;
        try{  Thread.sleep(300);
        }
        catch(InterruptedException e){}
      }
   }
}
