public class Example4_7 {
    public static void main(String args[]){
      Rectangle rect=new Rectangle();
      Circle circle=new Circle();
      Geometry geometry;
      geometry=new Geometry(rect,circle);
      geometry.setRectanglePosition(30,40);
      geometry.setRectangleWidthAndHeight(120,80);
      geometry.setCirclePosition(260,30);
      geometry.setCircleRadius(60);
      System.out.print("����ͼ����Բ�;��ε�λ�ù�ϵ�ǣ�");
      geometry.showState();   //��ʾԲ�;��ε�λ�ù�ϵ
      System.out.println("����ͼ�����µ�����Բ�;��ε�λ�á�");
      geometry.setRectanglePosition(220,160);
      geometry.setCirclePosition(40,30);
      System.out.print("�����󣬼���ͼ����Բ�;��ε�λ�ù�ϵ�ǣ�");
      geometry.showState();   //��ʾԲ�;��ε�λ�ù�ϵ
    }
}
