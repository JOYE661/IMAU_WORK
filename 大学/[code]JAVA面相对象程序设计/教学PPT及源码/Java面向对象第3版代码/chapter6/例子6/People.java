public class People {
     private int age=1;
     public void setAge(int age) throws IntegerException {
        if(age>=160||age<=0) {
            throw new IntegerException(age); //�����׳��쳣�����·�������
        }
        else {
            this.age=age;
        }
     }  
     public int getAge() {
        System.out.println("����"+age+"����");
        return age;
     }
}