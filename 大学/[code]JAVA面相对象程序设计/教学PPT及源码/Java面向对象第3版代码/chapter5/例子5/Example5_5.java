class CreatPeople {
    public People creatPeople() { //������������People��
        People p=new People();
        return p;               
    }
}
class CreatChinese extends CreatPeople {
    public Chinese creatPeople() {      //��д������������People�������:Chinese
        Chinese chinese=new Chinese();
        return chinese;               
    }
}
public class Example5_5 {
    public static void main(String args[]) {
      CreatChinese create=new CreatChinese();
      Chinese zhang=create.creatPeople();   //create������д�ķ���
      zhang.speak();   
    } 
}  
