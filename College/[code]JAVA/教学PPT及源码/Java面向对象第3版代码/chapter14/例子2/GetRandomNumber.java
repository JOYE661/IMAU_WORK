import java.util.LinkedList;
import java.util.Random;
public class GetRandomNumber {
    public static int [] getRandomNumber(int max,int amount){
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=1;i<=max;i++){
            list.add(i);
        }
        int result[] = new int[amount];
        while(amount>0){
           int index = new Random().nextInt(list.size());
           int m = list.remove(index);
           result[amount-1] = m;
           amount--;
        }
        return result;
    }
}