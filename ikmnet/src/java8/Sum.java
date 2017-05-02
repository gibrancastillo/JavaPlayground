package java8;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class Sum extends RecursiveTask<Long> {
	int low, high;
	int[] array;
	Sum(int[] arr, int lo, int hi) {
		array = arr;
		low = lo;
		high = hi;
	}
	
	protected Long process() {
		if(high - low <= 4) {
			long sum = 0;
			for(int i = low; i < high; ++i)
				sum += array[i];
			return sum;
		} else {
			int mid = low + (high - low) / 2;
			Sum left = new Sum(array, low, mid);
			Sum right = new Sum(array, mid, high);
			left.fork();
			long rightAns = right.process();
			long leftAns = left.join();
			return leftAns + rightAns;
		}
	}
	
	static long sumArray(int[] array) {
		return new ForkJoinPool().invoke(new Sum(array, 0, array.length));
	}

	@Override
	protected Long compute() {
		// TODO Auto-generated method stub
		return null;
	}
}