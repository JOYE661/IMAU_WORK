package ticker.data;
public interface MoneyHandler{
   public abstract void handleChange(int money);//把整钱money分解成小于或等于money的零钱
   public abstract void setNextMoneyHandler(MoneyHandler handler);
}
