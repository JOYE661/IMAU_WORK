public class Example4_4 {
   public static void main(String args[]) {
       Rect rect=new Rect();
       double w=12.76,h=25.28;
       rect.setWidth(w);
       rect.setHeight(h); 
       System.out.println("���ζ���Ŀ�"+rect.getWidth()+" �ߣ�"+rect.getHeight());
       System.out.println("���ε������"+rect.getArea());
       System.out.println("���������ķ�����������ֵ��w,h������ֵΪ100��256");
       w=100;
       h=256;
       System.out.println("���ζ���Ŀ�"+rect.getWidth()+" �ߣ�"+rect.getHeight());
    }
}
