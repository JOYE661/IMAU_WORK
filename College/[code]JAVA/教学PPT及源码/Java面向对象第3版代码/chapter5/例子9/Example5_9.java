public class Example5_9 {
   public static void main(String args[]) {
      People  people=new People(); 
      Anthropoid monkey=people;               //monkey��people�������ת�Ͷ���
      monkey.crySpeak("I love this game");    //��ͬ��people������д��crySpeak����
      //monkey.n=100;                         //�Ƿ�,��Ϊn�����������ĳ�Ա����
      //monkey.computer(12,19);               //�Ƿ�,��Ϊcomputer()�����������ķ���
       System.out.println(monkey.m) ;         //�������ص�m,����ͬ��people.m
       System.out.println(people.m) ;         //�������ص�m,����ͬ��people.m
       People zhang=(People)monkey;           //����ת�Ͷ���ǿ��ת��Ϊ����Ķ���
       zhang.computer(55,33);                 //zhang������Ķ���
       zhang.m='T';                           //�������������ĳ�Ա�ı���m
       System.out.println(zhang.m) ; 
    }
}

