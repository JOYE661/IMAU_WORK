public class Example15_1 { 
   public  static void main(String args[]) { //���߳�
       Tiger  tiger;
       Cat cat;  
       tiger = new Tiger() ;  //�����߳�
       cat = new Cat();      //�����߳�
       System.out.println("tiger��״̬:"+tiger.getState());
       System.out.println("cat״̬:"+cat.getState());
       tiger.start();            //�����߳� 
       cat.start();             //�����߳�
       for(int i=1;i <= 6;i++) {
          System.out.printf("\n%s","tiger״̬:"+tiger.getState());
          System.out.printf("\n%s","cat״̬:"+cat.getState());
          System.out.printf("\n%s","����"+i);
       }  
       System.out.printf("\n%s","|tiger��״̬:"+tiger.getState());
       System.out.printf("\n%s","|cat״̬:"+cat.getState());
   }
}
