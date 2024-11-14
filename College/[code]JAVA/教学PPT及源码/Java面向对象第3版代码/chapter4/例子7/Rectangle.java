public class Rectangle {
    double x,y,width,height;       
    public void setX(double a) {
       x=a;
    }
    public double getX(){
      return x;
    }
    public void setY(double b) {
       y=b;
    }
    public double getY(){
      return y;
    }
    public void setWidth(double w) {
       if(w > 0)
         this.width=w;
    }
    public double getWidth(){
       return width;
    }
    public void setHeight(double h) {
       if(h > 0)
          height=h;
    }
    public double getHeight() {
       return height;
    }
}
