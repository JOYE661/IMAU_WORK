public class IntegerException extends Exception {
   String message;
   public IntegerException(int m) {
       message="����"+m+"������";
   }
   public String toString() {
       return message;
   }
}