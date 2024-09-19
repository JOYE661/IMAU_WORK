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
        A.removeAll(B);           //A��ɵ��ø÷���֮ǰ�ļ���A�뼯��B�Ĳ
        B.removeAll(tempSet);      //B��ɵ��ø÷���֮ǰ�ļ���B�뼯��tempSet�Ĳ
        B.addAll(A);              //B���������A��B�ĶԳƲ� 
        int number=B.size();
        System.out.println("A��B�ĶԳƲ����"+number+"��Ԫ��:");
        Iterator<?> iter = B.iterator();
        while(iter.hasNext()){
            System.out.printf("%d��",iter.next());
        }
    }
}
