package test6;

public class Rec extends Geo{
	//数据域
		private double w=1;
		private double h=1;
		//方法
		public double getA(){  return w*h;  }
		public double getW() {  return w;	}
		public void setW( double w ) {   this.w = w;	}
		public double getH() {  return h;  }
		public void setH(  double h ) {  this.h = h;	}
		//构造方法
		public Rec(){ }
		public Rec(  double w , double h  ){
			this.w = w;	this.h = h;
		}


}
