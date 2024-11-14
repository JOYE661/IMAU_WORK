import java.util.*;
public class Example13_12{
    public static void main(String args[]){
        HashSet<Integer> A=new HashSet<Integer>(),
                         B=new HashSet<Integer>();
        for(int i=1;i<=4;i++){
            A.add(i); 
        }
        B.add(1); 
        B.add(2);
        B.add(5); 
        B.add(6);
        HashSet<Integer> tempSet=(HashSet<Integer>)A.clone();
        A.removeAll(B);           //A变成调用该方法之前的集合A与集合B的差集
        B.removeAll(tempSet);      //B变成调用该方法之前的集合B与集合tempSet的差集
        B.addAll(A);              //B就是最初的A与B的对称差 
        int number=B.size();
        System.out.println("A和B的对称差集合有"+number+"个元素:");
        Iterator<?> iter = B.iterator();
        while(iter.hasNext()){
            System.out.printf("%d，",iter.next());
        }
    }
}
