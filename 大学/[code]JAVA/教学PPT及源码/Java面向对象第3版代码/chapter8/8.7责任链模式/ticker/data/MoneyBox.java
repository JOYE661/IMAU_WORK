package ticker.data;
public class MoneyBox implements MoneyHandler{
     public int moneyValueCount;          //钱盒中相应面值钞票的个数
     int moneyValue;                      //钱的面值
     public int changeCount;               //找赎个数
     public boolean success;               //是否找赎成功
     private MoneyHandler handler;         //存放当前处理者后继处理者
     //用面值moneyValue的钱，把整钱money分解成小于或等于money的零钱：
     public void handleChange(int money){ 
        int completedChangeTasks = 0;     //本钱盒贡献的零钱 
        int n =0,sum = 0;
        while(true){ //找到最多用几个面值moneyValue的钱可以把整钱分解成小于或等于money
           sum = sum + moneyValue;
           n++;
           if(sum > money) 
             break;
        }
        n--; 
        //本钱盒可以给出的面值是moneyValue的零钱个数：  
        changeCount =Math.min(n,moneyValueCount);
        completedChangeTasks = moneyValue*changeCount;
       //钱盒中面值钞票的个数减少了changeCount个：
        moneyValueCount = moneyValueCount -changeCount;
        if(completedChangeTasks == money) {
           success = true ;       // 找赎成功 
        } 
        else {
           if( handler!= null){
             //下一个钱盒负责处理剩余的找赎任务：
             handler.handleChange(money-completedChangeTasks);
           }
           else {
             success = false;       // 找赎失败 
           }
        }
     }
     public void addMoneyValueCount(int n){//增加钱盒中相应面值钞票的个数
         moneyValueCount += n;
     }
     public void setMoneyValueCount(int count){
        if(count>=0) 
          moneyValueCount = count;
     }
     public void setMoneyValue(int moneyValue){//当前钱盒负责的钱的面值
          this.moneyValue = moneyValue;
     }
     public void setNextMoneyHandler(MoneyHandler handler){
          this.handler = handler;
     }
}
