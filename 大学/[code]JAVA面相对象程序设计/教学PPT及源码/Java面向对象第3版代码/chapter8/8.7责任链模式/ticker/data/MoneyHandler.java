package ticker.data;
public interface MoneyHandler{
   public abstract void handleChange(int money);//����Ǯmoney�ֽ��С�ڻ����money����Ǯ
   public abstract void setNextMoneyHandler(MoneyHandler handler);
}
