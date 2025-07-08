import java.util.*;

class Activity {
    int start, end;
    Activity(int s, int e) { start = s; end = e; }
}

public class ActivitySelection {
    public static void main(String[] args) {
        Activity[] activities = {
                new Activity(1, 3), new Activity(2, 4),
                new Activity(0, 6), new Activity(5, 7),
                new Activity(8, 9), new Activity(5, 9)
        };

        Arrays.sort(activities, Comparator.comparingInt(a -> a.end));

        int count = 1;
        int lastEnd = activities[0].end;

        System.out.println("Selected Activities:");
        System.out.println("(" + activities[0].start + ", " + activities[0].end + ")");

        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= lastEnd) {
                System.out.println("(" + activities[i].start + ", " + activities[i].end + ")");
                lastEnd = activities[i].end;
                count++;
            }
        }

        System.out.println("Maximum activities: " + count);
    }
}
