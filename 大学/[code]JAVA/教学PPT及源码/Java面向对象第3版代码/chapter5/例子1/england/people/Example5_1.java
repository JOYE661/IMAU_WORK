package england.people;
import american.people.Son;
import japan.people.Grandson;
public class Example5_1 {
    public static void main(String args[]) {
        Son son=new Son();
        Grandson grandson=new Grandson();
        son.height = 180;
        son.hand = "һ˫����"; 
        grandson.height = 155;
        grandson.hand = "һ˫С��";
        grandson.foot ="һ˫С��";
        String str = son.getHand();
        System.out.printf("���ӣ�%s,%d\n",str,son.height);
        str = grandson.getHand();
        System.out.printf("���ӣ�%s,%s,%d\n",str,grandson.foot,grandson.height); 
    }
}
