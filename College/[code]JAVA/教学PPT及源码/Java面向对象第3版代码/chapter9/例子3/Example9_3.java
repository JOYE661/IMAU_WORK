import java.util.Arrays;
public class Example9_3 {
    public static void main(String args[]) {
       String [] a={"boy","apple","Applet","girl","Hat"};
       String [] b=Arrays.copyOf(a,a.length);
       System.out.println("ʹ���û���д��SortString�࣬���ֵ�����������a��");
       SortString.sort(a);
       for(String s:a) {
          System.out.print("  "+s);
       }
       System.out.println();
       System.out.println("ʹ������е�Arrays�࣬���ֵ�����������b��"); 
       Arrays.sort(b);
       for(String s:b) {
          System.out.print("  "+s);
       }
    }
}

