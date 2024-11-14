import java.util.Arrays;
public class Example9_3 {
    public static void main(String args[]) {
       String [] a={"boy","apple","Applet","girl","Hat"};
       String [] b=Arrays.copyOf(a,a.length);
       System.out.println("使用用户编写的SortString类，按字典序排列数组a：");
       SortString.sort(a);
       for(String s:a) {
          System.out.print("  "+s);
       }
       System.out.println();
       System.out.println("使用类库中的Arrays类，按字典序排列数组b："); 
       Arrays.sort(b);
       for(String s:b) {
          System.out.print("  "+s);
       }
    }
}

