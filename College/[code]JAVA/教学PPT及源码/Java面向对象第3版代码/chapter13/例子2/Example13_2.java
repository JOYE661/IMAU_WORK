interface Computer<E,F> {
    void makeChorus(E x,F y);
}
class Chorus<E,F> implements Computer<E,F> {
   public void makeChorus(E x,F y) {
      x.toString();
      y.toString();
   }
}
class ���� {
   public String toString() {
      System.out.println("|3 5 1-|1 3 5-|12 35 2-|");
      return "";
   }
}
class ���� {
   public String toString() {
      System.out.println("�����,�Һ���,ͬס�����");
      return "";
   }
}
public class Example13_2 {
   public static void main(String args[ ]) {
      Chorus<���� ,����> model=new Chorus<����,����>();  
      ���� pengliyuan=new ����();
      ���� piano=new ����();
      model.makeChorus(pengliyuan,piano);
   }
}
