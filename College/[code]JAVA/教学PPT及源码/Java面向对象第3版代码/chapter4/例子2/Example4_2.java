public class Example4_2 {
   public static void main(String args[]) {
       XiyoujiRenwu zhubajie = null,sunwukong = null;//��������
       zhubajie=new XiyoujiRenwu();//Ϊ��������ڴ�,ʹ��new �������Ĭ�ϵĹ��췽��
       sunwukong=new XiyoujiRenwu();
       zhubajie.name=PersonName.�˽�; //����zhubajie���Լ��ı�����ֵ
       zhubajie.height=1.83f;     
       zhubajie.weight=86f;
       zhubajie.head="��ͷ";      
       sunwukong.name=PersonName.���;  //����sunwukong���Լ��ı�����ֵ
       sunwukong.height=1.66f; 
       sunwukong.weight=1000f;    
       sunwukong.head="��ͷ"; 
       System.out.println(zhubajie.name+"����ߣ�"+zhubajie.height);
       System.out.println(zhubajie.name+"�����أ�"+zhubajie.weight); 
       System.out.println(zhubajie.name+"��ͷ��"+zhubajie.head);
       System.out.println(sunwukong.name+"����ߣ�"+sunwukong.height);
       System.out.println(sunwukong.name+"�����أ�"+sunwukong.weight);
       System.out.println(sunwukong.name+"��ͷ��"+sunwukong.head);
       zhubajie.speak(zhubajie.name+"����Ȣϱ��");             //������÷���
       System.out.println(zhubajie.name+"���ڵ�ͷ��"+zhubajie.head);
       sunwukong.speak(sunwukong.name+"����"+
                       sunwukong.weight+"�����ƭ�˽䱳��"); //������÷���
       System.out.println(sunwukong.name+"���ڵ�ͷ��"+sunwukong.head);
    }
}
