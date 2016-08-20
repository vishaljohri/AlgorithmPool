
import java.util.Arrays;
import java.util.Comparator;

class Job {
	int start;
	int end;
	int profit;
	public Job(int start, int end, int profit) {
		this.start = start;
		this.end = end;
		this.profit = profit;
	}
}
public class JobScheduling {
	
	boolean isOverlap(Job j1, Job j2) {
		if(j1.end <= j2.start)
			return false;
		else
			return true;
	}
	
	// select non-overlapping jobs to make max profit
	int maxProfit(Job jobs[]) {
		Arrays.sort(jobs, new Comparator<Job>() {
			public int compare(Job j1, Job j2) {
				if(j1.end > j2.end)
					return 1;
				else if((j1.end > j2.end))
					return -1;
				else
					return 0;
					
			}
		});
		
		int dp[] = new int[jobs.length];
		dp[0] = jobs[0].profit;
		int maxProfit = dp[0];
		for(int i = 1; i < jobs.length; i++) {
			dp[i] = jobs[i].profit;
			int cur = dp[i];
			for(int j = 0; j < i; j++) {
				if(!isOverlap(jobs[j], jobs[i])) {
					cur = Math.max(cur, dp[i] + dp[j]);
				}
			}
			dp[i] = cur;
			maxProfit = Math.max(maxProfit, dp[i]);
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		JobScheduling js = new JobScheduling();
		Job jobs[] = {new Job(1, 3, 5), new Job(2, 5, 6), new Job(4, 6, 5), new Job(6, 7, 4), 
				new Job(5, 8, 11), new Job(7, 9, 2)};
		System.out.println(js.maxProfit(jobs));

	}

}
