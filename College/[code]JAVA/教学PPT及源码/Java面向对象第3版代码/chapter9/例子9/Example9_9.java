public class Example9_9 {
  public static void main (String args[ ]) {
        String regex = "-?[0-9][0-9]*[.]?[0-9]*";
        String str1="-0.618";
        String str2="999��Һ�,-123.45908����ż���";
        if(str1.matches(regex)) {
            System.out.println(str1+"���Ա�ʾ����"); 
        }
        else  {
            System.out.println(str1+"�����Ա�ʾ����"); 
        }
        String result=str2.replaceAll(regex,"");
        System.out.println("�޳�\""+str2+"\"�е����֣�\n�õ����ַ������ǣ�");
        System.out.println(result);
    }
}

