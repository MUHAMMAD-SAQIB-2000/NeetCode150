package easyproblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MeetingRooms {

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        List<Interval> intervals1 = new ArrayList<>();
        intervals1.add(new Interval(0, 30));
        intervals1.add(new Interval(5, 10));
        intervals1.add(new Interval(15, 20));

        System.out.println("Test Case 1: " + canAttendMeetings(intervals1) + ", Expected: false");

        System.out.println("\n========================");

        List<Interval> intervals2 = new ArrayList<>();
        intervals2.add(new Interval(5, 8));
        intervals2.add(new Interval(9, 15));

        System.out.println("Test Case 2: " + canAttendMeetings(intervals2) + ", Expected: true");
    }

    public static boolean canAttendMeetings(List<Interval> intervals) {
        List<Interval> sorted = intervals.stream()
                .sorted(Comparator.comparingInt(i -> i.start))
                .toList();

        for (int i = 0; i < sorted.size() - 1; i++) {
            if (sorted.get(i).end > sorted.get(i + 1).start) {
                return false;
            }
        }

        return true;
    }

}
