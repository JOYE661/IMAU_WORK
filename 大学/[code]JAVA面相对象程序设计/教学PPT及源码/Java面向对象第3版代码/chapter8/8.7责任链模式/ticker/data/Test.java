package ticker.data;
public class Test {
    public static void main(String args[]) {
        TickerSeller tickerSeller = new TickerSeller();
        tickerSeller.setTiketValue(7);         //Ʊ��7Ԫ
        int tickerNumer = 7;                  //��9��Ʊ
        int [] moneyCount = {3,1,2,0,0,0,0}; //Ǯ��ֵ������100,50,20,10,5,2,1
        System.out.println("���� "+tickerNumer+
                           " ��Ʊ,ÿ��"+tickerSeller.ticketValue+"Ԫ.");
        //�ṩ100Ԫ����,50Ԫһ��,20Ԫ2�ţ���100Ԫ��ʵ��û��Ҫ��
        boolean boo=tickerSeller.sellTiket(tickerNumer,moneyCount); 
        if(boo){
           System.out.println("ʵ��:"+tickerSeller.income+"Ԫ");
           System.out.println("����:"+tickerSeller.backChange+"Ԫ");
           System.out.println("�������£��뵱�����:");
        }
        System.out.println(tickerSeller.backMess);
        for(int i = 0;i<tickerSeller.moneybox.length;i++){
             System.out.println(tickerSeller.moneybox[i].moneyValueCount);
        }
    }
}