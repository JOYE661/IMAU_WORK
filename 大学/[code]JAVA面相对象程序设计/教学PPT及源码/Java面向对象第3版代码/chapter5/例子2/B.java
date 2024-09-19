public class B extends A {
     double y=12;
     public void setY(int y)
     {   //this.y=y+x; 非法，子类没有继承x
     }
     public double getY() {
        return y;
     }
}
