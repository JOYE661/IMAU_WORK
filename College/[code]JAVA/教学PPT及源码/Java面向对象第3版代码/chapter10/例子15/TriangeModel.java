public class TriangeModel {
    double sideA,sideB,sideC;
    boolean isTriange;
    public double getArea() {
     if(isTriange) {
        double p = (sideA+sideB+sideC)/2.0;
        double area = Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC)) ;
        return area;
     }
     else { 
        return Double.NaN;//Not-a-Number
     }
    } 
    public void setA(double a) {
        sideA = a;
        if(sideA+sideB>sideC&&sideA+sideC>sideB&&sideC+sideB>sideA) 
            isTriange = true;
        else 
            isTriange = false;
    }
    public void setB(double b) {
        sideB = b;
        if(sideA+sideB>sideC&&sideA+sideC>sideB&&sideC+sideB>sideA) 
            isTriange = true;
        else 
            isTriange = false;
    }
    public void setC(double c) {
        sideC = c;
        if(sideA+sideB>sideC&&sideA+sideC>sideB&&sideC+sideB>sideA) 
            isTriange = true;
        else 
            isTriange = false;
    }
}