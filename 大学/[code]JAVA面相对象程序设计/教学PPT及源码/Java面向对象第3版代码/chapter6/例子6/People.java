public class People {
     private int age=1;
     public void setAge(int age) throws IntegerException {
        if(age>=160||age<=0) {
            throw new IntegerException(age); //方法抛出异常，导致方法结束
        }
        else {
            this.age=age;
        }
     }  
     public int getAge() {
        System.out.println("年龄"+age+"合理");
        return age;
     }
}