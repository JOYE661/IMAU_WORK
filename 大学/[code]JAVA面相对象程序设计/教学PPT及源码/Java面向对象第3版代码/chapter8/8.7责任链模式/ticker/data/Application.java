package ticker.data;
public class Application {
    public static void main(String args[]) {
        TickerSeller tickerSeller = new TickerSeller();
        tickerSeller.setTiketValue(7);         //Ʊ��7Ԫ
        int tickerNumer = 2;                  //��tickerNumer��Ʊ
        int [] moneyCount = {1,0,0,0,0,0,0}; //Ǯ��ֵ������100,50,20,10,5,2,1
        System.out.println("���� "+tickerNumer+
                           " ��Ʊ,ÿ��"+tickerSeller.ticketValue+"Ԫ.");
        boolean boo=tickerSeller.sellTiket(tickerNumer,moneyCount); 
        if(boo){
           System.out.println("ʵ��:"+tickerSeller.income+"Ԫ");
           System.out.println("����:"+tickerSeller.backChange+"Ԫ");
           System.out.println("�������£��뵱�����:");
        }
        System.out.println(tickerSeller.backMess);
    }
}