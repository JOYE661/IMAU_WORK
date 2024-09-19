package ticker.data;
public class MoneyBox implements MoneyHandler{
     public int moneyValueCount;          //Ǯ������Ӧ��ֵ��Ʊ�ĸ���
     int moneyValue;                      //Ǯ����ֵ
     public int changeCount;               //�������
     public boolean success;               //�Ƿ�����ɹ�
     private MoneyHandler handler;         //��ŵ�ǰ�����ߺ�̴�����
     //����ֵmoneyValue��Ǯ������Ǯmoney�ֽ��С�ڻ����money����Ǯ��
     public void handleChange(int money){ 
        int completedChangeTasks = 0;     //��Ǯ�й��׵���Ǯ 
        int n =0,sum = 0;
        while(true){ //�ҵ�����ü�����ֵmoneyValue��Ǯ���԰���Ǯ�ֽ��С�ڻ����money
           sum = sum + moneyValue;
           n++;
           if(sum > money) 
             break;
        }
        n--; 
        //��Ǯ�п��Ը�������ֵ��moneyValue����Ǯ������  
        changeCount =Math.min(n,moneyValueCount);
        completedChangeTasks = moneyValue*changeCount;
       //Ǯ������ֵ��Ʊ�ĸ���������changeCount����
        moneyValueCount = moneyValueCount -changeCount;
        if(completedChangeTasks == money) {
           success = true ;       // ����ɹ� 
        } 
        else {
           if( handler!= null){
             //��һ��Ǯ�и�����ʣ�����������
             handler.handleChange(money-completedChangeTasks);
           }
           else {
             success = false;       // ����ʧ�� 
           }
        }
     }
     public void addMoneyValueCount(int n){//����Ǯ������Ӧ��ֵ��Ʊ�ĸ���
         moneyValueCount += n;
     }
     public void setMoneyValueCount(int count){
        if(count>=0) 
          moneyValueCount = count;
     }
     public void setMoneyValue(int moneyValue){//��ǰǮ�и����Ǯ����ֵ
          this.moneyValue = moneyValue;
     }
     public void setNextMoneyHandler(MoneyHandler handler){
          this.handler = handler;
     }
}
