
public class PartitionArray {
	
	boolean partition(int a[]) {
		int length = a.length;
		int sum = 0;
		if(a.length == 0 || a.length == 1)
			return false;
		for(int i = 0; i < length; i++) {
			sum += a[i];
		}
		
		if(sum % 2 != 0) 
			return false;
		
		return subsetSum(a, length - 1, sum / 2);
	}
	
	boolean subsetSum(int a[], int n, int sum) {
		if(sum == 0)
			return true;
		if(n < 0)
			return false;
		return subsetSum(a, n - 1, sum) || subsetSum(a, n - 1, sum - a[n]);
	}

	public static void main(String[] args) {
		int a[] = {1, 5, 11, 5};
		PartitionArray p = new PartitionArray();
		System.out.println(p.partition(a));

	}

}
