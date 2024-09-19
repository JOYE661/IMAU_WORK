public class AAA implements Printable {
     public void on(){    //必须重写接口的abstract方法on
         System.out.println("打开电视");
     }
     public float sum(float x ,float y){//必须重写接口的abstract方法sum
         return x+y;
     }
}

