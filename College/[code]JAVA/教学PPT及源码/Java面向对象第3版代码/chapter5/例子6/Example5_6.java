public class Example5_6 {
   public static void main(String args[]) {
       UniverStudent zhang=new UniverStudent(20111,"����",false);
       int number=zhang.getNumber();
       String name=zhang.getName();
       boolean marriage=zhang.getIsMarriage();
       System.out.println(name+"��ѧ����:"+number);
       if(marriage==true) {
         System.out.println(name+"�ѻ�");
       }
       else{
         System.out.println(name+"δ��");
       }
   }
}
