package sohu.com;
public class Triangle {  
    double sideA,sideB,sideC;
    boolean isTriange;
    public Triangle(double a,double b,double c) { 
       sideA=a;
       sideB=b;
       sideC=c;
       if(a+b>c&&a+c>b&&c+b>a) {
          isTriange=true;
       }    
       else {
          isTriange=false;
       }
    }
    public void �������() {
       if(isTriange) {
           double p=(sideA+sideB+sideC)/2.0;
           double area=Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC)) ;
           System.out.println("��һ��������,�����:"+area);
       }
       else {
           System.out.println("����һ��������,���ܼ������");
       }
    } 
    public void �޸�����(double a,double b,double c) {
       sideA=a;
       sideB=b;
       sideC=c;
       if(a+b>c&&a+c>b&&c+b>a) {
          isTriange=true;
       }    
       else {
          isTriange=false;
       }
    }
}

