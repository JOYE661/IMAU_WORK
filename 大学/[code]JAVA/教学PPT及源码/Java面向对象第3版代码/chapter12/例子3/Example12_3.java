import java.io.*;
public class Example12_3 {
   public static void main(String args[]) {
      try{ 
           Runtime ce=Runtime.getRuntime();
           File file=new File("c:/windows","Notepad.exe");
           ce.exec("java Example11_6"); 
           ce.exec(file.getAbsolutePath());
      }
      catch(Exception e) {
           System.out.println(e);
      } 
   } 
}

