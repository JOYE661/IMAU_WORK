package test8_time;

import java.util.*;
public class test2{

	public static void main(String[] args) {
		long arr[];
		arr=new long[100000];
		int k=10000;
		for(int i=0;i<100000;i++) {
			arr[i]=k;
			k--;
		}
		
		stopWatch s=new stopWatch();
		s.start();
		for(int i=0;i<arr.length-1;i++) {
			for(int j=arr.length-1;j>i;j--) {
				if(arr[j]>arr[j-1]) {
					long temp=arr[j];arr[j]=arr[j-1];arr[j-1]=temp;
				}
			}
		}
		s.stop();
		System.out.print(s.getElapsedTime());
		// TODO Auto-generated method stub

	}

}
