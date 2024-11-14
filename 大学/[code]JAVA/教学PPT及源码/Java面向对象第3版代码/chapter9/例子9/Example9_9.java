public class Example9_9 {
  public static void main (String args[ ]) {
        String regex = "-?[0-9][0-9]*[.]?[0-9]*";
        String str1="-0.618";
        String str2="999大家好,-123.45908明天放假了";
        if(str1.matches(regex)) {
            System.out.println(str1+"可以表示数字"); 
        }
        else  {
            System.out.println(str1+"不可以表示数字"); 
        }
        String result=str2.replaceAll(regex,"");
        System.out.println("剔除\""+str2+"\"中的数字，\n得到的字符序列是：");
        System.out.println(result);
    }
}

