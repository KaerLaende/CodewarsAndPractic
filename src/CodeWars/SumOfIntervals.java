package CodeWars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SumOfIntervals {
    static int[][] intervals = new int[][]{{-99, -79}, {-209, -194}, {-429, -418}, {-71, -54}, {-126, -112}, {-341, -329}, {-172, -164}, {-278, -270}, {387, 393}, {-314, -311}, {-84, -75}, {-437, -417}, {-423, -411}, {-456, -442}, {468, 487}, {-494, -489}};
    int answer = 171;
    static int[][] intervals2 = new int[][]{{-468, -450}, {-61, -60}, {-197, -192}, {-476, -475}, {305, 314}, {-480, -461}};
    int answer2 = 45;


    public static int sumIntervals(int[][] intervals) {
        //I'm sorry for this:
        int sum = 0;
        int t, d, x;
        //sorted by row
        for (int a = 1; a < intervals.length; a++) {
            for (int b = intervals.length - 1; b >= a; b--) {
                if (intervals[b - 1][0] > intervals[b][0]) {
                    t = intervals[b - 1][0];
                    d = intervals[b - 1][1];
                    intervals[b - 1][0] = intervals[b][0];
                    intervals[b - 1][1] = intervals[b][1];
                    intervals[b][0] = t;
                    intervals[b][1] = d;
                }
            }
        }
        for (int a = 1; a < intervals.length; a++) {
            for (int b = intervals.length - 1; b >= a; b--) {
                if (intervals[b - 1][0] < intervals[b][0]) {
                    if (intervals[b - 1][1] > intervals[b][1]){
                        int y = intervals[b - 1][1];
                        intervals[b - 1][1]=intervals[b][1];
                        intervals[b][1]=y;
                    }
                }
            }
        }
        //search in sorted Array
        for (int i = 0; i < intervals.length; i++) {
            x = intervals[i][1] - intervals[i][0];
            sum += intervals[i][1] - intervals[i][0];
            //decrease 'add' if interval is duplicated
            if (i != 0) {
                for (int j = 1; j <= i; j++) {
                    if (intervals[i][0] >= intervals[i - j][0] && intervals[i][0] <= intervals[i - j][1] && intervals[i][1] < intervals[i - j][1]) {
                        sum = sum - (intervals[i][1] - intervals[i][0]);
                    } else if (intervals[i][0] >= intervals[i - j][0] && intervals[i][0] <= intervals[i - j][1]) {
//                        if (intervals[i][0] >= intervals[i - j][0] && intervals[i][0] <= intervals[i - j][1] && intervals[i - j][1] < intervals[i - (j + 1)][1]) {
//                            sum = sum - (intervals[i - (j + 1)][1] - intervals[i][0]);
//                            break;
//                        }
                        sum = sum - (intervals[i - j][1] - intervals[i][0]);
                        break;
                    }

                }
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(sumIntervals1(intervals));
    }


    public static int sumIntervals1(int[][] intervals) {
        if (intervals == null || intervals.length < 1) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int result = 0;
        int currentIntervalEnd = intervals[0][0];

        for (int[] interval : intervals) {
            int intervalStart = interval[0];
            int intervalEnd = interval[1];
            if (intervalEnd > currentIntervalEnd) {
                result += intervalEnd - Math.max(intervalStart, currentIntervalEnd);
                currentIntervalEnd = intervalEnd;
            }
        }
        return result;
    }


    /**
     * Поиск суммы интервалов путем заполнения ArrayList
     *
     * @param intervals
     * @return Arrays.length
     */
    public static int sumIntervals2(int[][] intervals) {
        ArrayList<Integer> intervalArray = new ArrayList<>();
        int first = 0;
        int second = 0;
        for (int i = 0; i < intervals.length; i++) {
            first = intervals[i][1];
            second = intervals[i][0];
            while (second < first) {
                second++;
                if (!intervalArray.contains(second)) {
                    intervalArray.add(second);
                }
            }
        }
        return intervalArray.size();
    }

}
