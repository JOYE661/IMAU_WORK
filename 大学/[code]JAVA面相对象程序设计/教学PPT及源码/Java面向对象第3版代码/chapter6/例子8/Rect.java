public class Rect {
   double width,height,area;
   public Rect(){
   }
   public Rect(double w,double h){
       width = w;
       height = h;
   }
   public double getArea() {
       area=height*width;
       return area;
   }
} 
