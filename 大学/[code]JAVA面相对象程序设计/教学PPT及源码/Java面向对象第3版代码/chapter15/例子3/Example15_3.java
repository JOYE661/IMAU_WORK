public class Example15_3 {
   public static void main(String args[ ]) {
      Bank bank=new Bank();
      bank.setMoney(300);
      Thread threadOne,threadTwo;
      threadOne=new Thread(bank); 
      threadOne.setName("One");
      threadTwo=new Thread(bank); //threadTwo�� threadOne��Ŀ�������ͬ  
      threadTwo.setName("Two");
      threadOne.start();
      threadTwo.start();
   }
}


