public class Example4_2 {
   public static void main(String args[]) {
       XiyoujiRenwu zhubajie = null,sunwukong = null;//声明对象
       zhubajie=new XiyoujiRenwu();//为对象分配内存,使用new 运算符和默认的构造方法
       sunwukong=new XiyoujiRenwu();
       zhubajie.name=PersonName.八戒; //对象zhubajie给自己的变量赋值
       zhubajie.height=1.83f;     
       zhubajie.weight=86f;
       zhubajie.head="猪头";      
       sunwukong.name=PersonName.悟空;  //对象sunwukong给自己的变量赋值
       sunwukong.height=1.66f; 
       sunwukong.weight=1000f;    
       sunwukong.head="猴头"; 
       System.out.println(zhubajie.name+"的身高："+zhubajie.height);
       System.out.println(zhubajie.name+"的体重："+zhubajie.weight); 
       System.out.println(zhubajie.name+"的头："+zhubajie.head);
       System.out.println(sunwukong.name+"的身高："+sunwukong.height);
       System.out.println(sunwukong.name+"的体重："+sunwukong.weight);
       System.out.println(sunwukong.name+"的头："+sunwukong.head);
       zhubajie.speak(zhubajie.name+"我想娶媳妇");             //对象调用方法
       System.out.println(zhubajie.name+"现在的头："+zhubajie.head);
       sunwukong.speak(sunwukong.name+"我重"+
                       sunwukong.weight+"公斤，想骗八戒背我"); //对象调用方法
       System.out.println(sunwukong.name+"现在的头："+sunwukong.head);
    }
}
