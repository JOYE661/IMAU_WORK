public class People{
    int leg,hand;
    String name;
    People(String s){
        name=s;
        this.init();   //����ʡ��this������this.init();д��init();
    }
    void init(){
       leg=2;
       hand=2;
       System.out.println(name+"��"+hand+"ֻ��"+leg+"����");
    }
    public static void main(String args[]){
       People boshi=new People("��ʲ"); //�����ù��췽��People����boshiʱ�����е�this���Ƕ���boshi
    }
}
