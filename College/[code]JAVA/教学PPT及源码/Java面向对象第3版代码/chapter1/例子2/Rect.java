public class Rect{
   double width;      //长方形的宽
   double height;     //长方形的高
   double getArea(){  //返回长方形的面积
      return width*height;
   }
}
class Example1_2{       //主类
   public static void main(String args[]){
      Rect rectangle;
      rectangle=new Rect();
      rectangle.width=1.819;
      rectangle.height=1.5;
      double area=rectangle.getArea();
      System.out.println("矩形的面积:"+area);
    }
}


