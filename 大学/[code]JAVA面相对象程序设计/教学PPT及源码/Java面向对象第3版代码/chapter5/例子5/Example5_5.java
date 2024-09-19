class CreatPeople {
    public People creatPeople() { //方法的类型是People类
        People p=new People();
        return p;               
    }
}
class CreatChinese extends CreatPeople {
    public Chinese creatPeople() {      //重写方法的类型是People类的子类:Chinese
        Chinese chinese=new Chinese();
        return chinese;               
    }
}
public class Example5_5 {
    public static void main(String args[]) {
      CreatChinese create=new CreatChinese();
      Chinese zhang=create.creatPeople();   //create调用重写的方法
      zhang.speak();   
    } 
}  
