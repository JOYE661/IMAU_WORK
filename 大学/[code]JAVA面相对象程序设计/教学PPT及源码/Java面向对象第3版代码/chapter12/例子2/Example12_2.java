import java.io.*;
public class Example12_2 {
   public static void main(String args[]) {
      File dir=new File(".");
      FileAccept fileAccept=new FileAccept();
      fileAccept.setExtendName("java");
      String fileName[]=dir.list(fileAccept);
      for(String name:fileName) {
          System.out.println(name);
      }
   }
}
