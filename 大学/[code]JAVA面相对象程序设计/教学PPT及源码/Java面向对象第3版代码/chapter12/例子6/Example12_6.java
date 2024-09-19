import java.io.*;
public class Example12_6 {
   public static void main(String args[]) {
      char a[]="四月十二日10点发起总攻".toCharArray();   
      int n=0,m=0;
      try{  File f=new File("secret.txt");
            for(int i=0;i<a.length;i++) {
               a[i]=(char)(a[i]^'R');
            }
            FileWriter out=new FileWriter(f);
            out.write(a,0,a.length);
            out.close();
            FileReader in=new FileReader(f);
            char tom[]=new char[10];
            System.out.println("密文:");
            while((n=in.read(tom,0,10))!=-1) {
               String s=new String (tom,0,n);
               System.out.print(s);
            }
            in.close();
            System.out.printf("\n解密：\n"); 
            in=new FileReader(f);
            while((n=in.read(tom,0,10))!=-1) { 
               for(int i=0;i<n;i++) {
                  tom[i]=(char)(tom[i]^'R');
               }
               String s=new String (tom,0,n);
               System.out.print(s);
            }
            in.close();
          }
      catch(IOException e) {
          System.out.println(e.toString());
      }
   }
}

