public class ThreadJoin implements Runnable {
   Car car;
   Thread customer,carMaker;
   ThreadJoin() {
      customer=new Thread(this);
      customer.setName("顾客");
      carMaker=new Thread(this);
      carMaker.setName("汽车制造厂");
   }
   public void run() {
      if(Thread.currentThread()==customer) {
          System.out.println(customer.getName()+"等"+carMaker.getName()+"生产汽车");
          try{  carMaker.start(); 
                carMaker.join();  //线程customer开始等待carMaker结束
          } 
          catch(InterruptedException e){}
          System.out.println(customer.getName()+
                         "买了一辆汽车："+car.name+" 价钱:"+car.price);
      }
      else if(Thread.currentThread()==carMaker) {
          System.out.println(carMaker.getName()+"开始生产汽车,请等...");
          try { carMaker.sleep(2000);    
          }
          catch(InterruptedException e){}
          car=new Car("红旗轿车",288000) ;
          System.out.println(carMaker.getName()+"生产完毕");
      }
   }    
}
