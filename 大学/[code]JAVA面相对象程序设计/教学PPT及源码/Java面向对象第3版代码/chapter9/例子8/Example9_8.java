public class Example9_8 {
    public static void main(String args[]) {
       byte d[]="abc������".getBytes(); 
       System.out.println("����d�ĳ�����(gb2312����,һ������ռ2���ֽ�):"+d.length);
       String s=new String(d,3,2); //�������
       System.out.println(s);
       s=new String(d,7,2);
       System.out.println(s);     //�������
       try {
        d ="abc������".getBytes("utf-8");  //���ʹ��utf-8���룬һ������ռ3���ֽ�
        System.out.println("����d�ĳ�����(utf-8����,һ������ռ3���ֽ�):"+d.length);
       }
       catch(Exception exp){}
    }
}

