public class XiyoujiRenwu {
    PersonName name;
    float height,weight;
    String head;
    void speak(String s) {
       if(name==PersonName.�˽�){
          head="����ͷ";
       }
       else if(name==PersonName.���){
          head="��Ůͷ";
       }
       System.out.println(s);
    }
}
