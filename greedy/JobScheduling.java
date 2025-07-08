import java.util.*;

class Job {
    char id;
    int deadline;
    int profit;

    Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobScheduling {
    public static void main(String[] args) {
        Job[] jobs = {
                new Job('a', 2, 100),
                new Job('b', 1, 19),
                new Job('c', 2, 27),
                new Job('d', 1, 25),
                new Job('e', 3, 15)
        };

        scheduleJobs(jobs);
    }

    static void scheduleJobs(Job[] jobs) {
        // Sort jobs by descending order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int n = jobs.length;

        // Find max deadline to size the slots array
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        // Track free time slots
        boolean[] slot = new boolean[maxDeadline];
        char[] jobSequence = new char[maxDeadline];

        int totalProfit = 0;
        int jobsDone = 0;

        for (Job job : jobs) {
            // Try to schedule job at latest possible time before deadline
            for (int j = job.deadline - 1; j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    jobSequence[j] = job.id;
                    totalProfit += job.profit;
                    jobsDone++;
                    break;
                }
            }
        }

        System.out.println("Jobs scheduled: " + Arrays.toString(jobSequence));
        System.out.println("Total jobs done: " + jobsDone);
        System.out.println("Total profit: " + totalProfit);
    }
}

