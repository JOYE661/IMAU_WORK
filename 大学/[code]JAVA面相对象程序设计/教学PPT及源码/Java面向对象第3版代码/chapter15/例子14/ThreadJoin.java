public class ThreadJoin implements Runnable {
   Car car;
   Thread customer,carMaker;
   ThreadJoin() {
      customer=new Thread(this);
      customer.setName("�˿�");
      carMaker=new Thread(this);
      carMaker.setName("�������쳧");
   }
   public void run() {
      if(Thread.currentThread()==customer) {
          System.out.println(customer.getName()+"��"+carMaker.getName()+"��������");
          try{  carMaker.start(); 
                carMaker.join();  //�߳�customer��ʼ�ȴ�carMaker����
          } 
          catch(InterruptedException e){}
          System.out.println(customer.getName()+
                         "����һ��������"+car.name+" ��Ǯ:"+car.price);
      }
      else if(Thread.currentThread()==carMaker) {
          System.out.println(carMaker.getName()+"��ʼ��������,���...");
          try { carMaker.sleep(2000);    
          }
          catch(InterruptedException e){}
          car=new Car("����γ�",288000) ;
          System.out.println(carMaker.getName()+"�������");
      }
   }    
}
