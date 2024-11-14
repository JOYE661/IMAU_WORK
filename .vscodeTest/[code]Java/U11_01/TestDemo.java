//package U11_01;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.HashSet;
//import java.util.Set;
//
//public class TestDemo {
//	    public static void main(String[] args) throws FileNotFoundException {
//
//	        Set<Product> products = new HashSet<>();
//	        String pathName = "C:\\test\\product.txt";
//	        File file = null;
//
//	        FileInputStream fileInputStream = null;
//	        try {
//
//	            file = new File(pathName);
//
//
//	            fileInputStream = new FileInputStream(file);
//	            byte[] bytes = new byte[1024];
//	            int len;
//	            while ((len = fileInputStream.read(bytes)) != -1){
//
//	                String s = new String(bytes, 0, len);
//	                System.out.println(s);
//
//	            }
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }finally {
//
//	            if (fileInputStream != null){
//	                try {
//	                    fileInputStream.close();
//	                } catch (IOException e) {
//	                    e.printStackTrace();
//	                }
//
//	            }
//
//	        }
//
//
//
//
//
//	    }
//	}
//
//}
