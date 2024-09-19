public class IntegerException extends Exception {
   String message;
   public IntegerException(int m) {
       message="年龄"+m+"不合理";
   }
   public String toString() {
       return message;
   }
}