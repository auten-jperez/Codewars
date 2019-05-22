package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Intervals, should return 0, and return: " + sumIntervals(new int[][] {}));
        System.out.println("Intervals, should return 99999999, and return: " + sumIntervals(new int[][] {{1, 100000000}, {1, 1000}}));
        System.out.println("Intervals, should return 0, and return: "
                + sumIntervals(new int[][] { { 4, 4 }, { 6, 6 }, { 8, 8 } }));
        System.out.println("Intervals, should return 9, and return: "
                + sumIntervals(new int[][] { { 1, 4 }, { 7, 9 }, { 11, 15 } }));
        System.out.println("Intervals, should return 0, and return: " + sumIntervals(null));
        System.out.println("Intervals, should return 19, and return: "
                + sumIntervals(new int[][] { { 1, 5 }, { 10, 20 }, { 1, 6 }, { 16, 19 }, { 5, 11 } }));
        System.out.println("Intervals, should return 158, and return: "
                + sumIntervals(new int[][] { { -101, 24 }, { -35, 27 }, { 27, 53 }, { -105, 20 }, { -36, 26 } }));
    }

    public static int sumIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        orderIntervals(intervals);
        int sum = intervals[intervals.length-1][1] - intervals[intervals.length-1][0];
        int aux = intervals[intervals.length - 1][0];
        
        for (int i = intervals.length - 2; i >= 0; i--) {
            int firstNumber = intervals[i][0];
            int secondNumber = intervals[i][1];

            if(aux <= secondNumber && aux >= firstNumber) {
                sum += (aux - firstNumber);
                aux = firstNumber;
            }
            if(aux > firstNumber & aux > secondNumber){
                sum += (secondNumber - firstNumber);
                aux = firstNumber;
            } 
        }
        return sum;
    }
    
    public static void orderIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
    }

}