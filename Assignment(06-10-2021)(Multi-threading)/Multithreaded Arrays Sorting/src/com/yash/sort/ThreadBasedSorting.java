package com.yash.sort;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadBasedSorting {
	public static void main(String[] args) {
		final int nThreads=3;
		Integer []arr1 = new Integer[] {20,12};
		Integer []arr2 = new Integer[] {20,10,33,76,4,5,22,16};
		Integer []arr3 = new Integer[] {56,76,33,234,21,3,21,34,221,3,2,4,64};
		Integer []arr4 = new Integer[] {12,34,65,33,112,32,11,2};

		Integer[][] jaggedArr = new Integer[][] {arr1,arr2,arr3,arr4};
		
		ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
		
		Set<Future<Integer[]>> futureSet = new LinkedHashSet<>();
		for (int i = 0; i < 4; i++) {
			Future<Integer[]> future = executorService.submit(new SortService(jaggedArr[i]));
			futureSet.add(future);
		}
		try {
			futureSet.forEach(x->{
				try 
				{
					Integer[] integers = x.get();
					System.out.println("\nSorted array : "+ Arrays.asList(integers));
				} catch (ExecutionException | InterruptedException e) {
					e.printStackTrace();
				}
			});
			executorService.awaitTermination(10, TimeUnit.SECONDS);
			executorService.shutdown();
			if(executorService.isShutdown()) {
				System.out.println(" \n*********** Work completed ************");
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		
	}
}
