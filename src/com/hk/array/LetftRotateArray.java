package com.hk.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LetftRotateArray {

	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(1,2,3,4,5);
		rotLeft(a,6);

	}
	//[1,2,3,4,5], R=2
	//[3,4,5,1,2]
	
	public static List<Integer> rotLeft(List<Integer> a, int d) {
	    
			Collections.reverse(a);
			int s = a.size();
	         int n = s-(d%s);	       
	        for(int i=0,j=n-1;i<j;i++,j--){
	        	   int tmp = a.get(i);
	               a.set(i,a.get(j)); 
	               a.set(j,tmp); 
	        }
	        for(int i=n,j=s-1;i<j;i++,j--){
	        	   int tmp = a.get(i);
	               a.set(i,a.get(j)); 
	               a.set(j,tmp); 
	            }                
	        	        
	        return a;
	    }

}
