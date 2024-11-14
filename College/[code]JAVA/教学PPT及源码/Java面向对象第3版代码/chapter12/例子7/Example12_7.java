import java.io.*;
public class Example12_7 {
   public static void main(String args[]) {
      File file=new File("Student.txt");
      String content[]={"天气预报:","北京晴","上海多云,有小雨","大连晴,有时多云"};
       try{
           FileWriter outOne=new FileWriter(file);
           BufferedWriter outTwo= new BufferedWriter(outOne);
           for(String str:content) {
               outTwo.write(str);
               outTwo.newLine();
           }
           outTwo.close();
           outOne.close();
           FileReader inOne=new FileReader(file);
           BufferedReader inTwo= new BufferedReader(inOne);
           String s=null;
           while((s=inTwo.readLine())!=null) {
             System.out.println(s);
           }
           inOne.close();
           inTwo.close();
         }
      catch(IOException e) {
         System.out.println(e);
      }  
   }
}
