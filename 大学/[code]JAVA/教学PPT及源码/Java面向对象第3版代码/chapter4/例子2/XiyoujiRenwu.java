public class XiyoujiRenwu {
    PersonName name;
    float height,weight;
    String head;
    void speak(String s) {
       if(name==PersonName.八戒){
          head="美男头";
       }
       else if(name==PersonName.悟空){
          head="美女头";
       }
       System.out.println(s);
    }
}
