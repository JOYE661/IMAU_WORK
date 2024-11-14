import java.awt.event.*;
public class Controller implements ActionListener {
    MVCWindow mvc;
    public void setMVCWindow(MVCWindow mvc){
        this.mvc = mvc;
    }
    public void actionPerformed(ActionEvent e) {
     try{  
        double a = Double.parseDouble(mvc.textA.getText().trim());   
        double b = Double.parseDouble(mvc.textB.getText().trim());      
        double c = Double.parseDouble(mvc.textC.getText().trim()); 
        mvc.model.setA(a) ;          //��������
        mvc.model.setB(b);
        mvc.model.setC(c);
        double area = mvc.model.getArea();     
        mvc.showArea.append("������"+a+","+b+","+c+"�����:"); 
        mvc.showArea.append(""+area+"\n");  //������ͼ
     } 
     catch(Exception exp) {
        mvc.showArea.append("\n"+exp+"\n");
     }
   }
}