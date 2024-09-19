public class Example4_8 { 
   public static void main(String args[]) {
       Ladder.下底=100;  //Ladder的字节码被加载到内存,通过类名操作类变量
       Ladder ladderOne=new Ladder();
       Ladder ladderTwo=new Ladder();
       ladderOne.设置上底(28);
       ladderTwo.设置上底(66);
       System.out.println("ladderOne的上底:"+ladderOne.获取上底());
       System.out.println("ladderOne的下底:"+ladderOne.获取下底());
       System.out.println("ladderTwo的上底:"+ladderTwo.获取上底());
       System.out.println("ladderTwo的下底:"+ladderTwo.获取下底());
    } 
}
