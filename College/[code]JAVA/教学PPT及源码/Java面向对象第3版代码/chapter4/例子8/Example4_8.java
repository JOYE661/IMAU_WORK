public class Example4_8 { 
   public static void main(String args[]) {
       Ladder.�µ�=100;  //Ladder���ֽ��뱻���ص��ڴ�,ͨ���������������
       Ladder ladderOne=new Ladder();
       Ladder ladderTwo=new Ladder();
       ladderOne.�����ϵ�(28);
       ladderTwo.�����ϵ�(66);
       System.out.println("ladderOne���ϵ�:"+ladderOne.��ȡ�ϵ�());
       System.out.println("ladderOne���µ�:"+ladderOne.��ȡ�µ�());
       System.out.println("ladderTwo���ϵ�:"+ladderTwo.��ȡ�ϵ�());
       System.out.println("ladderTwo���µ�:"+ladderTwo.��ȡ�µ�());
    } 
}
