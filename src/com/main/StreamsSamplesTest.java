package com.main;

import java.util.Arrays;
import java.util.List;
interface Fly{
	 default public void takeOff() {
		System.out.println("Fly::takeOff"); 
	 }
	 default public void turn(){
			System.out.println("Fly::turn"); 
		 }
	 default public void cruise(){
			System.out.println("Fly::cruise"); 
		 }
	 default public void land(){
			System.out.println("Fly::land"); 
		 }
}

public class StreamsSamplesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> values=Arrays.asList(1,2,3,5,6);
		int total=0;
		for(int e:values) {
			total+=e*2;
		}
		System.out.println(total);
		total=values.stream().map(e->e*2).reduce(0,(c,e)->c+e);
		System.out.println(total);
				
	}

}
