package ticker.data;
public class TickerSeller {
    public int ticketValue;               //Ʊ��
    public MoneyBox [] moneybox;         //��ƱԱ��Ǯ����Ŀ
    public int income ;                  //�յ���Ʊ����
    public int backChange ;              //������
    public String backMess;              //������Ϣ
    int [] moneyValue ={100,50,20,10,5,2,1};  //7����ֵ��Ǯ����λԪ��
    //��ʼʱ��ƱԱ������ֵǮ�ĸ�������0��100Ԫ��Ǯ��10��50ԪǮ...50��1Ԫ��Ǯ:
    int [] moneyValueCount  ={0,10,12,30,27,23,50};
    public TickerSeller(){
        ticketValue = 8;      //Ĭ��Ʊ����8Ԫһ��
        backMess = "";
        moneybox = new MoneyBox[moneyValue.length];//Ǯ����Ŀ��7�� 
        init(); 
    }
    public void init(){      //��ƱԱ��ʼ���Լ���Ǯ��
        for(int i = 0;i<moneyValue.length;i++){
           moneybox[i] = new MoneyBox();
           //Ǯ�����ʼ��moneyValueCount[i] ��Ǯ:
           moneybox[i].setMoneyValueCount(moneyValueCount[i]); 
           moneybox[i].setMoneyValue(moneyValue[i]);//��ֵ��moneyValue[i]
        }
        for(int i = 0;i<moneyValue.length-1;i++){
           moneybox[i].setNextMoneyHandler(moneybox[i+1]);  //�γ�������
        }
    }
    public void setTiketValue(int ticketValue){    //����Ʊ��
        if(ticketValue>=1)
          this.ticketValue = ticketValue;
    }                      
    public boolean sellTiket(int ticketCount,int [] receiveMoneyValueCount){//������Ʊ�йص�����
        income = 0;   //�յ���Ʊ������
        backChange = 0;
        backMess = "";
        for(int i = 0;i<moneyValue.length;i++){
             moneybox[i].changeCount = 0;  //��Ǯ�������������
        } 
        int k =0;
        for(int i = receiveMoneyValueCount.length-1 ; i>=0;i-- ) { //�ۼ��յ�������ֵ��Ǯ
           income += receiveMoneyValueCount[i]*moneyValue[i];
           if(income >= ticketCount*ticketValue) {
              k = i;
              break;
           }
        }
        if(income < ticketCount*ticketValue) { //Ʊ���
              backMess = backMess+"Ʊ���";
              return false;
        }
        if(income == ticketCount*ticketValue){
             backMess = "Ʊ���Ҫ����";
             return true;
        }
        else {
             backChange = income - ticketCount*ticketValue;//��Ҫ����needChangeԪ
             moneybox[0].handleChange(backChange);   //������������Ǯ�У���ʼ����
             boolean isSuccess = false;               //�̻���ɹ�����
             for(int i = 0;i<moneybox.length;i++){    //����Ƿ�ɹ�����
                if( moneybox[i].success  == true) {
                   isSuccess = true;
                   break;
                }
             }
            if(isSuccess){ 
               for(int i = receiveMoneyValueCount.length-1 ;i>=k;i-- ) {
                   //Ǯ��������ֵǮ�ĸ���
                   moneybox[i].addMoneyValueCount(receiveMoneyValueCount[i]); 
               }
               for(int i = 0;i<moneyValue.length;i++){
                  if( moneybox[i].changeCount!=0)
                    backMess =backMess+moneybox[i].changeCount+"����ֵ"+
                               moneybox[i].moneyValue+"ԪǮ.\n";
               } 
            } 
            else {
                backMess ="����"+backChange+"Ԫʧ��";
                for(int i = 0;i<moneyValue.length;i++){  //��ԭǮ������֮ǰ����Ǯ����
                    moneybox[i].moneyValueCount =
                    moneybox[i].moneyValueCount + moneybox[i].changeCount;
                }
            }
            return isSuccess;
       }
   }
}