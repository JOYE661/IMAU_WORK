package ticker.data;
public class Test {
    public static void main(String args[]) {
        TickerSeller tickerSeller = new TickerSeller();
        tickerSeller.setTiketValue(7);         //票价7元
        int tickerNumer = 7;                  //买9张票
        int [] moneyCount = {3,1,2,0,0,0,0}; //钱面值依次是100,50,20,10,5,2,1
        System.out.println("购买 "+tickerNumer+
                           " 张票,每张"+tickerSeller.ticketValue+"元.");
        //提供100元三张,50元一张,20元2张（但100元的实际没必要）
        boolean boo=tickerSeller.sellTiket(tickerNumer,moneyCount); 
        if(boo){
           System.out.println("实收:"+tickerSeller.income+"元");
           System.out.println("找赎:"+tickerSeller.backChange+"元");
           System.out.println("找赎如下，请当面点清:");
        }
        System.out.println(tickerSeller.backMess);
        for(int i = 0;i<tickerSeller.moneybox.length;i++){
             System.out.println(tickerSeller.moneybox[i].moneyValueCount);
        }
    }
}