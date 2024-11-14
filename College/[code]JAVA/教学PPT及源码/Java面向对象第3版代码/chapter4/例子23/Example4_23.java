public class Example4_23 { 
   public static void main(String args[]) {
        var radius = 100;       //var声明变量radius并推断出是int型
        var height = 0.0;       // var声明变量height并推断出是double型
        height = 3.14;         //给 height赋值
        var circle = new Circle(10);     // var声明变量circe并推断出是Circle型 
        circle  = new Circle(radius);     //再次创建对象circle
        var yuanzui = new Circular();//推断出yuanzui是Circular型
        yuanzui.setBottom(circle);
        yuanzui.setHeight(height);
        var volume = yuanzui.getVolume(); //推断出volume是double型
        System.out.println(volume);
   } 
}

