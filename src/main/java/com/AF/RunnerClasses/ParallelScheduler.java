package com.AF.RunnerClasses;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.runners.model.RunnerScheduler;

public class ParallelScheduler implements RunnerScheduler{
	 private ExecutorService threadPool = Executors.newFixedThreadPool(
		        Runtime.getRuntime().availableProcessors());

		    public void schedule(Runnable childStatement) {
		        threadPool.submit(childStatement);
		    }

		    public void finished() {
		        try {
		            threadPool.shutdown();
		            threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		        } catch (InterruptedException e) {
		            Thread.currentThread().interrupt();
		            throw new RuntimeException("Got interrupted", e);
		        }
		    }
	

}
