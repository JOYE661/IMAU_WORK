public class Rect{
   double width;      //�����εĿ�
   double height;     //�����εĸ�
   double getArea(){  //���س����ε����
      return width*height;
   }
}
class Example1_2{       //����
   public static void main(String args[]){
      Rect rectangle;
      rectangle=new Rect();
      rectangle.width=1.819;
      rectangle.height=1.5;
      double area=rectangle.getArea();
      System.out.println("���ε����:"+area);
    }
}


