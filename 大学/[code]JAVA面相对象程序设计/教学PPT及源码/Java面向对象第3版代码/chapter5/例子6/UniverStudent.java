public class UniverStudent extends Student {
   boolean isMarriage; //子类新增的结婚属性
   UniverStudent(int number,String name,boolean b) {
      super(number,name);
   }
   public boolean getIsMarriage(){
      return isMarriage;
   }
}

