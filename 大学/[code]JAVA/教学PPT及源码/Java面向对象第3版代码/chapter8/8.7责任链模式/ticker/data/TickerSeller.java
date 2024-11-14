package ticker.data;
public class TickerSeller {
    public int ticketValue;               //票价
    public MoneyBox [] moneybox;         //售票员的钱盒数目
    public int income ;                  //收到的票款金额
    public int backChange ;              //找赎金额
    public String backMess;              //找赎信息
    int [] moneyValue ={100,50,20,10,5,2,1};  //7种面值的钱（单位元）
    //初始时售票员已有面值钱的个数，有0张100元的钱，10张50元钱...50张1元的钱:
    int [] moneyValueCount  ={0,10,12,30,27,23,50};
    public TickerSeller(){
        ticketValue = 8;      //默认票价是8元一张
        backMess = "";
        moneybox = new MoneyBox[moneyValue.length];//钱盒数目是7个 
        init(); 
    }
    public void init(){      //售票员初始化自己的钱盒
        for(int i = 0;i<moneyValue.length;i++){
           moneybox[i] = new MoneyBox();
           //钱盒里初始有moneyValueCount[i] 张钱:
           moneybox[i].setMoneyValueCount(moneyValueCount[i]); 
           moneybox[i].setMoneyValue(moneyValue[i]);//面值是moneyValue[i]
        }
        for(int i = 0;i<moneyValue.length-1;i++){
           moneybox[i].setNextMoneyHandler(moneybox[i+1]);  //形成责任链
        }
    }
    public void setTiketValue(int ticketValue){    //设置票价
        if(ticketValue>=1)
          this.ticketValue = ticketValue;
    }                      
    public boolean sellTiket(int ticketCount,int [] receiveMoneyValueCount){//接收买票有关的数据
        income = 0;   //收到的票款清零
        backChange = 0;
        backMess = "";
        for(int i = 0;i<moneyValue.length;i++){
             moneybox[i].changeCount = 0;  //将钱盒找零个数清零
        } 
        int k =0;
        for(int i = receiveMoneyValueCount.length-1 ; i>=0;i-- ) { //累加收到各种面值的钱
           income += receiveMoneyValueCount[i]*moneyValue[i];
           if(income >= ticketCount*ticketValue) {
              k = i;
              break;
           }
        }
        if(income < ticketCount*ticketValue) { //票款不足
              backMess = backMess+"票款不足";
              return false;
        }
        if(income == ticketCount*ticketValue){
             backMess = "票款不需要找赎";
             return true;
        }
        else {
             backChange = income - ticketCount*ticketValue;//需要找赎needChange元
             moneybox[0].handleChange(backChange);   //启动责任链（钱盒）开始找赎
             boolean isSuccess = false;               //刻画否成功找赎
             for(int i = 0;i<moneybox.length;i++){    //检查是否成功找赎
                if( moneybox[i].success  == true) {
                   isSuccess = true;
                   break;
                }
             }
            if(isSuccess){ 
               for(int i = receiveMoneyValueCount.length-1 ;i>=k;i-- ) {
                   //钱盒增加面值钱的个数
                   moneybox[i].addMoneyValueCount(receiveMoneyValueCount[i]); 
               }
               for(int i = 0;i<moneyValue.length;i++){
                  if( moneybox[i].changeCount!=0)
                    backMess =backMess+moneybox[i].changeCount+"张面值"+
                               moneybox[i].moneyValue+"元钱.\n";
               } 
            } 
            else {
                backMess ="找赎"+backChange+"元失败";
                for(int i = 0;i<moneyValue.length;i++){  //还原钱盒找赎之前的零钱个数
                    moneybox[i].moneyValueCount =
                    moneybox[i].moneyValueCount + moneybox[i].changeCount;
                }
            }
            return isSuccess;
       }
   }
}