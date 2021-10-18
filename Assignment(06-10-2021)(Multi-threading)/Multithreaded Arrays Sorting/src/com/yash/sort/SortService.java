package com.yash.sort;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class SortService implements Callable<Integer[]> {

	private Integer arr[];
	
	public SortService(Integer intArray[]) 
	{
		this.arr = intArray;
	}
	
	@Override
	public Integer[] call() throws Exception {
		System.out.println("Sorting Thread :"+Thread.currentThread());
		Arrays.sort(arr);
		return arr;
	}

}
