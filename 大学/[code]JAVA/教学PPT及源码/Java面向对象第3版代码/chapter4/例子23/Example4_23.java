public class Example4_23 { 
   public static void main(String args[]) {
        var radius = 100;       //var��������radius���ƶϳ���int��
        var height = 0.0;       // var��������height���ƶϳ���double��
        height = 3.14;         //�� height��ֵ
        var circle = new Circle(10);     // var��������circe���ƶϳ���Circle�� 
        circle  = new Circle(radius);     //�ٴδ�������circle
        var yuanzui = new Circular();//�ƶϳ�yuanzui��Circular��
        yuanzui.setBottom(circle);
        yuanzui.setHeight(height);
        var volume = yuanzui.getVolume(); //�ƶϳ�volume��double��
        System.out.println(volume);
   } 
}

