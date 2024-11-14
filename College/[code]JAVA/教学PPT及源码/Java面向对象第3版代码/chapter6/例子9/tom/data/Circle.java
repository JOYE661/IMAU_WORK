package tom.data;
public class Circle {
   double radius;
   public void setRadius(double r){
      radius = r;
   }
   public double getArea() {
      return Math.PI*radius*radius;
   }
} 
