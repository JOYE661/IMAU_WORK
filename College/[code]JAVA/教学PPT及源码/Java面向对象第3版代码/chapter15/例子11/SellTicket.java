public class SellTicket {
   int ��ԪǮ�ĸ���=2,ʮԪǮ�ĸ���=0,��ʮԪǮ�ĸ���=0; 
   String s=null;
   public synchronized void  ��Ʊ����(int money) {
      String name=Thread.currentThread().getName();
      if(money==5) {  //���ʹ�ø÷������̴߳��ݵĲ�����5,�Ͳ��õȴ�
        ��ԪǮ�ĸ���=��ԪǮ�ĸ���+1; 
         s= "��"+name+"�볡��,"+name+"��Ǯ����";
         WindowTicket.text.append("\n"+s);
      }
      else if(money==20) {           
         while(��ԪǮ�ĸ���<3) {
            try { WindowTicket.text.append("\n"+name+"���ߵ�...");
                  wait();    //���ʹ�ø÷������̴߳��ݵĲ�����20��ȴ�
            }
            catch(InterruptedException e){}
         }
         ��ԪǮ�ĸ���=��ԪǮ�ĸ���-3;
         ��ʮԪǮ�ĸ���=��ʮԪǮ�ĸ���+1;
         s="��"+name+"�볡��,"+name+"��20������15Ԫ";
         WindowTicket.text.append("\n"+s);
      }
      notifyAll();
   }
}
