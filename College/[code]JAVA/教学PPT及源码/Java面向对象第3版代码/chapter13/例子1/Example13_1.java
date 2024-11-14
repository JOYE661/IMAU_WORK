public class Example13_1 {
   public static void main(String args[]) {
      Circle circle=new Circle(10);
      Cone<? extends Computable> cone=new Cone<Circle>(circle);//ʹ���޶����ţ��޶�ʵ�ֽӿ�  
      cone.setHeight(16);
      System.out.println(cone.computerVolume());
      Rect rect=new Rect(15,23);
      cone=new Cone<Rect>(rect);//������׶����
      cone.setHeight(98); 
      System.out.println(cone.computerVolume());
      Cone<Rect> coneRect=new Cone<Rect>(rect);//��ʹ���޶����ţ�
      coneRect.setHeight(198); 
      System.out.println(coneRect.computerVolume());
      Cone<?> coneCircle=new Cone<Circle>(circle);//ʹ���޶����ţ�
      coneCircle.setHeight(100); 
      System.out.println(coneCircle.computerVolume());
  }
}