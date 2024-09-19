//模式的使用
public class Application{
   public static void main(String args[]){
     AverageScore game=new AverageScore();//上下文对象game
     game.setStrategy(new StrategyA());   //上下文对象使用具体策略
     Person zhang=new Person();
     zhang.setName("张三");
     double [] a={9.12,9.25,8.87,9.99,6.99,7.88};
     double aver = game.getAverage(a) ;    //上下文对象得到平均值   
     zhang.setScore(aver);
     System.out.println("算法A:");
     System.out.printf("%s最后得分:%5.3f%n",zhang.getName(),zhang.getScore());
     game.setStrategy(new StrategyB());   
     aver = game.getAverage(a) ;          //上下文对象得到平均值   
     zhang.setScore(aver);
     System.out.println("算法B:");
     System.out.printf("%s最后得分:%5.3f%n",zhang.getName(),zhang.getScore());  
  }
}
class Person{
   String name;
   double score;
   public void setScore(double t){
      score=t;
   }
   public void setName(String s){
      name=s;
   }
   public double getScore(){
      return score;
   }
   public String getName(){
      return name;
   }
}


