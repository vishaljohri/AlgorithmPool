
public class ArrayPatching {
	
	int numberPatches(int a[], int n) {
		long miss = 1;
		int result = 0;
		int i = 0;
		while(miss <= n) {
			if(i < a.length && a[i] <= miss) {
				miss += a[i++];
			}
			else {
				miss += miss;
				result += 1;
			}
				
		}
		return result;
	}

	public static void main(String[] args) {
		int a[] = {1, 5, 10};
		ArrayPatching ap = new ArrayPatching();
		System.out.println(ap.numberPatches(a, 20));

	}

}
