import java.util.Arrays;


public class TapeCount {
	
	// count no of tapes to fit files of given size
	// one tape can have maximum 2 files
	void countTapes(int files[], int size) {
		int count = 0;
		Arrays.sort(files);
		int start = 0;
		int end = files.length - 1;
		while(start < end) {
			if(files[start] + files[end] <= size) {
				count++;
				start++;
				end--;
			}
			else {
				count++;
				end--;
			}
		}
		if(start == end)
			count++;
		System.out.println(count);
	}

	public static void main(String[] args) {
		TapeCount tc = new TapeCount();
		int files[] = {50, 70, 60, 80, 98, 5, 20, 10};
		tc.countTapes(files, 100);
	}
}
